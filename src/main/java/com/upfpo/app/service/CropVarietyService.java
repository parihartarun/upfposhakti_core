package com.upfpo.app.service;

import java.util.HashMap;
import java.util.List;

import com.upfpo.app.dto.CropVerietyMasterDto;
import com.upfpo.app.entity.CropVerietyMaster;

public interface CropVarietyService 
{
	public List<CropVerietyMaster> getCropVarietiesOnCropId(int cropRefId);

	public List<CropVerietyMaster> getCropVarietiesByMultiCropId(String cropids);
}
