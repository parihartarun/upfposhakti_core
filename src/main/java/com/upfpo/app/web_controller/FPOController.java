package com.upfpo.app.web_controller;

import java.util.ArrayList;
import java.util.List;

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
@Api(produces = "application/json", value = "Add, Update, Delete, and retrive the FPO")
public class FPOController {
	private Class clz = new ArrayList<FPORegister>().getClass();
	@Autowired
	private FPOService fpoService;
	
	@PostMapping
	@ApiOperation(value="Add new FPO profile",code=201, produces = "application/json", notes="Api for add new FPO",response=FPORegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	
	})
	@ResponseStatus( HttpStatus.CREATED )
	public FPORegister addNewFpo(@RequestBody FPORegister newFpoRegister)
	{
		
		return fpoService.insertFpo(newFpoRegister);
	}
	@PutMapping("/:id")
	@ApiOperation(value="Update FPO profile", code=200, produces = "application/json", notes="Api for update FPO",response=FPORegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	
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
	})
	public FPORegister getFpoById(@PathVariable("id") Integer id)
	{
		return fpoService.selectFpoById(id);
	}
	@DeleteMapping("/:id")
	@ApiOperation(value="Delete FPO profile by id",code=204,produces = "text/plain",notes="Api for delete FPO by id",response=Boolean.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	
	})
	public Boolean deleteFpo(@PathVariable("id") Integer id)
	{
		return fpoService.deleteFpo(id);
	}
	@GetMapping
	@ApiOperation(value="Get All FPO profiles",code=200,produces = "application/json",notes="Api for view all FPOs")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	
	})
	public List<FPORegister> getFpos()
	{
		return fpoService.selectFpos();
	}
}
