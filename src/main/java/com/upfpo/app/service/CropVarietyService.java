package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.CropVerietyMaster;

public interface CropVarietyService 
{
	public List<CropVerietyMaster> getCropVarietiesOnCropId(int cropRefId);
}
