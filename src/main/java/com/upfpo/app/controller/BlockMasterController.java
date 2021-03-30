package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.MasterDTO;
import com.upfpo.app.entity.BlockMaster;
import com.upfpo.app.entity.Panchayats;
import com.upfpo.app.service.BlockMasterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="api/v1/block")
@Api(produces = "application/json", value = "Retrive Block Details", tags="Block Entity",description="Retrive Bank")
public class BlockMasterController 
{
	@Autowired
	BlockMasterService blockMasterService;
	
	@GetMapping(value="/getBlocks")
	@ApiOperation(value="Get All Block details",code=200,produces = "application/json",notes="Api for view all Blocks",response=BlockMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	private ResponseEntity<List<BlockMaster>> getBlocks()
	{
		List<BlockMaster> list = blockMasterService.getBlocks();
		return new ResponseEntity<List<BlockMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(value="/getBlocksByDistrictId/{distId}")
	@ApiOperation(value="Get Block details by district id",code=200,produces = "application/json",notes="Api for retrieve all Blocks by district id",response=BlockMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public List<MasterDTO> getBlocksByDistrictId(@PathVariable("distId") int distId)
	{
		return blockMasterService.getBlockByDistrictId(distId);
	}
}