package com.upfpo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.dto.CHCFMBDashboardBarchartDTO;
import com.upfpo.app.dto.CHCFMBDashboardIndentDTO;
import com.upfpo.app.service.CHCFMBDashboardService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/chcFmbDashboard")
@Api(produces = "application/json", value = "Retrive CHC Fmb Dashboard", tags="CHC FMB Dashboard",description="CHC FMB dashboard data")	
public class CHCFMBDashboardController 
{
	@Autowired
	CHCFMBDashboardService chcFmbDashboardService;
	
	@GetMapping("/barChart/{masterId}")
	public CHCFMBDashboardBarchartDTO getBarchartData(@PathVariable("masterId") Integer masterId)
	{
		return chcFmbDashboardService.getBarchartData(masterId);
	}
	
	@GetMapping("/indent/{masterId}")
	public CHCFMBDashboardIndentDTO getIndentData(@PathVariable("masterId") Integer masterId)
	{
		return chcFmbDashboardService.getIndentData(masterId);
	}
}
