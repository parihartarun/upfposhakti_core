package com.upfpo.app.service;

import java.util.List;
import java.util.Optional;

import com.upfpo.app.entity.FarmerRegister;

public interface FarmerServices {
	
	public FarmerRegister addFarmer(FarmerRegister farmerRegister);
	public List <FarmerRegister> getAllFarmers();
	public FarmerRegister getFarmerById(Integer id);
	public FarmerRegister deleteFarmerById(Integer id);


	List<FarmerRegister> getAllFarmerList();

	Optional<FarmerRegister> getFarmerDetailById(Integer id);

	FarmerRegister updateFarmerDetails(Integer id, FarmerRegister farmerRegister);
}
