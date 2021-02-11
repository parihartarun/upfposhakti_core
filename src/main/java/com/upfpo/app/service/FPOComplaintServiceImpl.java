package com.upfpo.app.service;

import com.upfpo.app.dto.FarmerComplaintDTO;
import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.FPOComplaints;
import com.upfpo.app.entity.Status;
import com.upfpo.app.properties.FileStorageProperties;
import com.upfpo.app.repository.ComplaintRepository;
import com.upfpo.app.repository.FPOComplaintRepository;
import com.upfpo.app.user.exception.FileStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.List;

@Service
public class FPOComplaintServiceImpl implements FPOComplaintService {

    @Autowired
    FPOComplaintRepository fpoComplaintRepository;

    @Autowired
    ComplaintRepository complaintRepository;

    private final Path fileStorageLocation;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public FPOComplaintServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            //throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",ex);
        }
    }


    @Override
    public FPOComplaints createComplaintByFPO(FPOComplaints complaints, MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        complaints.setStatus(Status.OPEN);
        complaints.setCreateBy(currentPrincipalName);
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
                    .path("/downloadFile/")
                    .path(fileName)
                    .toUriString();
            complaints.setFilePath(fileDownloadUri);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        complaints.setDeleted(false);
        return fpoComplaintRepository.save(complaints);
    }

    @Override
    public List<FarmerComplaintDTO> getFarmerComplaintToFpo(Integer fpoId){

        List<FarmerComplaintDTO> complaint = getComplaintByFPOId(fpoId);
        return complaint;
    }


    public List<FarmerComplaintDTO> getComplaintByFPOId(Integer fpoId)
    {
        String  sql = "select c.id as id, c.fpo_id as fpoid, c.issue_type as issuetype, c.role as role, c.status as status, c.message as message,  c.description as description, c.file_path as filepath, c.create_date_time as createdate, c.other_type as othertype, c.assigned_to as assignto, c.assigned_by as assignby,  c.comment as deptcomment, c.remarks as remarks, c.file_name as filename from complaints c join fpo f\r\n"
                + "on c.fpo_id = f.fpo_id where c.fpo_id = :fpoId and c.is_deleted = false order by c.id desc";

        List<FarmerComplaintDTO> obj =  (List<FarmerComplaintDTO>) entityManager.createNativeQuery(sql, "FarmerComplaintDTO").setParameter("fpoId", fpoId).getResultList();
        return obj;

    }

    @Override
    public List<Complaints> getFarmerComplaintByFPOId(Integer fpoId){


        List<Complaints> complaint = complaintRepository.findByFpoId(fpoId);
        return complaint;
    }

}


