package com.upfpo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upfpo.app.entity.LicenseMaster;

@Service
public interface LicenseMasterService {
	public LicenseMaster insertLicenseMaster(LicenseMaster e);
	public LicenseMaster updateLicenseMaster(int id,LicenseMaster e);
	public LicenseMaster insertOrUpdateLicenseMaster(LicenseMaster e);
	public boolean deleteLicenseMaster(int id);	
	public List<LicenseMaster> selectLicenseMaster();
	public LicenseMaster selectLicenseMasterById(int id);

}
