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
}
