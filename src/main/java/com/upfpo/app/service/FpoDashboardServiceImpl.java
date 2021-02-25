package com.upfpo.app.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.CropListOfFarmersDTO;
import com.upfpo.app.dto.FpoCropProductionDashboardDTO;
import com.upfpo.app.dto.FpoFarmerDashboardDTO;
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
		
		FpoFarmerDashboardDTO fpoFarmerDashboardDTO = new FpoFarmerDashboardDTO();
		fpoFarmerDashboardDTO.setTotalFpoFarmer(totalFpoFarmer);
		fpoFarmerDashboardDTO.setTotalMarginalFarmer(totalMarginalFarmer);
		fpoFarmerDashboardDTO.setTotalSmallFarmer(totalSmallFarmer);
		fpoFarmerDashboardDTO.setTotalOtherFarmer(totalOtherFarmer);
		fpoFarmerDashboardDTO.setLandArea(landArea);
		fpoFarmerDashboardDTO.setCrops(crops);
		fpoFarmerDashboardDTO.setFpoCropProductionDashboard(getFpoCropProductionforDashboard(fpoId));
		return fpoFarmerDashboardDTO;
	}
	
	public List<FpoCropProductionDashboardDTO> getFpoCropProductionforDashboard(Integer fpoId)
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, sum(c.total_actual_prod) as totAcProd, sum(c.total_marketable) as totMarkProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.fpo_id = :fpoId group by c.crop_id, d.crop_name order by totAcProd desc, totMarkProd desc";
		List<FpoCropProductionDashboardDTO> obj =  (List<FpoCropProductionDashboardDTO>) entityManager.createNativeQuery(sql,"FpoCropProductionDashboardDTO").setParameter("fpoId", fpoId).getResultList();
		return obj;
		
		
	}
}
