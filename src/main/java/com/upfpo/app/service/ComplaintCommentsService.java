package com.upfpo.app.service;

import com.upfpo.app.entity.ComplaintsComments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ComplaintCommentsService {

    public String deleteComment( Integer complaintId, Integer commentId);
    public ComplaintsComments addComment(Integer complaintId, ComplaintsComments complaintsComments);
    public Page<ComplaintsComments> getCommentByComplaintId(Integer id, Pageable pageable);
}
