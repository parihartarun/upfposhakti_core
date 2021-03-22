package com.upfpo.app.service;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.EnquiryChcFmbDTO;
import com.upfpo.app.dto.EnquiryFertilizerDTO;
import com.upfpo.app.dto.EnquiryInsecticideDTO;
import com.upfpo.app.dto.EnquirySeedDTO;
import com.upfpo.app.entity.EnquiryInputSupplierFertilizer;
import com.upfpo.app.entity.EnquiryInputSupplierInsecticide;
import com.upfpo.app.entity.EnquiryInputSupplierMachinery;
import com.upfpo.app.entity.EnquiryInputSupplierSeed;
import com.upfpo.app.repository.EnquiryInputSupplierFertilizerRepo;
import com.upfpo.app.repository.EnquiryInputSupplierInsecticideRepo;
import com.upfpo.app.repository.EnquiryInputSupplierMachineryRepo;
import com.upfpo.app.repository.EnquiryInputSupplierSeedRepository;
import com.upfpo.app.requestStrings.ReportRequestString;

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
	
	@Autowired
	EntityManager entityManager;
	
	
	@Override
	public List<EnquirySeedDTO> getSeedIndentMasterId(Integer masterId) 
	{
		String sql = "select e.enqid as enqId, e.created_by as createdBy, cm.crop_name as cropName, cv.crop_veriety as cropVeriety, e.status, e.indent_qty as indentQty, e.deliveryaddress\r\n"
				+ "				from enquiry_input_supplier_seed e\r\n"
				+ "				join crop_master cm on cm.id = e.crop_id\r\n"
				+ "				join crop_veriety_master cv on  cv.veriety_id = e.veriety_id\r\n"
				+ "				where e.master_id = :masterId order by e.enqid desc";
		List<EnquirySeedDTO> obj =  (List<EnquirySeedDTO>) entityManager.createNativeQuery(sql,"EnquirySeedDTO").setParameter("masterId", masterId).getResultList();
		return obj;
		//return enquiryInputSupplierSeedRepository.findByMasterIdOrderByEnqidDesc(masterId);
	}
	
	@Override
	public List<EnquirySeedDTO> getSeedIndentCreatedBy(ReportRequestString reportRequestString) 
	{
		String sql = "select e.enqid as enqId, e.created_by as createdBy, cm.crop_name as cropName, cv.crop_veriety as cropVeriety, e.status, e.indent_qty as indentQty, e.deliveryaddress\r\n"
				+ "				from enquiry_input_supplier_seed e\r\n"
				+ "				join crop_master cm on cm.id = e.crop_id\r\n"
				+ "				join crop_veriety_master cv on  cv.veriety_id = e.veriety_id\r\n"
				+ "				where e.created_by = :createdBy and e.role_ref_id = :roleId order by e.enqid desc";
		
		List<EnquirySeedDTO> obj =  (List<EnquirySeedDTO>) entityManager.createNativeQuery(sql,"EnquirySeedDTO").setParameter("createdBy", reportRequestString.getCreatedBy()).setParameter("roleId", reportRequestString.getRoleId()).
				getResultList();
		return obj;
		//return enquiryInputSupplierSeedRepository.findByCreatedByOrderByEnqidDesc(createdBy);
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
	public List<EnquiryFertilizerDTO> getFertilizerIndentByMasterId(Integer masterId) 
	{
		String sql = "select e.enqid as enqId, e.created_by as createdBy, cm.fertilizer_type as fertilizerType, cv.fertilizer_name as fertilizerName, e.status, e.indent_qty as indentQty, e.deliveryaddress\r\n"
				+ "				from enquiry_input_supplier_fertilizer e\r\n"
				+ "				join fertilizer_type_master cm on cm.id = e.fertilizer_type\r\n"
				+ "				join fertilizer_name_master cv on  cv.id = e.fertilizer_name\r\n"
				+ "				where e.master_id = :masterId  order by e.enqid desc";
		
		List<EnquiryFertilizerDTO> obj =  (List<EnquiryFertilizerDTO>) entityManager.createNativeQuery(sql,"EnquiryFertilizerDTO").setParameter("masterId", masterId).
				getResultList();
		return obj;
		//return enquiryInputSupplierFertilizerRepo.findByMasterIdOrderByEnqidDesc(masterId);
	}
	
	@Override
	public List<EnquiryFertilizerDTO> getFertilizerIndentCreatedBy(ReportRequestString reportRequestString) 
	{
		String sql = "select e.enqid as enqId, e.created_by as createdBy, cm.fertilizer_type as fertilizerType, cv.fertilizer_name as fertilizerName, e.status, e.indent_qty as indentQty, e.deliveryaddress\r\n"
				+ "				from enquiry_input_supplier_fertilizer e\r\n"
				+ "				join fertilizer_type_master cm on cm.id = e.fertilizer_type\r\n"
				+ "				join fertilizer_name_master cv on  cv.id = e.fertilizer_name\r\n"
				+ "				where e.created_by = :createdBy and e.role_ref_id = :roleId order by e.enqid desc";
		
		List<EnquiryFertilizerDTO> obj =  (List<EnquiryFertilizerDTO>) entityManager.createNativeQuery(sql,"EnquiryFertilizerDTO").setParameter("createdBy", reportRequestString.getCreatedBy()).setParameter("roleId", reportRequestString.getRoleId()).
				getResultList();
		return obj;
		//return enquiryInputSupplierFertilizerRepo.findByCreatedByAndRoleRefIdOrderByEnqidDesc(reportRequestString.getCreatedBy(), reportRequestString.getRoleId());
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
	public List<EnquiryChcFmbDTO> getIndentData(Integer masterId) 
	{
		String sql = "select e.enqid as enqId, e.created_by as createdBy, et.id as machineTypeId, et.type as equipType, em.id as machineId, em.equpment_name as equpmentName, e.status, e.indent_qty, e.deliveryaddress\r\n"
				+ "from enquiry_input_supplier_machinery e\r\n"
				+ "join equipment_type_master et on et.id = e.machinery_type_id\r\n"
				+ "join equip_master em on  em.id = e.machinery_name_id \r\n"
				+ "where e.master_id = :masterId";
	List<EnquiryChcFmbDTO> obj =  (List<EnquiryChcFmbDTO>) entityManager.createNativeQuery(sql,"EnquiryChcFmbDTO").setParameter("masterId", masterId).getResultList();
	return obj;
	}
	
	@Override
	public List<EnquiryChcFmbDTO> getIndentDataCreatedBy(ReportRequestString reportRequestString) 
	{
		String sql = "select e.enqid as enqId, e.created_by as createdBy, et.id as machineTypeId, et.type as equipType, em.id as machineId, em.equpment_name as equpmentName, e.status, e.indent_qty, e.deliveryaddress\r\n"
				+ "from enquiry_input_supplier_machinery e\r\n"
				+ "join equipment_type_master et on et.id = e.machinery_type_id\r\n"
				+ "join equip_master em on  em.id = e.machinery_name_id \r\n"
				+ "where e.created_by = :createdBy and e.role_ref_id = :roleId";
		List<EnquiryChcFmbDTO> obj =  (List<EnquiryChcFmbDTO>) entityManager.createNativeQuery(sql,"EnquiryChcFmbDTO").setParameter("createdBy", reportRequestString.getCreatedBy()).setParameter("roleId", reportRequestString.getRoleId()).
				getResultList();
		return obj;
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
	public List<EnquiryInsecticideDTO> getInsecticideIndentByMasterId(Integer masterId) 
	{
		String sql = "select e.enqid as enqId, e.created_by as createdBy, cm.insecticide_type as insecticideType, e.manufacturer_name as manufacturerName, e.status, e.indent_qty as indentQty, e.deliveryaddress\r\n"
				+ "				from enquiry_input_supplier_insecticide e\r\n"
				+ "				join insecticide_type_master cm on cm.id = e.insecticide_type_id\r\n"
				+ "				where e.master_id = :masterId order by e.enqid desc";
		List<EnquiryInsecticideDTO> obj =  (List<EnquiryInsecticideDTO>) entityManager.createNativeQuery(sql,"EnquiryInsecticideDTO").setParameter("masterId", masterId).getResultList();
		return obj;
		//return enquiryInputSupplierInsecticideRepo.findByMasterId(masterId);
	}
	
	@Override
	public List<EnquiryInsecticideDTO> getInsecticideIndentCreatedBy(ReportRequestString reportRequestString) 
	{
		String sql = "select e.enqid as enqId, e.created_by as createdBy, cm.insecticide_type as insecticideType, e.manufacturer_name as manufacturerName, e.status, e.indent_qty as indentQty, e.deliveryaddress\r\n"
				+ "				from enquiry_input_supplier_insecticide e\r\n"
				+ "				join insecticide_type_master cm on cm.id = e.insecticide_type_id\r\n"
				+ "				where e.created_by = :createdBy and e.role_ref_id = :roleId order by e.enqid desc";
		List<EnquiryInsecticideDTO> obj =  (List<EnquiryInsecticideDTO>) entityManager.createNativeQuery(sql,"EnquiryInsecticideDTO").setParameter("createdBy", reportRequestString.getCreatedBy()).setParameter("roleId", reportRequestString.getRoleId())
				.getResultList();
		return obj;
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
