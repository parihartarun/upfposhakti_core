package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.Panchayats;
import com.upfpo.app.repository.PanchayatsRepository;

@Service
public class PanchayatMasterServiceImpl implements PanchayatMasterService
{
	@Autowired
	PanchayatsRepository panchayatRepository;
	
	@Override
	public List<Panchayats> getPanchayats() 
	{
		List<Panchayats> panchayatList = new ArrayList<Panchayats>();
		panchayatRepository.findAll().forEach(panchayatList1->panchayatList.add(panchayatList1));
		return panchayatList;
	}
}
