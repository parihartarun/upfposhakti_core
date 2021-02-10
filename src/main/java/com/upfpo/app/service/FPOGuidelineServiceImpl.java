package com.upfpo.app.service;


import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.*;
import com.upfpo.app.properties.FileStorageProperties;
import com.upfpo.app.repository.FPOGuidelinesRepository;
import com.upfpo.app.repository.FPOGuidelinesRepository;
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
import reactor.util.annotation.Nullable;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class FPOGuidelineServiceImpl implements FPOGuidelineService{

    @Autowired
    private FPOGuidelinesRepository fpoGuidelinesRepository;

    private static final Logger LOG = LoggerFactory.getLogger(FPOGuidelineServiceImpl.class);

    //@Value("${upload.path.photo}")
    //String fileBasePath;

    private final Path fileStorageLocation;

    @Autowired
    public FPOGuidelineServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",ex);
        }
    }

    @Override
    public List<FPOGuidelines> getFPOGuidelineByType(FPOGuidelineType fpoGuidelineType){
        //FPOGuidelineType type= FPOGuidelineType.POSTREGISTRATION;
        if(fpoGuidelineType == FPOGuidelineType.POSTREGISTRATION){

            return fpoGuidelinesRepository.findByFpoGuidelineType(FPOGuidelineType.POSTREGISTRATION);
        }
        return fpoGuidelinesRepository.findByFpoGuidelineType(FPOGuidelineType.PREREGISTRATION);
    }

    @Override
    public List<FPOGuidelines> getAllFPOGuidelines(){
        return fpoGuidelinesRepository.findByIsDeleted(false);
    }

    @Override
    public FPOGuidelines uploadFPOGuidline(FPOGuidelines fpoGuideline, MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        fpoGuideline.setFileName(fileName);
        fpoGuideline.setCreateBy(currentPrincipalName);
        fpoGuideline.setCreateDate(Calendar.getInstance());

            try {
                // Check if the file's name contains invalid characters
                if (fileName.contains("..")) {
                    throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
                }
                // Copy file to the target location (Replacing existing file with the same name)
                Path targetLocation = this.fileStorageLocation.resolve(fileName);
                //Path path = Paths.get(fileBasePath + fileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/uploads/FPOGuidelines/")
                        .path(fileName)
                        .toUriString();
                fpoGuideline.setFilePath(fileDownloadUri);
                fpoGuideline.setFileName(fileName);
                fpoGuideline.setUploadDate(Calendar.getInstance());
                fpoGuideline.setUploadBy(currentPrincipalName);
                //fpoGuidelinesRepository.save(fpoGuidelines);
            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            }
        fpoGuideline.setDeleted(false);
        return fpoGuidelinesRepository.save(fpoGuideline);
    }

    @Override
    public FPOGuidelines updateFPOGuidelines(Long id, FPOGuidelines fpoGuidelines1, MultipartFile file)  {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String fileName;
        String currentPrincipalName = authentication.getName();
        String fileDownloadUri;
        Path targetLocation;
        if (file != null ) {
            fileName = StringUtils.cleanPath(file.getOriginalFilename());
            try {
                // Check if the file's name contains invalid characters
                if (fileName.contains("..")) {
                    throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
                }
                // Copy file to the target location (Replacing existing file with the same name)
                targetLocation = this.fileStorageLocation.resolve(fileName);
                //Path path = Paths.get(fileBasePath + fileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("uploads/FPOGuidelines/")
                        .path(fileName)
                        .toUriString();
                fpoGuidelinesRepository.findById(id)
                        .map(fpoGuidelines -> {
                            fpoGuidelines.setFilePath(fileDownloadUri);
                            fpoGuidelines.setFileName(fileName);
                            return fpoGuidelinesRepository.saveAndFlush(fpoGuidelines);
                        }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));

            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            }
        }
        return fpoGuidelinesRepository.findById(id)
                .map(fpoGuidelines -> {
                    fpoGuidelines.setDescription(fpoGuidelines1.getDescription());
                    fpoGuidelines.setId(fpoGuidelines1.getId());
                    fpoGuidelines.setUpdateBy(currentPrincipalName);
                    fpoGuidelines.setUpdateDate(Calendar.getInstance());
                    fpoGuidelines.setDeleted(false);
                    return fpoGuidelinesRepository.save(fpoGuidelines);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }

    @Override
    public Boolean deleteFPOGuidelines(Long id) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            FPOGuidelines fpoGuideline = fpoGuidelinesRepository.findById(id).get();
            fpoGuideline.setDeleted(true);
            fpoGuideline.setDeleteDate(Calendar.getInstance());
            fpoGuideline.setDeleteBy(currentPrincipalName);
            fpoGuidelinesRepository.save(fpoGuideline);
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
            //Path path = Paths.get(fileBasePath + fileName);
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
}
