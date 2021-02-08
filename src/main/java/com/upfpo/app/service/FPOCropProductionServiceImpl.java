package com.upfpo.app.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.FpoCropProductionDetailsDTO;
import com.upfpo.app.entity.MarketableSurplus;
import com.upfpo.app.entity.TotalProduction;
import com.upfpo.app.repository.CropDetailsMasterRepository;
import com.upfpo.app.repository.FPOCropProductionReporisitory;
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

	@Override
	public List<FpoCropProductionDetailsDTO> getAllMarketableSurplus(int masterId) 
	{
			String  sql =  	" Select s.season_name, cc.category, cm.crop_name,m.id,m.marketable_quantity,m.actual_quantity,\r\n"
					+ "		m.financial_year, case when cast(m.veriety_id as integer)!=0 then cvm.crop_veriety else 'Other' end\r\n"
					+ "		crop_variety from marketable_surplus_new m\r\n"
					+ "		inner join season_master s on CAST ( m.season_id as integer)=s.season_id \r\n"
					+ "		inner join crop_master cm on cm.id= m.crop_id\r\n"
					+ "		inner join crop_category cc on cc.id= cm.crop_cat_ref_id \r\n"
					+ "		left join crop_veriety_master cvm on cvm.veriety_id=cast(m.veriety_id as integer) \r\n"
					+ "		where m.master_id = :masterId  and m.is_deleted = false order by m.id desc;" ;
			  
			  List<FpoCropProductionDetailsDTO> obj =  (List<FpoCropProductionDetailsDTO>) entityManager.createNativeQuery(sql,"FpoCropProductionDetailsDTO").setParameter("masterId", masterId).getResultList();
			  return obj;
			    
		//return fpoCropProductionRepo.findAll();
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
		
		marketableSurplus.setFinancialYear(GetFinYear.getCurrentFinYear());
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
