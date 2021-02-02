package com.upfpo.app.controller;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.EnquiryDTO;
import com.upfpo.app.entity.Enquiry;
import com.upfpo.app.service.EnquiryServiceImpl;
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
@RequestMapping(value = "/enquiry")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "Enquiry Details", tags="Enquiry Controller",description="Enquiry Details")
public class EnquiryController {
    private static final Logger LOG = LoggerFactory.getLogger(EnquiryController.class);


    @Autowired
    private EnquiryServiceImpl enquiryService;


    @GetMapping("/getall")
    @ApiOperation(value="Enquiry List" ,code=201, produces = "application/json", notes="Api for all Enquiry Info",response= Enquiry.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<Enquiry> getAllEnquiryDetails (){

        LOG.info("Inside EnquiryController gettting list of Enquiry ");
        return enquiryService.getAllEnquiryInfo();
    }



    @PostMapping("/insert")
    @ApiOperation(value="Enquiry Request" ,code=201, produces = "application/json", notes="Api for all Enquiry Request",response= Enquiry.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> createEnquiry(@RequestBody Enquiry enquiry) {
        LOG.info("Inside EnquiryController saving Enquiry ", enquiry);
        ResponseEntity<String> resp = null;
        try {
            Enquiry id = enquiryService.createEnquiry(enquiry);
            resp = new ResponseEntity<String>("Enquiry created Successfully!", HttpStatus.OK );
            LOG.info("Enquiry created Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Save the Enquiry", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the Enquiry");
            e.printStackTrace();
        }
        LOG.info("Exiting Enquiry Of Controller with response ", resp);
        return resp;
    }


    @PutMapping("/update/{id}")
    @ApiOperation(value="Enquiry Update" ,code=201, produces = "application/json", notes="Api for all Enquiry Update",response= Enquiry.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> updateEnquiry(@PathVariable Long id, @RequestBody Enquiry enquiry) {
        LOG.info("Inside EnquiryController updating sales details ", enquiryService);
        ResponseEntity<String> resp = null;
        try {
            Enquiry fsd = enquiryService.updateEnquiryDetail(id, enquiry);
            resp = new ResponseEntity<String>("Enquiry Updated Successfully!", HttpStatus.OK );
            LOG.info("Enquiry Updated Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Update the Enquiry", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Update the Enquiry");
            e.printStackTrace();
        }
        LOG.info("Exiting Enquiry Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation(value="Enquiry Delete" ,code=201, produces = "application/json", notes="Api for all Enquiry Delete",response= Enquiry.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> deleteEnquiry(@PathVariable Long id) {
        LOG.info("Inside EnquiryController delete sales details ");
        ResponseEntity<String> resp = null;
        try {
            enquiryService.deleteEnquiry(id);
            resp = new ResponseEntity<String>("Enquiry Deleted Successfully!", HttpStatus.OK );
            LOG.info("Enquiry Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Delete the Enquiry", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the Enquiry");
            e.printStackTrace();
        }
        LOG.info("Exiting Enquiry Of Controller with response ", resp);
        return resp;
    }
    
    @PostMapping("/enquiry")
    @ApiOperation(value="Enquiry Request" ,code=201, produces = "application/json", notes="Api for all Enquiry Request",response= Enquiry.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> saveEnquiryHandler(@RequestBody Enquiry enquiry) {
        LOG.info("Inside EnquiryController saving Enquiry ", enquiry);
        ResponseEntity<String> resp = null;
        try {
             enquiryService.saveEnquiry(enquiry);
            resp = new ResponseEntity<String>("Enquiry created Successfully!", HttpStatus.OK );
            LOG.info("Enquiry created Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Save the Enquiry", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the Enquiry");
            e.printStackTrace();
        }
        LOG.info("Exiting Enquiry Of Controller with response ", resp);
        return resp;
    }   
    

}
