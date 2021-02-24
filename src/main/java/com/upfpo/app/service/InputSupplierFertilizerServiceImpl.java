package com.upfpo.app.service;


import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.FertilizerName;
import com.upfpo.app.entity.FertilizerType;
import com.upfpo.app.entity.InputSupplierFertilizer;
import com.upfpo.app.entity.InputSupplierFertilizer;
import com.upfpo.app.properties.FileStorageProperties;
import com.upfpo.app.repository.FertilizerNameRepository;
import com.upfpo.app.repository.FertilizerTypeRepository;
import com.upfpo.app.repository.InputSupplierFertilizerRepository;
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

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

    private final Path fileStorageLocation;

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
    public List<InputSupplierFertilizer> getAllInputSupplierFertilizer(){
        return fertilizerRepository.findByIsDeletedOrderByIdDesc(false);
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
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        inputSupplierFertilizer.setCreateBy(inputSupplierFertilizer.getInputSupplierId());
        inputSupplierFertilizer.setCreateDateTime(Calendar.getInstance());
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
                    .path("/inputsupplier/fertilizer/download/")
                    .path(fileName)
                    .toUriString();
            inputSupplierFertilizer.setFilePath(fileDownloadUri);
            inputSupplierFertilizer.setFileName(fileName);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
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
                    return fertilizerRepository.save(inputSupplierFertilizer);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }

}
