package com.upfpo.app.service;

import com.upfpo.app.dto.FarmerComplaintDTO;
import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.FPOComplaints;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FPOComplaintService {
    FPOComplaints createComplaintByInpuSupplier(FPOComplaints complaints, MultipartFile file);

    List<FPOComplaints> getAllComplaintToDept();

    FPOComplaints createComplaintByFPO(FPOComplaints complaints, MultipartFile file);

    FPOComplaints createComplaintByCHCFMB(FPOComplaints complaints, MultipartFile file);

    List<FarmerComplaintDTO> getFarmerComplaintToFpo(Integer fpoId);

    List<Complaints> getFarmerComplaintByFPOId(Integer fpoId);

    List<FPOComplaints> getComplaintBySupplierId(Integer supplierId);

    List<FPOComplaints> getComplaintByFpoId(Integer fpoId);

    List<FPOComplaints> getComplaintByChcFmbId(Integer chcId);

    List<FPOComplaints> getAllFPOComplaint();
}
