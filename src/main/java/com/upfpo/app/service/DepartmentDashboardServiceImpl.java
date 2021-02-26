package com.upfpo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.DepartmentDashboardDTO;
import com.upfpo.app.repository.FPORegisterRepository;
import com.upfpo.app.repository.FarmerMasterRepository;
import com.upfpo.app.repository.LandDetailsRepo;

@Service
public class DepartmentDashboardServiceImpl implements DepartmentDashboardService
{
	@Autowired
	LandDetailsRepo landDetailsRepo;
	
	@Autowired
	FPORegisterRepository fPORegisterRepository;
	
	@Autowired
	FarmerMasterRepository farmerMasterRepository;
	
	Double landArea = 0.0;
	
	Integer totalFpo = 0;
	
	Integer totalfarmers = 0;
	
	Double totalMarginalFarmer = 0.0;
	
	Double totalSmallFarmer = 0.0;
	
	Double totalOtherFarmer = 0.0;
	
	@Override
	public DepartmentDashboardDTO getDepartmentDashboardData() 
	{
		DepartmentDashboardDTO departmentDashboardDTO = new DepartmentDashboardDTO();
		landArea 				= landDetailsRepo.getTotalLand();
		totalFpo 				= fPORegisterRepository.getAllFpoCount();
		totalfarmers 			= farmerMasterRepository.getAllFarmers();
		totalMarginalFarmer 	= (totalfarmers * 0.8);
		totalSmallFarmer		= (totalfarmers * 0.13);
		totalOtherFarmer		= (totalfarmers * 0.07);
		departmentDashboardDTO.setLandArea(landArea);
		departmentDashboardDTO.setTotalFpo(totalFpo);
		departmentDashboardDTO.setTotalfarmers(totalfarmers);
		departmentDashboardDTO.setTotalMarginalFarmer(totalMarginalFarmer);
		departmentDashboardDTO.setTotalSmallFarmer(totalSmallFarmer);
		departmentDashboardDTO.setTotalOtherFarmer(totalOtherFarmer);
		
		return departmentDashboardDTO;
	}
}
