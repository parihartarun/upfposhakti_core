package com.upfpo.app.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.dto.FarmerComplaintDTO;
import com.upfpo.app.dto.FarmerLandDetailDto;
import com.upfpo.app.entity.*;
import com.upfpo.app.properties.FileStorageProperties;
import com.upfpo.app.repository.ComplaintCatgoriesRepository;
import com.upfpo.app.repository.ComplaintRepository;
import com.upfpo.app.user.exception.FileStorageException;
import com.upfpo.app.user.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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


import javax.persistence.EntityManager;
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
    private EntityManager entityManager;

    @Autowired
    public ComplaintServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
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
    public Complaints createComplaintByFarmer(Complaints complaints, MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        String role = "ROLE_FARMER";
        complaints.setCreateBy(currentPrincipalName);
        complaints.setStatus(Status.OPEN);
        complaints.setCreateDateTime(Calendar.getInstance());
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            //Path path = Paths.get( fileBasePath+fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/complaint/download/")
                    .path(fileName)
                    .toUriString();
            complaints.setFilePath(fileDownloadUri);
            complaints.setFileName(fileName);
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
            complaints.setDeleteDate(Calendar.getInstance());
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
            //Path path = Paths.get( fileBasePath+fileName);
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
    public Complaints updateComplaint(Integer id, Complaints complaints1,  MultipartFile file) {

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
            //Path path = Paths.get( fileBasePath+fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/complaint/download/")
                    .path(fileName)
                    .toUriString();
            complaintRepository.findById(id)
                    .map(complaints -> {
                        complaints.setFilePath(fileDownloadUri);
                        complaints.setFileName(fileName);
                        return complaintRepository.saveAndFlush(complaints);
                    }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }}

        return complaintRepository.findById(id)
                .map(complaints -> {
                    complaints.setTitle(complaints1.getTitle());
                    complaints.setDescription(complaints1.getDescription());
                    complaints.setIssueType(complaints1.getIssueType());
                    complaints.setUpdateBy(currentPrincipalName);
                    complaints.setUpdateDate(Calendar.getInstance());
                    complaints.setId(complaints1.getId());
                    complaints.setDeleted(false);
                    return complaintRepository.save(complaints);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }


    @Override
    public Complaints complaintAssign(Integer id, Complaints complaints1){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        return complaintRepository.findById(id)
                .map(complaints -> {
                    complaints.setId(complaints1.getId());
                    complaints.setAssignTo(complaints1.getAssignTo());
                    complaints.setAssignBy(currentPrincipalName);
                    complaints.setAssigned_date(Calendar.getInstance().getTime());
                    complaints.setFpoComment(complaints1.getFpoComment());
                    complaints.setDeleted(false);
                    complaints.setStatus(complaints1.getStatus());

                    return complaintRepository.save(complaints);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }


    /*public List<FarmerLandDetailDto> getLandDetailWithFarmerByFarmerId(Integer fpoId)
    {
        String  sql = "select l.land_id as landId, l.land_area as landArea,l.master_id as masterId,l.is_organic as isorganc,l.nature_of_ownership as ownership,f.farmer_id as farmerId, f.farmer_name as farmerName, f.farmer_parants as parantsName from land_details l join farmer f\r\n"
                + "on l.farmer_id = f.farmer_id where l.farmer_id = :farmerId and l.is_deleted = false order by l.land_id desc";

        List<FarmerLandDetailDto> obj =  (List<FarmerLandDetailDto>) entityManager.createNativeQuery(sql,"FarmerLandDetailDto").setParameter("farmerId", farmerId).getResultList();
        return obj;

    }

    public List<FarmerComplaintDTO> getComplaintByFPOId(Integer fpoId)
    {
        String  sql = "select c.id as id, c.fpo_id as fpoid, c.issue_type as issuetype, c.role as role, c.status as status, c.message as message,  c.description as description, c.file_path as filepath, c.create_date_time as createdate, c.file_path as filepath, c.other_type as othertype, c.assigned_to as assignto, c.assigned_by as assignby,  c.comment as deptcomment, c.remarks as remarks, c.file_name as filename from complaints c join fpo f\r\n"
                + "on c.fpo_id = f.fpo_id where c.fpo_id = :fpoId and c.is_deleted = false order by c.id desc";

        List<FarmerComplaintDTO> obj =  (List<FarmerComplaintDTO>) entityManager.createNativeQuery(sql, "FarmerComplaintDTO").setParameter("fpoId", fpoId).getResultList();
        return obj;

    }

    @Override
    public List<FarmerComplaintDTO> getFarmerComplaintToFpo (Integer fpoId){
        //return landDetailsRepo.findAll();
        List<FarmerComplaintDTO> complaint = getComplaintByFPOId(fpoId);
        return complaint;
    }*/

    @Override
    public List<Complaints> getComplaintByFarmerId(Integer farmerId){

        return complaintRepository.findByFarmerId(farmerId);
    }



}

