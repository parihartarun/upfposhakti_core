package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.FarmerMaster;

public interface FarmerService 
{
	public FarmerMaster updateFarmer(FarmerMaster farmerMaster,int farmerId);
	public List<FarmerMaster> getFarmer();
	public void deleteFarmer(int farmerId);
}
