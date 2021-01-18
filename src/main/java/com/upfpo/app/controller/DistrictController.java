package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.DistrictMaster;
import com.upfpo.app.service.DistrictService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping(value="/api/v1/District")
@Api(produces = "application/json", value = "Retrive Districts", tags="District Entity",description="Retrive districts")
public class DistrictController 
{
	@Autowired
	DistrictService districtService;
	
	@GetMapping(value="/getDistricts")
	@ApiOperation(value="Get All District details",code=200,produces = "application/json",notes="Api for view all Districts",response=DistrictMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	private ResponseEntity<List<DistrictMaster>> getDistricts()
	{
		List<DistrictMaster> list = districtService.getDistricts();
		return new ResponseEntity<List<DistrictMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(value="/getDistricts/{district_id}")
	@ApiOperation(value="Get All Bank details by id",code=200,produces = "application/json",notes="Api for view all Bank by id",response=DistrictMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public ResponseEntity<DistrictMaster> getDistrictsById(@PathVariable("district_id") int district_id )
	{
		DistrictMaster districtEntity = districtService.getDistrictsById(district_id);
		return new ResponseEntity<DistrictMaster>(districtEntity,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(value="/getDistrictsByStateId/{state_id}")
	@ApiOperation(value="Get All District details by State id",code=200,produces = "application/json",notes="Api for view all Districts by State id",response=DistrictMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public List<DistrictMaster> getStatesById(@PathVariable("state_id") int state_id )
	{
		return districtService.getDistrictsByStateId(state_id);
	}
}
