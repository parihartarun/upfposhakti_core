package com.upfpo.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.upfpo.app.dto.FarmerComplaintDTO;
import com.upfpo.app.dto.FarmerComplaintDetailDTO;
import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.FPOComplaints;

public interface FPOComplaintService {

    List<FPOComplaints> getAllComplaintToDept();

    FPOComplaints createComplaintByFPO(FPOComplaints complaints, MultipartFile file);

    FPOComplaints createComplaintByInpuSupplier(FPOComplaints complaints, MultipartFile file);

    FPOComplaints createComplaintByCHCFMB(FPOComplaints complaints, MultipartFile file);

    List<FarmerComplaintDetailDTO> getFarmerComplaintDetailByFPOId(Integer fpoId);

    List<FarmerComplaintDetailDTO> getFarmerComplaintByFPOId(Integer fpoId);

    List<FPOComplaints> getComplaintBySupplierId(Integer supplierId);

    List<FarmerComplaintDTO> getComplaintByFpoId(Integer fpoId);

    List<FPOComplaints> getComplaintByChcFmbId(Integer chcId);

    List<FarmerComplaintDTO> getAllFPOComplaint();

    FPOComplaints updateFPOComplaintStatus(Integer id, FPOComplaints complaints);

    List<Complaints> getFPOComplaints(Integer id);
}
