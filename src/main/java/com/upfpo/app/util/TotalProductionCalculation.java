package com.upfpo.app.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.TotalProductionDTO;
import com.upfpo.app.repository.FPOCropProductionReporisitory;
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
	
	/*
	 * public void updateTotalProduction(TotalProductionDTO totalProduction); {
	 * totalProductionRepository. }
	 */
	
	
	public void updateTotalProduction(int cropId, int cropVarietyId, int seasonId,String financialYear, int masterId)
	{
		double fpoActulaProduction = 
	}
}
