package com.upfpo.app.service;


import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.InputSupplierInsecticide;
import com.upfpo.app.properties.FileStorageProperties;
import com.upfpo.app.repository.InputSupplierInsecticideRepository;
import com.upfpo.app.repository.InputSupplierInsecticideRepository;
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
public class InputSupplierInsecticideServiceImpl implements InputSupplierInsecticideService {

    @Autowired
    private InputSupplierInsecticideRepository insecticideRepository;


    private final Path fileStorageLocation;


    @Autowired
    public InputSupplierInsecticideServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            //throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",ex);
        }
    }

    @Override
    public List<InputSupplierInsecticide> getAllInputSupplierInsecticide(){
        return insecticideRepository.findByIsDeletedOrderByIdDesc(false);
    }

    @Override
    public InputSupplierInsecticide createInputSupplierInsecticide(InputSupplierInsecticide inputSupplierInsecticide, MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        inputSupplierInsecticide.setCreateBy(inputSupplierInsecticide.getInputSupplierId());
        inputSupplierInsecticide.setCreateDateTime(Calendar.getInstance());
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
                    .path("/inputsupplier/insecticide/download/")
                    .path(fileName)
                    .toUriString();
            inputSupplierInsecticide.setFilePath(fileDownloadUri);
            inputSupplierInsecticide.setFileName(fileName);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        inputSupplierInsecticide.setDeleted(false);
        return insecticideRepository.save(inputSupplierInsecticide);
    }

    @Override
    public Boolean deleteInputSupplierInsecticide(Integer id) {
        try {
            InputSupplierInsecticide inputSupplierInsecticide = insecticideRepository.findById(id).get();
            inputSupplierInsecticide.setDeleted(true);
            inputSupplierInsecticide.setDeleteDate(Calendar.getInstance());
            insecticideRepository.save(inputSupplierInsecticide);
            return true;
        }catch(Exception e)
        {
            throw new NotFoundException();
        }
    }

   /* @Override
    public List<Crop> getInputSupplierInsecticideCatgories() {
        return complaintCatgoriesRepository.findAll();
    }*/



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
    public InputSupplierInsecticide updateInputSupplierInsecticide(Integer id, InputSupplierInsecticide inputSupplierInsecticide1, MultipartFile file) {

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
                        .path("/inputsupplier/insecticide/download/i")
                        .path(fileName)
                        .toUriString();
                insecticideRepository.findById(id)
                        .map(inputSupplierInsecticide -> {
                            inputSupplierInsecticide.setFilePath(fileDownloadUri);
                            inputSupplierInsecticide.setFileName(fileName);
                            return insecticideRepository.saveAndFlush(inputSupplierInsecticide);
                        }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));

            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            }}

        return insecticideRepository.findById(id)
                .map(inputSupplierInsecticide -> {
                    inputSupplierInsecticide.setUpdateBy(inputSupplierInsecticide.getInputSupplierId());
                    inputSupplierInsecticide.setUpdateDate(Calendar.getInstance());
                    inputSupplierInsecticide.setId(inputSupplierInsecticide1.getId());
                    inputSupplierInsecticide.setDeleted(false);
                    return insecticideRepository.save(inputSupplierInsecticide);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }

}
