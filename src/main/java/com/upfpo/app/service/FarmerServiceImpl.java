package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.repository.FarmerMasterRepository;

@Service
public class FarmerServiceImpl implements FarmerService
{
	@Autowired
	FarmerMasterRepository farmerMasterRepository;
	
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
}
