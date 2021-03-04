package com.upfpo.app.service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.dto.ChcFmbMachineryDTO;
import com.upfpo.app.dto.InputSupplierMachineryDTO;
import com.upfpo.app.entity.EquipmentType;
import com.upfpo.app.entity.EqupmentMaster;
import com.upfpo.app.entity.ChcFmbMachinery;
import com.upfpo.app.properties.FileStorageProperties;
import com.upfpo.app.repository.EquipmentMasterRepository;
import com.upfpo.app.repository.EquipmentTypeRepository;
import com.upfpo.app.repository.ChcFmbMachineryRepository;
import com.upfpo.app.user.exception.FileStorageException;
import com.upfpo.app.user.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Service
public class ChcFmbMachineryServiceImpl implements ChcFmbMachineryService {

    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg","image/jpg", "image/gif");

    @Autowired
    private ChcFmbMachineryRepository machineryRepository;

    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;

    @Autowired
    private EquipmentMasterRepository equipmentMasterRepository;

    private final Path fileStorageLocation;

    @Autowired
    private EntityManager entityManager;


    @Autowired
    public ChcFmbMachineryServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            //throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",ex);
        }
    }


    @Override
    public List<ChcFmbMachineryDTO> getAllChcFmbMachinery(Integer masterId) {

        List<ChcFmbMachineryDTO> cfm = getMachineryDetail(masterId);
        return cfm;
    }

    @Override
    public List<EquipmentType> getAllEquipmentType(){
        return equipmentTypeRepository.findAll();
    }


    @Override
    public List<EqupmentMaster> getAllEquipmentByType(Integer typeId){
        return equipmentMasterRepository.findByIsDeletedAndEqipType(false, typeId);
    }

    @Override
    public ChcFmbMachinery createChcFmbMachinery(ChcFmbMachinery chcFmbMachinery, MultipartFile file){
        String fileName=null;
        chcFmbMachinery.setCreateBy(chcFmbMachinery.getChcFmbId());
        chcFmbMachinery.setCreateDateTime(Calendar.getInstance());
        if (file!=null){
        try {
            String fileContentType = file.getContentType();
           fileName= StringUtils.cleanPath(file.getOriginalFilename());
                // Check if the file's name contains invalid characters
            if(fileName.contains("..") && contentTypes.contains(fileContentType)) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence or invalid file type" + fileName);
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            //Path path = Paths.get( fileBasePath+fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/inputsupplier/machinery/download/")
                    .path(fileName)
                    .toUriString();
            chcFmbMachinery.setFilePath(fileDownloadUri);
            chcFmbMachinery.setFileName(fileName);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }}
        chcFmbMachinery.setDeleted(false);
        return machineryRepository.save(chcFmbMachinery);
    }

    @Override
    public Boolean deleteChcFmbMachinery(Integer id) {
        try {
            ChcFmbMachinery chcFmbMachinery = machineryRepository.findById(id).get();
            chcFmbMachinery.setDeleted(true);
            chcFmbMachinery.setDeleteDate(Calendar.getInstance());
            machineryRepository.save(chcFmbMachinery);
            return true;
        }catch(Exception e)
        {
            throw new NotFoundException();
        }
    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            //Path path = Paths.get( fileBasePath+fileName);
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new ResourceNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new ResourceNotFoundException("File not found " + fileName, ex);
        }
    }

    @Override
    public ChcFmbMachinery updateChcFmbMachinery(Integer id, ChcFmbMachinery chcFmbMachinery1, MultipartFile file) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        String fileDownloadUri;
        String fileName;
        Path targetLocation;
        if(file!=null){
            String fileContentType = file.getContentType();
            fileName = StringUtils.cleanPath(file.getOriginalFilename());
            try {
                // Check if the file's name contains invalid characters
                if (fileName.contains("..") && contentTypes.contains(fileContentType)) {
                    throw new FileStorageException("Sorry! Filename contains invalid path sequence or Invalid file type " + fileName);
                }
                targetLocation = this.fileStorageLocation.resolve(fileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/inputsupplier/machinery/download/")
                        .path(fileName)
                        .toUriString();
                machineryRepository.findById(id)
                        .map(chcFmbMachinery -> {
                            chcFmbMachinery.setFilePath(fileDownloadUri);
                            chcFmbMachinery.setFileName(fileName);
                            return machineryRepository.saveAndFlush(chcFmbMachinery);
                        }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            }}

        return machineryRepository.findById(id)
                .map(chcFmbMachinery -> {
                    chcFmbMachinery.setUpdateBy(chcFmbMachinery.getChcFmbId());
                    chcFmbMachinery.setUpdateDate(Calendar.getInstance());
                    chcFmbMachinery.setId(chcFmbMachinery1.getId());
                    chcFmbMachinery.setEquipmentTypeId(chcFmbMachinery1.getEquipmentTypeId());
                    chcFmbMachinery.setEquipmentNameId(chcFmbMachinery1.getEquipmentNameId());
                    chcFmbMachinery.setChcFmbId(chcFmbMachinery1.getChcFmbId());
                    chcFmbMachinery.setEquipmentCapacity(chcFmbMachinery1.getEquipmentCapacity());
                    chcFmbMachinery.setEquipmentYear(chcFmbMachinery1.getEquipmentYear());
                    chcFmbMachinery.setQuantityAvailable(chcFmbMachinery1.getQuantityAvailable());
                    chcFmbMachinery.setCompany(chcFmbMachinery1.getCompany());
                    chcFmbMachinery.setGovtSchemeAssistant(chcFmbMachinery1.getGovtSchemeAssistant());
                    chcFmbMachinery.setRentPerDay(chcFmbMachinery1.getRentPerDay());
                    chcFmbMachinery.setDeleted(false);
                    return machineryRepository.save(chcFmbMachinery);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }

    public List<ChcFmbMachineryDTO> getMachineryDetail(Integer masterId) {
        List<ChcFmbMachineryDTO> list = null;
        try {
            String sql = "Select  cfm.id, cfm.equipment_type_id, etm.type, cfm.equipment_name_id, em.equpment_name, cfm.company, cfm.equipment_capacity, cfm.equip_purchase_year,\n" +
                    "\t\t\tcfm.quantity_avail, cfm.rent_per_day, cfm.company, cfm.govt_scheme_assistant, cfm.file_path\n" +
                    "            from chc_fmb_machinery cfm\n" +
                    "            left join equipment_type_master etm on etm.id=cfm.equipment_type_id\n" +
                    "            left join equip_master em on em.id=cfm.equipment_name_id\n" +
                    "            where cfm.chc_fmb_id=:masterId and  cfm.is_deleted = false";

            List<ChcFmbMachineryDTO> obj = (List<ChcFmbMachineryDTO>) entityManager.createNativeQuery(sql, "ChcFmbMachineryDTO").setParameter("masterId", masterId).getResultList();
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}





    /*String sql = "Select  cfm.id, etm.id as type_id, etm.type, em.id as name_id, em.equpment_name,  cfm.equipment_capacity, cfm.equip_purchase_year,\n" +
            "\t\t\tcfm.quantity_avail, cfm.rent_per_day, cfm.company, cfm.govt_scheme_assistant, cfm.file_path\n" +
            "            from chc_fmb_machinery cfm\n" +
            "            left join equipment_type_master etm on etm.id=cfm.equipment_type_id\n" +
            "            left join equip_master em on em.id=cfm.equipment_name_id\n" +
            "            where cfm.chc_fmb_id=:masterId and  cfm.is_deleted = false";*/