package com.upfpo.app.service;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.CropListOfFarmersDTO;
import com.upfpo.app.dto.EnquiryChcFmbDTO;
import com.upfpo.app.entity.EnquiryChcFmbMachinery;
import com.upfpo.app.repository.EnquiryChcFmbMachineryRepo;

@Service
public class ChcFmbEnquiryServiceImpl implements ChcFmbEnquiryService
{
	@Autowired
	EnquiryChcFmbMachineryRepo enquiryChcFmbMachineryRepo;
	
	@Autowired
	EntityManager entityManager;
	
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
	public List<EnquiryChcFmbDTO> getMachineryData(Integer masterId) 
	{
		String sql = "select e.enqid as enqId, e.created_by as createdBy, et.id as machineTypeId, et.type as equipType, em.id as machineId, em.equpment_name as equpmentName, e.status, e.indent_qty, e.deliveryaddress\r\n"
				+ "from enquiry_chc_fmb_machinery e\r\n"
				+ "join equipment_type_master et on et.id = e.machinery_type_id\r\n"
				+ "join equip_master em on  em.id = e.machinery_name_id \r\n"
				+ "where e.master_id = :masterId";
	List<EnquiryChcFmbDTO> obj =  (List<EnquiryChcFmbDTO>) entityManager.createNativeQuery(sql,"EnquiryChcFmbDTO").setParameter("masterId", masterId).getResultList();
	return obj;
	//return enquiryChcFmbMachineryRepo.getChcFmbMachineryDatad(masterId);
	}
	
	@Override
	public List<EnquiryChcFmbMachinery> getMachineryDatad(Integer masterId) 
	{
		return enquiryChcFmbMachineryRepo.findByMasterId(masterId);
	}
}
