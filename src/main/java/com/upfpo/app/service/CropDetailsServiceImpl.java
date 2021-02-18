package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.CropMasterDto;
import com.upfpo.app.entity.CropMaster;
import com.upfpo.app.repository.CropDetailsMasterRepository;

@Service
public class CropDetailsServiceImpl implements CropDetailsService
{
	@Autowired
	EntityManager entityManager;
	@Autowired
	CropDetailsMasterRepository cropDetailsMasterRepository;
	
	@Override
	public List<CropMaster> getCropDetails() 
	{
		List<CropMaster> cropList = new ArrayList<CropMaster>();
		cropDetailsMasterRepository.findAll().forEach(cropList1->cropList.add(cropList1));
		return cropList;
	}

	@Override
	public List<CropMaster> getCropsBySeasonId(Integer seasonId) {
		List<CropMaster> cropList = new ArrayList<CropMaster>();
		cropList = cropDetailsMasterRepository.getDistrictsByStateId(seasonId);
		return cropList;
	}

	@Override
	public List<CropMasterDto> getCropsBySearchText(String searchtext) {
		List<CropMasterDto> cropList = new ArrayList<CropMasterDto>();
		cropList = getCropsBySearch(searchtext);
		return cropList;
	}

	private List<CropMasterDto> getCropsBySearch(String searchtext) {
		String sql = "SELECT cm.id as cropId,cm.crop_name as cropName,cm.season_ref_id as seasonRefId,cm.is_active as isActive FROM crop_master cm WHERE cm.crop_name LIKE '%"+searchtext+"%' or\r\n"
				+ "cm.crop_name LIKE '"+searchtext+"%' or \r\n"
				+ "cm.crop_name LIKE '%"+searchtext+"'";
		List<CropMasterDto> obj = entityManager.createNativeQuery(sql,"CropMasterDto").getResultList();
		return obj;
		
	}
}
