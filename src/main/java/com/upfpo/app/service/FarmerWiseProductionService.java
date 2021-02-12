package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.FarmerWiseProductionDTO;
import com.upfpo.app.requestStrings.ReportRequestString;

public interface FarmerWiseProductionService 
{
	public List<FarmerWiseProductionDTO> getReport(ReportRequestString reportRequestString);
}
