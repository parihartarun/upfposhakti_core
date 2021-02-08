package com.upfpo.app.service;

import com.upfpo.app.entity.ComplaintCatgories;
import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.Status;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ComplaintService {

    public List<ComplaintCatgories> getComplaintsCatgories();
    public List<Complaints> getAllComplaint();
    public Complaints createComplaint (Complaints complaints, MultipartFile file);
    public Boolean deleteComplaint(Integer id);

    public Resource loadFileAsResource(String fileName);

    Complaints updateComplaint(Integer id, Complaints complaints1, MultipartFile file);

    public Complaints deptComplaintAssign(Integer id, Complaints complaints1);

}
