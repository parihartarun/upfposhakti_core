package com.upfpo.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
import com.upfpo.app.entity.LicenseMaster;
import com.upfpo.app.service.LicenseMasterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping(value="/api/licenses")
@Api(produces = "application/json", tags="Licenses", value = "Add, Update, Delete, and retrive the License", description="Add, Update, Delete, and retrive the License Master")
public class LicenseMasterController {

	@Autowired
	private LicenseMasterService licenseMasterService;
	
	@ApiOperation(value="Add new License Master",code=201, produces = "application/json", notes="Api for add new Collection Center",response=LicenseMaster.class)
	@PostMapping
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus( HttpStatus.CREATED )
	public LicenseMaster addNewLicenseMaster(@RequestBody @Validated LicenseMaster licenseMaster)
	{
	if(licenseMaster==null)
	{
		throw new ValidationException();
	}else {
		return licenseMasterService.insertLicenseMaster(licenseMaster);
	}
	

		
	}
	@PutMapping("/:id")
	@ApiOperation(value="Update License Master", code=200, produces = "application/json", notes="Api for update License Master",response=LicenseMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	
	public LicenseMaster updateLicenseMaster(@PathVariable("id") Integer id,@RequestBody LicenseMaster updateLicenseMaster)
	{
		return licenseMasterService.updateLicenseMaster(id, updateLicenseMaster);
	}
	@GetMapping("/:id")
	@ApiOperation(value="Get License Master by id", code=200, produces = "application/json",notes="Api for get License Master by id",response=LicenseMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public LicenseMaster getLicenseMasterById(@PathVariable("id") Integer id)
	{
		return licenseMasterService.selectLicenseMasterById(id);
	}
	@DeleteMapping("/:id")
	@ApiOperation(value="Delete License Master by id",code=204,produces = "text/plain",notes="Api for delete License Master by id",response=Boolean.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	@ResponseStatus( HttpStatus.NO_CONTENT)
	public Boolean deleteCollectionCenter(@PathVariable("id") Integer id)
	{
		return licenseMasterService.deleteLicenseMaster(id);
	}
	@GetMapping
	@ApiOperation(value="Get All License Masters",code=200,produces = "application/json",notes="Api for view all License Masters",response=LicenseMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public List<LicenseMaster> getLicenseMasters()
	{
		return licenseMasterService.selectLicenseMaster();
	}
}
