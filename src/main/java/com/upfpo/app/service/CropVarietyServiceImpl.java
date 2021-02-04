package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.CropVerietyMaster;
import com.upfpo.app.repository.CropVarietyRepository;

@Service
public class CropVarietyServiceImpl implements CropVarietyService
{
	@Autowired 
	CropVarietyRepository cropVarietyRepository;
	
	@Override
	public List<CropVerietyMaster> getCropVarietiesOnCropId(int cropRefId) 
	{
		return cropVarietyRepository.findByCropRefId(cropRefId);
	}
}
