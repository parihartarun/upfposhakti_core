package com.upfpo.app.service;

import com.upfpo.app.dto.BuyerSellerComplaintsDto;
import com.upfpo.app.dto.ChcFmbComplaintsDto;
import com.upfpo.app.dto.DepartmentProdReportDto;
import com.upfpo.app.dto.FarmerComplaintDTO;
import com.upfpo.app.dto.FarmerComplaintDetailDTO;
import com.upfpo.app.dto.InputSupplierComplaintsDto;
import com.upfpo.app.entity.ChcIsBsComplaints;
import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.FPOComplaints;
import com.upfpo.app.entity.Status;
import com.upfpo.app.properties.FileStorageProperties;
import com.upfpo.app.repository.ChcIsBsComplaintRepository;
import com.upfpo.app.repository.ComplaintRepository;
import com.upfpo.app.repository.FPOComplaintRepository;
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

import javax.persistence.EntityManager;
import java.io.IOException;
import java.net.MalformedURLException;
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
    ChcIsBsComplaintRepository chcIsBsComplaintRepository;

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

    /*@Override
    public List<FarmerComplaintDTO> getFarmerComplaintToFpo(Integer fpoId){

        List<FarmerComplaintDTO> complaint = getComplaintByFPOId(fpoId);
        return complaint;
    }*/

    @Override
    public List<FPOComplaints> getAllComplaintToDept(){

        return fpoComplaintRepository.findByIsDeletedOrderByIdDesc(false);
    }


    @Override
    public FPOComplaints createComplaintByFPO(FPOComplaints complaints, MultipartFile file){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String fileName = "";
        String currentPrincipalName = authentication.getName();
        complaints.setStatus(Status.OPEN);
        complaints.setCreateBy(currentPrincipalName);
        complaints.setCreateDateTime(Calendar.getInstance());
        if(file != null)
        {
        try {
        	 fileName = StringUtils.cleanPath(file.getOriginalFilename());
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            //Path path = Paths.get( fileBasePath+fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/fpocomplaint/download/")
                    .path(fileName)
                    .toUriString();
            complaints.setFilePath(fileDownloadUri);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
       }
        complaints.setDeleted(false);
        return fpoComplaintRepository.save(complaints);
    }


    @Override
    public ChcIsBsComplaints createComplaintByInpuSupplier(ChcIsBsComplaints complaints, MultipartFile file){
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
                    .path("/fpocomplaint/download/")
                    .path(fileName)
                    .toUriString();
            complaints.setFilePath(fileDownloadUri);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        complaints.setDeleted(false);
        return chcIsBsComplaintRepository.save(complaints);
    }
    
    public ChcIsBsComplaints createComplaintByBuyerSeller(ChcIsBsComplaints complaints, MultipartFile file){
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
                    .path("/fpocomplaint/download/")
                    .path(fileName)
                    .toUriString();
            complaints.setFilePath(fileDownloadUri);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        complaints.setDeleted(false);
        return chcIsBsComplaintRepository.save(complaints);
    }


    @Override
    public ChcIsBsComplaints createComplaintByCHCFMB(ChcIsBsComplaints complaints, MultipartFile file){
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
                    .path("/fpocomplaint/download/")
                    .path(fileName)
                    .toUriString();
            complaints.setFilePath(fileDownloadUri);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        complaints.setDeleted(false);
        return chcIsBsComplaintRepository.save(complaints);
    }


    public List<FarmerComplaintDTO> getComplaintByFPOId(Integer fpoId)
    {
        String  sql = "select c.id as id, c.fpo_id as fpoid, c.issue_type as issuetype, c.title as ftitle, c.role as role, c.status as status, c.message as message,  "
        		+ "c.description as description, c.file_path as filepath, c.create_date_time as createdate, c.other_type as othertype, "
        		+ "c.assign_to as assignto, c.assign_by as assignby,  c.comment as deptcomment, c.remarks as remarks, c.file_name as filename, c.assign_date as assigneddate,"
        		+ "f.fpo_name as fponame ,f.fpo_email as fpoemail from fpo_complaints c join fpo f\r\n"
                + "on c.fpo_id = f.fpo_id where c.fpo_id = :fpoId and c.is_deleted = false order by c.id desc";

        List<FarmerComplaintDTO> obj =  (List<FarmerComplaintDTO>) entityManager.createNativeQuery(sql, "FarmerComplaintDTO").setParameter("fpoId", fpoId).getResultList();
        return obj;

    }

    public List<FarmerComplaintDetailDTO> getFarmerComplaintDetailByFPOId(Integer fpoId)
    {
//        String  sql = "select fm.fpo_ref_id as fpoId ,fm.farmer_id as farmerId, fm.farmer_name as farmername, fm.farmer_mob as farmermobile from farmer fm join fpo fp \r\n"
//                + "on fm.fpo_ref_id = fp.fpo_id where fm.fpo_ref_id = :fpoId and fm.is_deleted = false order by fm.farmer_id desc";
       
        String  sql = "select c.id as id, c.fpo_id as fpoid, f.farmer_id as farmerid, c.issue_type as issuetype,c.title as ftitle, c.role as role, c.status as status, c.message as message,  \r\n"
        		+ "c.description as description, c.file_path as filepath, c.create_date_time as createdate, c.other_type as othertype, \r\n"
        		+ "c.assigned_to as assignto, c.assigned_by as assignby,  c.comment as deptcomment, c.remarks as remarks, c.file_name as filename,c.assigned_date as assigneddate,\r\n"
        		+ "f.farmer_name as farmername ,f.farmer_mob as farmermobile from complaints c join farmer f\r\n"
        		+ "on c.farmerid = f.farmer_id where f.fpo_ref_id = :fpoId and c.is_deleted = false order by c.id desc";
        
        List<FarmerComplaintDetailDTO> obj =  (List<FarmerComplaintDetailDTO>) entityManager.createNativeQuery(sql, "FarmerComplaintDetailDTO").setParameter("fpoId", fpoId).getResultList();
        return obj;

    }

    @Override
    public List<FarmerComplaintDetailDTO> getFarmerComplaintByFPOId(Integer fpoId){


        //List<FarmerComplaintDetailDTO> complaint = complaintRepository.findByFpoId(fpoId);
    	List<FarmerComplaintDetailDTO> farmer = getFarmerComplaintDetailByFPOId(fpoId);
        return farmer;
    }

    @Override
    public List<FarmerComplaintDTO> getComplaintByFpoId(Integer fpoId){
        //List<FPOComplaints> complaint = fpoComplaintRepository.findByFpoId(fpoId);
        List<FarmerComplaintDTO> complaint = getComplaintByFPOId(fpoId);
        return complaint;
    }
    
    @Override
    public List<ChcIsBsComplaints> getComplaintBySupplierId(Integer masterId){

        List<ChcIsBsComplaints> complaint = chcIsBsComplaintRepository.findByMasterIdOrderByIdDesc(masterId);
        return complaint;
    }

    @Override
    public List<ChcIsBsComplaints> getComplaintByChcFmbId(Integer masterId){

        List<ChcIsBsComplaints> complaint = chcIsBsComplaintRepository.findByMasterIdOrderByIdDesc(masterId);
        return complaint;
    }
    
    @Override
    public List<ChcIsBsComplaints> getComplaintByBuyerSellerId(Integer masterId){

        List<ChcIsBsComplaints> complaint = chcIsBsComplaintRepository.findByMasterIdOrderByIdDesc(masterId);
        return complaint;
    }
    
    @Override
    public List<InputSupplierComplaintsDto> getAllComplaintInputSupplierByRole(String role){
    	return getAllComplaintInputSupplierByRoleQuery(role);
    }
    
    private List<InputSupplierComplaintsDto> getAllComplaintInputSupplierByRoleQuery(String role) {
    	List<InputSupplierComplaintsDto> isComplaint = null;
    	String sql = null;
		String basequery = "Select cc.id as id, cc.master_id as masterId, cc.role, cc.title, cc.message, cc.status, "
				+ "cc.issue_type as issueType, cc.other_type as otherType, cc.description, cc.assigned_other as otherAssigned, "
				+ "cc.assign_to as assignTo, cc.assign_By as assignBy, cc.assign_date, cc.resolve_date, cc.comment as deptComment,"
				+ "cc.remarks, cc.file_path as filePath, cc.file_name as fileName, cc.upload_date as uploadDate,"
				+ "cc.uplaoded_by as uploadedBy, cc.update_date as updateDate, cc.update_by as updateBy, cc.is_deleted as isDeleted, "
				+ "cc.delete_date as deleteDate, cc.create_by as createBy,";
		String joinquery = null;
		String wherecondition = "where cc.role = :role";
		
    	if(role != null && role.equals("ROLE_INPUTSUPPLIER")) {
    		joinquery = "ii.input_supplier_name as inputSupplierName, ii.email, ii.mobile_number as mobileNumber from chcisbs_complaints cc "
    				+ "join input_supplier ii on cc.master_id = ii.input_supplier_id";
    	}
    	
    	sql = basequery + " " +joinquery+ " " + wherecondition;
    	isComplaint = (List<InputSupplierComplaintsDto>) entityManager
				.createNativeQuery(sql, "InputSupplierComplaintsDto")
				.setParameter("role", role).getResultList();
    	return isComplaint;
	}

	@Override
    public List<BuyerSellerComplaintsDto> getAllComplaintBuyerSellerByRole(String role){
    	List<BuyerSellerComplaintsDto> cibComplaint = null;
    	cibComplaint = getAllComplaintBuyerSellerByRoleQuery(role);
		return cibComplaint;
       
    }
    
    private List<BuyerSellerComplaintsDto> getAllComplaintBuyerSellerByRoleQuery(String role) {
    	List<BuyerSellerComplaintsDto> bsComplaint = null;
    	String sql = null;
		String basequery = "Select cc.id as id, cc.master_id as masterId, cc.role, cc.title, cc.message, cc.status, "
				+ "cc.issue_type as issueType, cc.other_type as otherType, cc.description, cc.assigned_other as otherAssigned, "
				+ "cc.assign_to as assignTo, cc.assign_By as assignBy, cc.assign_date, cc.resolve_date, cc.comment as deptComment,"
				+ "cc.remarks, cc.file_path as filePath, cc.file_name as fileName, cc.upload_date as uploadDate,"
				+ "cc.uplaoded_by as uploadedBy, cc.update_date as updateDate, cc.update_by as updateBy, cc.is_deleted as isDeleted, "
				+ "cc.delete_date as deleteDate, cc.create_by as createBy, ";
		String joinquery = null;
		String wherecondition = "where cc.role = :role";
		
    	if(role != null && role.equals("ROLE_BUYERSELLER")) {
    		joinquery = "bs.buyerseller_name as buyerSellerName, bs.email, bs.mobile_number as mobileNumber from chcisbs_complaints cc "
    				+ "join buyer_seller bs on cc.master_id = bs.buyerseller_id";
    	}
    	
    	sql = basequery + " " +joinquery+ " " + wherecondition;
    	bsComplaint = (List<BuyerSellerComplaintsDto>) entityManager
				.createNativeQuery(sql, "BuyerSellerComplaintsDto")
				.setParameter("role", role).getResultList();
    	return bsComplaint;
	}

	@Override
    public List<ChcFmbComplaintsDto> getAllComplaintChcFmbByRole(String role){
    	List<ChcFmbComplaintsDto> cfComplaint = null;
    	cfComplaint = getAllComplaintChcFmbByRoleQuery(role);
		return cfComplaint;
       
    }
    
    private List<ChcFmbComplaintsDto> getAllComplaintChcFmbByRoleQuery(String role) {
    	List<ChcFmbComplaintsDto> cfComplaint = null;
    	String sql = null;
		String basequery = "Select cc.id as id, cc.master_id as masterId, cc.role, cc.title, cc.message, cc.status, "
				+ "cc.issue_type as issueType, cc.other_type as otherType, cc.description, cc.assigned_other as otherAssigned, "
				+ "cc.assign_to as assignTo, cc.assign_By as assignBy, cc.assign_date, cc.resolve_date, cc.comment as deptComment,"
				+ "cc.remarks, cc.file_path as filePath, cc.file_name as fileName, cc.upload_date as uploadDate,"
				+ "cc.uplaoded_by as uploadedBy, cc.update_date as updateDate, cc.update_by as updateBy, cc.is_deleted as isDeleted, "
				+ "cc.delete_date as deleteDate, cc.create_by as createBy, ";
		String joinquery = null;
		String wherecondition = "where cc.role = :role";
		
    	if(role != null && role.equals("ROLE_CHCFMB")) {
    		joinquery = "cf.chc_fmb_name as chcFmbName, cf.email, cf.mobile_number as mobileNumber from chcisbs_complaints cc "
    				+ "join chc_fmb cf on cc.master_id = cf.chc_fmb_id";
    	}
    	
    	sql = basequery + " " +joinquery+ " " + wherecondition;
    	cfComplaint = (List<ChcFmbComplaintsDto>) entityManager
				.createNativeQuery(sql, "ChcFmbComplaintsDto")
				.setParameter("role", role).getResultList();
    	return cfComplaint;
	}

//	private List<ChcIsBsComplaintsDto> getAllComplaintChcIsBsByRole(String role) {
//    	List<ChcIsBsComplaintsDto> cibComplaint = null;
//    	String sql = null;
//		String basequery = "Select cc.id as id, cc.master_id as masterId, cc.role, cc.title, cc.message, cc.status, "
//				+ "cc.issue_type as issueType, cc.other_type as otherType, cc.description, cc.assigned_other as otherAssigned, "
//				+ "cc.assign_to as assignTo, cc.assign_By as assignBy, cc.assign_date, cc.resolve_date, cc.comment as deptComment,"
//				+ "cc.remarks, cc.file_path as filePath, cc.file_name as fileName, cc.upload_date as uploadDate,"
//				+ "cc.uplaoded_by as uploadedBy, cc.update_date as updateDate, cc.update_by as updateBy, cc.is_deleted as isDeleted, "
//				+ "cc.delete_date as deleteDate, cc.create_by as createBy, cc.createDateTime as createDateTime";
//		String joinquery = null;
//		String wherecondition = "where cc.role = :role";
//		
//    	if(role != null && role.equals("ROLE_INPUTSUPPLIER")) {
//    		joinquery = "is.input_supplier_name from chcisbs_complaints cc "
//    				+ "join input_supplier is on cc.master_id = is.input_supplier_id";
//    	}
//    	
//    	if(role != null && role.equals("ROLE_BUYERSELLER")) {
//    		joinquery = "bs.buyerseller_name from chcisbs_complaints cc "
//    				+ "join buyer_seller bs on cc.master_id = bs.buyerseller_id";
//    	}
//    	
//    	if(role != null && role.equals("ROLE_CHCFMB")) {
//    		joinquery = "cf.chc_fmb_name from chcisbs_complaints cc "
//    				+ "join chc_fmb cf on cc.master_id = cf.chc_fmb_id";
//    	}
//    	
//    	sql = basequery + " " +joinquery+ " " + wherecondition;
//    	cibComplaint = (List<ChcIsBsComplaintsDto>) entityManager
//				.createNativeQuery(sql, "ChcIsBsComplaintsDto")
//				.setParameter("role", role);
//    	return cibComplaint;
//	}

	@Override
    public List<FarmerComplaintDTO> getAllFPOComplaint() {
        //return fpoComplaintRepository.findAll();
    	List<FarmerComplaintDTO> complaint = getAllFpoComplaint();
        return complaint;
    }

    public List<FarmerComplaintDTO> getAllFpoComplaint() 
    {
    	String  sql = "select c.id as id, c.fpo_id as fpoid, c.issue_type as issuetype,c.title as ftitle, c.role as role, c.status as status, c.message as message,  "
        		+ "c.description as description, c.file_path as filepath,c.create_date_time as createdate, c.other_type as othertype, "
        		+ "c.assign_to as assignto, c.assign_by as assignby,  c.comment as deptcomment, c.remarks as remarks, c.file_name as filename,c.assign_date as assigneddate, "
        		+ "f.fpo_name as fponame ,f.fpo_email as fpoemail from fpo_complaints c join fpo f \r\n"
                + "on c.fpo_id = f.fpo_id where c.is_deleted = false order by c.id desc";

        List<FarmerComplaintDTO> obj =  (List<FarmerComplaintDTO>) entityManager.createNativeQuery(sql, "FarmerComplaintDTO").getResultList();
        return obj;

	}

	@Override
    public FPOComplaints updateFPOComplaintStatus(Integer id, FPOComplaints complaints) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        return fpoComplaintRepository.findById(id)
                .map(fpoComplaints -> {
                    fpoComplaints.setId(complaints.getId());
                    fpoComplaints.setAssignTo(complaints.getAssignTo());
                    fpoComplaints.setAssignBy(currentPrincipalName);
                    fpoComplaints.setAssign_date(Calendar.getInstance());
                    fpoComplaints.setDeptComment(complaints.getDeptComment());
                    fpoComplaints.setDeleted(false);
                    fpoComplaints.setStatus(complaints.getStatus());
                    return fpoComplaintRepository.save(fpoComplaints);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }
	
	@Override
    public ChcIsBsComplaints updateChcIsFmbComplaintStatus(Integer id, ChcIsBsComplaints complaints) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        return chcIsBsComplaintRepository.findById(id)
                .map(chcIsBsComplaints -> {
                	chcIsBsComplaints.setId(complaints.getId());
                	chcIsBsComplaints.setAssignTo(complaints.getAssignTo());
                    chcIsBsComplaints.setAssignBy(currentPrincipalName);
                    chcIsBsComplaints.setAssign_date(Calendar.getInstance());
                    chcIsBsComplaints.setDeptComment(complaints.getDeptComment());
                    chcIsBsComplaints.setDeleted(false);
                    chcIsBsComplaints.setStatus(complaints.getStatus());
                    return chcIsBsComplaintRepository.save(chcIsBsComplaints);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
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
//    @Override
//    public List<FarmerComplaintDetailDTO> getFarmerComplaintsToFpoByFpoId(Integer id) {
//        return complaintRepository.findByFpoId(id);
//    }
}


