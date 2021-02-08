package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.CropMaster;
import com.upfpo.app.entity.CropVerietyMaster;
import com.upfpo.app.repository.CropDetailsMasterRepository;
import com.upfpo.app.repository.CropVarietyRepository;

@Service
public class CropVarietyServiceImpl implements CropVarietyService
{
	@Autowired 
	CropVarietyRepository cropVarietyRepository;
	
	@Autowired 
	CropDetailsMasterRepository cropMasterRepository;	
	@Override
	public List<CropVerietyMaster> getCropVarietiesOnCropId(int cropRefId) 
	{
		
		CropMaster cropmster =cropMasterRepository.findById(cropRefId).orElseThrow(NotFoundException::new); 
		return cropVarietyRepository.findByCrop(cropmster);
	}
}
