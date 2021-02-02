package com.upfpo.app.service;

import com.upfpo.app.controller.ComplaintContoller;
import com.upfpo.app.entity.ComplaintsComments;
import com.upfpo.app.repository.ComplaintRepository;
import com.upfpo.app.repository.ComplaintsCommentsRepository;
import com.upfpo.app.user.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;



@Service
public class ComplaintCommentsServiceImpl implements ComplaintCommentsService {

    @Autowired
    public ComplaintsCommentsRepository complaintsCommentsRepository;

    @Autowired
    private ComplaintRepository  complaintRepository;

    //Getting Comment by Complaint id
    @Override
    public Page<ComplaintsComments> getCommentByComplaintId(Integer id, Pageable pageable) {
        if(!complaintRepository.existsById(id)) {
            throw new ResourceNotFoundException("Complaint not found!");
        }

        return complaintsCommentsRepository.findByComplaints_id(id, pageable);
    }

    //Add comment by complaintid
    @Override
    public ComplaintsComments addComment(Integer complaintId, ComplaintsComments complaintsComments) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        return complaintRepository.findById(complaintId)
                .map(complaints -> {
                    complaintsComments.setComplaints(complaints);
                    complaintsComments.setCreateBy(currentPrincipalName);
                    return complaintsCommentsRepository.save(complaintsComments);
                }).orElseThrow(() -> new ResourceNotFoundException(" not found!"));
    }

    //Delete comment by complaintID
    @Override
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



