package com.upfpo.app.service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.*;
import com.upfpo.app.entity.Circulars;
import com.upfpo.app.properties.FileStorageProperties;
import com.upfpo.app.repository.CircularsRepository;
import com.upfpo.app.user.exception.FileStorageException;
import com.upfpo.app.user.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import org.springframework.core.io.UrlResource;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reactor.util.annotation.Nullable;


@Service
public class CircularsServiceImpl implements CircularsService {

    @Autowired
    private CircularsRepository circularsRepository;

    private final Path fileStorageLocation;

    @Autowired
    public CircularsServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",ex);
        }
    }

    @Override
    public List<Circulars> getCirculars() {
        return circularsRepository.findByIsDeleted(false);
    }

    @Override
    public Circulars createCircular (Circulars  circulars, MultipartFile file){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentPrincipalName = authentication.getName();
        circulars.setCreateBy(currentPrincipalName);
        circulars.setCreateDate(Calendar.getInstance());
        circulars.setUploadedBy(currentPrincipalName);
        circulars.setUploadDate(Calendar.getInstance());
        circulars.setDeleted(false);
        if(file!=null){
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            //Path path = Paths.get( fileBasePath+fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/circulars/download/")
                    .path(fileName)
                    .toUriString();
            circulars.setFilePath(fileDownloadUri);
            circulars.setFileName(fileName);
            //complaintRepository.save(complaints);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }}
        circulars.setDeleted(false);
        return circularsRepository.save(circulars);
    }



    @Override
    public Circulars updateCirculars(Integer id, Circulars circulars1, String description,  MultipartFile file) {

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
            //Path path = Paths.get(fileBasePath + fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/circulars/download/")
                    .path(fileName)
                    .toUriString();
            circularsRepository.findById(id)
                    .map(circular -> {
                        circular.setFilePath(fileDownloadUri);
                        circular.setFileName(fileName);
                        return circularsRepository.saveAndFlush(circular);
                    }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }}

        return circularsRepository.findById(id)
                .map(circular -> {
                    circular.setDescription(circulars1.getDescription());
                    circular.setId(circulars1.getId());
                    circular.setDeleted(false);
                    circular.setUpdatedBy(currentPrincipalName);
                    circular.setUpdateDate(Calendar.getInstance());
                    return circularsRepository.saveAndFlush(circular);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }

    @Override
    public Boolean deleteCircular(Integer id) {

        try {
            Circulars circulars = circularsRepository.findById(id).get();
            circulars.setDeleted(true);
            circularsRepository.save(circulars);
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

