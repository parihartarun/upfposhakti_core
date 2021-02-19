package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.SeasonMaster;
import com.upfpo.app.entity.SeedMaster;
import com.upfpo.app.repository.SeedMasterRepository;

@Service
public class SeedMasterServiceImpl implements SeedMasterService
{
	@Autowired
	SeedMasterRepository seedMasterRepository; 
	
	@Override
	public List<SeedMaster> getSeeds() 
	{
		List<SeedMaster> seedList = new ArrayList<SeedMaster>();
		seedMasterRepository.findAll().forEach(seedList1->seedList.add(seedList1));
		return seedList;
	}	
}
