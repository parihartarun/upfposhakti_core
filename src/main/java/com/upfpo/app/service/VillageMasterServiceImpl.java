package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.VillageMaster;
import com.upfpo.app.repository.VillageMasterRepository;

@Service
public class VillageMasterServiceImpl implements VillageMasterService
{
	@Autowired
	VillageMasterRepository villageRepository;
	
	@Override
	public List<VillageMaster> getVillages() 
	{
		List<VillageMaster> villagestList = new ArrayList<VillageMaster>();
		villageRepository.findAll().forEach(villagestList1->villagestList.add(villagestList1));
		return villagestList;
	}
	
	@Override
	public List<VillageMaster> getVillagesByPanchayat(int panchayatId) 
	{
		return villageRepository.getVillagesByPanchayat(panchayatId);
	}
	
	@Override
	public List<VillageMaster> getVillagesByBlockId(int blockId) 
	{
		return villageRepository.getVillagesByBlockId(blockId);
	}
}
