package com.upfpo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.*;
import com.upfpo.app.repository.BuyerSellerRepository;
import com.upfpo.app.repository.FarmerMasterRepository;
import com.upfpo.app.repository.FpoMasterRepository;

import java.util.Optional;

@Service
public class RegistrationServicesImpl implements RegistrationServices
{
	@Autowired
	FpoMasterRepository fpoRepository;
	
	@Autowired 
	FarmerMasterRepository farmerMasterRepository;
	
	@Autowired
	BuyerSellerRepository buyerSellerRepository;
	
	@Override
	public void registerFPO(FPORegister fpoRegister) 
	{
		fpoRepository.save(fpoRegister);
	}
	
	@Override
	public void registerFarmer(FarmerMaster farmerRegister) 
	{
		farmerMasterRepository.save(farmerRegister);  
	}
	
	@Override
	public void update_farmer(FarmerMaster farmerMaster) 
	{
		farmerMasterRepository.save(farmerMaster);
	}
	
	@Override
	public FarmerMaster getFarmerDetailsById(int farmerId) 
	{
		
		return farmerMasterRepository.findById(farmerId).get();
	}
	
	@Override
	public void registerBuyerSeller(BuyerSellerMaster buyerSeller) 
	{
		buyerSellerRepository.save(buyerSeller);
	}
	
	@Override
	public void update_buyerSeller(BuyerSellerMaster buyerSellerMaster) 
	{
		buyerSellerRepository.save(buyerSellerMaster);
	}
}
