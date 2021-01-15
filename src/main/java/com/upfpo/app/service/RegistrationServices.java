package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.*;

public interface RegistrationServices 
{
	public void registerFPO(FPORegister fpoRegister);
	public FarmerMaster registerFarmer(FarmerMaster farmerRegister);
	public BuyerSellerMaster registerBuyerSeller(BuyerSellerMaster buyerSeller);
	public InputSupplierMaster registerInputSuplier(InputSupplierMaster inputSupplierMaster);
	public ChcFmbMaster registerChcFmb(ChcFmbMaster chcFmbMaster);
}
