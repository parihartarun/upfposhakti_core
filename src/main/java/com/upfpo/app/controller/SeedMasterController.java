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
import com.upfpo.app.entity.DistrictMaster;
import com.upfpo.app.entity.SeasonMaster;
import com.upfpo.app.entity.SeedMaster;
import com.upfpo.app.service.SeasonMasterService;
import com.upfpo.app.service.SeedMasterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*",allowCredentials="true")
@RequestMapping(value="/api/v1//seedmaster")
@Api(produces = "application/json", value = "Retrive Seeds", tags="Seeds Entity",description="Retrive Seeds")
public class SeedMasterController 
{
	@Autowired
	SeedMasterService seedMasterService;
	
	@GetMapping(value="/getSeeds")
	@ApiOperation(value="Get All seeds details",code=200,produces = "application/json",notes="Api for view all Seeds",response=SeedMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public ResponseEntity<List<SeedMaster>> getSeasons()
	{
		List<SeedMaster> seedList =seedMasterService.getSeeds();
		return new ResponseEntity<List<SeedMaster>>(seedList,new HttpHeaders(),HttpStatus.OK);
	}
}