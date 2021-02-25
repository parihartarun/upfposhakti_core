package com.upfpo.app.service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.EquipmentType;
import com.upfpo.app.entity.EqupmentMaster;
import com.upfpo.app.entity.InputSupplierMachinery;
import com.upfpo.app.properties.FileStorageProperties;
import com.upfpo.app.repository.EquipmentMasterRepository;
import com.upfpo.app.repository.EquipmentTypeRepository;
import com.upfpo.app.repository.InputSupplierMachineryRepository;
import com.upfpo.app.repository.InputSupplierMachineryRepository;
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
public class InputSupplierMachineryServiceImpl implements InputSupplierMachineryService{

    @Autowired
    private InputSupplierMachineryRepository machineryRepository;

    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;

    @Autowired
    private EquipmentMasterRepository equipmentMasterRepository;

    private final Path fileStorageLocation;


    @Autowired
    public InputSupplierMachineryServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            //throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",ex);
        }
    }


    @Override
    public List<InputSupplierMachinery> getAllInputSupplierMachinery() {
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
    public InputSupplierMachinery createInputSupplierMachinery(InputSupplierMachinery inputSupplierMachinery, MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        inputSupplierMachinery.setCreateBy(inputSupplierMachinery.getInputSupplierId());
        inputSupplierMachinery.setCreateDateTime(Calendar.getInstance());
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
            inputSupplierMachinery.setFilePath(fileDownloadUri);
            inputSupplierMachinery.setFileName(fileName);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        inputSupplierMachinery.setDeleted(false);
        return machineryRepository.save(inputSupplierMachinery);
    }

    @Override
    public Boolean deleteInputSupplierMachinery(Integer id) {
        try {
            InputSupplierMachinery inputSupplierMachinery = machineryRepository.findById(id).get();
            inputSupplierMachinery.setDeleted(true);
            inputSupplierMachinery.setDeleteDate(Calendar.getInstance());
            machineryRepository.save(inputSupplierMachinery);
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
    public InputSupplierMachinery updateInputSupplierMachinery(Integer id, InputSupplierMachinery inputSupplierMachinery1, MultipartFile file) {

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
                        .map(inputSupplierMachinery -> {
                            inputSupplierMachinery.setFilePath(fileDownloadUri);
                            inputSupplierMachinery.setFileName(fileName);
                            return machineryRepository.saveAndFlush(inputSupplierMachinery);
                        }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));

            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            }}

        return machineryRepository.findById(id)
                .map(inputSupplierMachinery -> {
                    inputSupplierMachinery.setUpdateBy(inputSupplierMachinery.getInputSupplierId());
                    inputSupplierMachinery.setUpdateDate(Calendar.getInstance());
                    inputSupplierMachinery.setId(inputSupplierMachinery1.getId());
                    inputSupplierMachinery.setDeleted(false);
                    return machineryRepository.save(inputSupplierMachinery);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }

}
