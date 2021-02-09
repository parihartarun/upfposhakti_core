package com.upfpo.app.service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.SchemeDetail;

import com.upfpo.app.entity.FileStorageProperties;

import com.upfpo.app.repository.SchemeDetailRepository;
import com.upfpo.app.user.exception.FileStorageException;
import com.upfpo.app.user.exception.ResourceNotFoundException;
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

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.List;

@Service
public class SchemeDetailServiceImpl implements SchemeDetailService {

    @Autowired
    private SchemeDetailRepository schemeDetailRepository;

    //@Value("${upload.path.schemedetail}")
    //private String fileBasePath;
    

    private final Path fileStorageLocation;

    @Autowired
    public SchemeDetailServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getSchemedetailDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            //throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",ex);
        }
    }

    public List<SchemeDetail> getAllSchemeDetail(){
        return schemeDetailRepository.findByIsDeleted(false);
    }

    @Override
    public SchemeDetail createSchemeDetail (SchemeDetail schemeDetail, MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        schemeDetail.setCreateBy(currentPrincipalName);
        schemeDetail.setCreateDate(Calendar.getInstance());
        schemeDetail.setDeleted(false);
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            //Path path = Paths.get(fileBasePath + fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("uploads/SchemeDetail/")
                    .path(fileName)
                    .toUriString();
            schemeDetail.setFilePath(fileDownloadUri);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        schemeDetail.setDeleted(false);
        return schemeDetailRepository.save(schemeDetail);
    }

    @Override
    public Boolean deleteSchemeDetail(Integer id) {

        try {
            SchemeDetail schemeDetail = schemeDetailRepository.findById(id).get();
            schemeDetail.setDeleted(true);
            schemeDetail.setDeleteDate(Calendar.getInstance());
            schemeDetailRepository.save(schemeDetail);
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

    @Override
    public SchemeDetail updateSchemeDetail(Integer id, SchemeDetail schemeDetail1,  MultipartFile file) {

        String fileName;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        String fileDownloadUri;
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
                    .path("uploads/SchemeDetail/")
                    .path(fileName)
                    .toUriString();
            schemeDetailRepository.findById(id)
                    .map(schemeDetail -> {
                        schemeDetail.setFilePath(fileDownloadUri);
                        schemeDetail.setFileName(fileName);
                        return schemeDetailRepository.saveAndFlush(schemeDetail);
                    }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        }

        return schemeDetailRepository.findById(id)
                .map(schemeDetail -> {
                    schemeDetail.setDescription(schemeDetail1.getDescription());
                    schemeDetail.setId(schemeDetail1.getId());
                    schemeDetail.setUploadDate(Calendar.getInstance());
                    schemeDetail.setUploadedBy(currentPrincipalName);
                    schemeDetail.setDeleted(false);
                    return schemeDetailRepository.save(schemeDetail);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }


}


