package com.upfpo.app.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.configuration.exception.ValidationException;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.custom.CustomException;
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

	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	
	@PostMapping(value="/fpo")
	@ApiOperation(value="Register new Fpo " ,code=201, produces = "application/json", notes="Api for add new Farmer",response=MessageResponse.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus( HttpStatus.OK)
	private ResponseEntity<MessageResponse> registerFPO(@Valid @RequestBody FPORegister fpoRegister) throws CustomException
	{
				if(registerServices.checkFPOExists(fpoRegister.getFpoEmail())>0){
					throw new CustomException("FPO already exists",HttpStatus.BAD_REQUEST);
				}
				if(registerServices.checkUserFpoExists(fpoRegister.getUserFpo().getUserName())>0)
				{
					throw new CustomException("FPO User Name already exists",HttpStatus.BAD_REQUEST);
				}
				registerServices.registerFPO(fpoRegister);
				return ResponseEntity.ok(new MessageResponse("SuccessFully Saved!"));

	}
	
	@PostMapping(value="/farmer")
	@ApiOperation(value="Register new Farmer profile" ,code=201, produces = "application/json", notes="Api for add new Farmer",response=String.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	private ResponseEntity<MessageResponse> registerFarmer(@Valid @RequestBody FarmerMaster farmerRegister) throws CustomException
	{
		if(farmerRegister==null)
		{
			throw new ValidationException();
		}
		else {
			if(registerServices.checkUserFarmerExists(farmerRegister.getUserFar().getUserName())>0)
			{
				throw new CustomException("Farmer User Name already exists",HttpStatus.BAD_REQUEST);
			}
			if(registerServices.checkFarmerExists(farmerRegister.getFarmerMob())>0)
			{
				throw new CustomException("Farmer already exists",HttpStatus.BAD_REQUEST);
			}
				registerServices.registerFarmer(farmerRegister);
				return ResponseEntity	
						.ok(new MessageResponse("SuccessFully Saved!"));
		}
	}
		
	@PostMapping(value="/buyerSeller")
	@ApiOperation(value="Register new Buyer Seller profile" ,code=201, produces = "application/json", notes="Api for add new Buyer Seller",response=MessageResponse.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	private ResponseEntity<MessageResponse> registerBuyerSeller(@Valid @RequestBody BuyerSellerMaster buyerSeller) throws CustomException
	{
		//return new ResponseEntity<MessageResponse>(buyerSellerdetails, new HttpHeaders(), HttpStatus.CREATED);
		if(buyerSeller==null)
		{
			throw new ValidationException();
		}
		else {
			if(registerServices.checkBuyerSellerExists(buyerSeller.getMobileNumber())==1){
				throw new CustomException("Buyer/Seller already exists",HttpStatus.BAD_REQUEST);
			}
			if(registerServices.checkUserBuyerSellerExists(buyerSeller.getUserBuyerSeller().getUserName())>0)
			{
				throw new CustomException("Buyer Seller User Name already exists",HttpStatus.BAD_REQUEST);
			}
				registerServices.registerBuyerSeller(buyerSeller);
				return ResponseEntity
						.ok(new MessageResponse("SuccessFully Saved!"));	
		}
	}
	
	@PostMapping(value="/inputSupplier")
	@ApiOperation(value="Register new Input Supplier profile" ,code=201, produces = "application/json", notes="Api for add new Input Supplier",response=MessageResponse.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	private ResponseEntity<MessageResponse> registerInputSupplier(@Valid @RequestBody InputSupplierMaster inputSupplierMaster) throws CustomException
	{
		if(inputSupplierMaster.getInputSupplierType()==1)
		{
			inputSupplierMaster.setBlockRefId(null);
			inputSupplierMaster.setVillageRefId(null);
		}
		if(registerServices.checkUserInputSupplierExists(inputSupplierMaster.getUserInputSeller().getUserName())>0)
		{
			throw new CustomException("Input Supplier User Name already exists",HttpStatus.BAD_REQUEST);
		}
		if(registerServices.checkInputSupplierExists(inputSupplierMaster.getMobile_number())>0)
		{
			throw new CustomException("Input Supplier already exists",HttpStatus.BAD_REQUEST);
		}
			registerServices.registerInputSuplier(inputSupplierMaster);
			return ResponseEntity	
					.ok(new MessageResponse("SuccessFully Saved!"));
		
		//return new ResponseEntity<InputSupplierMaster>(inputSupplierDetails,new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping(value="/chcFmb")
	@ApiOperation(value="Register new CHC FMB profile" ,code=201, produces = "application/json", notes="Api for add new CHC FMB",response=MessageResponse.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	private ResponseEntity<MessageResponse> registerChcFmb(@Valid @RequestBody ChcFmbMaster chcFmbMaster) throws CustomException
	{
		if(chcFmbMaster==null)
		{
			throw new ValidationException();
		}
		else {
			if(registerServices.checkUserChcFmbExists(chcFmbMaster.getUser().getUserName())>0)
			{
				throw new CustomException("CHC/FMB User Name already exists",HttpStatus.BAD_REQUEST);
			}
			if(registerServices.checkChcFmbExists(chcFmbMaster.getMobileNumber())>0)
			{
				throw new CustomException("CHC/FMB already exists",HttpStatus.BAD_REQUEST);
			}
			 registerServices.registerChcFmb(chcFmbMaster);
				return ResponseEntity
						.ok(new MessageResponse("SuccessFully Saved!"));
		}
	}
	
	
}
