package com.upfpo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void registerFPO(FPORegister fpoRegister) 
	{
		fpoRepository.save(fpoRegister);
	}
	
	@Override
	public FarmerMaster registerFarmer(FarmerMaster farmerRegister) 
	{
		return farmerMasterRepository.save(farmerRegister);  
	}
	
	
	@Override
	public BuyerSellerMaster registerBuyerSeller(BuyerSellerMaster buyerSeller) 
	{
		return buyerSellerRepository.save(buyerSeller);
	}
	
	
	@Override
	public InputSupplierMaster registerInputSuplier(InputSupplierMaster inputSupplierMaster) 
	{
		return inputSupplierRepository.save(inputSupplierMaster);	
	}
	
	@Override
	public ChcFmbMaster registerChcFmb(ChcFmbMaster chcFmbMaster) 
	{
		return chcFmbRepository.save(chcFmbMaster);
	}
}
