package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.ChcFmbMaster;
import com.upfpo.app.repository.ChcFmbMasterRepository;

@Service
public class ChcFmbServiceImpl implements ChcFmbService
{
	@Autowired
	ChcFmbMasterRepository chcFmbRepository;
	
	@Override
	public ChcFmbMaster updateChcFmb(ChcFmbMaster chcFmbMaster, int chcFmbId)
	{
		Optional<ChcFmbMaster> chcFmb = chcFmbRepository.findById(chcFmbId);
		if(chcFmb.isPresent())
		{
			ChcFmbMaster newchcFmb = chcFmb.get();
			newchcFmb.setChcFmbName(chcFmbMaster.getChcFmbName());
			newchcFmb.setDistRefId(chcFmbMaster.getDistRefId());
			newchcFmb.setVillageRefId(chcFmbMaster.getVillageRefId());
			newchcFmb.setBlockRefId(chcFmbMaster.getBlockRefId());
			newchcFmb.setPincode(chcFmbMaster.getPincode());
			newchcFmb.setAllotmentNo(chcFmbMaster.getAllotmentNo());
			newchcFmb.setFirmRegistraionNumber(chcFmbMaster.getFirmRegistraionNumber());
			newchcFmb.setShopEstablishmentNumber(chcFmbMaster.getShopEstablishmentNumber());
			newchcFmb.setMobileNumber(chcFmbMaster.getMobileNumber());
			newchcFmb.setEmail(chcFmbMaster.getEmail());
			
			newchcFmb = chcFmbRepository.save(newchcFmb);
			return newchcFmb;
		}
		else
		{
			chcFmbMaster = chcFmbRepository.save(chcFmbMaster);
			return chcFmbMaster;
		}
	}
	
	@Override
	public void deleteChcFmbMaster(int chcFmbId) 
	{ 
		chcFmbRepository.deleteChcFmb(chcFmbId);
	}
	
	@Override
	public List<ChcFmbMaster> getChcFmbMaster() 
	{
		List<ChcFmbMaster> chcFmbList = new ArrayList<ChcFmbMaster>();
		chcFmbRepository.findAll().forEach(chcFmbList1->chcFmbList.add(chcFmbList1));
		return chcFmbList;
	}
}
