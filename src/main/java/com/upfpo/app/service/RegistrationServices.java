package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.*;

public interface RegistrationServices 
{
	public void registerFPO(FPORegister fpoRegister);
	public void registerFarmer(FarmerMaster farmerRegister);
	public void update_farmer(FarmerMaster farmerMaster);
	public FarmerMaster getFarmerDetailsById(int farmerId);
	public void registerBuyerSeller(BuyerSellerMaster buyerSeller);
	public void update_buyerSeller(BuyerSellerMaster buyerSellerMaster);
}
