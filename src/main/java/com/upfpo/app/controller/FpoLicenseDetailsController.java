package com.upfpo.app.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.ValidationException;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.FpoLicenceDetails;
import com.upfpo.app.service.FpoLicenseDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@CrossOrigin(origins = "*", allowCredentials="true", maxAge = 3600)

@RestController
@RequestMapping(value="/api/fpo/license")
@Api(produces = "application/json", value = "Add, Update, Delete, and retrieve the Fpo License", tags="Farmer Producer Organization's License", description="Add, Update, Delete, and retrive the Fpo License")
public class FpoLicenseDetailsController {

	@Autowired
	private FpoLicenseDetailsService fpoLicenseDetailsService;
	
	@PostMapping
	@ApiOperation(value="Add new Fpo License",code=201, produces = "application/json", notes="Api for add new Collection Center",response=FpoLicenceDetails.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus(HttpStatus.CREATED)
	public FpoLicenceDetails addNewFpoLicenseDetails(@RequestBody @Valid FpoLicenceDetails fpoLicenseDetails)
	{
	if(fpoLicenseDetails==null)
	{
		throw new ValidationException();
	}else {
		return fpoLicenseDetailsService.insertFpoLicenceDetails(fpoLicenseDetails);
	}
	

		
	}
	
	//@PutMapping("/:id")
	@PutMapping(value="/updateLicense/{id}")
	@ApiOperation(value="Update Fpo License Details", code=200, produces = "application/json", notes="Api for update Fpo License Details",response=FpoLicenceDetails.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	
	public ResponseEntity<FpoLicenceDetails> updateFpoLicenseDetails(@PathVariable("id") Integer id,@RequestBody FpoLicenceDetails updateFpoLicenseDetails)
	{
		//return fpoLicenseDetailsService.updateFpoLicenceDetails(id, updateFpoLicenseDetails);
		FpoLicenceDetails fpoLicenceDetails = fpoLicenseDetailsService.updateFpoLicenceDetails(id, updateFpoLicenseDetails);
		return new ResponseEntity<FpoLicenceDetails>(fpoLicenceDetails, new HttpHeaders(), HttpStatus.OK);
	}
	
	//@GetMapping("/:id")
	@GetMapping(value="/getLicense/{id}")
	@ApiOperation(value="Get Fpo License Details by id", code=200, produces = "application/json",notes="Api for get Fpo License Details by id",response=FpoLicenceDetails.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public ResponseEntity<FpoLicenceDetails> getFpoLicenseDetailsById(@PathVariable("id") Integer id)
	{
		//return fpoLicenseDetailsService.selectFpoLicenceDetailsById(id);
		FpoLicenceDetails fpoLicenceDetails = fpoLicenseDetailsService.selectFpoLicenceDetailsById(id);
		return new ResponseEntity<FpoLicenceDetails>(fpoLicenceDetails, new HttpHeaders(), HttpStatus.OK);
	}
	
	//@DeleteMapping("/:id")
	@DeleteMapping(value="/deleteLicense/{id}")
	@ApiOperation(value="Delete Fpo License Details by id",code=204,produces = "text/plain",notes="Api for delete Fpo License Details by id",response=Boolean.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	//@ResponseStatus( HttpStatus.NO_CONTENT)
	public Boolean deleteFpoLicenseDetails(@PathVariable("id") Integer id)
	{
		return fpoLicenseDetailsService.deleteFpoLicenceDetails(id);
	}
	@GetMapping
	@ApiOperation(value="Get All Fpo License Details",code=200,produces = "application/json",notes="Api for view all Fpo License Details",response=FpoLicenceDetails.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public List<FpoLicenceDetails> getFpoLicenseDetails()
	{
		return fpoLicenseDetailsService.selectFpoLicenceDetails();
	}
}
