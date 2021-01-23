package com.upfpo.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.ValidationException;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.BuyerSellerMaster;
import com.upfpo.app.entity.ChcFmbMaster;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.entity.InputSupplierMaster;
import com.upfpo.app.service.RegistrationServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/register")
@Api(produces = "application/json", value = "Add", tags="Registration- Farmer, Buyer/Seller, Input Supplier,CHC/FMB",description="Add")
public class RegistrationController 
{
	@Autowired
	RegistrationServices registerServices;
	
	
	@PostMapping(value="/fpo")
	private ResponseEntity<MessageResponse> registerFPO(@Valid @RequestBody FPORegister fpoRegister)
	{
		
		if(fpoRegister==null)
		{
			throw new ValidationException();
		}
		else {
			String fpo = registerServices.registerFPO(fpoRegister);
			if(fpo=="exists")
			{
				return ResponseEntity
						.ok(new MessageResponse("Fpo already exists!"));
			}
			else
			{
				//return new ResponseEntity<String>("", new HttpHeaders(), HttpStatus.CREATED);
				return ResponseEntity
						.ok(new MessageResponse("SuccessFully Saved!"));
			}
		}
	}
	
	@PostMapping(value="/farmer")
	@ApiOperation(value="Register new Farmer profile" ,code=201, produces = "application/json", notes="Api for add new Farmer",response=String.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	private ResponseEntity<MessageResponse> registerFarmer(@RequestBody FarmerMaster farmerRegister)
	{
		if(farmerRegister==null)
		{
			throw new ValidationException();
		}
		else {
			String farmer = registerServices.registerFarmer(farmerRegister);
			if(farmer=="exists")
			{
				return ResponseEntity
						.ok(new MessageResponse("Farmer already exists!"));
			}
			else
			{
				return ResponseEntity
						.ok(new MessageResponse("SuccessFully Saved!"));
			}
		}
	}
		
	@PostMapping(value="/buyerSeller")
	@ApiOperation(value="Register new Buyer Seller profile" ,code=201, produces = "application/json", notes="Api for add new Buyer Seller",response=MessageResponse.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	private ResponseEntity<MessageResponse> registerBuyerSeller(@RequestBody BuyerSellerMaster buyerSeller)
	{
		//return new ResponseEntity<MessageResponse>(buyerSellerdetails, new HttpHeaders(), HttpStatus.CREATED);
		if(buyerSeller==null)
		{
			throw new ValidationException();
		}
		else {
			String buyerSellerdetails = registerServices.registerBuyerSeller(buyerSeller);
			if(buyerSellerdetails=="exists")
			{
				return ResponseEntity
						.ok(new MessageResponse("Buyer Seller already exists!"));
			}
			else
			{
				return ResponseEntity
						.ok(new MessageResponse("SuccessFully Saved!"));
			}
		}
	}
	
	@PostMapping(value="/inputSupplier")
	@ApiOperation(value="Register new Input Supplier profile" ,code=201, produces = "application/json", notes="Api for add new Input Supplier",response=MessageResponse.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	private ResponseEntity<MessageResponse> registerInputSupplier(@RequestBody InputSupplierMaster inputSupplierMaster)
	{
		if(inputSupplierMaster.getInputSupplierType()==1)
		{
			inputSupplierMaster.setBlockRefId(null);
			inputSupplierMaster.setVillageRefId(null);
		}
			String inputSupplierDetails = registerServices.registerInputSuplier(inputSupplierMaster);
			if(inputSupplierDetails=="exists")
			{
				return ResponseEntity
						.ok(new MessageResponse("Input Supplier already exists!"));
			}
			else
			{
				return ResponseEntity
						.ok(new MessageResponse("SuccessFully Saved!"));
			}
		//return new ResponseEntity<InputSupplierMaster>(inputSupplierDetails,new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping(value="/chcFmb")
	@ApiOperation(value="Register new CHC FMB profile" ,code=201, produces = "application/json", notes="Api for add new CHC FMB",response=MessageResponse.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	private ResponseEntity<MessageResponse> registerChcFmb(@RequestBody ChcFmbMaster chcFmbMaster)
	{
		if(chcFmbMaster==null)
		{
			throw new ValidationException();
		}
		else {
			String chcFmbDetails = registerServices.registerChcFmb(chcFmbMaster);
			if(chcFmbDetails=="exists")
			{
				return ResponseEntity
						.ok(new MessageResponse("CHC FMB already exists!"));
			}
			else
			{
				return ResponseEntity
						.ok(new MessageResponse("SuccessFully Saved!"));
			}
		}
	}
	
	
}
