package com.upfpo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.dto.FpoFarmerDashboardDTO;
import com.upfpo.app.service.FpoDashboardService;

@RestController
@RequestMapping("/fpoDashboard")
public class FpoDashboardController 
{
	@Autowired
	FpoDashboardService fpoDashboardService;
	
	@GetMapping("/farmerDetails/{fpoId}")
	public FpoFarmerDashboardDTO getFpoFarmerDashboard(@PathVariable("fpoId") Integer fpoId)
	{
		return fpoDashboardService.totalFpoFarmer(fpoId);
	}
}
