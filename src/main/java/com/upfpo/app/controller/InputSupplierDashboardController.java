package com.upfpo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.dto.InputSupplierDashboardBarchartDTO;
import com.upfpo.app.service.InputSupplierDashboardService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/inputSupplierDashboard")
@Api(produces = "application/json", value = "Retrive Fpo Dashboard", tags="Fpo Dashboard",description="Fpo dashboard data")	
public class InputSupplierDashboardController 
{
	@Autowired
	InputSupplierDashboardService inputSupplierDashboardService;
	
	@GetMapping("/barChart/{masterId}")
	public InputSupplierDashboardBarchartDTO getBarchartData(@PathVariable("masterId") Integer masterId)
	{
		return inputSupplierDashboardService.getBarchartData(masterId);
	}
}
