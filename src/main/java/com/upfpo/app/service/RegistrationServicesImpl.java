package com.upfpo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.*;
import com.upfpo.app.repository.BuyerSellerRepository;
import com.upfpo.app.repository.ChcFmbMasterRepository;
import com.upfpo.app.repository.FarmerMasterRepository;
import com.upfpo.app.repository.FpoMasterRepository;
import com.upfpo.app.repository.InputSupplierMasterRepository;

import java.util.ArrayList;
import java.util.List;
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
	
	@Autowired
	InputSupplierMasterRepository inputSupplierRepository;
	
	@Autowired
	ChcFmbMasterRepository chcFmbRepository;
	
	@Override
	public String registerFPO(FPORegister fpoRegister) 
	{
		int count = fpoRepository.alreadyExists(fpoRegister.getFpoEmail());
		String target = "";
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
		int count = farmerMasterRepository.alreadyExists(farmerRegister.getFarmerMob());
		String target = "";
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
		int count = buyerSellerRepository.alreadyExists(buyerSeller.getMobileNumber());
		String target = "";
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
		int count = inputSupplierRepository.alreadyExists(inputSupplierMaster.getMobile_number());
		String target = "";
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
		int count = chcFmbRepository.alreadyExists(chcFmbMaster.getMobileNumber());
		String target = "";
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
