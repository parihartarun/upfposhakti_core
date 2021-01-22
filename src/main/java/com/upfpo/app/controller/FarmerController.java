package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.service.FarmerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/Farmer")
@Api(produces = "application/json", value = "Update, Delete, and retrive the Farmer", tags="Farmer Operations", description="fUpdate, Delete, and retrive the FPO")
public class FarmerController 
{
	@Autowired
	FarmerService farmerService;
	
	@PutMapping(value="/editFarmer/{farmerId}")
	@ApiOperation(value="Update Farmer Details", code=200, produces = "application/json", notes="Api for update Farmer",response=FarmerMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response = ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	})
	private ResponseEntity<FarmerMaster> editFarmer(@RequestBody FarmerMaster farmerMaster, @PathVariable("farmerMaster") int farmerId )
	{
		FarmerMaster farmerEntity = farmerService.updateFarmer(farmerMaster, farmerId);
		return new ResponseEntity<FarmerMaster>(farmerEntity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@ApiOperation(value="Get all Farmer details", code=200, produces = "application/json",notes="Api for get all Farmer details",response=FarmerMaster.class, responseContainer = "List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	})
	@GetMapping(value="/getFarmerDetails")
	private ResponseEntity<List<FarmerMaster>> getFarmerDetailsById()
	{
		List<FarmerMaster> list = farmerService.getFarmer();
		return new ResponseEntity<List<FarmerMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	/*
	 * @GetMapping(value="/getFarmerDetails/{farmerId}") private FarmerMaster
	 * getFarmerDetailsById(@PathVariable("farmerId") int farmerId) { return
	 * registerServices.getFarmerDetailsById(farmerId); }
	 */
	
	@PutMapping(value="/deleteFarmer/{farmerId}")
	@ApiOperation(value="Delete Farmer deatails by id",code=204,produces = "text/plain",notes="Api for delete FPO by id",response=Boolean.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	})
	private Boolean deleteFarmer(@PathVariable("farmerId") int farmerId)
	{
		farmerService.deleteFarmer(farmerId);
		return true;
	}
	
}
