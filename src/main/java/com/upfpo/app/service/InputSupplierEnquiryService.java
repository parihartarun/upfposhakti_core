package com.upfpo.app.service;

import java.math.BigInteger;
import java.util.List;

import com.upfpo.app.dto.EnquiryChcFmbDTO;
import com.upfpo.app.dto.EnquiryFertilizerDTO;
import com.upfpo.app.dto.EnquiryInsecticideDTO;
import com.upfpo.app.dto.EnquirySeedDTO;
import com.upfpo.app.dto.InputSupplierDashBoardIndentSeedDTO;
import com.upfpo.app.dto.InputSupplierDashboardIndentDTO;
import com.upfpo.app.entity.EnquiryInputSupplierFertilizer;
import com.upfpo.app.entity.EnquiryInputSupplierInsecticide;
import com.upfpo.app.entity.EnquiryInputSupplierMachinery;
import com.upfpo.app.entity.EnquiryInputSupplierSeed;
import com.upfpo.app.requestStrings.ReportRequestString;

public interface InputSupplierEnquiryService 
{
	public List<EnquirySeedDTO> getSeedIndentMasterId(Integer masterId);
	
	public List<EnquirySeedDTO> getSeedIndentCreatedBy(ReportRequestString reportRequestString);
	
	public InputSupplierDashboardIndentDTO getFulfillment(ReportRequestString reportRequestString);
	
	public InputSupplierDashboardIndentDTO getRaised(ReportRequestString reportRequestString);
	
	public EnquiryInputSupplierSeed createSeedIndent(EnquiryInputSupplierSeed enquiryInputSupplierSeed);
	
	public EnquiryInputSupplierSeed updateSeedIndentStatus(EnquiryInputSupplierSeed enquiryInputSupplierSeed, BigInteger enqId);
	
	public List<EnquiryFertilizerDTO> getFertilizerIndentByMasterId(Integer masterId);
	
	public List<EnquiryFertilizerDTO> getFertilizerIndentCreatedBy(ReportRequestString reportRequestString);
	
	public EnquiryInputSupplierFertilizer createFertilizerIndent(EnquiryInputSupplierFertilizer enquiryInputSupplierFertilizer);
	
	public EnquiryInputSupplierFertilizer updateFertilizerIndentStatus(EnquiryInputSupplierFertilizer enquiryInputSupplierFertilizer, BigInteger enqId);
	
	public List<EnquiryInputSupplierMachinery> getMachineryIndentByMasterId(Integer masterId);
	
	public List<EnquiryChcFmbDTO> getIndentData(Integer masterId);
	
	public List<EnquiryChcFmbDTO> getIndentDataCreatedBy(ReportRequestString reportRequestString);
	
	public EnquiryInputSupplierMachinery createMachineryIndent(EnquiryInputSupplierMachinery enquiryInputSupplierMachinery);
	
	public EnquiryInputSupplierMachinery updateMachineryIndent(EnquiryInputSupplierMachinery enquiryInputSupplierMachinery, BigInteger enqId);
	
	public List<EnquiryInsecticideDTO> getInsecticideIndentByMasterId(Integer masterId);
	
	public List<EnquiryInsecticideDTO> getInsecticideIndentCreatedBy(ReportRequestString reportRequestString);
	
	public EnquiryInputSupplierInsecticide createInsecticide(EnquiryInputSupplierInsecticide enquiryInputSupplierInsecticide);
	
	public EnquiryInputSupplierInsecticide updateInsecticideIndent(EnquiryInputSupplierInsecticide enquiryInputSupplierInsecticide, BigInteger enqId);
}
