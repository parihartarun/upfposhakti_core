package com.upfpo.app.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.EnquieryRequest;
import com.upfpo.app.entity.Enquiry;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.User;
import com.upfpo.app.service.EnquiryServiceImpl;
import com.upfpo.app.service.FPOService;
import com.upfpo.app.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/enquiry")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "Enquiry Details", tags="Enquiry Controller",description="Enquiry Details")
public class EnquiryController {
    private static final Logger LOG = LoggerFactory.getLogger(EnquiryController.class);


    @Autowired
    private EnquiryServiceImpl enquiryService;
    @Autowired
    private UserService userService;
    @Autowired
    private FPOService fpoService;
	
  
    
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
    @ApiOperation(value="Enquiry Request" ,code=201, produces = "application/json", notes="Api for all Enquiry Request",response = Enquiry.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public ResponseEntity<String> createEnquiry(@RequestBody EnquieryRequest enquiry) {
        LOG.info("Inside EnquiryController saving Enquiry ", enquiry);
        ResponseEntity<String> resp = null;
        try {
        
        	
            Enquiry id = enquiryService.createEnquiry(enquiry);
            resp = new ResponseEntity<String>(id.getEnquieryNumber(), HttpStatus.OK );
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
    
//    @PostMapping()
//    @ApiOperation(value="Enquiry Request" ,code=201, produces = "application/json", notes="Api for all Enquiry Request",response= Enquiry.class)
//    @ApiResponses(value = {
//            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
//            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
//            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
//    })
//	public ResponseEntity<MessageResponse> saveEnquiryHandler(@RequestBody Enquiry enquiry) {
//		LOG.info("Inside EnquiryController saving Enquiry ", enquiry);
//		ResponseEntity<MessageResponse> resp = null;
//		try {
//			enquiryService.saveEnquiry(enquiry);
//			resp = ResponseEntity.ok(new MessageResponse("Enquiry created Successfully!"));
//			LOG.info("Enquiry created Successfully!");
//		} catch (Exception e) {
//			resp = new ResponseEntity<MessageResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//			LOG.info("Failed to Save the Enquiry");
//			e.printStackTrace();
//		}
//		LOG.info("Exiting Enquiry Of Controller with response ", resp);
//		return resp;
//	}
    
    
     
    
    @GetMapping("/findByUser")
    @ApiOperation(value="Enquiry By User" ,code=201, produces = "application/json", notes="Api for find Enquiry By UserInfo",response= Enquiry.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<Enquiry> getEnquiryByUser(@RequestParam Long userId) throws UserPrincipalNotFoundException{
    	Optional<User> user = userService.findById(userId);
    	if(!user.isPresent()) {
    		throw new UsernameNotFoundException("User does not exist for "+userId +"id");
    	}
        LOG.info("Inside EnquiryController gettting Enquiry by userId");
        return enquiryService.getEnquiryInfo(user.get());
    }

    // /getall            getmapping               get all enquiry details
    // /insert            postmapping              create new Enquiery details   
    // /update/{id}       putMapping               update Enquiery details
    // /delete/{id}       deleteMapping           delete Enqiry Mapping 
    // /findByUser        getmapping              find Enquiery by user 
    // /findByFpo         getmapping              find Enquiery by Fpo
   
    @GetMapping("/findByFpo")
    @ApiOperation(value="Enquiry By Fpo" ,code=201, produces = "application/json", notes="Api for find Enquiry By Fpo",response= Enquiry.class)
    @ApiResponses(value= {
            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
    })
    public List<Enquiry> getEnquiryByFpo(@RequestParam("fpoId") Integer fpoId) throws UserPrincipalNotFoundException{
    	Optional<FPORegister> fpo = fpoService.findById(fpoId);
    	if(!fpo.isPresent()) {
    		throw new UsernameNotFoundException("Fpo does not exist for "+fpoId +"id");
    	}
        LOG.info("Inside EnquiryController gettting Enquiry by fpoId");
        return enquiryService.getEnquiryInfoByFpo(fpo.get());
}
}
