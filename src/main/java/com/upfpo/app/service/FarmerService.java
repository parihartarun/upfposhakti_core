package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.dto.DepartmentAllUserDto;
import com.upfpo.app.dto.FarmerAllUserToFpoDto;
import com.upfpo.app.dto.FarmerDetailsDTO;
import com.upfpo.app.dto.FarmerMasterDTO;
import com.upfpo.app.entity.FarmerMaster;

public interface FarmerService 
{
	public FarmerMaster updateFarmer(FarmerMaster farmerMaster,int farmerId);
	public List<FarmerMaster> getFarmer(Integer masterId);
	public void deleteFarmer(int farmerId);
	public List<FarmerAllUserToFpoDto> getAllFarmerUserToFpo(Integer fpoId);
	public void deActivateFarmerUser(Long uid, String reason, Integer masterId);
	public void activateFarmerUser(Long uid, Integer masterId);
	public List<FarmerDetailsDTO> getFarmerDetailsByFpo(Integer masterId);
	public Integer getFarmerCountByFpo(Integer fpoId);
	public List<FarmerMasterDTO> getFarmersByUserId();
}
