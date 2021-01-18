package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.Panchayats;
import com.upfpo.app.service.PanchayatMasterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="api/v1/panchayats")
@Api(produces = "application/json", value = "Retrive Panchayat Details", tags="Panchayat Entity",description="Retrive Bank")
public class PanchayatMasterController 
{
	@Autowired
	PanchayatMasterService panchayatService;
	
	@GetMapping(value="/getPanchayats")
	@ApiOperation(value="Get All Panchayat details",code=200,produces = "application/json",notes="Api for view all Panchayats",response=Panchayats.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	private ResponseEntity<List<Panchayats>> getPanchayats()
	{
		List<Panchayats> list = panchayatService.getPanchayats();
		return new ResponseEntity<List<Panchayats>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(value="/getPanchayatsByBlockId/{blockRef}")
	@ApiOperation(value="Get Panchayat details by block id",code=200,produces = "application/json",notes="Api for retrieve all Panchayats by block id",response=Panchayats.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public List<Panchayats> getPanchayatByBlockId(@PathVariable("blockRef") int blockRef)
	{
		return panchayatService.getPanchayatByBlockId(blockRef);
	}
}