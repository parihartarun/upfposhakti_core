package com.upfpo.app.service;

import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.FPOSalesDetails;
import com.upfpo.app.entity.FPOServices;

import com.upfpo.app.entity.FileStorageProperties;
import com.upfpo.app.repository.FPOServicesRepository;
import com.upfpo.app.user.exception.FileStorageException;
import com.upfpo.app.user.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class FPOServicesServiceImpl implements FPOServicesService{


    @Autowired
    private FPOServicesRepository fpoServicesRepository;

    private final Path fileStorageLocation;

    @Override
    public List<FPOServices> getFPOServices() {
        return fpoServicesRepository.findAll();
    }

    @Autowired
    public FPOServicesServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            //throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",ex);
        }
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
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            fposervices.setFilePath(String.valueOf(targetLocation));
            //fposerviceRepository.save(fposervices);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        return fpoServicesRepository.save(fposervices);
    }



   /* @Override
    public FPOServices insertFPOServices(FPOServices FPOServices) {
        fpoServicesRepository.save(FPOServices);
        return FPOServices;
    }*/


    public FPOServices updateFPOServices(Integer id, FPOServices fpoServices1, String description, String servicename, MultipartFile file) {


        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path targetLocation;
        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            // Copy file to the target location (Replacing existing file with the same name)
            targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);


        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }

        return fpoServicesRepository.findById(id)
                .map(fpoServices -> {
                    fpoServices.setServicename(fpoServices1.getServicename());
                    fpoServices.setDescriptions(fpoServices1.getDescriptions());
                    fpoServices.setId(fpoServices1.getId());
                    fpoServices.setFilePath(String.valueOf(targetLocation));
                    return fpoServicesRepository.save(fpoServices);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));


    }

    @Override
    public Optional deleteFPOServices(Integer id) {
        return fpoServicesRepository.findById(id)
                .map(FPOServices -> {
                    fpoServicesRepository.delete(FPOServices);
                    return "Delete Successfully!";
                });
    }



}
