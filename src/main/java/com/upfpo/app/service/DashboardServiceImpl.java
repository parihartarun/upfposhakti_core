package com.upfpo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.DashBoardData;
import com.upfpo.app.repository.DashBoardRepository;

@Service
public class DashboardServiceImpl implements DashboardService {
	@Autowired 
	private DashBoardRepository dashBoardRepository;

	@Override
	public DashBoardData getDbd() {
		// TODO Auto-generated method stub
		return dashBoardRepository.getFarmCropDetailsForDepatment();
	}

	
	
}
