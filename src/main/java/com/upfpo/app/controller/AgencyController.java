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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.ValidationException;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.AgencyMaster;
import com.upfpo.app.entity.CollectionCenter;
import com.upfpo.app.service.AgencyMasterService;
import com.upfpo.app.service.CollectionCenterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/agencies")
@Api(produces = "application/json", value = "Add, Update, Delete, and retrive the Agencies", tags="Agency",description="Add, Update, Delete, and retrive the Agencies.")
public class AgencyController {

	@Autowired
	private AgencyMasterService agencyMasterService;
	
	@PostMapping
	@ApiOperation(value="Add new Agency Details",code=201, produces = "application/json", notes="Api for add new Agency Details",response=AgencyMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus( HttpStatus.CREATED )
	public AgencyMaster addNewAgencyDetails(@RequestBody @Valid AgencyMaster agencyMaster)
	{
	if(agencyMaster==null)
	{
		throw new ValidationException();
	}else {
		return agencyMasterService.insertAgencyMaster(agencyMaster);
	}
	

		
	}
	@PutMapping("/:id")
	@ApiOperation(value="Update Aganecy Details", code=200, produces = "application/json", notes="Api for update Agency Details",response=AgencyMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	
	public AgencyMaster updateAgencyMaster(@PathVariable("id") Integer id,@RequestBody AgencyMaster updateAgencyMaster)
	{
		return agencyMasterService.updateAgencyMaster(id, updateAgencyMaster);
	}
	@GetMapping("/:id")
	@ApiOperation(value="Get Agency by id", code=200, produces = "application/json",notes="Api for get Agency by id",response=AgencyMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public AgencyMaster getAgencyMasterById(@PathVariable("id") Integer id)
	{
		return agencyMasterService.selectAgencyMasterById(id);
	}
	@DeleteMapping("/:id")
	@ApiOperation(value="Delete Agency  Details by id",code=204,produces = "text/plain",notes="Api for delete Agency Details by id",response=Boolean.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	@ResponseStatus( HttpStatus.NO_CONTENT)
	public Boolean deleteAgencyMaster(@PathVariable("id") Integer id)
	{
		return agencyMasterService.deleteAgencyMaster(id);
	}
	@GetMapping
	@ApiOperation(value="Get All Agencies List",code=200,produces = "application/json",notes="Api for view all Agencies",response=AgencyMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public List<AgencyMaster> getAgencies()
	{
		return agencyMasterService.selectAgencyMaster();
	}
}
