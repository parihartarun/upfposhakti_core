package com.upfpo.app.service;


import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.dto.InputSupplierFertilizerDTO;
import com.upfpo.app.dto.InputSupplierMachineryDTO;
import com.upfpo.app.entity.FertilizerName;
import com.upfpo.app.entity.FertilizerType;
import com.upfpo.app.entity.InputSupplierFertilizer;
import com.upfpo.app.entity.InputSupplierFertilizer;
import com.upfpo.app.properties.FileStorageProperties;
import com.upfpo.app.repository.FertilizerNameRepository;
import com.upfpo.app.repository.FertilizerTypeRepository;
import com.upfpo.app.repository.InputSupplierFertilizerRepository;
import com.upfpo.app.requestStrings.ReportRequestString;
import com.upfpo.app.repository.InputSupplierFertilizerRepository;
import com.upfpo.app.user.exception.FileStorageException;
import com.upfpo.app.user.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class InputSupplierFertilizerServiceImpl implements InputSupplierFertilizerService {


    private static final Logger LOG = LoggerFactory.getLogger(InputSupplierFertilizerServiceImpl.class);



    @Autowired
    private InputSupplierFertilizerRepository fertilizerRepository;

    @Autowired
    private FertilizerNameRepository fertilizerNameRepository;

    @Autowired
    private FertilizerTypeRepository fertilizerTypeRepository;

    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/jpg", "image/gif",
            "image/PNG", "image/JPEG", "image/JPG", "image/GIF", "multipart/form-data", "application/pdf", "application/msword","application/vnd.openxmlformats-officedocument.wordprocessingml.document", "text/plain");


    private final Path fileStorageLocation;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public InputSupplierFertilizerServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            //throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",ex);
        }
    }
  


    @Override
    public List<InputSupplierFertilizerDTO> getAllInputSupplierFertilizer(ReportRequestString reportRequestString){
        List<InputSupplierFertilizerDTO> fertilizer = getFertilizerDetail(reportRequestString.getMasterId(), reportRequestString.getRoleId());
        return fertilizer;
    }

    @Override
    public List<FertilizerType> getAllFertilizerType(){
        return fertilizerTypeRepository.findAll();
    }

    @Override
    public List<FertilizerName> getAllFertilizerName(Integer typeId){
        return fertilizerNameRepository.findByFertilizerTypeId(typeId);
    }
  

    @Override
    public InputSupplierFertilizer createInputSupplierFertilizer(InputSupplierFertilizer inputSupplierFertilizer, MultipartFile file){
        String fileName = null;
        inputSupplierFertilizer.setCreateBy(inputSupplierFertilizer.getInputSupplierId());
        inputSupplierFertilizer.setCreateDateTime(Calendar.getInstance());
        if(file!=null){
        try {
            fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String fileContentType = file.getContentType();
                // Check if the file's name contains invalid characters
            if(fileName.contains("..") && contentTypes.contains(fileContentType)) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence or invalid file type" + fileName);
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            //Path path = Paths.get( fileBasePath+fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/inputsupplier/fertilizer/download/")
                    .path(fileName)
                    .toUriString();
            inputSupplierFertilizer.setFilePath(fileDownloadUri);
            inputSupplierFertilizer.setFileName(fileName);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        }
        inputSupplierFertilizer.setDeleted(false);
        return fertilizerRepository.save(inputSupplierFertilizer);
    }

    @Override
    public Boolean deleteInputSupplierFertilizer(Integer id) {
        try {
            InputSupplierFertilizer inputSupplierFertilizer = fertilizerRepository.findById(id).get();
            inputSupplierFertilizer.setDeleted(true);
            inputSupplierFertilizer.setDeleteDate(Calendar.getInstance());
            fertilizerRepository.save(inputSupplierFertilizer);
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
    public InputSupplierFertilizer updateInputSupplierFertilizer(Integer id, InputSupplierFertilizer inputSupplierFertilizer1,  MultipartFile file) {

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
                if (fileName.contains("..") &&  contentTypes.contains(fileContentType)) {
                    throw new FileStorageException("Sorry! Filename contains invalid path sequence & Invalid file type " + fileName);
                }
                // Copy file to the target location (Replacing existing file with the same name)
                targetLocation = this.fileStorageLocation.resolve(fileName);
                //Path path = Paths.get( fileBasePath+fileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/inputsupplier/fertilizer/download/")
                        .path(fileName)
                        .toUriString();
                fertilizerRepository.findById(id)
                        .map(inputSupplierFertilizer -> {
                            inputSupplierFertilizer.setFilePath(fileDownloadUri);
                            inputSupplierFertilizer.setFileName(fileName);
                            return fertilizerRepository.saveAndFlush(inputSupplierFertilizer);
                        }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            }}

        return fertilizerRepository.findById(id)
                .map(inputSupplierFertilizer -> {
                    inputSupplierFertilizer.setUpdateBy(inputSupplierFertilizer.getInputSupplierId());
                    inputSupplierFertilizer.setUpdateDate(Calendar.getInstance());
                    inputSupplierFertilizer.setDeleted(false);
                    inputSupplierFertilizer.setFertilizerType(inputSupplierFertilizer1.getFertilizerType());
                    inputSupplierFertilizer.setFertilizerNameId(inputSupplierFertilizer1.getFertilizerNameId());
                    inputSupplierFertilizer.setInputSupplierId(inputSupplierFertilizer1.getInputSupplierId());
                    inputSupplierFertilizer.setFertilizerGrade(inputSupplierFertilizer1.getFertilizerGrade());
                    inputSupplierFertilizer.setManufacturerName(inputSupplierFertilizer1.getManufacturerName());
                    inputSupplierFertilizer.setQuantity(inputSupplierFertilizer1.getQuantity());
                    return fertilizerRepository.save(inputSupplierFertilizer);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }


    public List<InputSupplierFertilizerDTO> getFertilizerDetail(Integer masterId, String roleId) {
        List<InputSupplierFertilizerDTO> list = null;
        try {
            String sql = "Select  isf.id, ftm.id as type_id, ftm.fertilizer_type, fnm.id as name_id, fnm.fertilizer_name,  isf.fertilizer_grade, isf.manufacturer_name, isf.file_path, isf.quantity \r\n" +
                    "from input_supplier_fertilizer isf \r\n" +
                    "left join fertilizer_type_master ftm on ftm.id=isf.fertilizer_type_id \r\n" +
                    "left join fertilizer_name_master fnm on fnm.id=isf.fertilizer_name_id \r\n" +
                    //"inner join input_supplier isup on isf.input_supplier_id=isup.input_supplier_id \r\n" +
                    "where isf.input_supplier_id=:masterId and isf.role = :roleId and isf.is_deleted = false order by isf.id desc";

            List<InputSupplierFertilizerDTO> obj = (List<InputSupplierFertilizerDTO>) entityManager.createNativeQuery(sql, "InputSupplierFertilizerDTO").setParameter("masterId", masterId).setParameter("roleId", roleId).
            		getResultList();
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
