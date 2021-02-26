package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.dto.DepartmentDashboardDTO;
import com.upfpo.app.dto.DeptDashboardReportDTO;
import com.upfpo.app.requestStrings.ReportRequestString;
import com.upfpo.app.service.DepartmentDashboardService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/departmentDashboard")
@Api(produces = "application/json", value = "Retrive Department Dashboard", tags="Department Dashboard",description="Retrive Bank")	
public class DepartmentDashboardController 
{
	@Autowired
	DepartmentDashboardService departmentDashboardService; 
	
	@GetMapping("/getDeptDashBoardData")
	public DepartmentDashboardDTO getDepartmentDashBoardData()
	{
		return departmentDashboardService.getDepartmentDashboardData();
	}
	
	@PostMapping("/getDeptDashboardReport")
	public List<DeptDashboardReportDTO> getDashboardReport(@RequestBody ReportRequestString reportRequestString)
	{
		return departmentDashboardService.getDepartmentDashboardReport(reportRequestString);
	}
}
