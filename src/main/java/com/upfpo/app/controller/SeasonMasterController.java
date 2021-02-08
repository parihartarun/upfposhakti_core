package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.DistrictMaster;
import com.upfpo.app.entity.SeasonMaster;
import com.upfpo.app.service.SeasonMasterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/seasonMaster")
@Api(produces = "application/json", value = "Retrive Seasons", tags="Season Entity",description="Retrive Seasons")
public class SeasonMasterController 
{
	@Autowired
	SeasonMasterService seasonMasterService;
	
	@GetMapping(value="/getSeasons")
	@ApiOperation(value="Get All Season details",code=200,produces = "application/json",notes="Api for view all Seasons",response=SeasonMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public ResponseEntity<List<SeasonMaster>> getSeasons()
	{
		List<SeasonMaster> seasonList =seasonMasterService.getSeasons();
		return new ResponseEntity<List<SeasonMaster>>(seasonList,new HttpHeaders(),HttpStatus.OK);
	}
}
