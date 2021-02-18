package com.upfpo.app.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.CropListOfFarmersDTO;
import com.upfpo.app.dto.FPOCropSowingExistingDTO;
import com.upfpo.app.dto.FarmerCropSowingDTO;
import com.upfpo.app.entity.CropDatails;
import com.upfpo.app.entity.NewSowing;
import com.upfpo.app.repository.CropDetailsRepository;
import com.upfpo.app.repository.NewSowingMasterRepository;
import com.upfpo.app.requestStrings.ReportRequestString;
import com.upfpo.app.util.GetFinYear;
import com.upfpo.app.util.TotalProductionCalculation;

@Service
public class FPOCropSowingServiceImpl implements FPOCropSowingService
{
	@Autowired
	NewSowingMasterRepository newSowingMasterRepository;
	
	@Autowired
	CropDetailsRepository cropDetailsRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	TotalProductionCalculation totalProductionCalculation;
	
	@Override 
	public FarmerCropSowingDTO getFarmerDetailsForCropSowing(int farmerId) 
	  {
		  return newSowingMasterRepository.getFarmerDetailsForCropSowing(farmerId);
	  }

	@Override
	public List<CropListOfFarmersDTO> getCropListForFarmersByFpo(int masterId) 
	{
		String sql =  "Select cd.crop_id id,f.farmer_id,f.farmer_name,f.farmer_parants father_husband_name,\r\n" + 
        		"cd.financial_year,sm.season_id,sm.season_name,nsi.sowing_id, \r\n" + 
        		"cm.id crop_id,cm.crop_name,case when cast(cd.veriety_ref as integer)!=0 \r\n" + 
        		"then cv.crop_veriety else 'Other'end crop_veriety\r\n" + 
        		",cd.sowing_area,cd.ex_yield,cv.veriety_id from crop_details cd\r\n" + 
        		"inner join farmer f on f.farmer_id = cd.farmer_id \r\n" + 
        		"inner join season_master sm on sm.season_id=cd.season_ref \r\n" + 
        		"inner join crop_master cm on cm.id=cast( crop_ref as integer) \r\n" + 
        		"left join crop_veriety_master cv on cv.veriety_id = cast (cd.veriety_ref as integer) \r\n" + 
        		"left join new_sowing_info nsi on nsi.sowing_id = cd.sowing_id\r\n" + 
        		"where f.fpo_ref_id = :masterId and cd.is_deleted=false";
		
		List<CropListOfFarmersDTO> obj =  (List<CropListOfFarmersDTO>) entityManager.createNativeQuery(sql,"CropListOfFarmersDTO").setParameter("masterId", masterId).getResultList();
		  return obj;
	}
	
	@Override
	public void addFarmerCropDetails(NewSowing newSowing) 
	{
		String finYear = GetFinYear.getCurrentFinYear();
		newSowing.setFinYear(finYear);
		List<CropDatails> cropDetails = null;
		cropDetails = newSowing.getList();
		for(int i = 0; i < cropDetails.size(); i++)
		{
			cropDetails.get(i).setFinYear(finYear);
			cropDetails.get(i).setSeasonRefName(newSowing.getSeasonRefName());
		}
		newSowingMasterRepository.save(newSowing);
		for(int i = 0; i < cropDetails.size(); i++)
		{
			cropDetails.get(i).setFinYear(finYear);
			cropDetails.get(i).setSeasonRefName(newSowing.getSeasonRefName());
			totalProductionCalculation.updateTotalProductionForCropSowing(cropDetails.get(0).getCropRefName(), cropDetails.get(0).getVerietyRef(), cropDetails.get(0).getSeasonRefName(), 
					finYear, newSowing.getMasterId(), cropDetails.get(0).getActualYield(), 0.0);
		}
	}
	
	@Override
	public List<FPOCropSowingExistingDTO> getExistingSowingDetails(ReportRequestString reportRequestString) 
	{
		String finYear = GetFinYear.getCurrentFinYear();
		List<FPOCropSowingExistingDTO> obj = null;
		String sql =  "select nsi.sowing_id, nsi.fin_year,\r\n"
				+ "cd.crop_id, cd.season_ref, cd.veriety_ref, cd.crop_ref, cd.ex_yield, cd.actual_yield, cd.sowing_area, \r\n"
				+ "cm.id crop_master_id,cm.crop_name,\r\n"
				+ "f.farmer_id,f.farmer_name,f.farmer_parants father_husband_name,\r\n"
				+ "sm.season_id,sm.season_name,\r\n"
				+ "cv.veriety_id, cv.crop_veriety\r\n"
				+ "from new_sowing_info nsi join crop_details cd  on nsi.sowing_id = cd.sowing_id \r\n"
				+ "join crop_master cm on cm.id = cd.crop_ref\r\n"
				+ "join farmer f on f.farmer_id = nsi.farmer_id\r\n"
				+ "join season_master sm on sm.season_id= cd.season_ref\r\n"
				+ "join crop_veriety_master cv on cv.veriety_id = cd.veriety_ref\r\n";
		
		if(reportRequestString.getFarmerId() != null && ! reportRequestString.getFarmerId().equals(""))
		{
			sql = sql + "where nsi.farmer_id = :farmerId and nsi.master_id = :masterId and nsi.fin_year = :finYear";
			obj =  (List<FPOCropSowingExistingDTO>) entityManager.createNativeQuery(sql,"FPOCropSowingExistingDTO").setParameter("farmerId", reportRequestString.getFarmerId()).
					setParameter("masterId", reportRequestString.getMasterId()).setParameter("finYear", finYear).getResultList();
		}
		else
		{
			sql = sql + "where nsi.master_id = :masterId and nsi.fin_year = :finYear";
			obj =  (List<FPOCropSowingExistingDTO>) entityManager.createNativeQuery(sql,"FPOCropSowingExistingDTO").setParameter("masterId", reportRequestString.getMasterId()).
					setParameter("finYear", finYear).getResultList();
		}
		
		return obj;
	}
	
	@Override
	public NewSowing updateCropSowingDetails(Integer sowing_id, NewSowing newSowingMaster) 
	{
		String finYear = GetFinYear.getCurrentFinYear();
		NewSowing newSowingUpdated = null;
		try
		{
			Optional<NewSowing> newSowing = newSowingMasterRepository.findById(sowing_id);
			if(newSowing.isPresent())
			{
				newSowingUpdated = newSowingMasterRepository.findById(sowing_id).get();
				newSowingUpdated.setBaseland(newSowingMaster.getBaseland());
				newSowingUpdated.setGuardianName(newSowingMaster.getGuardianName());
				newSowingUpdated.setFinYear(finYear);
				newSowingUpdated.setFarmerId(newSowingMaster.getFarmerId());
				newSowingUpdated.setMasterId(newSowingMaster.getMasterId());
				
				CropDatails cropDatails = cropDetailsRepository.findById(newSowingMaster.getList().get(0).getCropId()).get();
				cropDatails.setActualYield(newSowingMaster.getList().get(0).getActualYield());
				cropDatails.setExpectedYield(newSowingMaster.getList().get(0).getExpectedYield());
				cropDatails.setCropRefName(newSowingMaster.getList().get(0).getCropRefName());
				cropDatails.setVerietyRef(newSowingMaster.getList().get(0).getVerietyRef());
				cropDatails.setSeasonRefName(newSowingMaster.getSeasonRefName());
				cropDatails.setFinYear(finYear);
				cropDatails.setDeleted(false);
				cropDatails.setSowingArea(newSowingMaster.getList().get(0).getSowingArea());
				
				newSowingUpdated = newSowingMasterRepository.save(newSowingUpdated);
				cropDatails = cropDetailsRepository.save(cropDatails);
			}
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
		}
		
		return newSowingUpdated;
	}
}
