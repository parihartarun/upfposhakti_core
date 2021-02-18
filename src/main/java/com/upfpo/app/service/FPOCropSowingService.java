package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.CropListOfFarmersDTO;
import com.upfpo.app.dto.FPOCropSowingExistingDTO;
import com.upfpo.app.dto.FarmerCropSowingDTO;
import com.upfpo.app.entity.NewSowing;
import com.upfpo.app.requestStrings.ReportRequestString;

public interface FPOCropSowingService 
{
	public FarmerCropSowingDTO getFarmerDetailsForCropSowing(int farmerId);
	public List<CropListOfFarmersDTO> getCropListForFarmersByFpo(int masterId);
	public NewSowing addFarmerCropDetails(NewSowing newSowing);
	public List<FPOCropSowingExistingDTO> getExistingSowingDetails(ReportRequestString reportRequestString);
	public NewSowing updateCropSowingDetails(Integer sowing_id, NewSowing newSowing);
}
