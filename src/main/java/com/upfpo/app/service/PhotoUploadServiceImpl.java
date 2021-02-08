package com.upfpo.app.service;


import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.controller.PhotoUploadController;
import com.upfpo.app.entity.Circulars;
import com.upfpo.app.entity.PhotoUpload;
import com.upfpo.app.entity.FileStorageProperties;
import com.upfpo.app.entity.PhotoUpload;
import com.upfpo.app.repository.PhotoUploadRepository;
import com.upfpo.app.user.exception.FileStorageException;
import com.upfpo.app.user.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class PhotoUploadServiceImpl implements PhotoUploadService {

    @Autowired
    private PhotoUploadRepository photoUploadRepository;

    private static final Logger LOG = LoggerFactory.getLogger(PhotoUploadServiceImpl.class);

    //@Value("${upload.path.photo}")
    //String fileBasePath;

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
                //Path path = Paths.get(fileBasePath + fileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("uploads/Photos/")
                        .path(fileName)
                        .toUriString();
                photoUpload.setFilePath(fileDownloadUri);
                photoUpload.setUploadDate(Calendar.getInstance());
                photoUpload.setUploadedBy(currentPrincipalName);
                //photoUploadRepository.save(photoUploads);
            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            }}

        photoUpload.setDeleted(false);
        return photoUploadRepository.save(photoUpload);
    }

    @Override
    public PhotoUpload updatePhotoUpload(Integer id, PhotoUpload photoUploads1, @Nullable MultipartFile file) throws IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        String fileName;
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
                        .path("uploads/Photos/")
                        .path(fileName)
                        .toUriString();
                photoUploadRepository.findById(id)
                        .map(photoUploads -> {
                            photoUploads.setFilePath(fileDownloadUri);
                            photoUploads.setFileName(fileName);
                            return photoUploadRepository.saveAndFlush(photoUploads);
                        }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));

            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            }
        }

        return photoUploadRepository.findById(id)
                .map(photoUploads -> {
                    photoUploads.setDescription(photoUploads1.getDescription());
                    photoUploads.setId(photoUploads1.getId());
                    photoUploads.setFileName(photoUploads1.getFileName());
                    photoUploads.setFilePath(photoUploads1.getFilePath());
                    photoUploads.setUpdatedBy(currentPrincipalName);
                    photoUploads.setUpdateDate(Calendar.getInstance());
                    photoUploads.setDeleted(false);
                    return photoUploadRepository.saveAndFlush(photoUploads);
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
