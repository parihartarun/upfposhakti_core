package com.upfpo.app.service;


import com.upfpo.app.entity.FPOGuidelines;
import com.upfpo.app.entity.FPOSalesDetails;
import com.upfpo.app.repository.FPOGuidelinesRepository;
import com.upfpo.app.user.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FPOGuidelineServiceImpl implements FPOGuidelineService{

    private final Path root = Paths.get("uploads/FPOGuidelines");


    @Autowired
    private FPOGuidelinesRepository fpoGuidelinesRepository;

    //Get all FPOGuidelines
    public List<FPOGuidelines> getAllFPOGuidelines (){
        return fpoGuidelinesRepository.findAll();
    }

    //Find By Id
    public FPOGuidelines getFPOGuidelinesByID(Long id) {
        Optional<FPOGuidelines> FPOGuidelines = fpoGuidelinesRepository.findById(id);
        if(FPOGuidelines.isPresent()) {
            return FPOGuidelines.get();
        }else {
            throw new ResourceNotFoundException("Not Found");
        }
    }

    //create new FPOGuidelines
    public FPOGuidelines createFPOGuidelines(FPOGuidelines fpoGuidelines){
        return fpoGuidelinesRepository.save(fpoGuidelines);
    }



    //Update FPOGuidelines
    public FPOGuidelines updateFPOGuidelines(Long id, FPOGuidelines fpoGuidelines) {
        Optional<FPOGuidelines> sd = fpoGuidelinesRepository.findById(id);
        if(!sd.isPresent()) {
            return null;
        }

        fpoGuidelines.setId(new Long(id));

        return fpoGuidelinesRepository.save(fpoGuidelines);
    }


    //Delete FPOGuidelines
    public Optional deleteFPOGuidelines(Long id) {
        return fpoGuidelinesRepository.findById(id)
                .map(fpoGuidelines -> {
                    fpoGuidelinesRepository.delete(fpoGuidelines);
                    return "Delete Successfully!";
                });
    }

    public void save(MultipartFile file) {
        FPOGuidelines fpoGuidelines = new FPOGuidelines();

        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            /*String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String filePath = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/upload/FPOGuidelines")
                    .path(String.valueOf(fpoGuidelines.getId()))
                    .toUriString();
            fpoGuidelines.setFilePath(filePath);
            fpoGuidelines.setFileName(fileName);
            fpoGuidelinesRepository.save(fpoGuidelines);*/
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }


    public UrlResource load(String filename) {
        try {
            Path file = root.resolve(filename);
            UrlResource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void init() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }


}
