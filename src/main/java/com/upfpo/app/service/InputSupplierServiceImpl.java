package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.InputSupplierMaster;
import com.upfpo.app.repository.InputSupplierMasterRepository;

@Service
public class InputSupplierServiceImpl implements InputSupplierService
{
	@Autowired
	InputSupplierMasterRepository inputSupplierRepository;
	
	@Override
	public InputSupplierMaster updateInputSupplier(InputSupplierMaster inputSupplierMaster,int inputSupplierId)
	{
		Optional<InputSupplierMaster> inputSupplier = inputSupplierRepository.findById(inputSupplierId);
		if(inputSupplier.isPresent())
		{
			InputSupplierMaster newInputSupplier = inputSupplier.get();
			newInputSupplier.setInputSupplierName(inputSupplierMaster.getInputSupplierName());
			newInputSupplier.setBlockRefId(inputSupplierMaster.getBlockRefId());
			newInputSupplier.setCategoryDeal(inputSupplierMaster.getCategoryDeal());
			newInputSupplier.setContact_person(inputSupplierMaster.getContact_person());
			newInputSupplier.setLicense_number(inputSupplierMaster.getLicense_number());
			newInputSupplier.setEmail(inputSupplierMaster.getEmail());
			newInputSupplier.setDistRefId(inputSupplierMaster.getDistRefId());
			newInputSupplier.setGstNumber(inputSupplierMaster.getGstNumber());
			newInputSupplier.setMobile_number(inputSupplierMaster.getMobile_number());
			newInputSupplier.setPincode(inputSupplierMaster.getPincode());
			newInputSupplier.setVillageRefId(inputSupplierMaster.getVillageRefId());
			newInputSupplier.setInputSupplierType(inputSupplierMaster.getInputSupplierType());
			
			newInputSupplier = inputSupplierRepository.save(newInputSupplier);
			return newInputSupplier;
		}
		else
		{
			inputSupplierMaster = inputSupplierRepository.save(inputSupplierMaster);
			return inputSupplierMaster;
		}
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

	@Override
	public InputSupplierMaster selectInputSupplierById(Integer inputSupplierId) {
		return inputSupplierRepository.findById(inputSupplierId).get();
	}
}
