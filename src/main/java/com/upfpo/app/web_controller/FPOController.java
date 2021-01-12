package com.upfpo.app.web_controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.configuration.exception.ValidationException;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.SPRegister;
import com.upfpo.app.service.FIGService;
import com.upfpo.app.service.FPOService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/api/fpos")
@Api(produces = "application/json", value = "Add, Update, Delete, and retrive the FPO", description="Add, Update, Delete, and retrive the FPO")
public class FPOController {

	@Autowired
	private FPOService fpoService;
	
	@PostMapping
	@ApiOperation(value="Add new FPO profile",code=201, produces = "application/json", notes="Api for add new FPO",response=FPORegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus( HttpStatus.CREATED )
	public FPORegister addNewFpo(@RequestBody @Valid FPORegister newFpoRegister)
	{
	if(newFpoRegister==null)
	{
		throw new ValidationException();
	}else {
		return fpoService.insertFpo(newFpoRegister);
	}
	

		
	}
	@PutMapping("/:id")
	@ApiOperation(value="Update FPO profile", code=200, produces = "application/json", notes="Api for update FPO",response=FPORegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	
	public FPORegister updateFpo(@PathVariable("id") Integer id,@RequestBody FPORegister updateFpoRegister)
	{
		return fpoService.updateFpo(id, updateFpoRegister);
	}
	@GetMapping("/:id")
	@ApiOperation(value="Get FPO profile by id", code=200, produces = "application/json",notes="Api for get FPO by id",response=FPORegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public FPORegister getFpoById(@PathVariable("id") Integer id)
	{
		return fpoService.selectFpoById(id);
	}
	@DeleteMapping("/:id")
	@ApiOperation(value="Delete FPO profile by id",code=204,produces = "text/plain",notes="Api for delete FPO by id",response=Boolean.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	@ResponseStatus( HttpStatus.NO_CONTENT)
	public Boolean deleteFpo(@PathVariable("id") Integer id)
	{
		return fpoService.deleteFpo(id);
	}
	@GetMapping
	@ApiOperation(value="Get All FPO profiles",code=200,produces = "application/json",notes="Api for view all FPOs",response=FPORegister.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public List<FPORegister> getFpos()
	{
		return fpoService.selectFpos();
	}
}
