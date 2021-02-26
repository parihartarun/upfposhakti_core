package com.upfpo.app.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.FpoActProdKharifDTO;
import com.upfpo.app.dto.FpoActProdRabiDTO;
import com.upfpo.app.dto.FpoActProdZayadDTO;
import com.upfpo.app.dto.FpoActualProdDashboardDTO;
import com.upfpo.app.dto.FpoFarmerDashboardDTO;
import com.upfpo.app.dto.FpoMarkeProdDashboardDTO;
import com.upfpo.app.dto.FpoTotMarKharifDTO;
import com.upfpo.app.dto.FpoTotMarRabiDTO;
import com.upfpo.app.dto.FpoTotMarZayadDTO;
import com.upfpo.app.dto.FpoTotSoldKharifDTO;
import com.upfpo.app.dto.FpoTotSoldProductionDTO;
import com.upfpo.app.dto.FpoTotSoldRabiDTO;
import com.upfpo.app.dto.FpoTotSoldZayadDTO;
import com.upfpo.app.repository.FarmerMasterRepository;
import com.upfpo.app.repository.LandDetailsRepo;
import com.upfpo.app.repository.TotalProductionRepository;

@Service
public class FpoDashboardServiceImpl implements FpoDashboardService
{
	@Autowired
	FarmerMasterRepository farmerMasterRepository;
	
	@Autowired
	LandDetailsRepo landDetailsRepo; 
	
	@Autowired
	TotalProductionRepository totalProductionRepository;
	
	@Autowired
	EntityManager entityManager;
	
	String sql = "";
	
	public FpoFarmerDashboardDTO totalFpoFarmer(Integer fpoId)
	{
		Integer totalFpoFarmer 		=	farmerMasterRepository.getFpoFarmer(fpoId);
		Double totalMarginalFarmer 	=	(totalFpoFarmer * 0.8);
		Double totalSmallFarmer		=	(totalFpoFarmer * 0.13);
		Double totalOtherFarmer		=	(totalFpoFarmer * 0.07);
		
		Double landArea 			=	landDetailsRepo.getTotalFpoLand(fpoId);
		
		Integer crops				=	totalProductionRepository.getCountCrops(fpoId);
		
		FpoActualProdDashboardDTO actProd = new FpoActualProdDashboardDTO();
		actProd.setFpoActProdKharif(getFpoActualCropProductionKharif(fpoId));
		actProd.setFpoActProdRabi(getFpoActualCropProductionRabi(fpoId));
		actProd.setFpoActProdZayad(getFpoActualCropProductionZayad(fpoId));
		
		FpoMarkeProdDashboardDTO mrkProd = new FpoMarkeProdDashboardDTO();
		mrkProd.setFpoTotMarKharif(getFpoMarketableCropProductionKharif(fpoId));
		mrkProd.setFpoTotMarRabi(getFpoMarketableCropProductionRabi(fpoId));
		mrkProd.setFpoTotMarZayad(getFpoMarketableCropProductionZayad(fpoId));
		
		FpoTotSoldProductionDTO totSold = new FpoTotSoldProductionDTO();
		totSold.setFpoTotSoldKharif(getFpoSoldCropProductionKharif(fpoId));
		totSold.setFpoTotSoldRabi(getFpoSoldCropProductionRabi(fpoId));
		totSold.setFpoTotSoldZayad(getFpoSoldCropProductionZayad(fpoId));
		
		FpoFarmerDashboardDTO fpoFarmerDashboardDTO = new FpoFarmerDashboardDTO();
		fpoFarmerDashboardDTO.setTotalFpoFarmer(totalFpoFarmer);
		fpoFarmerDashboardDTO.setTotalMarginalFarmer(totalMarginalFarmer);
		fpoFarmerDashboardDTO.setTotalSmallFarmer(totalSmallFarmer);
		fpoFarmerDashboardDTO.setTotalOtherFarmer(totalOtherFarmer);
		fpoFarmerDashboardDTO.setLandArea(landArea);
		fpoFarmerDashboardDTO.setCrops(crops);
		fpoFarmerDashboardDTO.setFpoActualProduction(actProd);
		fpoFarmerDashboardDTO.setFpoMarketableProduction(mrkProd);
		fpoFarmerDashboardDTO.setFpoTotSoldProduction(totSold);
		return fpoFarmerDashboardDTO;
	}
	
	public List<FpoActProdRabiDTO> getFpoActualCropProductionRabi(Integer fpoId)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_actual_prod) as totAcProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.fpo_id = :fpoId and c.season_id = 1 group by c.crop_id, d.crop_name, seasonId order by totAcProd desc ";
		List<FpoActProdRabiDTO> obj =  (List<FpoActProdRabiDTO>) entityManager.createNativeQuery(sql,"FpoActProdRabiDTO").setParameter("fpoId", fpoId).getResultList();
		return obj;
	}
	
	public List<FpoActProdZayadDTO> getFpoActualCropProductionZayad(Integer fpoId)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_actual_prod) as totAcProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.fpo_id = :fpoId and c.season_id = 3 group by c.crop_id, d.crop_name, seasonId order by totAcProd desc ";
		List<FpoActProdZayadDTO> obj =  (List<FpoActProdZayadDTO>) entityManager.createNativeQuery(sql,"FpoActProdZayadDTO").setParameter("fpoId", fpoId).getResultList();
		return obj;
	}
	
	public List<FpoActProdKharifDTO> getFpoActualCropProductionKharif(Integer fpoId)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_actual_prod) as totAcProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.fpo_id = :fpoId and c.season_id = 2 group by c.crop_id, d.crop_name, seasonId order by totAcProd desc ";
		List<FpoActProdKharifDTO> obj =  (List<FpoActProdKharifDTO>) entityManager.createNativeQuery(sql,"FpoActProdKharifDTO").setParameter("fpoId", fpoId).getResultList();
		return obj;
	}
	
	public List<FpoTotMarRabiDTO> getFpoMarketableCropProductionRabi(Integer fpoId)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_marketable) as totMarkProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.fpo_id = :fpoId and c.season_id = 1 group by c.crop_id, d.crop_name, seasonId  order by totMarkProd desc";
		List<FpoTotMarRabiDTO> obj =  (List<FpoTotMarRabiDTO>) entityManager.createNativeQuery(sql,"FpoTotMarRabiDTO").setParameter("fpoId", fpoId).getResultList();
		return obj;
	}
	
	public List<FpoTotMarZayadDTO> getFpoMarketableCropProductionZayad(Integer fpoId)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_marketable) as totMarkProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.fpo_id = :fpoId and c.season_id = 3 group by c.crop_id, d.crop_name, seasonId  order by totMarkProd desc";
		List<FpoTotMarZayadDTO> obj =  (List<FpoTotMarZayadDTO>) entityManager.createNativeQuery(sql,"FpoTotMarZayadDTO").setParameter("fpoId", fpoId).getResultList();
		return obj;
	}
	
	public List<FpoTotMarKharifDTO> getFpoMarketableCropProductionKharif(Integer fpoId)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_marketable) as totMarkProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.fpo_id = :fpoId and c.season_id = 2 group by c.crop_id, d.crop_name, seasonId  order by totMarkProd desc";
		List<FpoTotMarKharifDTO> obj =  (List<FpoTotMarKharifDTO>) entityManager.createNativeQuery(sql,"FpoTotMarKharifDTO").setParameter("fpoId", fpoId).getResultList();
		return obj;
	}
	
	public List<FpoTotSoldRabiDTO> getFpoSoldCropProductionRabi(Integer fpoId)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_sold) as totSold from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.fpo_id = :fpoId and c.season_id = 1 group by c.crop_id, d.crop_name, seasonId  order by totSold desc";
		List<FpoTotSoldRabiDTO> obj =  (List<FpoTotSoldRabiDTO>) entityManager.createNativeQuery(sql,"FpoTotSoldRabiDTO").setParameter("fpoId", fpoId).getResultList();
		return obj;
	}
	
	public List<FpoTotSoldZayadDTO> getFpoSoldCropProductionZayad(Integer fpoId)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_sold) as totSold from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.fpo_id = :fpoId and c.season_id = 3 group by c.crop_id, d.crop_name, seasonId  order by totSold desc";
		List<FpoTotSoldZayadDTO> obj =  (List<FpoTotSoldZayadDTO>) entityManager.createNativeQuery(sql,"FpoTotSoldZayadDTO").setParameter("fpoId", fpoId).getResultList();
		return obj;
	}
	
	public List<FpoTotSoldKharifDTO> getFpoSoldCropProductionKharif(Integer fpoId)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_sold) as totSold from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.fpo_id = :fpoId and c.season_id = 2 group by c.crop_id, d.crop_name, seasonId  order by totSold desc";
		List<FpoTotSoldKharifDTO> obj =  (List<FpoTotSoldKharifDTO>) entityManager.createNativeQuery(sql,"FpoTotSoldKharifDTO").setParameter("fpoId", fpoId).getResultList();
		return obj;
	}
}
