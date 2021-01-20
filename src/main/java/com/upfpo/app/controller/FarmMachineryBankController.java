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
import com.upfpo.app.entity.DistrictMaster;
import com.upfpo.app.entity.FarmMachineryBank;
import com.upfpo.app.service.FarmMachineryBankService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping(value="/api/farm/machinery/banks")
@Api(produces = "application/json", value = "Add, Update, Delete, and retrieve the Farm Machinery Banks", tags="Farm Machinary Bank", description="Add, Update, Delete, and retrieve the Farm Machinery Banks")
public class FarmMachineryBankController {

	@Autowired
	private FarmMachineryBankService farmMachineryBankService;
	
	@PostMapping
	@ApiOperation(value="Add new Farm Machinery Bank",code=201, produces = "application/json", notes="Api for add new Farm Machinery Bank",response=FarmMachineryBank.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus( HttpStatus.CREATED )
	public FarmMachineryBank addNewFarmMachineryBank(@RequestBody @Valid FarmMachineryBank farmMachineryBank)
	{
	if(farmMachineryBank==null)
	{
		throw new ValidationException();
	}else {
		return farmMachineryBankService.insertFarmMachineryBank(farmMachineryBank);
	}
	

		
	}
	
	@PutMapping("/:id")
	@ApiOperation(value="Update Farm Machinery Bank", code=200, produces = "application/json", notes="Api for update Farm Machinery Bank",response=FarmMachineryBank.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	
	public FarmMachineryBank updateFarmMachineryBank(@PathVariable("id") Integer id,@RequestBody FarmMachineryBank updateFarmMachineryBank)
	{
		return farmMachineryBankService.updateFarmMachineryBank(id, updateFarmMachineryBank);
	}
	
	//@GetMapping("/:id")
	@GetMapping(value="/getMachinery/{id}")
	@ApiOperation(value="Get Farm Machinery Bank by id", code=200, produces = "application/json",notes="Api for get Farm Machinery Bank by id",response=FarmMachineryBank.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public ResponseEntity<FarmMachineryBank> getFarmMachineryBankById(@PathVariable("id") Integer id)
	{
		//return farmMachineryBankService.selectFarmMachineryBankById(id);
		FarmMachineryBank FMB = farmMachineryBankService.selectFarmMachineryBankById(id);
		return new ResponseEntity<FarmMachineryBank>(FMB,new HttpHeaders(),HttpStatus.OK);
	}
	
	//@DeleteMapping("/:id")
	@DeleteMapping(value="/deleteMachinery/{id}")
	@ApiOperation(value="Delete Farm Machinery Bank by id",code=204,produces = "text/plain",notes="Api for Delete Farm Machinery Bank by id",response=boolean.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	@ResponseStatus( HttpStatus.NO_CONTENT)
	public Boolean deleteFarmMachineryBank(@PathVariable("id") Integer id)
	{
		System.err.println("$$$$$$$$$$$$$$$ == "+id);
		return farmMachineryBankService.deleteFarmMachineryBank(id);
	}
	
	@GetMapping
	@ApiOperation(value="Get All Farm Machinery Banks",code=200,produces = "application/json",notes="Api for view all Farm Machinery Banks",response=FarmMachineryBank.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public List<FarmMachineryBank> getFarmMachineryBank()
	{
		return farmMachineryBankService.selectFarmMachineryBank();
	}
}
