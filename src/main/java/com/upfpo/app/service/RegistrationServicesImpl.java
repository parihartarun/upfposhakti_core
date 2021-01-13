package com.upfpo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.*;
import com.upfpo.app.repository.BuyerSellerRepository;
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
	
	@Override
	public void registerInputSuplier(InputSupplierMaster inputSupplierMaster) 
	{
		inputSupplierRepository.save(inputSupplierMaster);	
	}
	
	@Override
	public void update_inputSupplier(InputSupplierMaster inputSupplierMaster)
	{
		inputSupplierRepository.save(inputSupplierMaster);
	}
	
	@Override
	public List<InputSupplierMaster> getInputSupplierDetails() 
	{
		List<InputSupplierMaster> inputSupplierList = new ArrayList<InputSupplierMaster>();
	    inputSupplierRepository.findAll().forEach(inputSupplierList1->inputSupplierList.add(inputSupplierList1));
	    return inputSupplierList;
	}
	
	@Override
	public void deleteInputSupplier(int inputSupplierId) 
	{
		inputSupplierRepository.deleteInputSupplier(inputSupplierId);
	}
}
