package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.MarketableSurplus;
import com.upfpo.app.repository.FPOCropProductionReporisitory;

@Service
public class FPOCropProductionServiceImpl implements FPOCropProductionService {

	@Autowired
	private FPOCropProductionReporisitory fpoCropProductionRepo;

	@Override
	public List<MarketableSurplus> getAllMarketableSurplus() {
		
		return fpoCropProductionRepo.findAll();
	}
	
	
}
