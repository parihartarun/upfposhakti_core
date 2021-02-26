package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.DepartmentAllUserDto;
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
	public List<DepartmentAllUserDto> getAllFarmerUserToFpo() {
		List <DepartmentAllUserDto> list = null;
		   try
			{
			  String sql = "select users.user_id,users.user_name,fpo_name,district_name,date_of_regi,fpo_landline,fpo_email,users.enabled from fpo \r\n" + 
			   		"join districts on fpo.dist_ref_id = districts.district_id  \r\n" + 
			   		"join users on fpo.users_id = users.user_id";
			   
			  list = (List<DepartmentAllUserDto>) entityManager.createNativeQuery(sql, "DepartmentAllUserDto").getResultList();
			  System.out.println(list.size());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		   return list;
	}

	@Override
	public void deActivateFarmerUser(Long uid, String reason, Integer masterId) {
		farmerMasterRepository.deActivateUserByDept(uid,reason, masterId);
	}

	@Override
	public void activateFarmerUser(Long uid, Integer masterId) {
		farmerMasterRepository.activateUserByDept(uid, masterId);
	}
}
