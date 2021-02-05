package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.MarketableSurplus;

public interface FPOCropProductionService {

	List<MarketableSurplus> getAllMarketableSurplus();

	void saveMarketableSurplus(MarketableSurplus marketableSurplus);

	MarketableSurplus updateMarketableSurplus(Integer id, MarketableSurplus marketableSurplus);

	void deleteMarketableSurplus(Integer id);

}
