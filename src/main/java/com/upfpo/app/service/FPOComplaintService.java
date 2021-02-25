package com.upfpo.app.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.upfpo.app.dto.FarmerComplaintDTO;
import com.upfpo.app.dto.FarmerComplaintDetailDTO;
import com.upfpo.app.entity.ChcIsBsComplaints;
import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.FPOComplaints;

public interface FPOComplaintService {

    List<FPOComplaints> getAllComplaintToDept();

    FPOComplaints createComplaintByFPO(FPOComplaints complaints, MultipartFile file);

    ChcIsBsComplaints createComplaintByInpuSupplier(ChcIsBsComplaints complaints, MultipartFile file);

    ChcIsBsComplaints createComplaintByCHCFMB(ChcIsBsComplaints complaints, MultipartFile file);
    
    ChcIsBsComplaints createComplaintByBuyerSeller(ChcIsBsComplaints complaints, MultipartFile file);

    //List<FarmerComplaintDetailDTO> getFarmerComplaintsToFpoByFpoId(Integer fpoId);

    List<FarmerComplaintDetailDTO> getFarmerComplaintByFPOId(Integer fpoId);

    List<ChcIsBsComplaints> getComplaintBySupplierId(Integer supplierId);
    
    List<ChcIsBsComplaints> getComplaintByChcFmbId(Integer chcId);
    
    List<ChcIsBsComplaints> getComplaintByBuyerSellerId(Integer id);

    List<FarmerComplaintDTO> getComplaintByFpoId(Integer fpoId);

    List<FarmerComplaintDTO> getAllFPOComplaint();

    FPOComplaints updateFPOComplaintStatus(Integer id, FPOComplaints complaints);

    Resource loadFileAsResource(String fileName);

	List<ChcIsBsComplaints> getAllComplaintIsChcBsByRole(String role);

	ChcIsBsComplaints updateChcIsFmbComplaintStatus(Integer id, ChcIsBsComplaints complaints);

    //List<FarmerComplaintDetailDTO> getFarmerComplaintByFPOId(Integer id);
}
