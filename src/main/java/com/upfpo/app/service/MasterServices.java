package com.upfpo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upfpo.app.entity.BankMaster;
import com.upfpo.app.entity.DistrictMaster;
import com.upfpo.app.entity.EducationMaster;

public interface MasterServices 
{
	public List<DistrictMaster> getDistricts();
	public DistrictMaster getDistrictsById(int dist_id);
	public List<BankMaster> getBanks();
	public List<EducationMaster> getQualifications();
}
