package com.upfpo.app.service;

import java.math.BigInteger;

import com.upfpo.app.entity.EnquiryInputSupplierFertilizer;
import com.upfpo.app.entity.EnquiryInputSupplierMachinery;
import com.upfpo.app.entity.EnquiryInputSupplierSeed;

public interface InputSupplierEnquiryService 
{
	public EnquiryInputSupplierSeed createSeedIndent(EnquiryInputSupplierSeed enquiryInputSupplierSeed);
	
	public EnquiryInputSupplierSeed updateSeedIndentStatus(EnquiryInputSupplierSeed enquiryInputSupplierSeed, BigInteger enqId);
	
	public EnquiryInputSupplierFertilizer createFertilizerIndent(EnquiryInputSupplierFertilizer enquiryInputSupplierFertilizer);
	
	public EnquiryInputSupplierFertilizer updateFertilizerIndentStatus(EnquiryInputSupplierFertilizer enquiryInputSupplierFertilizer, BigInteger enqId);
	
	public EnquiryInputSupplierMachinery createMachineryIndent(EnquiryInputSupplierMachinery enquiryInputSupplierMachinery);
	
	public EnquiryInputSupplierMachinery updateMachineryIndent(EnquiryInputSupplierMachinery enquiryInputSupplierMachinery, BigInteger enqId);
}
