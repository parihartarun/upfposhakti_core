package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.CropListOfFarmersDTO;
import com.upfpo.app.dto.FPOCropSowingExistingDTO;
import com.upfpo.app.dto.FarmerCropSowingDTO;
import com.upfpo.app.entity.CropDatails;
import com.upfpo.app.entity.NewSowing;
import com.upfpo.app.requestStrings.ReportRequestString;

public interface FPOCropSowingService 
{
	public FarmerCropSowingDTO getFarmerDetailsForCropSowing(int farmerId);
	public FarmerCropSowingDTO getFarmerParentDetails(int farmerId);
	public List<CropListOfFarmersDTO> getCropListForFarmersByFpo(int masterId);
	public void addFarmerCropDetails(NewSowing newSowing);
	public List<FPOCropSowingExistingDTO> getExistingSowingDetails(ReportRequestString reportRequestString);
	public CropDatails updateCropSowingDetails(Integer cropId, CropDatails cropDatails);
	public Boolean deleteCropSowingDetails(Integer cropId);
}
