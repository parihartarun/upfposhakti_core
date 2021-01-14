package com.upfpo.app.web_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.BankMaster;
import com.upfpo.app.entity.ChcFmbMaster;
import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.service.BankService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="api/v1/Bank")
@Api(produces = "application/json", value = "Retrive Bank Details", tags="Bank Entity",description="Retrive Bank")
public class BankController 
{
	@Autowired
	BankService bankService;
	
	@GetMapping(value="/getBanks")
	@ApiOperation(value="Get All Bank details",code=200,produces = "application/json",notes="Api for view all Banks",response=BankMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	private ResponseEntity<List<BankMaster>> getBanks()
	{
		List<BankMaster> list = bankService.getBanks();
		return new ResponseEntity<List<BankMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}
