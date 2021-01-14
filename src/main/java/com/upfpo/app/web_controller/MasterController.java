package com.upfpo.app.web_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.entity.BankMaster;
import com.upfpo.app.entity.DistrictMaster;
import com.upfpo.app.entity.Panchayats;
import com.upfpo.app.service.MasterServices;

@RestController
@RequestMapping(value="/master")
public class MasterController 
{
	@Autowired
	MasterServices masterServices;
	
	@GetMapping(value="/getDistricts")
	public List<DistrictMaster> getDistricts()
	{
		System.out.println("Inside me");
		return masterServices.getDistricts();
	}
	
	@GetMapping(value="/getDistricts/{district_id}")
	public DistrictMaster getDistrictsById(@PathVariable("district_id") int district_id )
	{
		System.out.println("Inside me");
		return masterServices.getDistrictsById(district_id);
	}
	
	@GetMapping(value="/getBanks")
	public List<BankMaster> getBanks()
	{
		System.out.println("Inside me");
		return masterServices.getBanks();
	}
	
	@GetMapping(value="/getPanchayatsByBlockId/{blockRef}")
	public List<Panchayats> getPanchayatByBlockId(@PathVariable("blockRef") int blockRef)
	{
		return masterServices.getPanchayatByBlockId(blockRef);
	}
	
	
}
