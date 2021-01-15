package com.upfpo.app.web_controller;

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
import com.upfpo.app.entity.VillageMaster;
import com.upfpo.app.service.VillageMasterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="api/v1/villages")
@Api(produces = "application/json", value = "Retrive Villages Details", tags="Village Entity",description="Retrive Villages")
public class VillageMasterController 
{
	@Autowired
	VillageMasterService villageMasterService;
	
	@GetMapping(value="/getVillages")
	@ApiOperation(value="Get All Village details",code=200,produces = "application/json",notes="Api for view all Village",response=VillageMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	private ResponseEntity<List<VillageMaster>> getVillages()
	{
		List<VillageMaster> list = villageMasterService.getVillages();
		return new ResponseEntity<List<VillageMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(value="/getVillagesByPanchayatId/{blockRef}")
	@ApiOperation(value="Get Villages details by Panchayat id",code=200,produces = "application/json",notes="Api for retrieve all Villages by Panchayat id",response=VillageMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public List<VillageMaster> getVillagesByPanchayat(@PathVariable("panchayatId") int panchayatId)
	{
		return villageMasterService.getVillagesByPanchayat(panchayatId);
	}
}
