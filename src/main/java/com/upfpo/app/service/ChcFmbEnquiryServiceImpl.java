package com.upfpo.app.service;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.EnquiryChcFmbMachinery;
import com.upfpo.app.entity.EnquiryInputSupplierFertilizer;
import com.upfpo.app.repository.EnquiryChcFmbMachineryRepo;

@Service
public class ChcFmbEnquiryServiceImpl implements ChcFmbEnquiryService
{
	@Autowired
	EnquiryChcFmbMachineryRepo enquiryChcFmbMachineryRepo;
	
	@Override
	public EnquiryChcFmbMachinery createMachineryIndent(EnquiryChcFmbMachinery enquiryChcFmbMachinery) 
	{
		enquiryChcFmbMachinery.setCreateDateTime(Calendar.getInstance());
		enquiryChcFmbMachinery.setStatus("Active");
		return enquiryChcFmbMachineryRepo.save(enquiryChcFmbMachinery);
	}
	
	@Override
	public EnquiryChcFmbMachinery updateMachineryStatus(EnquiryChcFmbMachinery enquiryChcFmbMachinery, BigInteger enqid) 
	{
		Optional<EnquiryChcFmbMachinery> machineryDetails = enquiryChcFmbMachineryRepo.findById(enqid);
		if(machineryDetails.isPresent())
		{
			EnquiryChcFmbMachinery newMachineryDetails = machineryDetails.get();
			if(enquiryChcFmbMachinery.getStatus()=="Rejected")
			{
				newMachineryDetails.setFulfilledQty(0.0);
			}
			else
			{
				newMachineryDetails.setFulfilledQty(enquiryChcFmbMachinery.getFulfilledQty());
			}
			newMachineryDetails.setStatus(enquiryChcFmbMachinery.getStatus());
			newMachineryDetails.setFulfillmentDate(Calendar.getInstance());
			
			newMachineryDetails = enquiryChcFmbMachineryRepo.save(newMachineryDetails);
			return newMachineryDetails;
		}
		else
		{
			enquiryChcFmbMachinery = enquiryChcFmbMachineryRepo.save(enquiryChcFmbMachinery);
			return enquiryChcFmbMachinery;
		}
	}
	
	@Override
	public List<EnquiryChcFmbMachinery> getMachineryData() 
	{
		return enquiryChcFmbMachineryRepo.getChcFmbMachineryData();
	}
}
