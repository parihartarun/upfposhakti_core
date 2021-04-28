package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.dto.CropListOfFarmersDTO;
import com.upfpo.app.dto.FPOCropSowingExistingDTO;
import com.upfpo.app.dto.FarmerCropSowingDTO;
import com.upfpo.app.entity.CropDatails;
import com.upfpo.app.entity.NewSowing;
import com.upfpo.app.requestStrings.ReportRequestString;
import com.upfpo.app.service.FPOCropSowingService;

import lombok.Delegate;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping(value = "/fpoCropSowing")
public class FPOCropSowingController 
{
	@Autowired
	FPOCropSowingService fPOCropSowingService;
	
	@GetMapping(value="/getFarmerDetailsForCropSowing/{farmerId}") 
	 public  FarmerCropSowingDTO getFarmerDetailsForCropSowing(@PathVariable("farmerId") Integer farmerId) 
	 { 
		  return fPOCropSowingService.getFarmerDetailsForCropSowing(farmerId); 
    }
	
	@GetMapping(value="/getFarmerParentDetails/{farmerId}")
	public FarmerCropSowingDTO getFarmerParentDetails(@PathVariable("farmerId") Integer farmerId)
	{
		return fPOCropSowingService.getFarmerParentDetails(farmerId);
	}
	 
	 @GetMapping(value="/farmersCropSowingsList/{masterId}")
	 public List<CropListOfFarmersDTO> getfarmersCropList(@PathVariable("masterId") int masterId)
	 {
		 return fPOCropSowingService.getCropListForFarmersByFpo(masterId);
	 }
	 
	 @PostMapping("/getFarmerCropSowingDetails")
	 public List<FPOCropSowingExistingDTO> getFramerCropSowingDetails(@RequestBody ReportRequestString reportRequestString) 
	 {
		 return fPOCropSowingService.getExistingSowingDetails(reportRequestString);
	 }
	 
	 @PostMapping(value="/addFarmerCropSowingDetails")
	 public void addFarmerCropDetails(@RequestBody NewSowing newSowing)
	 {
		  fPOCropSowingService.addFarmerCropDetails(newSowing);
	 }
	 
	 @PutMapping("/updateFarmerCropSowingDetails/{cropId}")
	 public CropDatails updateFarmerCropDetails(@PathVariable("cropId") Integer cropId,@RequestBody CropDatails cropDatails)
	 {
		 return fPOCropSowingService.updateCropSowingDetails(cropId, cropDatails);
	 }
	 
	 @DeleteMapping("/deleteCropSowingDetails/{cropId}")
	 public Boolean deleteCropSowingDetails(@PathVariable("cropId") Integer cropId)
	 {
		 return fPOCropSowingService.deleteCropSowingDetails(cropId);
	 }
}
