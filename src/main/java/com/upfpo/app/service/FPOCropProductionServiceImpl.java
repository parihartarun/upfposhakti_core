package com.upfpo.app.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public void saveMarketableSurplus(MarketableSurplus marketableSurplus) {
		 fpoCropProductionRepo.save(marketableSurplus);
		
	}

	@Override
	public MarketableSurplus updateMarketableSurplus(Integer id, MarketableSurplus marketableSurplus) {
		 Optional<MarketableSurplus> sd = fpoCropProductionRepo.findById(id);
	        if(!sd.isPresent()) {
	            return null;
	        }
	        marketableSurplus.setId(id);
	        return fpoCropProductionRepo.save(marketableSurplus);
	}

	@Override
	public void deleteMarketableSurplus(Integer id) {
		 fpoCropProductionRepo.findById(id)
                .map(marketableSurplus -> {
                	fpoCropProductionRepo.delete(marketableSurplus);
                    return "Delete Successfully!";
                });
    }
	
	
}
