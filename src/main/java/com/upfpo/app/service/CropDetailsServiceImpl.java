package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.CropMaster;
import com.upfpo.app.entity.DistrictMaster;
import com.upfpo.app.repository.CropDetailsMasterRepository;

@Service
public class CropDetailsServiceImpl implements CropDetailsService
{
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
}
