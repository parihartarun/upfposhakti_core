package com.upfpo.app.web_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.ChcFmbMaster;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.service.ChcFmbService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="api/v1/CHCFMB")
@Api(produces = "application/json", value = "Update, Delete, and retrive the CHC FMB", tags="CHC FMB Operations",description="Update, Delete, and retrive the FPO")
public class ChcFmbController 
{
	@Autowired
	ChcFmbService chcFmbService;
	
	@GetMapping(value="/getChcFmb")
	@ApiOperation(value="Get All CHC FMB details",code=200,produces = "application/json",notes="Api for view all CHC FMBs",response=ChcFmbMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	private ResponseEntity<List<ChcFmbMaster>> getchcFmbMaster()
	{
		List<ChcFmbMaster> list = chcFmbService.getChcFmbMaster();
		return new ResponseEntity<List<ChcFmbMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping(value="/editChcFmb/{chcFmbId}")
	@ApiOperation(value="Update CHC FMB", code=200, produces = "application/json", notes="Api for update CHC FMB",response=ChcFmbMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	private ResponseEntity<ChcFmbMaster> editChcFmb(@RequestBody ChcFmbMaster chcFmbMaster,@PathVariable("chcFmbId") int chcFmbId)
	{
		ChcFmbMaster chcFmbentity = chcFmbService.updateChcFmb(chcFmbMaster,chcFmbId);
		return new ResponseEntity<ChcFmbMaster>(chcFmbentity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping(value="/deleteChcFmbMaster/{chcFmbId}")
	@ApiOperation(value="Delete FPO profile by id",code=204,produces = "text/plain",notes="Api for delete FPO by id",response=HttpStatus.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	private HttpStatus deleteChcFmbMaster(@PathVariable("chcFmbId") int chcFmbId)
	{
		chcFmbService.deleteChcFmbMaster(chcFmbId);
		return HttpStatus.FORBIDDEN;
	}
}
