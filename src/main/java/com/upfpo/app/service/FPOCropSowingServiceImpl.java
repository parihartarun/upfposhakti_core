package com.upfpo.app.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.dto.CropListOfFarmersDTO;
import com.upfpo.app.dto.FPOCropSowingExistingDTO;
import com.upfpo.app.dto.FarmerCropSowingDTO;
import com.upfpo.app.entity.CropDatails;
import com.upfpo.app.entity.MarketableSurplus;
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
			cropDetails.get(i).setMasterId(newSowing.getMasterId());
			cropDetails.get(i).setDeleted(false);
		}
		newSowingMasterRepository.save(newSowing);
		for(int i = 0; i < cropDetails.size(); i++)
		{
			System.out.println(i);
			cropDetails.get(i).setFinYear(finYear);
			cropDetails.get(i).setSeasonRefName(newSowing.getSeasonRefName());
			System.out.println("Crop Id::"+cropDetails.get(i).getCropRefName()+"Veriety Id::"+cropDetails.get(i).getVerietyRef());
			totalProductionCalculation.updateTotalProductionChange(cropDetails.get(i).getCropRefName(), cropDetails.get(i).getVerietyRef(), cropDetails.get(i).getSeasonRefName(), 
					finYear, newSowing.getMasterId());
		}
	}
	
	@Override
	public List<FPOCropSowingExistingDTO> getExistingSowingDetails(ReportRequestString reportRequestString) 
	{
		String finYear = GetFinYear.getCurrentFinYear();
		String sql = "";
		//int count = 0;
		List<FPOCropSowingExistingDTO> obj = null;
		/*count = newSowingMasterRepository.existingFarmer(reportRequestString.getFarmerId(), reportRequestString.getMasterId(), finYear);
		if(count<=0)
		{
			sql = "SELECT f.farmer_parants as father_husband_name, sum(l.land_area) as land_area FROM land_details l join farmer f on f.farmer_id = l.farmer_id \r\n"
					+ "				where f.farmer_id=:farmerId and f.fpo_ref_id =:masterId group by f.farmer_parants, f.farmer_name";
			
			obj =  (List<FPOCropSowingExistingDTO>) entityManager.createNativeQuery(sql,"FPOCropSowingExistingDTO").setParameter("farmerId", reportRequestString.getFarmerId()).
					setParameter("masterId", reportRequestString.getMasterId()).getResultList();
			return obj;
		}*/
			 sql =  "select nsi.sowing_id, nsi.fin_year, sum(l.land_area) as land_area,\r\n"
					+ "cd.crop_id, cd.season_ref, cd.veriety_ref, cd.crop_ref, cd.ex_yield, cd.actual_yield, cd.sowing_area, cd.marketable_quantity,  \r\n"
					+ "cm.id crop_master_id,cm.crop_name,\r\n"
					+ "f.farmer_id,f.farmer_name,f.farmer_parants father_husband_name,\r\n"
					+ "sm.season_id,sm.season_name,\r\n"
					+ "cv.veriety_id, cv.crop_veriety\r\n"
					+ "from new_sowing_info nsi join crop_details cd  on nsi.sowing_id = cd.sowing_id \r\n"
					+ "join crop_master cm on cm.id = cd.crop_ref\r\n"
					+ "join farmer f on f.farmer_id = nsi.farmer_id\r\n"
					+ "join season_master sm on sm.season_id= cd.season_ref\r\n"
					+ "join crop_veriety_master cv on cv.veriety_id = cd.veriety_ref\r\n"
					+ "join land_details l on l.farmer_id = f.farmer_id\r\n";
					
			
			if(reportRequestString.getFarmerId() != null && ! reportRequestString.getFarmerId().equals(""))
			{
				sql = sql + "where nsi.farmer_id = :farmerId and nsi.master_id = :masterId and nsi.fin_year = :finYear and cd.is_deleted = false group by  nsi.sowing_id,cd.crop_id, cd.season_ref, cd.veriety_ref, cd.crop_ref, cd.ex_yield, cd.actual_yield, cd.sowing_area, \r\n"
						+ "				crop_master_id, cm.crop_name,f.farmer_id,f.farmer_name, father_husband_name, sm.season_id, sm.season_name, cv.veriety_id, cv.crop_veriety";
				obj =  (List<FPOCropSowingExistingDTO>) entityManager.createNativeQuery(sql,"FPOCropSowingExistingDTO").setParameter("farmerId", reportRequestString.getFarmerId()).
						setParameter("masterId", reportRequestString.getMasterId()).setParameter("finYear", finYear).getResultList();
			}
			else
			{
				sql = sql + "where nsi.master_id = :masterId and nsi.fin_year = :finYear and cd.is_deleted = false group by  nsi.sowing_id,cd.crop_id, cd.season_ref, cd.veriety_ref, cd.crop_ref, cd.ex_yield, cd.actual_yield, cd.sowing_area, \r\n"
						+ "				crop_master_id, cm.crop_name,f.farmer_id,f.farmer_name, father_husband_name, sm.season_id, sm.season_name, cv.veriety_id, cv.crop_veriety";
				obj =  (List<FPOCropSowingExistingDTO>) entityManager.createNativeQuery(sql,"FPOCropSowingExistingDTO").setParameter("masterId", reportRequestString.getMasterId()).
						setParameter("finYear", finYear).getResultList();
			}
			System.out.print("SQL"+sql.toString());
			return obj;
		
	}
	
	@Override
	public CropDatails updateCropSowingDetails(Integer cropId, CropDatails cropDatailsMaster) 
	{
		CropDatails newCropDetails = null;
		String finYear = GetFinYear.getCurrentFinYear();
		try
		{
			Optional<CropDatails> cropDetails = cropDetailsRepository.findById(cropId);
			if(cropDetails.isPresent())
			{
				
				newCropDetails = cropDetails.get();
				newCropDetails.setActualYield(cropDatailsMaster.getActualYield());
				newCropDetails.setExpectedYield(cropDatailsMaster.getExpectedYield());
				newCropDetails.setCropRefName(cropDatailsMaster.getCropRefName());
				newCropDetails.setVerietyRef(cropDatailsMaster.getVerietyRef());
				newCropDetails.setSeasonRefName(cropDatailsMaster.getSeasonRefName());
				newCropDetails.setDeleted(false);
				newCropDetails.setSowingArea(cropDatailsMaster.getSowingArea());
				newCropDetails.setMarketableQuantity(cropDatailsMaster.getMarketableQuantity());
				
				newCropDetails = cropDetailsRepository.save(newCropDetails);
				
				totalProductionCalculation.updateTotalProductionChange(cropDatailsMaster.getCropRefName(), cropDatailsMaster.getVerietyRef(), cropDatailsMaster.getSeasonRefName(), 
						finYear,cropDatailsMaster.getMasterId());
			}
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
		}
		return newCropDetails;
	}
	
	@Override
	public Boolean deleteCropSowingDetails(Integer cropId) 
	{
		CropDatails cropDetails = cropDetailsRepository.findById(cropId).get();
		String financialYear = GetFinYear.getCurrentFinYear();
		try {
			cropDetails.setDeleted(true);
			cropDetailsRepository.save(cropDetails);

		}catch(Exception e)
		{
			e.printStackTrace();
			throw new NotFoundException();
		}
		totalProductionCalculation.updateTotalProductionChange(cropDetails.getCropRefName(), cropDetails.getVerietyRef(), cropDetails.getSeasonRefName(), financialYear, cropDetails.getMasterId());
		return true;
	}
}
