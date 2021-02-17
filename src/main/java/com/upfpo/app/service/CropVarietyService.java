package com.upfpo.app.service;

import java.util.HashMap;
import java.util.List;

import com.upfpo.app.entity.CropVerietyMaster;

public interface CropVarietyService 
{
	public List<CropVerietyMaster> getCropVarietiesOnCropId(int cropRefId);

	public HashMap<Integer, List<CropVerietyMaster>> getCropVarietiesByMultiCropId(String cropRefId);
}
