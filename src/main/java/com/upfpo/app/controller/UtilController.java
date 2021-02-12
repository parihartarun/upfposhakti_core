package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.DisplayDataDTO;
import com.upfpo.app.dto.FPODetailsDTO;
import com.upfpo.app.dto.ProductionDTO;
import com.upfpo.app.service.MasterService;
import com.upfpo.app.util.GetCurrentDate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/home")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "Retrive Data on Homepage")
public class UtilController {
	
	@Autowired
	private MasterService  masterServices;
	
	@GetMapping("/farmer")
	@ApiOperation(value="Get farmer's Data on homepage",code=200,produces = "application/json",notes="API to view farmer's data on homepage",response=DisplayDataDTO.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public DisplayDataDTO getFarmers()
	{
		return masterServices.farmers();
	}
	
	
	@GetMapping("/production")
	@ApiOperation(value="Production categorization",code=200,produces = "application/json",notes="API to view production data on homepage",response=DisplayDataDTO.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public ProductionDTO getProductions(String finYear)
	{
		return masterServices.productions(GetCurrentDate.getCurrentFinYear());
	}
	
	
	@GetMapping("/search")
	@ApiOperation(value="Search results",code=200,produces = "application/json",notes="API for search Results",response=FPODetailsDTO.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	
	public List<FPODetailsDTO> homeSearch(@RequestParam("val") String searchVal, @RequestParam("in") String searchIn,@RequestParam(value = "filterdist",required = false) List<String> districts,@RequestParam(value = "filterqty",required = false) List<Integer> qty,@RequestParam(value = "filtercrop",required = false) List<String> crops)
	{
		
//		crops.forEach(data->{
//			System.out.println("String of filterCrops = "+data);		
//		});
	
	
		return masterServices.homeSearch(searchVal,searchIn,districts,qty,crops);
			
	}
	
	
	//two parameters -> val in = type
	//fpo district crop any  --> types
	
}