package com.upfpo.app.service;


import com.upfpo.app.entity.Circulars;
import com.upfpo.app.entity.FileStorageProperties;
import com.upfpo.app.entity.PhotoUpload;
import com.upfpo.app.repository.PhotoUploadRepository;
import com.upfpo.app.user.exception.FileStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
    public PhotoUpload uploadPhoto (PhotoUpload  photoUpload, MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        photoUpload.setFileName(fileName);
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            photoUpload.setFilePath(String.valueOf(targetLocation));
            //complaintRepository.save(complaints);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        return photoUploadRepository.save(photoUpload);
    }
}
