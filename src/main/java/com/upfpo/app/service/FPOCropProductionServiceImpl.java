package com.upfpo.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.MarketableSurplus;
import com.upfpo.app.entity.TotalProduction;
import com.upfpo.app.repository.CropDetailsMasterRepository;
import com.upfpo.app.repository.FPOCropProductionReporisitory;
import com.upfpo.app.repository.TotalProductionRepository;

@Service
public class FPOCropProductionServiceImpl implements FPOCropProductionService {

	@Autowired
	private FPOCropProductionReporisitory fpoCropProductionRepo;
	
	@Autowired
	private TotalProductionRepository totalProductionRepository;
	
	@Autowired
	private CropDetailsMasterRepository cropDetailsMasterRepository;

	@Override
	public List<MarketableSurplus> getAllMarketableSurplus() {
		
		return fpoCropProductionRepo.findAll();
	}

	@Override
	@Transactional
	public void saveMarketableSurplus(MarketableSurplus marketableSurplus) 
	{
		TotalProduction totProd = new TotalProduction();
		totProd.setCropMaster(marketableSurplus.getCrop_id());
		totProd.setCropVerityMaster(marketableSurplus.getVerietyId());
		totProd.setFpoRegister(marketableSurplus.getMasterId());
		totProd.setTotalMarketable(marketableSurplus.getMarketableQuantity());
		totProd.setTotal_actual_prod(marketableSurplus.getActualQuantity());
		fpoCropProductionRepo.save(marketableSurplus);
		totalProductionRepository.save(totProd);
		
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
