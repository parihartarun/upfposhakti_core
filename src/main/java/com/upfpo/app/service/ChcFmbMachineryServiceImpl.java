package com.upfpo.app.service;

import com.upfpo.app.configuration.exception.NotFoundException;
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

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.List;

@Service
public class ChcFmbMachineryServiceImpl implements ChcFmbMachineryService {

    @Autowired
    private ChcFmbMachineryRepository machineryRepository;

    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;

    @Autowired
    private EquipmentMasterRepository equipmentMasterRepository;

    private final Path fileStorageLocation;


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
    public List<ChcFmbMachinery> getAllChcFmbMachinery() {
        return machineryRepository.findByIsDeletedOrderByIdDesc(false);
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
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        chcFmbMachinery.setCreateBy(chcFmbMachinery.getChcFmbId());
        chcFmbMachinery.setCreateDateTime(Calendar.getInstance());
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
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
        }
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
            fileName = StringUtils.cleanPath(file.getOriginalFilename());
            try {
                // Check if the file's name contains invalid characters
                if (fileName.contains("..")) {
                    throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
                }
                // Copy file to the target location (Replacing existing file with the same name)
                targetLocation = this.fileStorageLocation.resolve(fileName);
                //Path path = Paths.get( fileBasePath+fileName);
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
                    chcFmbMachinery.setUpdateBy(chcFmbMachinery.getInputSupplierId());
                    chcFmbMachinery.setUpdateDate(Calendar.getInstance());
                    chcFmbMachinery.setId(chcFmbMachinery1.getId());
                    chcFmbMachinery.setDeleted(false);
                    return machineryRepository.save(chcFmbMachinery);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }

}
