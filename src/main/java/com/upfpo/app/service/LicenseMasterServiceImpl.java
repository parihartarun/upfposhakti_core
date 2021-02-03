package com.upfpo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.BuyerSellerMaster;
import com.upfpo.app.entity.FarmMachineryBank;
import com.upfpo.app.entity.LicenseMaster;
import com.upfpo.app.repository.LicenseMasterRepository;

@Service
public class LicenseMasterServiceImpl implements LicenseMasterService {

	
	@Autowired
	private LicenseMasterRepository licenseMasterRepository; 
	
	@Override
	public LicenseMaster insertLicenseMaster(LicenseMaster e) {
		// TODO Auto-generated method stub
		
		e.setDeleted(false);
		return licenseMasterRepository.save(e);
	}

	@Override
	public LicenseMaster updateLicenseMaster(int id, LicenseMaster licenseMaster) {
		// TODO Auto-generated method stub
		
		Optional<LicenseMaster> license = licenseMasterRepository.findById(id);
		if(license.isPresent())
		{
			LicenseMaster newLicense = license.get();
			newLicense.setId(licenseMaster.getId());
			newLicense.setLicenseName(licenseMaster.getLicenseName());
			newLicense.setDeleted(false);
			newLicense = licenseMasterRepository.save(newLicense);
			return newLicense;
		}
		else
		{
			licenseMaster = licenseMasterRepository.save(licenseMaster);
			return licenseMaster;
		}
	}
	

	@Override
	public LicenseMaster insertOrUpdateLicenseMaster(LicenseMaster e) {
		// TODO Auto-generated method stub
		e.setDeleted(false);
		return licenseMasterRepository.save(e);
	}

	@Override
	public boolean deleteLicenseMaster(int id) {
		// TODO Auto-generated method stub
		try {
			LicenseMaster licenseMaster = licenseMasterRepository.getOne(id);
			licenseMaster.setDeleteDate(new java.sql.Date(new java.util.Date().getTime()));
			licenseMaster.setDeleted(true);
			licenseMasterRepository.save(licenseMaster);
	          return true;
		}catch(Exception e){
		      return false;	
		}
		
		
	}

	@Override
	public List<LicenseMaster> selectLicenseMaster() {
		// TODO Auto-generated method stub
		return licenseMasterRepository.findByIsDeletedOrderByIdDesc(false);
	}

//	@Override
//	public LicenseMaster selectLicenseMasterById(int id) {
//		// TODO Auto-generated method stub
//		try {
//		return licenseMasterRepository.getOne(id);
//		}catch(Exception e)
//		{
//			throw new NotFoundException();
//		}
//		}
	
	@Override
	public LicenseMaster selectLicenseMasterById(int id) {
		{
			return licenseMasterRepository.findById(id).get();
		}
	}



}
