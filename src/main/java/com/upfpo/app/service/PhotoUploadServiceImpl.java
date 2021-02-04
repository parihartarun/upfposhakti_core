package com.upfpo.app.service;


import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.Circulars;
import com.upfpo.app.entity.PhotoUpload;
import com.upfpo.app.entity.FileStorageProperties;
import com.upfpo.app.entity.PhotoUpload;
import com.upfpo.app.repository.PhotoUploadRepository;
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
public class PhotoUploadServiceImpl implements PhotoUploadService {

    @Autowired
    private PhotoUploadRepository photoUploadRepository;

    private final Path fileStorageLocation;

    @Autowired
    public PhotoUploadServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getPhotouploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",ex);
        }
    }

    @Override
    public List<PhotoUpload> getAllPhotoUpload(){
        return photoUploadRepository.findAll();
    }

    @Override
    public PhotoUpload uploadPhoto (PhotoUpload  photoUpload, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        photoUpload.setFileName(fileName);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        photoUpload.setCreateBy(currentPrincipalName);
        photoUpload.setCreateDate(Calendar.getInstance());
        if (file != null){
            try {
                // Check if the file's name contains invalid characters
                if (fileName.contains("..")) {
                    throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
                }
                // Copy file to the target location (Replacing existing file with the same name)
                Path targetLocation = this.fileStorageLocation.resolve(fileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("uploads/Photos/")
                        .path(fileName)
                        .toUriString();
                photoUpload.setFilePath(fileDownloadUri);
                //photoUploadRepository.save(photoUploads);
            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            }}

        photoUpload.setDeleted(false);
        return photoUploadRepository.save(photoUpload);
    }

    @Override
    public PhotoUpload updatePhotoUpload(Integer id, PhotoUpload photoUploads1,  MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename()); Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        String fileDownloadUri;
        Path targetLocation;
        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            // Copy file to the target location (Replacing existing file with the same name)
            targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("uploads/Photos/")
                    .path(fileName)
                    .toUriString();

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }

        return photoUploadRepository.findById(id)
                .map(photoUploads -> {
                    photoUploads.setDescription(photoUploads1.getDescription());
                    photoUploads.setFilePath(fileDownloadUri);
                    photoUploads.setId(photoUploads1.getId());
                    photoUploads.setDeleted(false);
                    photoUploads.setFilePath(String.valueOf(targetLocation));
                    return photoUploadRepository.save(photoUploads);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }

    @Override
    public Boolean deletePhotoUpload(Integer id) {

        try {
            PhotoUpload photoUpload = photoUploadRepository.findById(id).get();
            photoUpload.setDeleted(true);
            photoUpload.setDeleteDate(Calendar.getInstance().getTime());
            photoUploadRepository.save(photoUpload);
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
