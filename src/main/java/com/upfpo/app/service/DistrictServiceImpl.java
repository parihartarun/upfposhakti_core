package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.MasterDataDto;
import com.upfpo.app.entity.DistrictMaster;
import com.upfpo.app.repository.DistrictMasterRepository;

@Service
public class DistrictServiceImpl implements DistrictService
{
	@Autowired
	DistrictMasterRepository districtRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<MasterDataDto> getDistricts() 
	{
		List<MasterDataDto> districtList = new ArrayList<MasterDataDto>();
		//districtRepository.findAll().forEach(districtList1->districtList.add(districtList1));
		districtList = getDistrictByStateId(9);
		return districtList;    
	}
	
	public List<MasterDataDto> getDistrictByStateId(int stateId) 
	{
		String  sql = "select d.district_id as district_id, d.district_name as district_name from districts d where d.state_id = :stateId order by d.district_name asc";
		  
		List<MasterDataDto> obj =  (List<MasterDataDto>) entityManager.createNativeQuery(sql,"MasterDataDto").setParameter("stateId", stateId).getResultList();
		return obj;
	}
	
	@Override
	public DistrictMaster getDistrictsById(int distId) 
	{
		return districtRepository.findById(distId).get();
	}
	
	@Override
	public List<DistrictMaster> getDistrictsByStateId(int state_id) 
	{
		return districtRepository.getDistrictsByStateId(state_id);
	}
	
}
