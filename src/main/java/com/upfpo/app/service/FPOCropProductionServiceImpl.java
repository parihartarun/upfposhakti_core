package com.upfpo.app.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.FpoCropProductionDetailsDTO;
import com.upfpo.app.entity.LandDetails;
import com.upfpo.app.entity.MarketableSurplus;
import com.upfpo.app.entity.TotalProduction;
import com.upfpo.app.repository.CropDetailsMasterRepository;
import com.upfpo.app.repository.FPOCropProductionReporisitory;
import com.upfpo.app.repository.ProductionDetailsRepository;
import com.upfpo.app.repository.TotalProductionRepository;
import com.upfpo.app.util.GetFinYear;

@Service
public class FPOCropProductionServiceImpl implements FPOCropProductionService {

	@Autowired
	private  EntityManager entityManager;
	
	@Autowired
	private FPOCropProductionReporisitory fpoCropProductionRepo;
	
	@Autowired
	private TotalProductionRepository totalProductionRepository;
	
	@Autowired
	private CropDetailsMasterRepository cropDetailsMasterRepository;
	
	@Autowired
	private ProductionDetailsRepository productionDetailsRepository;

	@Override
	public List<FpoCropProductionDetailsDTO> getAllMarketableSurplus(int masterId) 
	{
			String  sql =  	" Select s.season_id,s.season_name, cc.id as category_id, cc.category, cm.id as crop_id ,cm.crop_name, m.id as marketable_id,m.marketable_quantity,m.actual_quantity,\r\n"
					+ "			m.financial_year,cvm.veriety_id, case when cast(m.veriety_id as integer)!=0 then cvm.crop_veriety else 'Other' end\r\n"
					+ "			crop_variety from marketable_surplus_new m\r\n"
					+ "			inner join season_master s on CAST ( m.season_id as integer)=s.season_id \r\n"
					+ "			inner join crop_master cm on cm.id= m.crop_id\r\n"
					+ "			inner join crop_category cc on cc.id= cm.crop_cat_ref_id \r\n"
					+ "			left join crop_veriety_master cvm on cvm.veriety_id=cast(m.veriety_id as integer) \r\n"
					+ "			where m.master_id = :masterId  and m.is_deleted = false order by m.id desc" ;

			  
			  List<FpoCropProductionDetailsDTO> obj =  (List<FpoCropProductionDetailsDTO>) entityManager.createNativeQuery(sql,"FpoCropProductionDetailsDTO").setParameter("masterId", masterId).getResultList();
			  return obj;
			    
		//return fpoCropProductionRepo.findAll();
	}

	@Override
	@Transactional
	public void saveMarketableSurplus(MarketableSurplus marketableSurplus) 
	{
		fpoCropProductionRepo.save(marketableSurplus);
		TotalProduction totProd = new TotalProduction();
		totProd.setCropMaster(marketableSurplus.getCrop_id());
		totProd.setCropVerityMaster(marketableSurplus.getVerietyId());
		totProd.setFpoRegister(marketableSurplus.getMasterId());
		totProd.setTotalMarketable(marketableSurplus.getMarketableQuantity());
		totProd.setTotal_actual_prod(marketableSurplus.getActualQuantity());
		totProd.setMarketableSurplusId(marketableSurplus.getId());	
		marketableSurplus.setFinancialYear(GetFinYear.getCurrentFinYear());
		totalProductionRepository.save(totProd);
		
	}

	@Override
	public MarketableSurplus updateMarketableSurplus(Integer id, MarketableSurplus marketableSurplusMaster) 
	{
		TotalProduction totalProduction = totalProductionRepository.findByMarketableSurplusId(id).get();
		Integer farmerid = totalProduction.getFarmerMaster().getFarmerId();
		String crop_id = Integer.toString(marketableSurplusMaster.getCrop_id().getCropId());
		String variety_id = Integer.toString(marketableSurplusMaster.getVerietyId().getVerietyId());
		String financialYear = GetFinYear.getCurrentFinYear();
		String seasonId = Integer.toString(marketableSurplusMaster.getSeason());
		
		double updatedActualProduction = marketableSurplusMaster.getActualQuantity();
		double actualProductionByfarmer = 0.0;
		double totalProductionVal = 0.0;
		if(farmerid != null|| farmerid != 0)
		{
			actualProductionByfarmer = productionDetailsRepository.getActualProduction(farmerid,crop_id,variety_id,financialYear,seasonId);
			totalProductionVal = actualProductionByfarmer+updatedActualProduction;	
		}
		else
		{
			totalProductionVal = updatedActualProduction;
		}
		
		Optional<TotalProduction> totalProductionDetails = totalProductionRepository.findByMarketableSurplusId(id);
		Optional<MarketableSurplus> marketableSurplus = fpoCropProductionRepo.findById(id);
		MarketableSurplus newMarketableSurplus = null;
		if(marketableSurplus.isPresent())
		{
			newMarketableSurplus = fpoCropProductionRepo.findById(id).get();
			newMarketableSurplus.setActualQuantity(marketableSurplusMaster.getActualQuantity());
			newMarketableSurplus.setCrop_id(marketableSurplusMaster.getCrop_id());
			newMarketableSurplus.setVerietyId(marketableSurplusMaster.getVerietyId());
			newMarketableSurplus.setMarketableQuantity(marketableSurplusMaster.getMarketableQuantity());
			newMarketableSurplus.setSeason(marketableSurplusMaster.getSeason());
			
			newMarketableSurplus = fpoCropProductionRepo.save(newMarketableSurplus);
			//return newMarketableSurplus;
		}
		else
		{
			newMarketableSurplus = fpoCropProductionRepo.save(marketableSurplusMaster);
		}
		if(totalProductionDetails.isPresent())
		{
			TotalProduction newTotalProduction = totalProductionRepository.findByMarketableSurplusId(id).get();
			newTotalProduction.setTotal_actual_prod(totalProductionVal);
			newTotalProduction.setCropMaster(marketableSurplusMaster.getCrop_id());
			newTotalProduction.setCropVerityMaster(marketableSurplusMaster.getVerietyId());
			newTotalProduction.setTotalMarketable(marketableSurplusMaster.getMarketableQuantity());
			newTotalProduction.setFpoRegister(marketableSurplusMaster.getMasterId());
			
			newTotalProduction = totalProductionRepository.save(newTotalProduction);
		}
		else
		{
			totalProduction = totalProductionRepository.save(totalProduction);
		}
		
		return newMarketableSurplus;
		
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
;