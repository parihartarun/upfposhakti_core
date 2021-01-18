package com.upfpo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


@RestController
@RequestMapping("/register")
@Api(produces = "application/json", value = "Add", tags="Registration- Farmer, Buyer/Seller, Input Supplier,CHC/FMB",description="Add")
public class RegistrationController 
{
	@Autowired
	RegistrationServices registerServices;
	
	
	@PostMapping(value="/fpo")
	private int registerFPO(@RequestBody FPORegister fpoRegister)
	{
		System.out.println("Inside registerFpo");
		registerServices.registerFPO(fpoRegister);
		return 1;
	}
	
	@PostMapping(value="/farmer")
	@ApiOperation(value="Register new Farmer profile" ,code=201, produces = "application/json", notes="Api for add new Farmer",response=FarmerMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	private ResponseEntity<FarmerMaster> registerFarmer(@RequestBody FarmerMaster farmerRegister)
	{
		if(farmerRegister==null)
		{
			throw new ValidationException();
		}
		else {
			FarmerMaster farmer = registerServices.registerFarmer(farmerRegister);
			return new ResponseEntity<FarmerMaster>(farmer, new HttpHeaders(), HttpStatus.CREATED);
		}
	}
		
	@PostMapping(value="/buyerSeller")
	@ApiOperation(value="Register new Buyer Seller profile" ,code=201, produces = "application/json", notes="Api for add new Buyer Seller",response=BuyerSellerMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	private ResponseEntity<BuyerSellerMaster> registerBuyerSeller(@RequestBody BuyerSellerMaster buyerSeller)
	{
		BuyerSellerMaster buyerSellerdetails = registerServices.registerBuyerSeller(buyerSeller);
		return new ResponseEntity<BuyerSellerMaster>(buyerSellerdetails, new HttpHeaders(), HttpStatus.CREATED);
	}
	
	@PostMapping(value="/inputSupplier")
	@ApiOperation(value="Register new Input Supplier profile" ,code=201, produces = "application/json", notes="Api for add new Input Supplier",response=InputSupplierMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	private ResponseEntity<InputSupplierMaster> registerInputSupplier(@RequestBody InputSupplierMaster inputSupplierMaster)
	{
		if(inputSupplierMaster.getInputSupplierType()==1)
		{
			inputSupplierMaster.setBlockRefId(null);
			inputSupplierMaster.setVillageRefId(null);
		}
		InputSupplierMaster inputSupplierDetails = registerServices.registerInputSuplier(inputSupplierMaster);
		return new ResponseEntity<InputSupplierMaster>(inputSupplierDetails,new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping(value="/chcFmb")
	@ApiOperation(value="Register new CHC FMB profile" ,code=201, produces = "application/json", notes="Api for add new CHC FMB",response=ChcFmbMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	private ResponseEntity<ChcFmbMaster> registerChcFmb(@RequestBody ChcFmbMaster chcFmbMaster)
	{
		ChcFmbMaster chcFmbDetails = registerServices.registerChcFmb(chcFmbMaster);
		return new ResponseEntity<ChcFmbMaster>(chcFmbDetails,new HttpHeaders(), HttpStatus.CREATED);
	}
	
	
}
