package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.dto.FarmerWiseProductionDTO;
import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.service.FarmerWiseProductionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/farmerWiseProductionReport")
@Api(produces = "application/json", value = "Farmer wise production report", tags="Farmer wise Production Report", description="Farmer production report")
public class FarmerWiseProductionReportController 
{
	@Autowired
	FarmerWiseProductionService farmerWiseProductionService;
	
	@ApiOperation(value="Get farmer production report", code=200, produces = "application/json",notes="Api for get all Farmer Production details",response=FarmerWiseProductionDTO.class, responseContainer = "List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	})
	@GetMapping("/getFarmerProductionReport/{fpoId}/{finYear}/{seasonId}")
	public List<FarmerWiseProductionDTO> getFarmerWiseProductionReport(@PathVariable("fpoId") Integer fpoId,@PathVariable("finYear") String finYear,@PathVariable("seasonId") Integer seasonId)
	{
		return farmerWiseProductionService.getReport(fpoId,finYear,seasonId);
	}
}
