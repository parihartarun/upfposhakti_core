package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.*;

public interface RegistrationServices 
{
	public String registerFPO(FPORegister fpoRegister);
	public String registerFarmer(FarmerMaster farmerRegister);
	public String registerBuyerSeller(BuyerSellerMaster buyerSeller);
	public String registerInputSuplier(InputSupplierMaster inputSupplierMaster);
	public String registerChcFmb(ChcFmbMaster chcFmbMaster);
}
