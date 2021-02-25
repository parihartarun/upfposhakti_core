package com.upfpo.app.util;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.TotalProductionDTO;
import com.upfpo.app.entity.TotalProduction;
import com.upfpo.app.repository.CropDetailsMasterRepository;
import com.upfpo.app.repository.CropDetailsRepository;
import com.upfpo.app.repository.CropVarietyRepository;
import com.upfpo.app.repository.FPOCropProductionReporisitory;
import com.upfpo.app.repository.ProductionDetailsRepository;
import com.upfpo.app.repository.TotalProductionRepository;
import com.upfpo.app.service.TotalProductionServiceImpl;

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
	
	@Autowired
	CropDetailsRepository cropDetailsRepository;
	
	String sql = "";
	
	public TotalProductionDTO getProductionDetailsofFarmer(int cropId, int cropVarietyId, int seasonId,String financialYear, int masterId)
	{
		sql = "select sum(c.actual_yield) as totalActualProdction,sum(c.marketable_quantity) as totalMarketableQty from crop_details c join new_sowing_info n on c.sowing_id = n.sowing_id\r\n"
				+ "			where c.crop_ref =:cropId and c.veriety_ref= :cropVarietyId and c.season_ref =:seasonId and n.fin_year =:financialYear and n.master_id =:masterId and c.is_deleted = false";
		
		TotalProductionDTO obj =  (TotalProductionDTO) entityManager.createNativeQuery(sql,"TotalProductionDTO").setParameter("cropId", cropId).setParameter("cropVarietyId",cropVarietyId).setParameter("seasonId", seasonId)
								.setParameter("financialYear", financialYear).setParameter("masterId", masterId).getSingleResult();
		 return obj;
	}
	
	public void updateTotalProductionChange(int cropId, int cropVarietyId, int seasonId,String financialYear, int masterId)
	{
		Double fpoActulaProduction 		= fPOCropProductionReporisitory.getActulaProduction(cropId, cropVarietyId, seasonId, masterId, financialYear);
		
		if(fpoActulaProduction == null)
		{
			fpoActulaProduction = 0.0;
		}
		System.out.println("cropId:"+cropId+"cropVarietyId:"+cropVarietyId+"seasonId:"+seasonId+"masterId:"+masterId+"financialYear:"+financialYear);
		
		TotalProductionDTO t	= getProductionDetailsofFarmer(cropId, cropVarietyId, seasonId, financialYear,masterId);
		
		Double farmerActualProduction = t.getTotalActualProdction();
		
		if(farmerActualProduction == null)
		{
			farmerActualProduction = 0.0;
		}
		
		Double totalActualProduction 	= fpoActulaProduction+farmerActualProduction;
		
		System.out.println("fpoActulaProduction:"+fpoActulaProduction+"farmerActualProduction:"+farmerActualProduction+"totalActualProduction"+totalActualProduction);
		
		Double fpoMarketableQty 		= fPOCropProductionReporisitory.getMarketableQty(cropId, cropVarietyId, seasonId, masterId, financialYear);
		
		if(fpoMarketableQty == null)
		{
			fpoMarketableQty = 0.0;
		}
		
		Double farmerMarketableQty		=  t.getTotalMarketableQty();
		
		if(farmerMarketableQty == null)
		{
			farmerMarketableQty = 0.0;
		}
		
		Double totalMarketableQty       = fpoMarketableQty+farmerMarketableQty;
		
		Double currentMarketableQty = totalProductionRepository.getCurrentMarketableQty(cropId, cropVarietyId, masterId, seasonId, financialYear);
		
		Double totalSold			= totalProductionRepository.getSoldQty(cropId, cropVarietyId, masterId, seasonId, financialYear);
		
		if(totalSold == null)
		{
			totalSold = 0.0;
		}
		
		if(currentMarketableQty == null)
		{
			currentMarketableQty = totalMarketableQty;
		}
		else
		{ 
			currentMarketableQty = totalMarketableQty - totalSold;
		}
		
		System.out.println("fpoMarketableQty:"+fpoMarketableQty+"farmerMarketableQty:"+farmerMarketableQty+"totalMarketableQty"+totalMarketableQty);
		
		int count = 0;
		
		try
		{
			if(fpoActulaProduction != null && farmerActualProduction != null && totalActualProduction != null && fpoMarketableQty != null && farmerMarketableQty != null && totalMarketableQty != null && currentMarketableQty != null)
			{
				count = totalProductionRepository.getCountTotalProductionCount(cropId, cropVarietyId, masterId, seasonId, financialYear);
				if(count != 0 && count > 0 )
				{
					totalProductionRepository.updateTotalProduction(totalActualProduction, totalMarketableQty, currentMarketableQty, cropId, cropVarietyId, masterId, seasonId, financialYear);
				}
				else
				{
					TotalProduction totalProduction = new TotalProduction();
					totalProduction.setCropMaster(cropDetailsMasterRepository.findById(cropId).get());
					totalProduction.setCropVerityMaster(cropVarietyRepository.findById(cropVarietyId).get());
					totalProduction.setSeasonId(seasonId);
					totalProduction.setFinYear(financialYear);
					totalProduction.setFpoRegister(masterId);
					totalProduction.setTotal_actual_prod(totalActualProduction);
					totalProduction.setTotalMarketable(totalMarketableQty);
					totalProduction.setCurrentMarketable(currentMarketableQty);
					totalProductionRepository.save(totalProduction);
				}
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
	
	public void updateTotalProductionForSalesDetails(double soldQty, int cropId, int cropVarietyId, int seasonId,String financialYear, int masterId, boolean status)
	{
		Double totalMarketableQty = totalProductionRepository.getTotalMarketableQty(cropId, cropVarietyId, masterId, seasonId, financialYear);
		
		if(totalMarketableQty == null)
		{
			totalMarketableQty = 0.0;
		}
		
		Double updatedMarketableQty = 0.0;
		if(status == false)
		{
			updatedMarketableQty = totalMarketableQty - soldQty;
		}
		else
		{
			updatedMarketableQty = totalMarketableQty + soldQty;
		}
		
		int count = 0;
		
		try
		{
			if(totalMarketableQty != null && updatedMarketableQty != null)
			{
				count = totalProductionRepository.getCountTotalProductionCount(cropId, cropVarietyId, masterId, seasonId, financialYear);
				if(count != 0 && count > 0 )
				{
					totalProductionRepository.updateMarketable(soldQty, updatedMarketableQty, cropId, cropVarietyId, masterId,seasonId, financialYear);
				}
				else
				{
					throw new Exception("No record is available");
				}
			}
			else
			{
				
			}
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
		}
	}
	
}
