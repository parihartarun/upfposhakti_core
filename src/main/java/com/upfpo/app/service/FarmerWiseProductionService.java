package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.FarmerWiseProductionDTO;

public interface FarmerWiseProductionService 
{
	public List<FarmerWiseProductionDTO> getReport(Integer fpoId, String finYear, Integer seasonId);
}
