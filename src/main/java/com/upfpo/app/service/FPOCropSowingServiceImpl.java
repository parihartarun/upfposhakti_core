package com.upfpo.app.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.upfpo.app.dto.CropListOfFarmersDTO;
import com.upfpo.app.dto.FarmerCropSowingDTO;
import com.upfpo.app.entity.CropDatails;
import com.upfpo.app.entity.NewSowing;
import com.upfpo.app.repository.CropDetailsRepository;
import com.upfpo.app.repository.NewSowingMasterRepository;
import com.upfpo.app.util.GetFinYear;

public class FPOCropSowingServiceImpl implements FPOCropSowingService
{
	@Autowired
	NewSowingMasterRepository newSowingMasterRepository;
	
	@Autowired
	CropDetailsRepository cropDetailsRepository;
	
	@Autowired
	EntityManager entityManager;
	
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
	public NewSowing addFarmerCropDetails(NewSowing newSowing) 
	{
		return newSowingMasterRepository.save(newSowing);
	}
	
	/**
	 *
	 */
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
