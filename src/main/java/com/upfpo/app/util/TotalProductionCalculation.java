package com.upfpo.app.util;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.TotalProductionDTO;
import com.upfpo.app.entity.TotalProduction;
import com.upfpo.app.repository.CropDetailsMasterRepository;
import com.upfpo.app.repository.CropVarietyRepository;
import com.upfpo.app.repository.FPOCropProductionReporisitory;
import com.upfpo.app.repository.ProductionDetailsRepository;
import com.upfpo.app.repository.TotalProductionRepository;

@Service
public class TotalProductionCalculation 
{
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	TotalProductionRepository totalProductionRepository;
	
	@Autowired
	FPOCropProductionReporisitory fPOCropProductionReporisitory;
	
	@Autowired
	ProductionDetailsRepository productionDetailsRepository; 
	
	@Autowired
	CropDetailsMasterRepository cropDetailsMasterRepository;
	
	@Autowired
	CropVarietyRepository cropVarietyRepository;
	
	String sql = "";
	
	public TotalProductionDTO getActualProduction(int cropId, int cropVarietyId, int seasonId,String financialYear, int masterId)
	{
		sql = " Select sum(f.actual_quantity+p.actual_production) as totalActualProdction,sum(f.marketable_quantity+p.marketable_surplus) as totalMarketableQty from marketable_surplus_new f join production_details p on f.master_id = p.master_id \r\n"
				+ "and  f.crop_id=p.crop_id and f.veriety_id = p.veriety_id\r\n"
				+ "and  f.season_id = p.season_id and f.financial_year = p.financial_year\r\n"
				+ "and f.master_id = :masterId\r\n"
				+ "and f.crop_id = :cropId\r\n"
				+ "and f.veriety_id = :cropVarietyId,\r\n"
				+ "and f.season_id = :seasonId\r\n";
				//+ "and f.financial_year=:'financialYear'";
		
		TotalProductionDTO obj =  (TotalProductionDTO) entityManager.createNativeQuery(sql,"TotalProductionDTO").setParameter("masterId", masterId).setParameter("cropId",cropId).setParameter("cropVarietyId", cropVarietyId)
						.setParameter("seasonId",seasonId ).
						//setParameter("financialYear", financialYear). 
						getSingleResult();
		 return obj;
	}
	
	public void updateTotalProduction(int cropId, int cropVarietyId, int seasonId,String financialYear, int masterId)
	{
		double fpoActulaProduction 		= fPOCropProductionReporisitory.getActulaProduction(cropId, cropVarietyId, seasonId, masterId);
		double farmerActualProduction	= productionDetailsRepository.getActualProductionbyFarmer(cropId, cropVarietyId, seasonId, masterId);
		
		double totalActualProduction 	= fpoActulaProduction+farmerActualProduction;
		
		double fpoMarketableQty 		= fPOCropProductionReporisitory.getMarketableQty(cropId, cropVarietyId, seasonId, masterId);
		double farmerMarketableQty		= productionDetailsRepository.getMarketableQty(cropId, cropVarietyId, seasonId, masterId);
		
		double totalMarketableQty       = fpoMarketableQty+farmerMarketableQty;
		
		int count = 0;
		
		try
		{
			count = totalProductionRepository.getCountTotalProductionCount(cropId, cropVarietyId, masterId);
			if(count != 0 && count > 0 )
			{
				totalProductionRepository.updateTotalProduction(totalActualProduction, totalMarketableQty, cropId, cropVarietyId, masterId);
			}
			else
			{
				TotalProduction totalProduction = new TotalProduction();
				totalProduction.setCropMaster(cropDetailsMasterRepository.findById(cropId).get());
				totalProduction.setCropVerityMaster(cropVarietyRepository.findById(cropVarietyId).get());
				totalProduction.setFpoRegister(masterId);
				totalProduction.setTotal_actual_prod(totalActualProduction);
				totalProduction.setTotalMarketable(totalMarketableQty);
				totalProductionRepository.save(totalProduction);
			}
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
		}
	}
	
	public void updateTotalProductionForSalesDetails(double soldQty, int cropId, int cropVarietyId, int seasonId,String financialYear, int masterId)
	{
		double totalMarketableQty = totalProductionRepository.getTotalMarketableQty(cropId, cropVarietyId, masterId);
		
		double updatedMarketableQty = totalMarketableQty - soldQty;
		
		int count = 0;
		
		try
		{
			count = totalProductionRepository.getCountTotalProductionCount(cropId, cropVarietyId, masterId);
			if(count != 0 && count > 0 )
			{
				totalProductionRepository.updateMarketable(soldQty, updatedMarketableQty, cropId, cropVarietyId, masterId);
			}
			else
			{
				throw new Exception("No record is available");
			}
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
		}
	}
	
}
