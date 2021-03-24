package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.custom.annotations.Mobile;
import com.upfpo.app.dto.DepartmentAllUserDto;
import com.upfpo.app.dto.FarmerAllUserToFpoDto;
import com.upfpo.app.dto.FarmerDetailsDTO;
import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.repository.FarmerMasterRepository;

@Service
public class FarmerServiceImpl implements FarmerService
{
	@Autowired
	FarmerMasterRepository farmerMasterRepository;
	
	@Autowired
	private  EntityManager entityManager;
	
	@Override
	public List<FarmerMaster> getFarmer(Integer masterId) 
	{
		List<FarmerMaster> farmerList = new ArrayList<FarmerMaster>();
		//farmerMasterRepository.findAll().forEach(farmerList1->farmerList.add(farmerList1));
		//farmerMasterRepository.getFarmers(1001).forEach(farmerList1->farmerList.add(farmerList1));
		
		return farmerMasterRepository.findByFpoRefIdAndIsDeletedOrderByFarmerIdDesc(masterId, false);
	}
	
	@Override
	public FarmerMaster updateFarmer(FarmerMaster farmerMaster, int farmerId) 
	{
		Optional<FarmerMaster> farmer = farmerMasterRepository.findById(farmerId);
		if(farmer.isPresent())
		{
			FarmerMaster newFarmer = farmer.get();
			newFarmer.setStateref(farmerMaster.getStateref());
			newFarmer.setPincode(farmerMaster.getPincode());
			newFarmer.setBlockRef(farmerMaster.getBlockRef());
			newFarmer.setSlaRefId(farmerMaster.getSlaRefId());
			newFarmer.setDistRefId(farmerMaster.getDistRefId());
			newFarmer.setBankRefId(farmerMaster.getBankRefId());
			newFarmer.setFpoRefId(farmerMaster.getFpoRefId());
			newFarmer.setVillRefId(farmerMaster.getVillRefId());
			newFarmer.setFigRefId(farmerMaster.getFigRefId());
			newFarmer.setEducationId(farmerMaster.getEducationId());
			newFarmer.setFarmerName(farmerMaster.getFarmerName());
			newFarmer.setFarmerAdhaar(farmerMaster.getFarmerAdhaar());
			newFarmer.setFarmerAddress(farmerMaster.getFarmerAddress());
			newFarmer.setRegisterDate(farmerMaster.getRegisterDate());
			newFarmer.setFarmerMob(farmerMaster.getFarmerMob());
			newFarmer.setFarmerLotNo(farmerMaster.getFarmerLotNo());
			newFarmer.setIfscCode(farmerMaster.getIfscCode());
			newFarmer.setAccountNo(farmerMaster.getAccountNo());
			newFarmer.setKccno(farmerMaster.getKccno());
			newFarmer.setParantsName(farmerMaster.getParantsName());
			//newFarmer.setUserRefId(farmerMaster.getUserRefId());
			newFarmer.setCreateDate(farmerMaster.getCreateDate());
			newFarmer.setCreatedBy(farmerMaster.getCreatedBy());
			newFarmer.setGender(farmerMaster.getGender());
			newFarmer.setDistanceFromFpc(farmerMaster.getDistanceFromFpc());
			newFarmer.setUserName(farmerMaster.getUserName());
			newFarmer.setCategory(farmerMaster.getCategory());
			newFarmer.setUpdateDate(farmerMaster.getUpdateDate());
			newFarmer.setAgency(farmerMaster.getAgency());
			newFarmer.setUpBSMId(farmerMaster.getUpBSMId());
			newFarmer.setVillagePanchayatId(farmerMaster.getVillagePanchayatId());
			newFarmer.setDeleteDate(farmerMaster.getDeleteDate());
			newFarmer.setUpdatedBy(farmerMaster.getUpdatedBy());
			
			newFarmer = farmerMasterRepository.save(newFarmer);
			return newFarmer;
		}
		else
		{
			farmerMaster = farmerMasterRepository.save(farmerMaster);
			return farmerMaster;
		}
	}
	
	@Override
	public void deleteFarmer(int farmerId) 
	{
		farmerMasterRepository.deleteFarmer(farmerId);
	}

	@Override
	public List<FarmerAllUserToFpoDto> getAllFarmerUserToFpo(Integer fpoId) {
		List <FarmerAllUserToFpoDto> list = null;
		   try
			{
			  String sql = "select f.farmer_id as farmerId, f.state_ref as stateref, f.pincode, f.blockId as blockRef, f.sla_ref_id as slaRefId,"
			  		+ "f. district_ref_id as distRefId, f.bank_ref_id as bankRefId, f.fpo_ref_id as fpoRefId, f.village_ref_id as villRefId,"
			  		+ "f.fig_ref_id as figRefId, f.education_ref_id as educationId, f.farmer_name as farmerName, f.aadhaar as farmerAdhaar, f.address as "
			  		+ "farmerAddress, f.date_associated as registerDate, f.farmer_mob as farmerMob, f.farmerlotno as farmerLotNo, f.ifsccode as "
			  		+ "ifscCode, f.accountno as accountNo , f.kccno, f.farmer_parants as parantsName , f.create_date as createDate, f.created_by "
			  		+ "as createdBy, f.enabled , f.farm_gen as gender , f.distance_from_fpc as distanceFromFpc, f.username as farmerUserName, f.farm_category "
			  		+ "as category, f.update_date as updateDate, f.agency_associated as agency , f.upbsm_id as upBSMId , f.vill_panchayat_ref_id "
			  		+ "as villagePanchayatId , f.is_deleted as isDeleted, f.delete_date as deleteDate, f.updated_by as updatedBy,"
			  		+ "u.user_id as userId,u.user_name as userName,u.enabled as userEnabled,d.district_name as districtName from farmer f\r\n"
			  		+ "left join districts d on f.district_ref_id = d.district_id \r\n"
			  		+ "join users u on f.user_id = u.user_id\r\n"
			  		+ "where f.fpo_ref_id =:fpoId and f.is_deleted= false";
			   
			  list = (List<FarmerAllUserToFpoDto>) entityManager.createNativeQuery(sql, "FarmerAllUserToFpoDto")
					  .setParameter("fpoId", fpoId)
					  .getResultList();
			  System.out.println(list.size());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		   return list;
	}

	@Override
	public void deActivateFarmerUser(Long uid, String reason, Integer masterId) {
		farmerMasterRepository.deActivateUserByFpo(uid,reason, masterId);
	}

	@Override
	public void activateFarmerUser(Long uid, Integer masterId) {
		farmerMasterRepository.activateUserByFpo(uid, masterId);
	}
	
	@Override
	public List<FarmerDetailsDTO> getFarmerDetailsByFpo(Integer masterId) 
	{
		return farmerMasterRepository.getFarmersByFpo(masterId);
	}
	
	@Override
	public Integer getFarmerCountByFpo(Integer fpoId) 
	{
		return farmerMasterRepository.getFpoFarmer(fpoId);
	}
}
