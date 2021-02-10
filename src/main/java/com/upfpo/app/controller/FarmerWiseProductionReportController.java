package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.dto.FarmerWiseProductionDTO;
import com.upfpo.app.service.FarmerWiseProductionService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/farmerWiseProductionReport")
public class FarmerWiseProductionReportController 
{
	@Autowired
	FarmerWiseProductionService farmerWiseProductionService;
	
	@GetMapping("/getFarmerProductionReport/{fpoId}/{finYear}/{seasonId}")
	public List<FarmerWiseProductionDTO> getFarmerWiseProductionReport(@PathVariable("fpoId") Integer fpoId,@PathVariable("finYear") String finYear,@PathVariable("seasonId") Integer seasonId)
	{
		return farmerWiseProductionService.getReport(fpoId,finYear,seasonId);
	}
}
