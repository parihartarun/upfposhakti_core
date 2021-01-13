package com.upfpo.app.web_controller;

import java.util.List;

import javax.persistence.PostRemove;

import org.hibernate.event.service.spi.EventListenerRegistrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.entity.BuyerSellerMaster;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.entity.InputSupplierMaster;
import com.upfpo.app.service.RegistrationServices;


@RestController
@RequestMapping("/register")
public class RegistrationController 
{
	@Autowired
	RegistrationServices registerServices;
	
	
	@PostMapping(value="/fpo")
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
		return registerServices.getFarmerDetailsById(farmerId);
	}
	
	@PostMapping(value="/buyerSeller")
	private int registerBuyerSeller(@RequestBody BuyerSellerMaster buyerSeller)
	{
		registerServices.registerBuyerSeller(buyerSeller);
		return 1;
	}
	
	@PutMapping(value="/editBuyerSeller")
	private BuyerSellerMaster editBuyerSeller(@RequestBody BuyerSellerMaster buyerSeller)
	{
		registerServices.update_buyerSeller(buyerSeller);
		return buyerSeller;
	}
	
	@PostMapping(value="/inputSupplier")
	private int registerInputSupplier(@RequestBody InputSupplierMaster inputSupplierMaster)
	{
		if(inputSupplierMaster.getInputSupplierType()==1)
		{
			inputSupplierMaster.setBlockRefId(null);
			inputSupplierMaster.setVillageRefId(null);
		}
		registerServices.registerInputSuplier(inputSupplierMaster);
		return 1;
	}
	
	@PutMapping(value="/editInputSupplier")
	private InputSupplierMaster editInputSupplier(@RequestBody InputSupplierMaster inputSupplierMaster)
	{
		registerServices.update_inputSupplier(inputSupplierMaster);
		return inputSupplierMaster;
	}
	
	@GetMapping(value="/getInputSupplier")
	private List<InputSupplierMaster> getInputSupplierDetails()
	{
		return registerServices.getInputSupplierDetails();
	}
	
	@PutMapping(value="/deleteInputSupplier/{inputSupplierId}")
	private int deleteInputSupplier(@PathVariable("inputSupplierId") int inputSupplierId)
	{
		registerServices.deleteInputSupplier(inputSupplierId);
		return 1;
	}
	
	
}
