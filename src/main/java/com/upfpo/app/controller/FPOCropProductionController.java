package com.upfpo.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.Enquiry;
import com.upfpo.app.entity.MarketableSurplus;
import com.upfpo.app.service.FPOCropProductionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)


@RestController
@RequestMapping(value="api/marketablesurplus")
@Api(produces = "application/json", tags="FPOCropProductionController", value = "Add, Update, Delete, and retrive the MarketableSurplus Crop Production")
public class FPOCropProductionController {
    private static final Logger LOG = LoggerFactory.getLogger(FPOCropProductionController.class);

	
	@Autowired
	private FPOCropProductionService fpoCropProductionService;
	
	
	 @GetMapping("/getall")
	    @ApiOperation(value="MarketableSurplus List" ,code=201, produces = "application/json", notes="Api for all MarketableSurplus Info",response= MarketableSurplus.class)
	    @ApiResponses(value= {
	            @ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	            @ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	            @ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	    })
	    public List<MarketableSurplus> getAllEnquiryDetails (){

	        LOG.info("Inside FPOCropProductionController gettting list of Enquiry ");
	        return fpoCropProductionService.getAllMarketableSurplus();
	    }
}
