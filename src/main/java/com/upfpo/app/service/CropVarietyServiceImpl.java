package com.upfpo.app.service;

import java.sql.Array;
import java.util.HashMap;
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
	
	@Override
	public HashMap<Integer, List<CropVerietyMaster>> getCropVarietiesByMultiCropId(String cropRefId) {
		HashMap<Integer, List<CropVerietyMaster> >  cropVerMster1 = new HashMap<Integer, List<CropVerietyMaster>>();
		String[] aa = cropRefId.split(",");
		for(int i=0; i<aa.length; i++) {
			System.err.println("@@@@@ == "+aa.length);
			 List<CropVerietyMaster>  cropVerMster = null;
			 Integer cropId = Integer.parseInt(aa[i]);
			 System.err.println("cropId == "+cropId);
			CropMaster cropmster =cropMasterRepository.findById(cropId).orElseThrow(NotFoundException::new); 
			cropVerMster = cropVarietyRepository.findByCrop(cropmster);
			cropVerMster1.put(i,cropVerMster);
		}
		return cropVerMster1;
	}
}
