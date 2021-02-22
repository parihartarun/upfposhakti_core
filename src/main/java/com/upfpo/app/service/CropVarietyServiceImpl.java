package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

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
	EntityManager entityManager;
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
	public List<CropVerietyMaster> getCropVarietiesByMultiCropId(String cropRefId) {
		List<CropVerietyMaster> CombineCropVerMster = new ArrayList<CropVerietyMaster>();
		String[] aa = cropRefId.split(",");
		for(int i=0; i<aa.length; i++) {
			System.err.println("@@@@@ == "+aa.length);
			 List<CropVerietyMaster>  cropVerMster = null;
			 Integer cropId = Integer.parseInt(aa[i]);
			 System.err.println("cropId == "+cropId);
			CropMaster cropmster =cropMasterRepository.findById(cropId).orElseThrow(NotFoundException::new); 
			cropVerMster = cropVarietyRepository.findByCrop(cropmster);
			for(CropVerietyMaster cc: cropVerMster) {
				CombineCropVerMster.add(cc);
			}
		}
		return CombineCropVerMster;
	}

//	private List<CropVerietyMasterDto> findByCropVerityByCropId(String searchtext,Integer cropId) {
//		String sql = "SELECT cv.veriety_id as verietyId,cv.crop_veriety as verityName FROM crop_veriety_master cv WHERE cv.crop_master_ref_id="+cropId
//				+ " and cv.crop_veriety LIKE '%"+searchtext+"%' or\r\n"
//				+ "cv.crop_veriety LIKE '"+searchtext+"%' or \r\n"
//				+ "cv.crop_veriety LIKE '%"+searchtext+"'";
//		List<CropVerietyMasterDto> obj = entityManager.createNativeQuery(sql,"CropVerietyMasterDto").getResultList();
//		return obj;
//	}
}
