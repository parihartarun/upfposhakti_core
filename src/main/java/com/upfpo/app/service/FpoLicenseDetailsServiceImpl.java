package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.FpoLicenceDetails;
import com.upfpo.app.repository.FpoLicenseDetailsRepository;

@Service
public class FpoLicenseDetailsServiceImpl implements FpoLicenseDetailsService {

	
	@Autowired
	private FpoLicenseDetailsRepository fpoLicenseDetailsRepository; 
	
	@Override
	public FpoLicenceDetails insertFpoLicenceDetails(FpoLicenceDetails e) {
		// TODO Auto-generated method stub
		
		e.setDeleted(false);
		return fpoLicenseDetailsRepository.save(e);
	}

	@Override
	public FpoLicenceDetails updateFpoLicenceDetails(int id, FpoLicenceDetails e) {
		// TODO Auto-generated method stub
		e.setId(id);
		e.setDeleted(false);
		return fpoLicenseDetailsRepository.save(e);
	}

	@Override
	public FpoLicenceDetails insertOrUpdateFpoLicenceDetails(FpoLicenceDetails e) {
		// TODO Auto-generated method stub
		e.setDeleted(false);
		return fpoLicenseDetailsRepository.save(e);
	}

	@Override
	public boolean deleteFpoLicenceDetails(int id) {
		// TODO Auto-generated method stub
		try {
			FpoLicenceDetails fpoLicenceDetails = fpoLicenseDetailsRepository.getOne(id);
			fpoLicenceDetails.setDeleteDate(new java.sql.Date(new java.util.Date().getTime()));
			fpoLicenceDetails.setDeleted(true);
	          return true;
		}catch(Exception e){
		      return false;	
		}
		
		
	}

	@Override
	public List<FpoLicenceDetails> selectFpoLicenceDetails() {
		// TODO Auto-generated method stub
		return fpoLicenseDetailsRepository.findByIsDeleted(false);
	}

	@Override
	public FpoLicenceDetails selectFpoLicenceDetailsById(int id) {
		// TODO Auto-generated method stub
		try {
		return fpoLicenseDetailsRepository.getOne(id);
		}catch(Exception e)
		{
			throw new NotFoundException();
		}
		}



}
