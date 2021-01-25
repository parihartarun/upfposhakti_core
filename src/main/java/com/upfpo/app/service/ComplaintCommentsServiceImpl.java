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
    public Optional<ComplaintsComments> getCommentByComplaintId(Integer id) {
        if(!complaintRepository.existsById(id)) {
            throw new ResourceNotFoundException("Complaint not found!");
        }

        return complaintsCommentsRepository.findByComplaint_id(id);
    }

    //Add comment by complaintid
    public ComplaintsComments addComment(Integer complaintId, ComplaintsComments complaintsComments) {
        return complaintRepository.findById(complaintId)
                .map(complaints -> {
                    complaintsComments.setComplaints(complaints);
                    return complaintsCommentsRepository.save(complaintsComments);
                }).orElseThrow(() -> new ResourceNotFoundException(" not found!"));
    }


    //Delete comment by complaintID
    public String deleteComment( Integer complaintId, Integer commentId) {

        if(!complaintRepository.existsById(complaintId)) {
            throw new ResourceNotFoundException("Id not found!");
        }
        return complaintsCommentsRepository.findById(commentId)
                .map(complaintsComments -> {
                    complaintsCommentsRepository.delete(complaintsComments);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new ResourceNotFoundException("Complaint Commment id not found!"));
    }


}


