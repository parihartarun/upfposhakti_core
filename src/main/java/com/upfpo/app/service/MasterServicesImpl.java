package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.BankMaster;
import com.upfpo.app.entity.DistrictMaster;
import com.upfpo.app.entity.EducationMaster;
import com.upfpo.app.repository.BankMasterRepository;
import com.upfpo.app.repository.DistrictMasterRepository;
import com.upfpo.app.repository.EducationMasterRepository;

@Service
public class MasterServicesImpl implements MasterServices
{
	@Autowired
	DistrictMasterRepository districtMasterRepository;
	
	@Autowired 
	BankMasterRepository bankMasterRepository;
	
	@Autowired
	EducationMasterRepository educationMasterRepository;
	
	public List<DistrictMaster> getDistricts()
	{
		List<DistrictMaster> distList = new ArrayList<DistrictMaster>();
		districtMasterRepository.findAll().forEach(distList1->distList.add(distList1));
		return distList;
	}
	
	@Override
	public DistrictMaster getDistrictsById(int dist_id) {
		 
		return districtMasterRepository.findById(dist_id).get();
	}
	
	@Override
	public List<BankMaster> getBanks() {
		List<BankMaster> bankList = new ArrayList<BankMaster>();
		bankMasterRepository.findAll().forEach(bankList1->bankList.add(bankList1)); 
		return bankList;
	}
	
	@Override
	public List<EducationMaster> getQualifications() 
	{
		List<EducationMaster> educationList = new ArrayList<EducationMaster>();
		educationMasterRepository.findAll().forEach(educationList1->educationList.add(educationList1));
		return educationList;
	}
}
