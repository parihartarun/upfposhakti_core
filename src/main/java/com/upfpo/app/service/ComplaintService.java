package com.upfpo.app.service;

import com.upfpo.app.entity.ComplaintCatgories;
import com.upfpo.app.entity.Complaints;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ComplaintService {

    public List<ComplaintCatgories> getComplaintsCatgories();
    public List<Complaints> getAllComplaint();
    public Complaints createComplaint (Complaints complaints, MultipartFile file);
    public Boolean deleteComplaint(Integer id);
    public String storeFile(MultipartFile file);
    public Resource loadFileAsResource(String fileName);
    public Complaints updateComplaint(Integer id, Complaints complaints1, String description, String title, String issueType, MultipartFile file);

}
