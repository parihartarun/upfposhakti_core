package com.upfpo.app.service;

import java.math.BigInteger;
import java.util.List;

import com.upfpo.app.dto.EnquiryChcFmbDTO;
import com.upfpo.app.entity.EnquiryChcFmbMachinery;

public interface ChcFmbEnquiryService 
{
	public EnquiryChcFmbMachinery createMachineryIndent(EnquiryChcFmbMachinery enquiryChcFmbMachinery);
	
	public EnquiryChcFmbMachinery updateMachineryStatus(EnquiryChcFmbMachinery enquiryChcFmbMachinery, BigInteger enqid);
	
	public List<EnquiryChcFmbDTO> getMachineryData(Integer masterId);
	
	public List<EnquiryChcFmbMachinery> getMachineryDatad(Integer masterId);
}
