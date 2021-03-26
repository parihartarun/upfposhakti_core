package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.InputSupplierMaster;
import com.upfpo.app.service.InputSupplierService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/api/v1/InputSupplier")
@Api(produces = "application/json", value = "Update,Delete, and retrive the Input Supplier", tags="Input Supplier Operations",description="Update, Delete, and retrive the FPO")
public class InputSupplier 
{
	@Autowired
	InputSupplierService inputSupplierService;
	
	
	@GetMapping(value="/getInputSupplier")
	@ApiOperation(value="Get All Input Supplier details",code=200,produces = "application/json",notes="Api for view all Input Suppliers",response=InputSupplierMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	private ResponseEntity<List<InputSupplierMaster>> getInputSupplierDetails()
	{
		List<InputSupplierMaster> list = inputSupplierService.getInputSupplierDetails();
		return new ResponseEntity<List<InputSupplierMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{inputSupplierId}")
	@ApiOperation(value="Get InputSupplier profile by id", code=200, produces = "application/json",notes="Api for get FPO by id",response=InputSupplierMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public InputSupplierMaster getInputSupplierById(@PathVariable("inputSupplierId") Integer inputSupplierId)
	{
		return inputSupplierService.selectInputSupplierById(inputSupplierId);
	}
	@PutMapping(value="/editInputSupplier/{inputSupplierId}")
	@ApiOperation(value="Update Input Supplier", code=200, produces = "application/json", notes="Api for update Input Supplier",response=InputSupplierMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	private ResponseEntity<MessageResponse> editInputSupplier(@RequestBody InputSupplierMaster inputSupplier,@PathVariable("inputSupplierId") int inputSupplierId)
	{
		try {
			InputSupplierMaster inputSupplierEntity = inputSupplierService.updateInputSupplier(inputSupplier,inputSupplierId);
		return ResponseEntity	
				.ok(new MessageResponse("Input Supplier updated Successfully!"));
		//return new ResponseEntity<InputSupplierMaster>(inputSupplierEntity, new HttpHeaders(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return ResponseEntity	
					.ok(new MessageResponse("Input Supplier updated Successfully!"));
		}
	}
	
	@PutMapping(value="/deleteInputSupplier/{inputSupplierId}")
	@ApiOperation(value="Delete Input Supplier by id",code=204,produces = "text/plain",notes="Api for delete Input Supplier by id",response=HttpStatus.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	private HttpStatus deleteInputSupplier(@PathVariable("inputSupplierId") int inputSupplierId)
	{
		inputSupplierService.deleteInputSupplier(inputSupplierId);
		return HttpStatus.FORBIDDEN;
	}



}
