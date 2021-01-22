package com.upfpo.app.service;

import com.upfpo.app.controller.ComplaintContoller;
import com.upfpo.app.entity.ComplaintsComments;
import com.upfpo.app.repository.ComplaintRepository;
import com.upfpo.app.repository.ComplaintsCommentsRepository;
import com.upfpo.app.user.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComplaintCommentsServiceImpl implements ComplaintCommentsService {



    @Autowired
    public ComplaintsCommentsRepository complaintsCommentsRepository;

    @Autowired
    private ComplaintRepository  complaintRepository;

    //Getting Comment by Complaint id
    public Optional<ComplaintsComments> getCommentByComplaintId(Long id) {
        if(!complaintRepository.existsById(id)) {
            throw new ResourceNotFoundException("Complaint not found!");
        }

        return complaintsCommentsRepository.findByComplaint_id(id);
    }

    //Add blog to user id
    public ComplaintsComments addComment(Long userId, ComplaintsComments complaintsComments) {
        return complaintRepository.findById(userId)
                .map(complaints -> {
                    complaintsComments.setComplaints(complaints);
                    return complaintsCommentsRepository.save(complaintsComments);
                }).orElseThrow(() -> new ResourceNotFoundException(" not found!"));
    }


    //Delete blog
    public String deleteComment( Long cId, Long ccId) {

        if(!complaintRepository.existsById(cId)) {
            throw new ResourceNotFoundException("Id not found!");
        }
        return complaintsCommentsRepository.findById(ccId)
                .map(complaintsComments -> {
                    complaintsCommentsRepository.delete(complaintsComments);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new ResourceNotFoundException("Complaint Commment id not found!"));
    }


}


