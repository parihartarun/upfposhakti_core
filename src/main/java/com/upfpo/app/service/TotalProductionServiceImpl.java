package com.upfpo.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.TotalProduction;
import com.upfpo.app.repository.TotalProductionRepository;

@Service
public class TotalProductionServiceImpl implements TotalProductionService{

	@Autowired
	TotalProductionRepository totalProductionRepository;
	
	
	@Transactional
	@Override
	public void saveTotalProduction(TotalProduction totProd) {
		
		totalProductionRepository.save(totProd);
	}

}
