package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.FpoFarmerDashboardDTO;
import com.upfpo.app.requestStrings.ReportRequestString;
import com.upfpo.app.service.FpoDashboardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/fpoDashboard")
@Api(produces = "application/json", value = "Retrive Fpo Dashboard", tags="Fpo Dashboard",description="Fpo dashboard data")	
public class FpoDashboardController 
{
	@Autowired
	FpoDashboardService fpoDashboardService;
	
	
	@PostMapping("/farmerDetails")
	@ApiOperation(value="Get Fpo Dashboard Data",code=200,produces = "application/json",notes="Api for view Fpo Dashboard Data",response=FpoFarmerDashboardDTO.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public FpoFarmerDashboardDTO getFpoFarmerDashboard(@RequestBody ReportRequestString reportRequestString)
	{
		return fpoDashboardService.totalFpoFarmer(reportRequestString);
	}
	 
	
	@GetMapping("/getFinancialYears")
	public List<String> getFinYear()
	{
		return fpoDashboardService.getFinYearFromTotProd();
	}
}
