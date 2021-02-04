package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.entity.CropMaster;
import com.upfpo.app.entity.CropVerietyMaster;
import com.upfpo.app.service.CropVarietyService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="api/v1/cropVarietyDetails")
@Api(produces = "application/json", tags="Crop Variety Entity", value = "Retrive Crop Variety Details")
public class CropVarietyController 
{
	@Autowired
	CropVarietyService cropVarietyService;
	
	@GetMapping(value="/getCropVarietiesByCropId/{cropRefId}")
	public ResponseEntity<List<CropVerietyMaster>> getCropVarietyByCropId(@PathVariable("cropRefId") Integer cropRefId)
	{
		List<CropVerietyMaster> list = cropVarietyService.getCropVarietiesOnCropId(cropRefId);
		return new ResponseEntity<List<CropVerietyMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}
