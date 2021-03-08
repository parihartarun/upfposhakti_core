package com.upfpo.app.service;

import java.math.BigInteger;
import java.util.List;

import com.upfpo.app.entity.EnquiryInputSupplierFertilizer;
import com.upfpo.app.entity.EnquiryInputSupplierInsecticide;
import com.upfpo.app.entity.EnquiryInputSupplierMachinery;
import com.upfpo.app.entity.EnquiryInputSupplierSeed;

public interface InputSupplierEnquiryService 
{
	public List<EnquiryInputSupplierSeed> getSeedIndentMasterId(Integer masterId);
	
	public EnquiryInputSupplierSeed createSeedIndent(EnquiryInputSupplierSeed enquiryInputSupplierSeed);
	
	public EnquiryInputSupplierSeed updateSeedIndentStatus(EnquiryInputSupplierSeed enquiryInputSupplierSeed, BigInteger enqId);
	
	public List<EnquiryInputSupplierFertilizer> getFertilizerIndentByMasterId(Integer masterId);
	
	public EnquiryInputSupplierFertilizer createFertilizerIndent(EnquiryInputSupplierFertilizer enquiryInputSupplierFertilizer);
	
	public EnquiryInputSupplierFertilizer updateFertilizerIndentStatus(EnquiryInputSupplierFertilizer enquiryInputSupplierFertilizer, BigInteger enqId);
	
	public List<EnquiryInputSupplierMachinery> getMachineryIndentByMasterId(Integer masterId);
	
	public EnquiryInputSupplierMachinery createMachineryIndent(EnquiryInputSupplierMachinery enquiryInputSupplierMachinery);
	
	public EnquiryInputSupplierMachinery updateMachineryIndent(EnquiryInputSupplierMachinery enquiryInputSupplierMachinery, BigInteger enqId);
	
	public List<EnquiryInputSupplierInsecticide> getInsecticideIndentByMasterId(Integer masterId);
	
	public EnquiryInputSupplierInsecticide createInsecticide(EnquiryInputSupplierInsecticide enquiryInputSupplierInsecticide);
	
	public EnquiryInputSupplierInsecticide updateInsecticideIndent(EnquiryInputSupplierInsecticide enquiryInputSupplierInsecticide, BigInteger enqId);
}
