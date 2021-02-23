package com.upfpo.app.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.ValidationException;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.DistrictFilterDto;
import com.upfpo.app.entity.AgencyMaster;
import com.upfpo.app.entity.CollectionCenter;
import com.upfpo.app.service.AgencyMasterService;
import com.upfpo.app.service.CollectionCenterService;
import com.upfpo.app.service.FilterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/search/filters")
@Api(produces = "application/json", value = "One Controller to get All Dynamic Filters", tags="Search Filters",description="One Controller to get All Dynamic Filters")
public class FiltersController {

	@Autowired
	private FilterService filterService;
	
	@GetMapping("/districts")
	@ApiOperation(value="Get Districts List By Search Criteria",code=201, produces = "application/json", notes="Api for add new Agency Details",response=DistrictFilterDto.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	
	@ResponseStatus( HttpStatus.CREATED )
	public List<DistrictFilterDto> addNewAgencyDetails(@RequestParam("in") String in,@RequestParam("val") String value)
	{	
		//System.out.println("In  = "+in);
		//System.out.println("Val  = "+value);
		return filterService.getDistrictFilterListBySearchKeys(value, in);	
	}
	
}
