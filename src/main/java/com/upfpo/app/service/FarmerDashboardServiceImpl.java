package com.upfpo.app.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.FarmerCropProductionDTO;
import com.upfpo.app.dto.FarmerDashboardDTO;
import com.upfpo.app.dto.FpoActProdKharifDTO;
import com.upfpo.app.repository.CropDetailsRepository;
import com.upfpo.app.repository.LandDetailsRepo;
import com.upfpo.app.util.GetFinYear;

@Service
public class FarmerDashboardServiceImpl implements FarmerDashboardService
{
	@Autowired
	LandDetailsRepo landDetailsRepo;
	
	@Autowired
	CropDetailsRepository cropDetailsRepository;
	
	@Autowired
	EntityManager entityManager;
	
	Double totalLandArea = 0.0;
	
	Double cultivatedLand = 0.0;
	
	Double uncultivatedLand = 0.0;
	
	Integer crops = 0;
	
	String sql = "";
	
	@Override
	public FarmerDashboardDTO getFarmerDashboardData(Integer farmerId) 
	{
		String financialYear = GetFinYear.getCurrentFinYear();
		totalLandArea = landDetailsRepo.getFarmerTotalLand(farmerId);
		cultivatedLand = cropDetailsRepository.getCultivatedLand(farmerId, financialYear);
		uncultivatedLand = totalLandArea - cultivatedLand;
		crops = cropDetailsRepository.getCropsCount(farmerId, financialYear);
		
		FarmerDashboardDTO farmerData = new FarmerDashboardDTO();
		farmerData.setLandArea(totalLandArea);
		farmerData.setCultivatedLand(cultivatedLand);
		farmerData.setUncultivatedLand(uncultivatedLand);
		farmerData.setCrops(crops);
		farmerData.setExpectedYeildRabi(getExpectedFarmerRabi(farmerId, financialYear));
		farmerData.setExpectedYeildZayad(getExpectedFarmerZayad(farmerId, financialYear));
		farmerData.setExpectedYeildKhrif(getExpectedFarmerKharif(farmerId, financialYear));
		farmerData.setActualYeildKharif(getActualFarmerKharif(farmerId, financialYear));
		farmerData.setActualYeildRabi(getActualFarmerRabi(farmerId, financialYear));
		farmerData.setActualYeildZayad(getActualFarmerZayad(farmerId, financialYear));
		return farmerData;
	}
	
	public List<FarmerCropProductionDTO> getExpectedFarmerRabi(Integer farmerId, String finYear)
	{
		sql = "select cd.crop_ref as cropId, cm.crop_name as cropName, sum(cd.ex_yield) as production,\r\n"
				+ "cd.season_ref as seasonId, sm.season_name as seasonName\r\n"
				+ "	from crop_details cd join crop_master cm on cd.crop_ref = cm.id \r\n"
				+ "	join new_sowing_info nsi on nsi.sowing_id = cd.sowing_id\r\n"
				+ "	join season_master sm on sm.season_id = cd.season_ref\r\n"
				+ "	where nsi.farmer_id = :farmerId and nsi.fin_year= :finYear and cd.season_ref = 1 \r\n"
				+ "	group by cd.crop_ref, cm.crop_name, nsi.farmer_id, cd.season_ref, sm.season_name order by production desc";
		List<FarmerCropProductionDTO> obj =  (List<FarmerCropProductionDTO>) entityManager.createNativeQuery(sql,"FarmerCropProductionDTO").setParameter("farmerId", farmerId).
				setParameter("finYear", finYear).getResultList();
		return obj;
	}
	
	public List<FarmerCropProductionDTO> getExpectedFarmerZayad(Integer farmerId, String finYear)
	{
		sql = "select cd.crop_ref as cropId, cm.crop_name as cropName, sum(cd.ex_yield) as production,\r\n"
				+ "cd.season_ref as seasonId, sm.season_name as seasonName\r\n"
				+ "	from crop_details cd join crop_master cm on cd.crop_ref = cm.id \r\n"
				+ "	join new_sowing_info nsi on nsi.sowing_id = cd.sowing_id\r\n"
				+ "	join season_master sm on sm.season_id = cd.season_ref\r\n"
				+ "	where nsi.farmer_id = :farmerId and nsi.fin_year= :finYear and cd.season_ref = 3 \r\n"
				+ "	group by cd.crop_ref, cm.crop_name, nsi.farmer_id, cd.season_ref, sm.season_name order by production desc";
		List<FarmerCropProductionDTO> obj =  (List<FarmerCropProductionDTO>) entityManager.createNativeQuery(sql,"FarmerCropProductionDTO").setParameter("farmerId", farmerId).
				setParameter("finYear", finYear).getResultList();
		return obj;
	}
	
	public List<FarmerCropProductionDTO> getExpectedFarmerKharif(Integer farmerId, String finYear)
	{
		sql = "select cd.crop_ref as cropId, cm.crop_name as cropName, sum(cd.ex_yield) as production,\r\n"
				+ "cd.season_ref as seasonId, sm.season_name as seasonName\r\n"
				+ "	from crop_details cd join crop_master cm on cd.crop_ref = cm.id \r\n"
				+ "	join new_sowing_info nsi on nsi.sowing_id = cd.sowing_id\r\n"
				+ "	join season_master sm on sm.season_id = cd.season_ref\r\n"
				+ "	where nsi.farmer_id = :farmerId and nsi.fin_year= :finYear and cd.season_ref = 2 \r\n"
				+ "	group by cd.crop_ref, cm.crop_name, nsi.farmer_id, cd.season_ref, sm.season_name order by production desc";
		List<FarmerCropProductionDTO> obj =  (List<FarmerCropProductionDTO>) entityManager.createNativeQuery(sql,"FarmerCropProductionDTO").setParameter("farmerId", farmerId).
				setParameter("finYear", finYear).getResultList();
		return obj;
	}
	
	public List<FarmerCropProductionDTO> getActualFarmerZayad(Integer farmerId, String finYear)
	{
		sql = "select cd.crop_ref as cropId, cm.crop_name as cropName, sum(cd.actual_yield) as production,\r\n"
				+ "cd.season_ref as seasonId, sm.season_name as seasonName\r\n"
				+ "	from crop_details cd join crop_master cm on cd.crop_ref = cm.id \r\n"
				+ "	join new_sowing_info nsi on nsi.sowing_id = cd.sowing_id\r\n"
				+ "	join season_master sm on sm.season_id = cd.season_ref\r\n"
				+ "	where nsi.farmer_id = :farmerId and nsi.fin_year= :finYear and cd.season_ref = 3 \r\n"
				+ "	group by cd.crop_ref, cm.crop_name, nsi.farmer_id, cd.season_ref, sm.season_name order by production desc";
		List<FarmerCropProductionDTO> obj =  (List<FarmerCropProductionDTO>) entityManager.createNativeQuery(sql,"FarmerCropProductionDTO").setParameter("farmerId", farmerId).
				setParameter("finYear", finYear).getResultList();
		return obj;
	}
	
	public List<FarmerCropProductionDTO> getActualFarmerRabi(Integer farmerId, String finYear)
	{
		sql = "select cd.crop_ref as cropId, cm.crop_name as cropName, sum(cd.actual_yield) as production,\r\n"
				+ "cd.season_ref as seasonId, sm.season_name as seasonName\r\n"
				+ "	from crop_details cd join crop_master cm on cd.crop_ref = cm.id \r\n"
				+ "	join new_sowing_info nsi on nsi.sowing_id = cd.sowing_id\r\n"
				+ "	join season_master sm on sm.season_id = cd.season_ref\r\n"
				+ "	where nsi.farmer_id = :farmerId and nsi.fin_year= :finYear and cd.season_ref = 1 \r\n"
				+ "	group by cd.crop_ref, cm.crop_name, nsi.farmer_id, cd.season_ref, sm.season_name order by production desc";
		List<FarmerCropProductionDTO> obj =  (List<FarmerCropProductionDTO>) entityManager.createNativeQuery(sql,"FarmerCropProductionDTO").setParameter("farmerId", farmerId).
				setParameter("finYear", finYear).getResultList();
		return obj;
	}
	
	public List<FarmerCropProductionDTO> getActualFarmerKharif(Integer farmerId, String finYear)
	{
		sql = "select cd.crop_ref as cropId, cm.crop_name as cropName, sum(cd.actual_yield) as production,\r\n"
				+ "cd.season_ref as seasonId, sm.season_name as seasonName\r\n"
				+ "	from crop_details cd join crop_master cm on cd.crop_ref = cm.id \r\n"
				+ "	join new_sowing_info nsi on nsi.sowing_id = cd.sowing_id\r\n"
				+ "	join season_master sm on sm.season_id = cd.season_ref\r\n"
				+ "	where nsi.farmer_id = :farmerId and nsi.fin_year= :finYear and cd.season_ref = 2 \r\n"
				+ "	group by cd.crop_ref, cm.crop_name, nsi.farmer_id, cd.season_ref, sm.season_name order by production desc";
		List<FarmerCropProductionDTO> obj =  (List<FarmerCropProductionDTO>) entityManager.createNativeQuery(sql,"FarmerCropProductionDTO").setParameter("farmerId", farmerId).
				setParameter("finYear", finYear).getResultList();
		return obj;
	}
}
