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
	public int checkUserFpoExists(String userName);
	public String registerFarmer(FarmerMaster farmerRegister);
	public int checkUserFarmerExists(String userName);
	public String registerBuyerSeller(BuyerSellerMaster buyerSeller);
	public int checkBuyerSellerExists(long mobileNo);
	public int checkUserBuyerSellerExists(String userName);
	public String registerInputSuplier(InputSupplierMaster inputSupplierMaster);
	public int checkUserInputSupplierExists(String userName);
	public String registerChcFmb(ChcFmbMaster chcFmbMaster);
	public int checkUserChcFmbExists(String userName) ;
}
