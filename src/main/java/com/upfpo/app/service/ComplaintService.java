package com.upfpo.app.service;

import com.upfpo.app.dto.FarmerComplaintDTO;
import com.upfpo.app.entity.ComplaintCatgories;
import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.Status;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ComplaintService {

    public List<ComplaintCatgories> getComplaintsCatgories();

    public List<Complaints> getAllComplaint();
    //public Complaints createComplaint (Complaints complaints, MultipartFile file);

    Complaints createComplaintByFarmer(Complaints complaints, MultipartFile file);

    public Boolean deleteComplaint(Integer id);

    public Resource loadFileAsResource(String fileName);

    Complaints updateComplaint(Integer id, Complaints complaints1, MultipartFile file);


    //List<FarmerComplaintDTO> getFarmerComplaintToFpo(Integer fpoId);



    Complaints complaintAssign(Integer id, Complaints complaints1);

    List<Complaints> getComplaintByFarmerId(Integer farmerId);
}
