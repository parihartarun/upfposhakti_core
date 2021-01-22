package com.upfpo.app.controller;

import com.upfpo.app.auth.response.JwtResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.Complaints;

import com.upfpo.app.service.ComplaintServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/complaint")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "Complaint Details", tags="Complaint Controller",description="Complaint Details")
public class ComplaintContoller {

    private static final Logger LOG = LoggerFactory.getLogger(ComplaintContoller.class);

    @Autowired
    private ComplaintServiceImpl complaintService;

    @GetMapping("/getall")
    @ApiOperation(value="Complaints List" ,code=201, produces = "application/json", notes="Api for all Complaints Info",response= Complaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<Complaints> getAllComplaints (){

        return complaintService.getAllComplaint();
    }



    @PostMapping("/insert")
    @ApiOperation(value="Create Complaint" ,code=201, produces = "application/json", notes="Api for all create Complaint",response= Complaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> createComplaint(@RequestBody Complaints complaints) {
        LOG.info("Inside ComplaintController saving Complaint ", complaints);
        ResponseEntity<String> resp = null;
        try {
            Complaints id = complaintService.createComplaint(complaints);
            resp = new ResponseEntity<String>("Complaint created Successfully!", HttpStatus.OK );
            LOG.info("Complaint  created Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Save the Complaint", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the Complaint");
            e.printStackTrace();
        }
        LOG.info("Exiting Complaint Of Controller with response ", resp);
        return resp;
    }


    @PutMapping("/update1/{id}")
    @ApiOperation(value="Complaints Update" ,code=201, produces = "application/json", notes="Api for all Update Complaints Info",response= Complaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> updateComplaint(@PathVariable Long id, @RequestBody Complaints complaints) {
        LOG.info("Inside ComplaintController updating sales details ", complaints);
        ResponseEntity<String> resp = null;
        try {
            Complaints fsd = complaintService.updateComplaintDetail(id, complaints);
            resp = new ResponseEntity<String>("Complaint Updated Successfully!", HttpStatus.OK );
            LOG.info("Complaint Updated Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Update the Complaint", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Update the Complaint");
            e.printStackTrace();
        }
        LOG.info("Exiting Complaint Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping("/delete1/{id}")
    @ApiOperation(value="Delete Complaint" ,code=201, produces = "application/json", notes="Api for all Complaints Deletion",response= Complaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> deleteComplaint(@PathVariable Long id) {
        LOG.info("Inside ComplaintController delete sales details ");
        ResponseEntity<String> resp = null;
        try {
            complaintService.deleteComplaint(id);
            resp = new ResponseEntity<String>("Complaint Deleted Successfully!", HttpStatus.OK );
            LOG.info("Complaint Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Delete the Complaint", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the Complaint");
            e.printStackTrace();
        }
        LOG.info("Exiting Complaint Of Controller with response ", resp);
        return resp;
    }

}
