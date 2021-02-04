package com.upfpo.app.service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.FPOSalesDetails;
import com.upfpo.app.entity.FPOServices;

import com.upfpo.app.entity.FileStorageProperties;
import com.upfpo.app.repository.FPOServicesRepository;
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
import java.util.Optional;

@Service
public class FPOServicesServiceImpl implements FPOServicesService{


    @Autowired
    private FPOServicesRepository fpoServicesRepository;

    private final Path fileStorageLocation;

    @Autowired
    public FPOServicesServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getfposervicesDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            //throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",ex);
        }
    }

    @Override
    public List<FPOServices> getFPOServices() {
        return fpoServicesRepository.findByIsDeleted(false);
    }

    @Override
    public Optional<FPOServices> getFPOServicesById(Integer id) {
        if(!fpoServicesRepository.existsById(id)) {
            return null;
        }
        return fpoServicesRepository.findById(id);
    }

    public FPOServices insertFPOServices (FPOServices fposervices, MultipartFile file){

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        fposervices.setCreatedBy(currentPrincipalName);
        fposervices.setCreatedDate(Calendar.getInstance());
        fposervices.setUploadedBy(currentPrincipalName);
        fposervices.setUploadDate(Calendar.getInstance());
        fposervices.setFileName(fileName);
        fposervices.setDeleted(false);
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("uploads/FPOService/")
                    .path(fileName)
                    .toUriString();
            fposervices.setFilePath(fileDownloadUri);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        return fpoServicesRepository.save(fposervices);
    }


    public FPOServices updateFPOServices(Integer id, FPOServices fpoServices1, String description, String servicename, MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileDownloadUri;
        Path targetLocation;
            try {
                // Check if the file's name contains invalid characters
                if (fileName.contains("..")) {
                    throw new FileStorageException("Sorry! Filename contains invalid path sequence or its null " + fileName);
                }
                // Copy file to the target location (Replacing existing file with the same name)

                targetLocation = this.fileStorageLocation.resolve(fileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("uploads/FPOService/")
                        .path(fileName)
                        .toUriString();

            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            }

        return fpoServicesRepository.findById(id)
                .map(fpoServices -> {
                    fpoServices.setServicename(fpoServices1.getServicename());
                    fpoServices.setDescriptions(fpoServices1.getDescriptions());
                    fpoServices.setFileName(fileName);
                    fpoServices.setId(fpoServices1.getId());
                    fpoServices.setDeleted(false);
                    fpoServices.setFilePath(fileDownloadUri);
                    return fpoServicesRepository.save(fpoServices);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }

    @Override
    public Boolean deleteFPOService(Integer id) {
        if(fpoServicesRepository.findById(id) != null)
        try {
            FPOServices fpoServices = fpoServicesRepository.findById(id).get();
            fpoServices.setDeleted(true);
            fpoServices.setDeleteDate(Calendar.getInstance().getTime());
            fpoServicesRepository.save(fpoServices);
            return true;
        }catch(Exception e)
        {
            throw new NotFoundException();
        }
        else
            return false;
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
