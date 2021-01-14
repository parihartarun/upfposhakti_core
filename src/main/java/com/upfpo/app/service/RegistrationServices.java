package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.*;

public interface RegistrationServices 
{
	public void registerFPO(FPORegister fpoRegister);
	public void registerFarmer(FarmerMaster farmerRegister);
	public void registerBuyerSeller(BuyerSellerMaster buyerSeller);
	public void registerInputSuplier(InputSupplierMaster inputSupplierMaster);
	public void registerChcFmb(ChcFmbMaster chcFmbMaster);
}
