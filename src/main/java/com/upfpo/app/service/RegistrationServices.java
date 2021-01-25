package com.upfpo.app.service;

import com.upfpo.app.entity.BuyerSellerMaster;
import com.upfpo.app.entity.ChcFmbMaster;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.entity.InputSupplierMaster;

public interface RegistrationServices 
{
	public String registerFPO(FPORegister fpoRegister);
	public int checkFPOExists(String email);
	public String registerFarmer(FarmerMaster farmerRegister);
	public String registerBuyerSeller(BuyerSellerMaster buyerSeller);
	public int checkBuyerSellerExists(long mobileNo);
	public String registerInputSuplier(InputSupplierMaster inputSupplierMaster);
	public String registerChcFmb(ChcFmbMaster chcFmbMaster);
}
