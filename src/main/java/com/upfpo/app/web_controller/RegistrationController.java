package com.upfpo.app.web_controller;

import java.util.List;

import javax.persistence.PostRemove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;ewa
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.service.RegistrationServices;


@RestController
@RequestMapping("/register")
public class RegistrationController 
{
	@Autowired
	RegistrationServices registerServices;
	
	
	@RequestMapping(value="/fpo")
	private int registerFPO(@RequestBody FPORegister fpoRegister)
	{
		System.out.println("Inside registerFpo");
		registerServices.registerFPO(fpoRegister);
		return 1;
	}
	
	@PostMapping(value="/farmer")
	private int registerFarmer(@RequestBody FarmerMaster farmerRegister)
	{
		registerServices.registerFarmer(farmerRegister);
		return 1;
	}
	
	@PutMapping(value="/editFarmer")
	private FarmerMaster editFarmer(@RequestBody FarmerMaster farmerMaster)
	{
		registerServices.update_farmer(farmerMaster);
		return farmerMaster;
	}
	
	@GetMapping(value="/getFarmerDetails/{farmerId}")
	private FarmerMaster getFarmerDetailsById(@PathVariable("farmerId") int farmerId)
	{
		registerServices.getFarmerDetailsById(farmerId);
	}
}
