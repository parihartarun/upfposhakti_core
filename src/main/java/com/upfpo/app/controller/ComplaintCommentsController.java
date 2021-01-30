package com.upfpo.app.controller;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.ComplaintsComments;
import com.upfpo.app.service.ComplaintCommentsService;
import com.upfpo.app.service.ComplaintCommentsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/complaintcomments")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "Complaint Comment Details", tags="Complaint Comment Controller",description="Complaint Comment Details")
public class ComplaintCommentsController {

    @Autowired
    private ComplaintCommentsServiceImpl complaintCommentsService;

    //Get ComplaintsComments by Complaint
    @GetMapping("/{complaintid}")
    @ApiOperation(value="Complaints Comments List" ,code=201, produces = "application/json", notes="Api to get Comments by Complaint ID",response= ComplaintsComments.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public Page<ComplaintsComments> getComplaintsCommentsByComplaintId (@PathVariable("complaintid")Integer complaintId, Pageable pageable){
        return complaintCommentsService.getCommentByComplaintId(complaintId, pageable);
    }

    //Create ComplaintsComments by UserID
    @PostMapping("/{complaintid}")
    @ApiOperation(value="Insert Comments on Complaint id" ,code=201, produces = "application/json", notes="Api for Add Comment on  Complaints Id",response= ComplaintsComments.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ComplaintsComments addComplaintsComments(@PathVariable("complaintid") Integer complaintId, @RequestBody ComplaintsComments complaintsComments){
        return complaintCommentsService.addComment(complaintId, complaintsComments);
    }


    //Delete ComplaintsComments by Complaint
    @DeleteMapping("/{complaintid}/{comlaintcommentid}")
    @ApiOperation(value="Delete Comments by Complaint Id" ,code=201, produces = "application/json", notes="Api for Delete Comments by ComplaintID",response= ComplaintsComments.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public String deleteComment (@PathVariable("complaintid")Integer complaintId, @PathVariable("comlaintcommentid") Integer commentId){

        return complaintCommentsService.deleteComment(complaintId, commentId);
    }
}

