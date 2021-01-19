package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.StateMaster;
import com.upfpo.app.service.StateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/v1/state")
@Api(produces = "application/json", value = "Retrive States", tags="State Entity",description="Retrive states")
public class StateController 
{
	@Autowired
	StateService stateService;
	
	@GetMapping(value="/getStates")
	@ApiOperation(value="Get All State details",code=200,produces = "application/json",notes="Api for view all States",response=StateMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	private ResponseEntity<List<StateMaster>> getStates()
	{
		List<StateMaster> list = stateService.getStates();
		return new ResponseEntity<List<StateMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}