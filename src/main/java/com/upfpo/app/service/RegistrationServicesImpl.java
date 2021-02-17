package com.upfpo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.BuyerSellerMaster;
import com.upfpo.app.entity.ChcFmbMaster;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.entity.InputSupplierMaster;
import com.upfpo.app.repository.BuyerSellerRepository;
import com.upfpo.app.repository.ChcFmbMasterRepository;
import com.upfpo.app.repository.FarmerMasterRepository;
import com.upfpo.app.repository.FpoMasterRepository;
import com.upfpo.app.repository.InputSupplierMasterRepository;

@Service
public class RegistrationServicesImpl implements RegistrationServices
{
	@Autowired
	FpoMasterRepository fpoRepository;
	
	@Autowired 
	FarmerMasterRepository farmerMasterRepository;
	
	@Autowired
	BuyerSellerRepository buyerSellerRepository;
	
	@Autowired
	InputSupplierMasterRepository inputSupplierRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	ChcFmbMasterRepository chcFmbRepository;
	
	int count = 0;
	
	String target = "";


	public int checkFPOExists(String email){
		return fpoRepository.alreadyExists(email);
	}
	
	@Override
	public int checkUserFpoExists(String userName) 
	{
		return fpoRepository.checkUserFpoExists(userName.toUpperCase());
	}
	
	@Override
	public int checkFarmerExists(long mobileNo) 
	{
		return farmerMasterRepository.alreadyExists(mobileNo);
	}
	
	@Override
	public int checkUserFarmerExists(String userName) 
	{
		return farmerMasterRepository.checkUserFarmerExists(userName.toUpperCase());
	}
	
	@Override
	public int checkBuyerSellerExists(long mobileNo) 
	{
		int ss= buyerSellerRepository.alreadyExists(mobileNo);
		System.err.println("Count::"+ss);
		return buyerSellerRepository.alreadyExists(mobileNo);
	}
	
	@Override
	public int checkUserBuyerSellerExists(String userName) 
	{
		return buyerSellerRepository.checkUserBuyerSellerExists(userName.toUpperCase());
	}
	
	@Override
	public int checkUserInputSupplierExists(String userName) 
	{
		return inputSupplierRepository.checkUserInputSupplierExists(userName.toUpperCase());
	}
	
	@Override
	public int checkInputSupplierExists(long mobileNo) 
	{
		return inputSupplierRepository.alreadyExists(mobileNo);
	}
	
	@Override
	public int checkUserChcFmbExists(String userName) 
	{
		return chcFmbRepository.checkUserChcFmbExists(userName.toUpperCase());
	}
	
	@Override
	public int checkChcFmbExists(long mobileNo) 
	{
		return chcFmbRepository.alreadyExists(mobileNo);
	}
	
	@Override
	public String registerFPO(FPORegister fpoRegister) 
	{
		String password = fpoRegister.getUserFpo().getPassword();
		fpoRegister.getUserFpo().setPassword(passwordEncoder.encode(password));
		fpoRegister.setUserName(fpoRegister.getUserFpo().getUserName());
		fpoRegister.getUserFpo().setRoleRefId("4");
		fpoRegister.setStateref(9);
		fpoRegister.getUserFpo().setEnabled(true);
		fpoRegister.setDeleted(false);
		count = fpoRepository.alreadyExists(fpoRegister.getFpoEmail());
		if(count==1)
		{
			  target="exists";
		}
		else
		{
			fpoRepository.save(fpoRegister);
			 target="Saved";
		}
		return target;
	}
	
	@Override
	public String registerFarmer(FarmerMaster farmerRegister) 
	{
		String password = farmerRegister.getUserFar().getPassword();
		farmerRegister.getUserFar().setPassword(passwordEncoder.encode(password));
		farmerRegister.getUserFar().setRoleRefId("6");
		farmerRegister.getUserFar().setEnabled(true);
		farmerRegister.setDeleted(false);
		count = farmerMasterRepository.alreadyExists(farmerRegister.getFarmerMob());
		if(count==1)
		{
			  target="exists";
		}
		else
		{
			 farmerMasterRepository.save(farmerRegister);
			 target="Saved";
		}
		return target;
	}

	@Override
	public String registerBuyerSeller(BuyerSellerMaster buyerSeller) 
	{
		String password = buyerSeller.getUserBuyerSeller().getPassword();
		buyerSeller.getUserBuyerSeller().setPassword(passwordEncoder.encode(password));
		buyerSeller.getUserBuyerSeller().setRoleRefId("2");
		buyerSeller.getUserBuyerSeller().setEnabled(true);
		buyerSeller.setDeleted(false);
		count = buyerSellerRepository.alreadyExists(buyerSeller.getMobileNumber());
		if(count==1)
		{
			  target="exists";
		}
		else
		{
			buyerSellerRepository.save(buyerSeller);
			 target="Saved";
		}
		return target;
	}
	
	
	@Override
	public String registerInputSuplier(InputSupplierMaster inputSupplierMaster) 
	{ 
		String password = inputSupplierMaster.getUserInputSeller().getPassword();
		inputSupplierMaster.getUserInputSeller().setPassword(passwordEncoder.encode(password));
		inputSupplierMaster.getUserInputSeller().setRoleRefId("3");
		inputSupplierMaster.getUserInputSeller().setEnabled(true);
		inputSupplierMaster.setDeleted(false);
		count = inputSupplierRepository.alreadyExists(inputSupplierMaster.getMobile_number());
		if(count==1)
		{
			  target="exists";
		}
		else
		{
			inputSupplierRepository.save(inputSupplierMaster);
			 target="Saved";
		}
		return target;
	}
	
	@Override
	public String registerChcFmb(ChcFmbMaster chcFmbMaster) 
	{
		String password = chcFmbMaster.getUser().getPassword();
		chcFmbMaster.getUser().setPassword(passwordEncoder.encode(password));
		chcFmbMaster.getUser().setRoleRefId("5");
		chcFmbMaster.getUser().setEnabled(true);
		chcFmbMaster.setDeleted(false);
		count = chcFmbRepository.alreadyExists(chcFmbMaster.getMobileNumber());
		if(count==1)
		{
			  target="exists";
		}
		else
		{
			chcFmbRepository.save(chcFmbMaster);
			 target="Saved";
		}
		return target;
	}
}
