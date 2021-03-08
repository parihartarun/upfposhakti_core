package com.upfpo.app.service;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.EnquiryInputSupplierFertilizer;
import com.upfpo.app.entity.EnquiryInputSupplierInsecticide;
import com.upfpo.app.entity.EnquiryInputSupplierMachinery;
import com.upfpo.app.entity.EnquiryInputSupplierSeed;
import com.upfpo.app.repository.EnquiryInputSupplierFertilizerRepo;
import com.upfpo.app.repository.EnquiryInputSupplierInsecticideRepo;
import com.upfpo.app.repository.EnquiryInputSupplierMachineryRepo;
import com.upfpo.app.repository.EnquiryInputSupplierSeedRepository;

@Service
public class InputSupplierEnquiryServiceImpl implements InputSupplierEnquiryService
{
	@Autowired
	EnquiryInputSupplierSeedRepository enquiryInputSupplierSeedRepository;
	
	@Autowired
	EnquiryInputSupplierFertilizerRepo enquiryInputSupplierFertilizerRepo;
	
	@Autowired
	EnquiryInputSupplierMachineryRepo enquiryInputSupplierMachineryRepo;
	
	@Autowired
	EnquiryInputSupplierInsecticideRepo enquiryInputSupplierInsecticideRepo;
	
	
	@Override
	public List<EnquiryInputSupplierSeed> getSeedIndentMasterId(Integer masterId) 
	{
		return enquiryInputSupplierSeedRepository.findByMasterId(masterId);
	}
	
	@Override
	public EnquiryInputSupplierSeed createSeedIndent(EnquiryInputSupplierSeed enquiryInputSupplierSeed) 
	{
		return enquiryInputSupplierSeedRepository.save(enquiryInputSupplierSeed);
	}
	
	@Override
	public EnquiryInputSupplierSeed updateSeedIndentStatus(EnquiryInputSupplierSeed enquiryInputSupplierSeed, BigInteger enqId) 
	{
		Optional<EnquiryInputSupplierSeed> seedDetails = enquiryInputSupplierSeedRepository.findById(enqId);
		if(seedDetails.isPresent())
		{
			EnquiryInputSupplierSeed newSeedDetails = seedDetails.get();
			if(enquiryInputSupplierSeed.getStatus()=="Rejected")
			{
				newSeedDetails.setFulfilledQty(0.0);
			}
			else
			{
				newSeedDetails.setFulfilledQty(enquiryInputSupplierSeed.getFulfilledQty());
			}
			newSeedDetails.setStatus(enquiryInputSupplierSeed.getStatus());
			newSeedDetails.setFulfillmentDate(enquiryInputSupplierSeed.getFulfillmentDate());
			
			newSeedDetails = enquiryInputSupplierSeedRepository.save(newSeedDetails);
			return newSeedDetails;
		}
		else
		{
			enquiryInputSupplierSeed = enquiryInputSupplierSeedRepository.save(enquiryInputSupplierSeed);
			return enquiryInputSupplierSeed;
		}
	}
	
	@Override
	public List<EnquiryInputSupplierFertilizer> getFertilizerIndentByMasterId(Integer masterId) 
	{
		return enquiryInputSupplierFertilizerRepo.findByMasterId(masterId);
	}
	
	@Override
	public EnquiryInputSupplierFertilizer createFertilizerIndent(EnquiryInputSupplierFertilizer enquiryInputSupplierFertilizer) 
	{
		enquiryInputSupplierFertilizer.setCreateDateTime(Calendar.getInstance());
		return enquiryInputSupplierFertilizerRepo.save(enquiryInputSupplierFertilizer);
	}
	
	@Override
	public EnquiryInputSupplierFertilizer updateFertilizerIndentStatus(EnquiryInputSupplierFertilizer enquiryInputSupplierFertilizer, BigInteger enqId) 
	{
		Optional<EnquiryInputSupplierFertilizer> fertilzerDetails = enquiryInputSupplierFertilizerRepo.findById(enqId);
		if(fertilzerDetails.isPresent())
		{
			EnquiryInputSupplierFertilizer newFertilizerDetails = fertilzerDetails.get();
			if(enquiryInputSupplierFertilizer.getStatus()=="Rejected")
			{
				newFertilizerDetails.setFulfilledQty(0.0);
			}
			else
			{
				newFertilizerDetails.setFulfilledQty(enquiryInputSupplierFertilizer.getFulfilledQty());
			}
			newFertilizerDetails.setStatus(enquiryInputSupplierFertilizer.getStatus());
			newFertilizerDetails.setFulfillmentDate(Calendar.getInstance());
			
			newFertilizerDetails = enquiryInputSupplierFertilizerRepo.save(newFertilizerDetails);
			return newFertilizerDetails;
		}
		else
		{
			enquiryInputSupplierFertilizer = enquiryInputSupplierFertilizerRepo.save(enquiryInputSupplierFertilizer);
			return enquiryInputSupplierFertilizer;
		}
	}
	
	@Override
	public List<EnquiryInputSupplierMachinery> getMachineryIndentByMasterId(Integer masterId) 
	{
		return enquiryInputSupplierMachineryRepo.findByMasterId(masterId);
	}
	
	@Override
	public EnquiryInputSupplierMachinery createMachineryIndent(EnquiryInputSupplierMachinery enquiryInputSupplierMachinery) 
	{
		enquiryInputSupplierMachinery.setCreateDateTime(Calendar.getInstance());
		return enquiryInputSupplierMachineryRepo.save(enquiryInputSupplierMachinery);
	}
	
	@Override
	public EnquiryInputSupplierMachinery updateMachineryIndent(EnquiryInputSupplierMachinery enquiryInputSupplierMachinery, BigInteger enqId) 
	{
		Optional<EnquiryInputSupplierMachinery> machineryDetails = enquiryInputSupplierMachineryRepo.findById(enqId);
		if(machineryDetails.isPresent())
		{
			EnquiryInputSupplierMachinery newMachineryDetails = machineryDetails.get();
			if(enquiryInputSupplierMachinery.getStatus()=="Rejected")
			{
				newMachineryDetails.setFulfilledQty(0.0);
			}
			else
			{
				newMachineryDetails.setFulfilledQty(enquiryInputSupplierMachinery.getFulfilledQty());
			}
			newMachineryDetails.setStatus(enquiryInputSupplierMachinery.getStatus());
			newMachineryDetails.setFulfillmentDate(Calendar.getInstance());
			
			newMachineryDetails = enquiryInputSupplierMachineryRepo.save(newMachineryDetails);
			return newMachineryDetails;
		}
		else
		{
			enquiryInputSupplierMachinery = enquiryInputSupplierMachineryRepo.save(enquiryInputSupplierMachinery);
			return enquiryInputSupplierMachinery;
		}
	}
	
	@Override
	public List<EnquiryInputSupplierInsecticide> getInsecticideIndentByMasterId(Integer masterId) 
	{
		return enquiryInputSupplierInsecticideRepo.findByMasterId(masterId);
	}
	
	@Override
	public EnquiryInputSupplierInsecticide createInsecticide(EnquiryInputSupplierInsecticide enquiryInputSupplierInsecticide) 
	{
		enquiryInputSupplierInsecticide.setCreateDateTime(Calendar.getInstance());
		return enquiryInputSupplierInsecticideRepo.save(enquiryInputSupplierInsecticide);
	}
	
	@Override
	public EnquiryInputSupplierInsecticide updateInsecticideIndent(EnquiryInputSupplierInsecticide enquiryInputSupplierInsecticide, BigInteger enqId) 
	{
		Optional<EnquiryInputSupplierInsecticide> insecticideDetails = enquiryInputSupplierInsecticideRepo.findById(enqId);
		if(insecticideDetails.isPresent())
		{
			EnquiryInputSupplierInsecticide newInsecticideDetails = insecticideDetails.get();
			if(enquiryInputSupplierInsecticide.getStatus()=="Rejected")
			{
				newInsecticideDetails.setFulfilledQty(0.0);
			}
			else
			{
				newInsecticideDetails.setFulfilledQty(enquiryInputSupplierInsecticide.getFulfilledQty());
			}
			newInsecticideDetails.setStatus(enquiryInputSupplierInsecticide.getStatus());
			newInsecticideDetails.setFulfillmentDate(Calendar.getInstance());
			
			newInsecticideDetails = enquiryInputSupplierInsecticideRepo.save(newInsecticideDetails);
			return newInsecticideDetails;
		}
		else
		{
			enquiryInputSupplierInsecticide = enquiryInputSupplierInsecticideRepo.save(enquiryInputSupplierInsecticide);
			return enquiryInputSupplierInsecticide;
		}
	}
	
}
