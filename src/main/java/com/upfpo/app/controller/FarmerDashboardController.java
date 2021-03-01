package com.upfpo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.FarmerDashboardDTO;
import com.upfpo.app.dto.FpoFarmerDashboardDTO;
import com.upfpo.app.service.FarmerDashboardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/farmerDashboard")
@Api(produces = "application/json", value = "Retrive Farmer Dashboard", tags="Farmer Dashboard",description="Farmer dashboard data")	
public class FarmerDashboardController 
{
	@Autowired
	FarmerDashboardService farmerDashboardService; 
	
	@GetMapping("/getFarmerDetails/{farmerId}")
	@ApiOperation(value="Get Farmer Dashboard Data",code=200,produces = "application/json",notes="Api for view Fpo Dashboard Data",response=FpoFarmerDashboardDTO.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public FarmerDashboardDTO getFarmerDashBoard(@PathVariable("farmerId") Integer farmerId)
	{
		return farmerDashboardService.getFarmerDashboardData(farmerId);
	}
	
}
