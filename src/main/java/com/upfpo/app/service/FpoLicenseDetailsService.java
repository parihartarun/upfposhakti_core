package com.upfpo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upfpo.app.entity.FpoLicenceDetails;

@Service
public interface FpoLicenseDetailsService {
	public FpoLicenceDetails insertFpoLicenceDetails(FpoLicenceDetails e);
	public FpoLicenceDetails updateFpoLicenceDetails(int id,FpoLicenceDetails e);
	public FpoLicenceDetails insertOrUpdateFpoLicenceDetails(FpoLicenceDetails e);
	public boolean deleteFpoLicenceDetails(int id);	
	public List<FpoLicenceDetails> selectFpoLicenceDetails();
	public FpoLicenceDetails selectFpoLicenceDetailsById(int id);
	public List<FpoLicenceDetails> getFpoLicenceDetailsByFpo(Integer masterId);

}
