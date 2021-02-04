package com.upfpo.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.entity.CropVerietyMaster;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="api/v1/cropVarietyDetails")
@Api(produces = "application/json", tags="Crop Variety Entity", value = "Retrive Crop Variety Details")
public class CropVarietyController 
{
	@GetMapping(value="/getCropVarietiesByCropId/{cropRefId}")
	public List<CropVerietyMaster> getCropVarietyByCropId(@PathVariable("cropRefId") Integer cropRefId)
	{
		
	}
}
