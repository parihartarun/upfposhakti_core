package com.upfpo.app.controller;


import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.FarmerComplaintDTO;
import com.upfpo.app.dto.FarmerComplaintDetailDTO;
import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.FPOComplaints;
import com.upfpo.app.entity.Status;
import com.upfpo.app.service.FPOComplaintService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/fpocomplaint")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "FPOComplaint Details", tags="FPOComplaint Controller",description="FPOComplaint Details")
public class FPOComplaintController {

    private static final Logger LOG = LoggerFactory.getLogger(FPOComplaintController.class);


    @Autowired
    FPOComplaintService fpoComplaintService;





    @GetMapping("/getall")
    @ApiOperation(value="All Complaints List" ,code=201, produces = "application/json", notes="Api for all Complaints Info to Department",response= FPOComplaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<FarmerComplaintDTO> getAllComplaints (){
        return fpoComplaintService.getAllFPOComplaint();
    }



    @GetMapping("farmerComplaint/{id}")
    @ApiOperation(value="Farmer Complaints List to FPO" ,code=201, produces = "application/json", notes="Api for all Farmer Complaints Info By FPO ID",response= FarmerComplaintDetailDTO.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<FarmerComplaintDetailDTO> getFarmerComplaintByFPOId (@PathVariable Integer id){
        return fpoComplaintService.getFarmerComplaintByFPOId(id);
    }


    @GetMapping("/{id}")
    @ApiOperation(value="Farmer Complaints List to FPO" ,code=201, produces = "application/json", notes="Api for all Farmer Complaints Info By FPO ID",response= FarmerComplaintDetailDTO.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<Complaints> getFPOComplaints (@PathVariable Integer id){
        return fpoComplaintService.getFPOComplaints(id);
    }



    @GetMapping("/fpo/{id}")
    @ApiOperation(value="FPO Complaints List" ,code=201, produces = "application/json", notes="Api for all Complaints Info By FPO ID",response= FPOComplaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<FarmerComplaintDTO> getComplaintByFpoId (@PathVariable Integer id){
        return fpoComplaintService.getComplaintByFpoId(id);
    }


    @GetMapping("/chcfmb/{id}")
    @ApiOperation(value="CHC/FMB Complaints List" ,code=201, produces = "application/json", notes="Api for all Complaints Info By CHC/FMB ID",response= FPOComplaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<FPOComplaints> getComplaintByChcFmbId (@PathVariable Integer id){
        return fpoComplaintService.getComplaintByChcFmbId(id);
    }


    @GetMapping("/inputsupplier/{id}")
    @ApiOperation(value="Supplier Complaints List" ,code=201, produces = "application/json", notes="Api for all Complaints Info By Supplier ID",response= FPOComplaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<FPOComplaints> getComplaintBySupplierId(@PathVariable Integer id){
        return fpoComplaintService.getComplaintBySupplierId(id);
    }


    @PostMapping
    @ApiOperation(value="Create Complaint" ,code=201, produces = "application/json", notes="Api for all FPO Create Complaint",response= FPOComplaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> createComplaint(@RequestParam("description") String description, @RequestParam("title") String title,
                                                           @RequestParam("issue_type") String issueType, @RequestParam("fpo_id") Integer fpoId,
                                                           @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside FPOComplaintController saving Complaint ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            FPOComplaints complaints = new FPOComplaints(description, title, issueType, fpoId);
            FPOComplaints id = fpoComplaintService.createComplaintByFPO(complaints, file);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("FPOComplaint created successfully"), HttpStatus.OK );
            LOG.info("FPOComplaint  created Successfully!");
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("FPOComplaint creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the FPOComplaint");
            e.printStackTrace();
        }
        LOG.info("Exiting Complaint Of Controller with response ", resp);
        return resp;
    }


    @PostMapping("/inputsupplier")
    @ApiOperation(value="Create Complaint" ,code=201, produces = "application/json", notes="Api for all create Complaint",response= FPOComplaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> createComplaintInputSupplier(@RequestParam("description") String description, @RequestParam("title") String title,
                                                           @RequestParam("issue_type") String issueType, @RequestParam("supplier_id") Integer supplierId,
                                                           @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside FPOComplaintController saving Complaint ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            FPOComplaints complaints = new FPOComplaints();
            complaints.setDescription(description);
            complaints.setIssueType(issueType);
            complaints.setTitle(title);
            complaints.setInputSupplierId(supplierId);
            FPOComplaints id = fpoComplaintService.createComplaintByFPO(complaints, file);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("FPOComplaint created successfully"), HttpStatus.OK );
            LOG.info("FPOComplaint  created Successfully!");
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("FPOComplaint creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the FPOComplaint");
            e.printStackTrace();
        }
        LOG.info("Exiting Complaint Of Controller with response ", resp);
        return resp;
    }


    @PostMapping("/chcfmb")
    @ApiOperation(value="Create Complaint" ,code=201, produces = "application/json", notes="Api for all create Complaint",response= FPOComplaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> createComplaintCHCFMB(@RequestParam("description") String description, @RequestParam("title") String title,
                                                                 @RequestParam("issue_type") String issueType, @RequestParam("chc_fmb_id") Integer chcid,
                                                                 @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside FPOComplaintController saving Complaint ");
        ResponseEntity<MessageResponse> resp = null;
        try {
            FPOComplaints complaints = new FPOComplaints();
            complaints.setDescription(description);
            complaints.setIssueType(issueType);
            complaints.setTitle(title);
            complaints.setChcFmbId(chcid);
            FPOComplaints id = fpoComplaintService.createComplaintByFPO(complaints, file);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("FPOComplaint created successfully"), HttpStatus.OK );
            LOG.info("FPOComplaint  created Successfully!");
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("FPOComplaint creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the FPOComplaint");
            e.printStackTrace();
        }
        LOG.info("Exiting Complaint Of Controller with response ", resp);
        return resp;
    }



    @PutMapping("/complaintstatus/{id}")
    @ApiOperation(value="Update Complaint Details" ,code=201, produces = "application/json", notes="Api To Update Complaint Details",response= FPOComplaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> updateFPOComplaintStatuByDepartment(@PathVariable Integer id,
                                                                 @RequestPart(value = "assign_to") String assignTo,
                                                                 @RequestPart(value = "comment") String deptComment,
                                                                 @RequestParam(value = "status") Status status) {
        LOG.info("Inside Complaint updating Complaint detail ");
        FPOComplaints complaints = new FPOComplaints();
        complaints.setId(id);
        complaints.setAssignTo(assignTo);
        complaints.setDeptComment(deptComment);
        complaints.setStatus(status);
        ResponseEntity<MessageResponse> resp = null;
        try {
            fpoComplaintService.updateFPOComplaintStatus(id, complaints);
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Complaint Details Updated Successfully!"), HttpStatus.OK );
            LOG.info("Complaint Updated Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Failed to Update the Complaint Details"), HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Update the Complaint Details");
            e.printStackTrace();
        }
        LOG.info("Exiting Complaint Of Controller with response ", resp);
        return resp;
    }
     /*@GetMapping("/getcomplaint/{id}")
    @ApiOperation(value="Get Complaints By Farmer",code=200,produces = "application/json",notes="Api to view Complaint Detail by farmer id",response= FarmerComplaintDTO.class)
    @ApiResponses(value= {
            @ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
            @ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
    @ResponseBody
    public List<FarmerComplaintDTO> getComplaintByFarmerToFPO(@PathVariable Integer id){

        return fpoComplaintService.getFarmerComplaintToFpo(id);
    }*/

     /*@GetMapping("/getcomplaint/{id}")
    @ApiOperation(value="Get Complaints By Farmer",code=200,produces = "application/json",notes="Api to view Complaint Detail by farmer id",response= FarmerComplaintDTO.class)
    @ApiResponses(value= {
            @ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
            @ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
    @ResponseBody
    public List<FarmerComplaintDTO> getComplaintByFarmerToFPO(@PathVariable Integer id){

        return fpoComplaintService.getFarmerComplaintToFpo(id);
    }*/

}
