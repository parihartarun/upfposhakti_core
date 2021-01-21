package com.upfpo.app.service;


import com.upfpo.app.entity.Complaints;
import com.upfpo.app.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    public List<Complaints> getAllComplaint(){
        return complaintRepository.findAll();
    }

    public Complaints createComplaint (Complaints complaints){
        return complaintRepository.save(complaints);
    }



    public Complaints updateComplaintDetail(Long id, Complaints complaints) {
        Optional<Complaints> sd = complaintRepository.findById(id);
        if(!sd.isPresent()) {
            return null;
        }
        complaints.setId(id);
        return complaintRepository.save(complaints);
    }


    public Optional deleteComplaint(Long id) {
        return complaintRepository.findById(id)
                .map(complaints -> {
                    complaintRepository.delete(complaints);
                    return "Delete Successfully!";
                });
    }


}
