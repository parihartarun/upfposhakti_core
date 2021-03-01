package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.FpoFarmerDashboardDTO;
import com.upfpo.app.requestStrings.ReportRequestString;

public interface FpoDashboardService 
{
	public FpoFarmerDashboardDTO totalFpoFarmer(ReportRequestString reportRequestString);
	
	
	public List<String> getFinYearFromTotProd();
}
