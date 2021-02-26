package com.upfpo.app.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.DepartmentDashboardDTO;
import com.upfpo.app.dto.DeptActProdKharifDTO;
import com.upfpo.app.dto.DeptActProdRabiDTO;
import com.upfpo.app.dto.DeptActProdZayadfDTO;
import com.upfpo.app.dto.DeptActualProductionDTO;
import com.upfpo.app.dto.DeptFpoAgencyDTO;
import com.upfpo.app.dto.DeptMarketableProductionDTO;
import com.upfpo.app.dto.DeptTotMarKharifDTO;
import com.upfpo.app.dto.DeptTotMarRabiDTO;
import com.upfpo.app.dto.DeptTotMarZayadDTO;
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
	
	@Autowired
	EntityManager entityManager;
	
	Double landArea = 0.0;
	
	Integer totalFpo = 0;
	
	Integer totalfarmers = 0;
	
	Double totalMarginalFarmer = 0.0;
	
	Double totalSmallFarmer = 0.0;
	
	Double totalOtherFarmer = 0.0;
	
	Double percentile	= 0.0;
	
	String sql = "";
	
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
		
		DeptActualProductionDTO depAct = new DeptActualProductionDTO();
		depAct.setDeptActProdKharif(getDeptActualCropProductionKharif());
		depAct.setDeptActProdRabi(getDeptActualCropProductionRabi());
		depAct.setDeptActProdZayad(getDeptActualCropProductionZayad());
		
		DeptMarketableProductionDTO depMar = new DeptMarketableProductionDTO();
		depMar.setDeptTotMarKharif(getDeMarketableCropProductionKharif());
		depMar.setDeptTotMarRabi(getDeptMarketableCropProductionRabi());
		depMar.setDeptTotMarZayad(getDeptMarketableCropProductionZayad());
		
		List<DeptFpoAgencyDTO> agency = fPORegisterRepository.getAgency();
		Integer totalFpo = fPORegisterRepository.getAllFpoCount();
		
		for(int i =	0; i < agency.size(); i++)
		{
			Double value = (Double)agency.get(i).getCount().doubleValue();
			percentile = (totalFpo) * (value/ 100);
			agency.get(i).setAgencyWiseFpo(percentile);
		}
		
		departmentDashboardDTO.setLandArea(landArea);
		departmentDashboardDTO.setTotalFpo(totalFpo);
		departmentDashboardDTO.setTotalfarmers(totalfarmers);
		departmentDashboardDTO.setTotalMarginalFarmer(totalMarginalFarmer);
		departmentDashboardDTO.setTotalSmallFarmer(totalSmallFarmer);
		departmentDashboardDTO.setTotalOtherFarmer(totalOtherFarmer);
		departmentDashboardDTO.setDeptActualProduction(depAct);
		departmentDashboardDTO.setDeptMarketableProduction(depMar);
		departmentDashboardDTO.setDeptFpoAgency(agency);
		return departmentDashboardDTO;
	}
	
	public List<DeptActProdRabiDTO> getDeptActualCropProductionRabi()
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_actual_prod) as totAcProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.season_id = 1 group by c.crop_id, d.crop_name, seasonId order by totAcProd desc ";
		List<DeptActProdRabiDTO> obj =  (List<DeptActProdRabiDTO>) entityManager.createNativeQuery(sql,"DeptActProdRabiDTO").getResultList();
		return obj;
	}
	
	public List<DeptActProdZayadfDTO> getDeptActualCropProductionZayad()
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_actual_prod) as totAcProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.season_id = 3 group by c.crop_id, d.crop_name, seasonId order by totAcProd desc ";
		List<DeptActProdZayadfDTO> obj =  (List<DeptActProdZayadfDTO>) entityManager.createNativeQuery(sql,"DeptActProdZayadfDTO").getResultList();
		return obj;
	}
	
	public List<DeptActProdKharifDTO> getDeptActualCropProductionKharif()
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_actual_prod) as totAcProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.season_id = 2 group by c.crop_id, d.crop_name, seasonId order by totAcProd desc ";
		List<DeptActProdKharifDTO> obj =  (List<DeptActProdKharifDTO>) entityManager.createNativeQuery(sql,"DeptActProdKharifDTO").getResultList();
		return obj;
	}
	
	public List<DeptTotMarRabiDTO> getDeptMarketableCropProductionRabi()
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_marketable) as totMarkProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.season_id = 1 group by c.crop_id, d.crop_name, seasonId  order by totMarkProd desc";
		List<DeptTotMarRabiDTO> obj =  (List<DeptTotMarRabiDTO>) entityManager.createNativeQuery(sql,"DeptTotMarRabiDTO").getResultList();
		return obj;
	}
	
	public List<DeptTotMarZayadDTO> getDeptMarketableCropProductionZayad()
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_marketable) as totMarkProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.season_id = 3 group by c.crop_id, d.crop_name, seasonId  order by totMarkProd desc";
		List<DeptTotMarZayadDTO> obj =  (List<DeptTotMarZayadDTO>) entityManager.createNativeQuery(sql,"DeptTotMarZayadDTO").getResultList();
		return obj;
	}
	
	public List<DeptTotMarKharifDTO> getDeMarketableCropProductionKharif()
	{
		sql = "select distinct c.crop_id as cropId, d.crop_name as cropName, c.season_id as seasonId, sum(c.total_marketable) as totMarkProd from total_production c join crop_master d on d.id = c.crop_id\r\n"
				+ "				where c.season_id = 2 group by c.crop_id, d.crop_name, seasonId  order by totMarkProd desc";
		List<DeptTotMarKharifDTO> obj =  (List<DeptTotMarKharifDTO>) entityManager.createNativeQuery(sql,"DeptTotMarKharifDTO").getResultList();
		return obj;
	}
}
