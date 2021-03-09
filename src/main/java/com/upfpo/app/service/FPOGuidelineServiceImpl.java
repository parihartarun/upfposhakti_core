package com.upfpo.app.service;


import com.upfpo.app.auth.response.UploadFileResponse;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reactor.util.annotation.Nullable;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private FileStorageService fileStorageService;

    private static final Logger LOG = LoggerFactory.getLogger(FPOGuidelineServiceImpl.class);

    @Autowired
    private FileStorageProperties fileStorageProperties;

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

            return fpoGuidelinesRepository.findByFpoGuidelineTypeOrderByIdDesc(FPOGuidelineType.POSTREGISTRATION);
        }
        return fpoGuidelinesRepository.findByFpoGuidelineTypeOrderByIdDesc(FPOGuidelineType.PREREGISTRATION);
    }

    @Override
    public List<FPOGuidelines> getAllFPOGuidelines(){
        return fpoGuidelinesRepository.findByIsDeletedOrderByIdDesc(false);
    }





    @Override
    public FPOGuidelines uploadFPOGuidline(FPOGuidelines fpoGuideline, MultipartFile file, MultipartFile hindiFile) {
        String fileName1 = fileStorageService.storeFile(file);
        String fileName2 = fileStorageService.storeFile(hindiFile);
            if(fileName1 != null ) {
                fileName1 = fileName1.trim();
                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/fpoguidelines/download/")
                        .path(fileName1)
                        .toUriString();
                fpoGuideline.setFilePath(fileDownloadUri);
                fpoGuideline.setFileName(fileName1);

            }
            if(fileName2 != null ) {
                fileName2 = fileName2.trim();
                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/fpoguidelines/download/")
                        .path(fileName2)
                        .toUriString();
                fpoGuideline.setFilePath(fileDownloadUri);
                fpoGuideline.setFileName(fileName2);

            }
        fpoGuideline.setDeleted(false);
        fpoGuideline.setUploadDate(Calendar.getInstance());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        fpoGuideline.setUploadBy(currentPrincipalName);
        fpoGuideline.setCreateBy(currentPrincipalName);
        fpoGuideline.setCreateDate(Calendar.getInstance());
        return fpoGuidelinesRepository.save(fpoGuideline);
    }


    @Override
    public FPOGuidelines updateFPOGuidelines(Integer id, FPOGuidelines fpoGuidelines1, MultipartFile file)  {

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
                        .path("/fpoguidelines/download/")
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
                    fpoGuidelines.setUpdateBy(currentPrincipalName);
                    fpoGuidelines.setUpdateDate(Calendar.getInstance());
                    fpoGuidelines.setDeleted(false);
                    return fpoGuidelinesRepository.saveAndFlush(fpoGuidelines);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }

    private boolean isSupportedContentType(String contentType) {
        return contentType.equals("application/pdf");

    }

    @Override
    public Boolean deleteFPOGuidelines(Long id) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            FPOGuidelines fpoGuideline = fpoGuidelinesRepository.findById(id.intValue()).get();
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
    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
