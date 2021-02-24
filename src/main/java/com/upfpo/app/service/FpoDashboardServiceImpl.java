package com.upfpo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return fpoFarmerDashboardDTO;
	}
	
}
