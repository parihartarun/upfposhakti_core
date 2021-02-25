package com.upfpo.app.controller;


import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.FarmerComplaintDTO;
import com.upfpo.app.dto.FarmerComplaintDetailDTO;
import com.upfpo.app.dto.UploadFileResponse;
import com.upfpo.app.entity.ChcIsBsComplaints;
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
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/fpocomplaint")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "FPOComplaint Details", tags="FPOComplaint Controller",description="FPOComplaint Details")
public class FPOComplaintController {

    private static final Logger LOG = LoggerFactory.getLogger(FPOComplaintController.class);


    @Autowired
    FPOComplaintService fpoComplaintService;

    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/gif","application/pdf");



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



//    @GetMapping("farmerComplaint/{id}")
//    @ApiOperation(value="Farmer Complaints List to FPO" ,code=201, produces = "application/json", notes="Api for all Farmer Complaints Info By FPO ID",response= FarmerComplaintDetailDTO.class)
//    @ApiResponses(value= {
//            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
//            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
//            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
//    })
//    public List<FarmerComplaintDetailDTO> getFarmerComplaintByFPOId (@PathVariable Integer id){
//        return fpoComplaintService.getFarmerComplaintByFPOId(id);
//    }


    @GetMapping("/{id}")
    @ApiOperation(value="Farmer Complaints List to FPO" ,code=201, produces = "application/json", notes="Api for all Farmer Complaints Info By FPO ID",response= FarmerComplaintDetailDTO.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<FarmerComplaintDetailDTO> getFarmerComplaintsToFpo (@PathVariable Integer id){
        return fpoComplaintService.getFarmerComplaintByFPOId(id);
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
    @ApiOperation(value="CHC/FMB Complaints List" ,code=201, produces = "application/json", notes="Api for all Complaints Info By Master ID",response= ChcIsBsComplaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<ChcIsBsComplaints> getComplaintByChcFmbId (@PathVariable Integer id){
        return fpoComplaintService.getComplaintByChcFmbId(id);
    }


    @GetMapping("/inputsupplier/{id}")
    @ApiOperation(value="Supplier Complaints List" ,code=201, produces = "application/json", notes="Api for all Complaints Info By Master ID",response= ChcIsBsComplaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<ChcIsBsComplaints> getComplaintBySupplierId(@PathVariable Integer id){
        return fpoComplaintService.getComplaintBySupplierId(id);
    }
    
    
    @GetMapping("/buyerseller/{id}")
    @ApiOperation(value="Supplier Complaints List" ,code=201, produces = "application/json", notes="Api for all Complaints Info By Master ID",response= ChcIsBsComplaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<ChcIsBsComplaints> getComplaintByBuyerSellerId(@PathVariable Integer id){
        return fpoComplaintService.getComplaintByBuyerSellerId(id);
    }
    
    
    //this api for all compalaint of input supplier , Chc Fmb, Buyer seller using role
    @GetMapping("/getAllComplaintIsChcBs/{role}")
    @ApiOperation(value="Supplier Complaints List" ,code=201, produces = "application/json", notes="Api for all Complaints Info By Master ID",response= ChcIsBsComplaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<ChcIsBsComplaints> getAllComplaintIsChcBsByRole(@PathVariable String role){
        return fpoComplaintService.getAllComplaintIsChcBsByRole(role);
    }


    @PostMapping
    @ApiOperation(value="Create Fpo Complaint" ,code=201, produces = "application/json", notes="Api for all FPO Create Complaint",response= FPOComplaints.class)
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
        String fileContentType = file.getContentType();
        if (contentTypes.contains(fileContentType)){
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
        }
        else{
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Incorrect file type, PDF or Image required."), HttpStatus.BAD_REQUEST);
            throw new IllegalArgumentException("Incorrect file type, Photo required.");
        }
        LOG.info("Exiting Complaint Of Controller with response ", resp);
        return resp;
    }


    @PostMapping("/inputsupplier")
    @ApiOperation(value="Create Input supplier Complaint" ,code=201, produces = "application/json", notes="Api for all create Input supplier Complaint",response= ChcIsBsComplaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> createComplaintInputSupplier(@RequestParam("description") String description, @RequestParam("title") String title,
                                                           @RequestParam("issue_type") String issueType, @RequestParam("masterId") Integer masterId,@RequestParam("role") String role,
                                                           @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside Input Supplier omplaintController saving Complaint ");
        ResponseEntity<MessageResponse> resp = null;
        String fileContentType = file.getContentType();
        if (contentTypes.contains(fileContentType)){
            try {
            	ChcIsBsComplaints complaints = new ChcIsBsComplaints();
                complaints.setDescription(description);
                complaints.setIssueType(issueType);
                complaints.setTitle(title);
                complaints.setMasterId(masterId);
                complaints.setRole(role);
                ChcIsBsComplaints id = fpoComplaintService.createComplaintByInpuSupplier(complaints, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Input Supplier Complaint created successfully"), HttpStatus.OK );
                LOG.info("Input Supplier Complaint  created Successfully!");
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Input Supplier Complaint creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Save the Input Supplier Complaint");
                e.printStackTrace();
        }}
        else{
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Incorrect file type, PDF or Image required."), HttpStatus.BAD_REQUEST);
            throw new IllegalArgumentException("Incorrect file type, Photo required.");
        }
        LOG.info("Exiting Complaint Of Controller with response ", resp);
        return resp;
    }
    
    @PostMapping("/chcfmb")
    @ApiOperation(value="Create Chc Fmb Complaint" ,code=201, produces = "application/json", notes="Api for create Chc Fmb Complaint",response= ChcIsBsComplaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> createComplaintCHCFMB(@RequestParam("description") String description, @RequestParam("title") String title,
                                                                 @RequestParam("issue_type") String issueType, @RequestParam("masterId") Integer masterId,
                                                                 @RequestParam("role") String role, @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside chcfmbComplaintController saving Complaint ");
        ResponseEntity<MessageResponse> resp = null;
        String fileContentType = file.getContentType();
        if (contentTypes.contains(fileContentType)){
            try {
            	ChcIsBsComplaints complaints = new ChcIsBsComplaints();
                complaints.setDescription(description);
                complaints.setIssueType(issueType);
                complaints.setTitle(title);
                complaints.setMasterId(masterId);
                complaints.setRole(role);
                ChcIsBsComplaints id = fpoComplaintService.createComplaintByCHCFMB(complaints, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("chcfmb Complaint created successfully"), HttpStatus.OK );
                LOG.info("chcfmbComplaint  created Successfully!");
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("chcfmb Complaint creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Save the chcfmbComplaint");
                e.printStackTrace();
            }
        }
        else{
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Incorrect file type, PDF or Image required."), HttpStatus.BAD_REQUEST);
            throw new IllegalArgumentException("Incorrect file type, Photo required.");
        }
        LOG.info("Exiting Complaint Of Controller with response ", resp);
        return resp;
    }
    
    @PostMapping("/buyerseller")
    @ApiOperation(value="Create Buyer Seller Complaint" ,code=201, produces = "application/json", notes="Api for all create buyer seller complaint",response= ChcIsBsComplaints.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<MessageResponse> createComplaintSuyerSeller(@RequestParam("description") String description, @RequestParam("title") String title,
                                                           @RequestParam("issue_type") String issueType, @RequestParam("masterId") Integer masterId,@RequestParam("role") String role,
                                                           @RequestParam(value = "file", required = false) MultipartFile file) {
        LOG.info("Inside Buyer Seller omplaintController saving Complaint ");
        ResponseEntity<MessageResponse> resp = null;
        String fileContentType = file.getContentType();
        if (contentTypes.contains(fileContentType)){
            try {
            	ChcIsBsComplaints complaints = new ChcIsBsComplaints();
                complaints.setDescription(description);
                complaints.setIssueType(issueType);
                complaints.setTitle(title);
                complaints.setMasterId(masterId);
                complaints.setRole(role);
                ChcIsBsComplaints id = fpoComplaintService.createComplaintByBuyerSeller(complaints, file);
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Buyer Seller Complaint created successfully"), HttpStatus.OK );
                LOG.info("Buyer Seller Complaint  created Successfully!");
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        } catch (Exception e) {
                resp = new ResponseEntity<MessageResponse>(new MessageResponse("Buyer Seller Complaint creation fail"), HttpStatus.INTERNAL_SERVER_ERROR);
                LOG.info("Failed to Save the Buyer Seller Complaint");
                e.printStackTrace();
        }}
        else{
            resp = new ResponseEntity<MessageResponse>(new MessageResponse("Incorrect file type, PDF or Image required."), HttpStatus.BAD_REQUEST);
            throw new IllegalArgumentException("Incorrect file type, Photo required.");
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
                                                                 @RequestParam(value = "assign_to") String assignTo,
                                                                 @RequestParam(value = "comment") String deptComment,
                                                                 @RequestParam(value = "status") Status status,
                                                                 @RequestParam(value = "role") String role) {
        LOG.info("Inside Complaint updating Complaint detail ");
        FPOComplaints complaints = new FPOComplaints();
        complaints.setId(id);
        complaints.setAssignTo(assignTo);
        complaints.setDeptComment(deptComment);
        complaints.setStatus(status);
        //complaints.setUpdateDate(new Date());
        
        ChcIsBsComplaints cibComplaint = new ChcIsBsComplaints();
        cibComplaint.setId(id);
        cibComplaint.setAssignTo(assignTo);
        cibComplaint.setDeptComment(deptComment);
        cibComplaint.setStatus(status);
        cibComplaint.setRole(role);
        ResponseEntity<MessageResponse> resp = null;

        try {
        	if(role != null && role.equals("ROLE_FPC")) {
        		fpoComplaintService.updateFPOComplaintStatus(id, complaints);
        	}
        	else {
        		fpoComplaintService.updateChcIsFmbComplaintStatus(id, cibComplaint);
        	}
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

    @GetMapping("/download/{fileName:.+}")
    @ApiOperation(value="PhotoUpload Download" ,code=201, produces = "application/json", notes="Api for Download PhotoUpload File", response= UploadFileResponse.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fpoComplaintService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            LOG.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
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
