package com.upfpo.app.web_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.entity.BankMaster;
import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.service.BankService;

@RestController
@RequestMapping(value="api/v1/Bank")
public class BankController 
{
	@Autowired
	BankService bankService;
	
	@GetMapping(value="/getBanks")
	private ResponseEntity<List<BankMaster>> getBanks()
	{
		List<BankMaster> list = bankService.getBanks();
		return new ResponseEntity<List<BankMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}
