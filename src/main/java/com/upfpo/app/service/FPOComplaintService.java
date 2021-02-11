package com.upfpo.app.service;

import com.upfpo.app.dto.FarmerComplaintDTO;
import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.FPOComplaints;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FPOComplaintService {
    FPOComplaints createComplaintByFPO(FPOComplaints complaints, MultipartFile file);

    List<FarmerComplaintDTO> getFarmerComplaintToFpo(Integer fpoId);

    List<Complaints> getFarmerComplaintByFPOId(Integer fpoId);
}
