package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.BankMaster;
import com.upfpo.app.entity.CropMaster;
import com.upfpo.app.service.CropDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="api/v1/cropMasterDetails")
@Api(produces = "application/json", value = "Retrive Crop Master Details", tags="Crop Master Entity",description="Retrive Crop Master Details")
public class CropDetailsController 
{
	@Autowired
	CropDetailsService cropDetailsService;
	
	@GetMapping(value="/getCropDetails")
	@ApiOperation(value="Get All Crop master details",code=200,produces = "application/json",notes="Api for view all Crop master",response=CropMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public ResponseEntity<List<CropMaster>> getCropDetails()
	{
		List<CropMaster> list = cropDetailsService.getCropDetails();
		return new ResponseEntity<List<CropMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}
