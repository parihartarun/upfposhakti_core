package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.AgencyMaster;
import com.upfpo.app.entity.BlockMaster;
import com.upfpo.app.entity.FpoLicenceDetails;
import com.upfpo.app.repository.AgencyMasterRepository;
import com.upfpo.app.repository.BlockMasterRepository;

@Service
public class AgencyMasterServiceImpl implements AgencyMasterService
{
	@Autowired
	AgencyMasterRepository agencyMasterRepository;
	
	@Override
	public AgencyMaster insertAgencyMaster(AgencyMaster e) {
		// TODO Auto-generated method stub
		
		e.setDeleted(false);
		return agencyMasterRepository.save(e);
	}

	@Override
	public AgencyMaster updateAgencyMaster(int id, AgencyMaster agencyMaster) {
		// TODO Auto-generated method stub
		
		Optional<AgencyMaster> oldAgencyMaster = agencyMasterRepository.findById(id);
		if(oldAgencyMaster.isPresent())
		{
			AgencyMaster newAgencyMaster = oldAgencyMaster.get();
			//newfboLicense.setId(fpoLicenceDetails.getId());
			newAgencyMaster.setActive(agencyMaster.isActive());
			newAgencyMaster.setFpo(agencyMaster.isFpo());
			newAgencyMaster.setAgencyName(agencyMaster.getAgencyName());
		
			
			
			newAgencyMaster.setDeleteDate(new java.sql.Date(new java.util.Date().getTime()));
			newAgencyMaster.setDeleted(false);
			newAgencyMaster = agencyMasterRepository.save(newAgencyMaster);
			return newAgencyMaster;
		}
		else
		{
			AgencyMaster newAgencyMaster = agencyMasterRepository.save(agencyMaster);
			return newAgencyMaster;
		}
	}

	@Override
	public AgencyMaster insertOrUpdateAgencyMaster(AgencyMaster e) {
		// TODO Auto-generated method stub
		e.setDeleted(false);
		return agencyMasterRepository.save(e);
	}

	@Override
	public boolean deleteAgencyMaster(int id) {
		// TODO Auto-generated method stub
		try {
			AgencyMaster agencyMaster = agencyMasterRepository.getOne(id);
			agencyMaster.setDeleteDate(new java.sql.Date(new java.util.Date().getTime()));
			agencyMaster.setDeleted(true);
			agencyMasterRepository.save(agencyMaster);
	          return true;
		}catch(Exception e){
		      return false;	
		}
		
		
	}

	@Override
	public List<AgencyMaster> selectAgencyMaster() {
		// TODO Auto-generated method stub
		return agencyMasterRepository.findByIsDeleted(false);
	}

//	@Override
//	public FpoLicenceDetails selectFpoLicenceDetailsById(int id) {
//		// TODO Auto-generated method stub
//		try {
//		return fpoLicenseDetailsRepository.getOne(id);
//		}catch(Exception e)
//		{
//			throw new NotFoundException();
//		}
//		}
	
	@Override
	public AgencyMaster selectAgencyMasterById(int id) {
		{
			return agencyMasterRepository.findById(id).get();
		}
	}

}
