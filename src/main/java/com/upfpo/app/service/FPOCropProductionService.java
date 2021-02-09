package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.FpoCropProductionDetailsDTO;
import com.upfpo.app.dto.TotalProductionDTO;
import com.upfpo.app.entity.MarketableSurplus;

public interface FPOCropProductionService {

	List<FpoCropProductionDetailsDTO> getAllMarketableSurplus(int masterId);

	void saveMarketableSurplus(MarketableSurplus marketableSurplus);

	MarketableSurplus updateMarketableSurplus(Integer id, MarketableSurplus marketableSurplus);

	Boolean deleteMarketableSurplus(Integer id);
	
}
