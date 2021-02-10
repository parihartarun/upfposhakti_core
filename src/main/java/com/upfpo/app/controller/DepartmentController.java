package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.DepartmentProdReportDto;
import com.upfpo.app.dto.DepartmentSalesReportDto;
import com.upfpo.app.service.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="api/department")
@Api(produces = "application/json", tags="Department reports and circular and suggestions", value = "view report, and upload circular of the Department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping(value="/getProductionReport")
	@ApiOperation(value="Get production report", code=200, produces = "application/json",notes="Api for get production report",response=DepartmentProdReportDto.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	})
	public List<DepartmentProdReportDto> productionReport(@RequestParam("finYear") String finYear,
			@RequestParam("distId") Integer distId, @RequestParam("cropId") Integer cropId,
			@RequestParam("seasonId") Integer seasonId) {
		
		return departmentService.getDepartmentProductionReport(finYear, distId, cropId, seasonId);
	}
	
	@PostMapping(value="/getSalesReport")
	@ApiOperation(value="Get sales report", code=200, produces = "application/json",notes="Api for get sales report",response=DepartmentSalesReportDto.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	})
	public List<DepartmentSalesReportDto> salesReport(@RequestParam("finYear") String finYear,
			@RequestParam("distId") Integer distId, @RequestParam("cropId") Integer cropId,
			@RequestParam("seasonId") Integer seasonId) {
		
		return departmentService.getDepartmentSalesReport(finYear, distId, cropId, seasonId);
	}

}
