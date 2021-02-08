package com.upfpo.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.FpoCropProductionDetailsDTO;
import com.upfpo.app.entity.MarketableSurplus;
import com.upfpo.app.service.FPOCropProductionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)


@RestController
@RequestMapping(value="marketablesurplus")
@Api(produces = "application/json", tags="FPOCropProductionController", value = "Add, Update, Delete, and retrive the MarketableSurplus Crop Production")
public class FPOCropProductionController {
    private static final Logger LOG = LoggerFactory.getLogger(FPOCropProductionController.class);

	
	@Autowired
	private FPOCropProductionService fpoCropProductionService;
	
	
	 @GetMapping("/getFpoCropProductionDetails/{masterId}")
	    @ApiOperation(value="MarketableSurplus List" ,code=201, produces = "application/json", notes="Api for all MarketableSurplus Info",response= MarketableSurplus.class)
	    @ApiResponses(value= {
	            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	    })
	    public List<FpoCropProductionDetailsDTO> getAllFpoCropProductionDetails (@PathVariable("masterId") Integer masterId){

	        LOG.info("Inside FPOCropProductionController gettting list of Enquiry ");
	        return fpoCropProductionService.getAllMarketableSurplus(masterId);
	    }
	 
	 @PostMapping()
	    @ApiOperation(value="MarketableSurplus Request" ,code=201, produces = "application/json", notes="Api for all Enquiry Request",response= MarketableSurplus.class)
	    @ApiResponses(value= {
	            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	    })
		public ResponseEntity<MessageResponse> saveMarketableSurplus(@RequestBody MarketableSurplus marketableSurplus) {
			LOG.info("Inside FPOCropProductionController saving marketableSurplus ", marketableSurplus);
			ResponseEntity<MessageResponse> resp = null;
			try {
				fpoCropProductionService.saveMarketableSurplus(marketableSurplus);
				resp = ResponseEntity.ok(new MessageResponse("MarketableSurplus created Successfully!"));
				LOG.info("MarketableSurplus created Successfully!");
			} catch (Exception e) {
				resp = new ResponseEntity<MessageResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
				LOG.info("Failed to Save the MarketableSurplus");
				e.printStackTrace();
			}
			LOG.info("Exiting MarketableSurplus Of Controller with response ", resp);
			return resp;
		}
	 
	 
	  @PutMapping("/update/{id}")
	    @ApiOperation(value="MarketableSurplus Update" ,code=201, produces = "application/json", notes="Api for all MarketableSurplus Update",response= MarketableSurplus.class)
	    @ApiResponses(value= {
	            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	    })
	    public ResponseEntity<String> updateEnquiry(@PathVariable Integer id, @RequestBody MarketableSurplus marketableSurplus) {
	        LOG.info("Inside FPOCropProductionController updating sales details ", marketableSurplus);
	        ResponseEntity<String> resp = null;
	        try {
	        	MarketableSurplus MarketableSplus = fpoCropProductionService.updateMarketableSurplus(id, marketableSurplus);
	            resp = new ResponseEntity<String>("MarketableSurplus Updated Successfully!", HttpStatus.OK );
	            LOG.info("MarketableSurplus Updated Successfully!");
	            //}
	        } catch (Exception e) {
	            resp = new ResponseEntity<String>("Failed to Update the MarketableSurplus", HttpStatus.INTERNAL_SERVER_ERROR);
	            LOG.info("Failed to Update the MarketableSurplus");
	            e.printStackTrace();
	        }
	        LOG.info("Exiting MarketableSurplus Of Controller with response ", resp);
	        return resp;
	    }
	  
	  @DeleteMapping("/delete/{id}")
	    @ApiOperation(value="MarketableSurplus Delete" ,code=201, produces = "application/json", notes="Api for all Enquiry Delete",response= MarketableSurplus.class)
	    @ApiResponses(value= {
	            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	    })
	    public ResponseEntity<String> deleteEnquiry(@PathVariable Integer id) {
	        LOG.info("Inside FPOCropProductionController MarketableSurplus details ");
	        ResponseEntity<String> resp = null;
	        try {
	        	fpoCropProductionService.deleteMarketableSurplus(id);
	            resp = new ResponseEntity<String>("MarketableSurplus Deleted Successfully!", HttpStatus.OK );
	            LOG.info("MarketableSurplus Deleted Successfully!");
	            //}
	        } catch (Exception e) {
	            resp = new ResponseEntity<String>("Failed to Delete the MarketableSurplus", HttpStatus.INTERNAL_SERVER_ERROR);
	            LOG.info("Failed to Delete the MarketableSurplus");
	            e.printStackTrace();
	        }
	        LOG.info("Exiting MarketableSurplus Of Controller with response ", resp);
	        return resp;
	    }
	    
	    
}
