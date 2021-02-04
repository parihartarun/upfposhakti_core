package com.upfpo.app.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.*;
import com.upfpo.app.repository.ComplaintCatgoriesRepository;
import com.upfpo.app.repository.ComplaintRepository;
import com.upfpo.app.user.exception.FileStorageException;
import com.upfpo.app.user.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
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
import java.util.stream.Stream;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private ComplaintCatgoriesRepository complaintCatgoriesRepository;

    private final Path fileStorageLocation;

    @Autowired
    public ComplaintServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getComplaintDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            //throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",ex);
        }
    }

    public List<Complaints> getAllComplaint(){
        return complaintRepository.findByIsDeleted(false);
    }

    @Override
    public Complaints createComplaint (Complaints complaints, MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        complaints.setCreateBy(currentPrincipalName);
        complaints.setCreateDateTime(Calendar.getInstance());
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("uploads/Complaint&Suggestion/")
                    .path(fileName)
                    .toUriString();
            complaints.setFilePath(fileDownloadUri);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        complaints.setDeleted(false);
        return complaintRepository.save(complaints);
    }

    @Override
    public Boolean deleteComplaint(Integer id) {

        try {
            Complaints complaints = complaintRepository.findById(id).get();
            complaints.setDeleted(true);
            complaints.setDeleteDate(Calendar.getInstance().getTime());
            complaintRepository.save(complaints);
            return true;
        }catch(Exception e)
        {
            throw new NotFoundException();
        }
    }

    @Override
    public List<ComplaintCatgories> getComplaintsCatgories() {
        return complaintCatgoriesRepository.findAll();
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

    @Override
    public Complaints updateComplaint(Integer id, Complaints complaints1, String description, String title, String issueType, MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
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
                    .path("uploads/Complaint/Suggestion/")
                    .path(fileName)
                    .toUriString();
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }

        return complaintRepository.findById(id)
                .map(complaints -> {
                    complaints.setTitle(complaints1.getTitle());
                    complaints.setDescription(complaints1.getDescription());
                    complaints.setIssueType(complaints1.getIssueType());
                    complaints.setId(complaints1.getId());
                    complaints.setDeleted(false);
                    complaints.setFilePath(fileDownloadUri);
                    return complaintRepository.save(complaints);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }

    public Complaints deptComplaintAssign(Integer id, Complaints complaints1){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        return complaintRepository.findById(id)
                .map(complaints -> {
                    complaints.setId(complaints1.getId());
                    complaints.setAssignTo(complaints1.getAssignTo());
                    complaints.setAssignBy(currentPrincipalName);
                    complaints.setAssigned_date(Calendar.getInstance().getTime());
                    complaints.setDeptComment(complaints1.getDeptComment());
                    complaints.setDeleted(false);
                    complaints.setStatus(complaints1.getStatus());

                    return complaintRepository.save(complaints);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }

}

