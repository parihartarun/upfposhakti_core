package com.upfpo.app.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.dto.FpoCropProductionDetailsDTO;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.LandDetails;
import com.upfpo.app.entity.MarketableSurplus;
import com.upfpo.app.entity.TotalProduction;
import com.upfpo.app.repository.CropDetailsMasterRepository;
import com.upfpo.app.repository.FPOCropProductionReporisitory;
import com.upfpo.app.repository.ProductionDetailsRepository;
import com.upfpo.app.repository.TotalProductionRepository;
import com.upfpo.app.util.GetCurrentDate;
import com.upfpo.app.util.GetFinYear;
import com.upfpo.app.util.TotalProductionCalculation;

@Service
public class FPOCropProductionServiceImpl implements FPOCropProductionService {

	@Autowired
	private  EntityManager entityManager;
	
	@Autowired
	private FPOCropProductionReporisitory fpoCropProductionRepo;
	
	@Autowired
	private TotalProductionRepository totalProductionRepository;
	
	@Autowired
	TotalProductionCalculation totalProductionCalculation;
	
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
		String financialYear = GetFinYear.getCurrentFinYear();
		marketableSurplus.setFinancialYear(financialYear);
		marketableSurplus.setDeleted(false);
		fpoCropProductionRepo.save(marketableSurplus);
		totalProductionCalculation.updateTotalProduction(marketableSurplus.getCrop_id(), marketableSurplus.getVerietyId(), marketableSurplus.getSeason(), financialYear, marketableSurplus.getMasterId());
	}

	@Override
	public MarketableSurplus updateMarketableSurplus(Integer id, MarketableSurplus marketableSurplusMaster) 
	{
		Optional<MarketableSurplus> marketableSurplus = fpoCropProductionRepo.findById(id);
		String financialYear = GetFinYear.getCurrentFinYear();
		MarketableSurplus newMarketableSurplus = null;
		try
		{
			if(marketableSurplus.isPresent())
			{
				newMarketableSurplus = fpoCropProductionRepo.findById(id).get();
				newMarketableSurplus.setActualQuantity(marketableSurplusMaster.getActualQuantity());
				newMarketableSurplus.setCrop_id(marketableSurplusMaster.getCrop_id());
				newMarketableSurplus.setVerietyId(marketableSurplusMaster.getVerietyId());
				newMarketableSurplus.setMarketableQuantity(marketableSurplusMaster.getMarketableQuantity());
				newMarketableSurplus.setSeason(marketableSurplusMaster.getSeason());
				newMarketableSurplus.setFinancialYear(financialYear);
				
				newMarketableSurplus = fpoCropProductionRepo.save(newMarketableSurplus);
			}
			else
			{
				newMarketableSurplus = fpoCropProductionRepo.save(marketableSurplusMaster);
			}
			totalProductionCalculation.updateTotalProduction(marketableSurplusMaster.getCrop_id(), marketableSurplusMaster.getVerietyId(), marketableSurplusMaster.getSeason(), financialYear, marketableSurplusMaster.getMasterId());
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
		}
		return newMarketableSurplus;
	}

	@Override
	public Boolean deleteMarketableSurplus(Integer id) 
	{
		try {
		MarketableSurplus marketableSurplus = fpoCropProductionRepo.findById(id).get();
		marketableSurplus.setDeleted(true);
		fpoCropProductionRepo.save(marketableSurplus);

		}catch(Exception e)
		{
			e.printStackTrace();
			throw new NotFoundException();
		}
		return true;
    }
	
	
}
;