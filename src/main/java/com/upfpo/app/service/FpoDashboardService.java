package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.FpoFarmerDashboardDTO;

public interface FpoDashboardService 
{
	public FpoFarmerDashboardDTO totalFpoFarmer(Integer fpoId);
	
	public List<String> getFinYearFromTotProd();
}
