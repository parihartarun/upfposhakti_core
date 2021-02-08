package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.SeasonMaster;
import com.upfpo.app.repository.SeasonMasterRepository;

@Service
public class SeasonMasterServiceImpl implements SeasonMasterService
{
	@Autowired
	SeasonMasterRepository seasonMasterRepository; 
	
	@Override
	public List<SeasonMaster> getSeasons() 
	{
		List<SeasonMaster> seasonList = new ArrayList<SeasonMaster>();
		seasonMasterRepository.findAll().forEach(seasonList1->seasonList.add(seasonList1));
		return seasonList;
	}	
}
