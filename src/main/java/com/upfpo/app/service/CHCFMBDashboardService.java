package com.upfpo.app.service;

import com.upfpo.app.dto.CHCFMBDashboardBarchartDTO;
import com.upfpo.app.dto.CHCFMBDashboardIndentDTO;

public interface CHCFMBDashboardService 
{
	public CHCFMBDashboardBarchartDTO getBarchartData(Integer masterId);
	
	public CHCFMBDashboardIndentDTO getIndentData(Integer masterId);
}
