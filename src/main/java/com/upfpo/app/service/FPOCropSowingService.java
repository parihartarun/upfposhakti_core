package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.CropListOfFarmersDTO;
import com.upfpo.app.dto.FarmerCropSowingDTO;
import com.upfpo.app.entity.NewSowing;

public interface FPOCropSowingService 
{
	public FarmerCropSowingDTO getFarmerDetailsForCropSowing(int farmerId);
	public List<CropListOfFarmersDTO> getCropListForFarmersByFpo(int masterId);
	public NewSowing addFarmerCropDetails(NewSowing newSowing);
	public NewSowing updateCropSowingDetails(Integer sowing_id, NewSowing newSowing);
}
