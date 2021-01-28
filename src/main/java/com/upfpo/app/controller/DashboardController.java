package com.upfpo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.entity.DashBoardData;
import com.upfpo.app.service.DashboardService;

@RestController
@RequestMapping("api/home/dashboard")
@CrossOrigin(origins="*",allowCredentials = "true")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;
	@GetMapping
	public DashBoardData getData()
	{
	return dashboardService.getDbd();	
	}
}
