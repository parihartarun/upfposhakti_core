package com.upfpo.app.web_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.entity.BankMaster;
import com.upfpo.app.entity.DistrictMaster;
import com.upfpo.app.service.DistrictService;

@RestController
@RequestMapping(value="/api/v1/District")
public class DistrictController 
{
	@Autowired
	DistrictService districtService;
	
	@GetMapping(value="/getDistricts")
	private ResponseEntity<List<DistrictMaster>> getDistricts()
	{
		List<DistrictMaster> list = districtService.getDistricts();
		return new ResponseEntity<List<DistrictMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(value="/getDistricts/{district_id}")
	public ResponseEntity<DistrictMaster> getDistrictsById(@PathVariable("district_id") int district_id )
	{
		DistrictMaster districtEntity = districtService.getDistrictsById(district_id);
		return new ResponseEntity<DistrictMaster>(districtEntity,new HttpHeaders(),HttpStatus.OK);
	}
}
