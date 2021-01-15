package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.DistrictMaster;
import com.upfpo.app.repository.DistrictMasterRepository;

@Service
public class DistrictServiceImpl implements DistrictService
{
	@Autowired
	DistrictMasterRepository districtRepository;
	
	@Override
	public List<DistrictMaster> getDistricts() 
	{
		List<DistrictMaster> districtList = new ArrayList<DistrictMaster>();
		districtRepository.findAll().forEach(districtList1->districtList.add(districtList1));
		return districtList;    
	}
	
	@Override
	public DistrictMaster getDistrictsById(int distId) 
	{
		return districtRepository.findById(distId).get();
	}
	
	
}
