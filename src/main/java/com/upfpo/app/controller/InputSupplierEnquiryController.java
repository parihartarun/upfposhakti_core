package com.upfpo.app.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.entity.EnquiryInputSupplierFertilizer;
import com.upfpo.app.entity.EnquiryInputSupplierMachinery;
import com.upfpo.app.entity.EnquiryInputSupplierSeed;
import com.upfpo.app.service.InputSupplierEnquiryService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/inputSupplierIndent")
@Api(produces = "application/json", tags="Input Supplier Indent", value = "Create indents for seeds, fertilizer, insecticides")
public class InputSupplierEnquiryController 
{
	@Autowired
	InputSupplierEnquiryService inputSupplierEnquiryService;  
	
	@PostMapping("/seedIndent/create")
	public ResponseEntity<MessageResponse> createIndentSeed(@RequestBody EnquiryInputSupplierSeed enquiryInputSupplierSeed)
	{
		try
		{
			inputSupplierEnquiryService.createSeedIndent(enquiryInputSupplierSeed);
			return ResponseEntity.ok(new MessageResponse("Indent Created SuccessFully !"));
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			return ResponseEntity.ok(new MessageResponse("Failed to Create Indent!"));
		}
	}
	
	@PutMapping("/seedIndent/updateStatus/enqId")
	public ResponseEntity<MessageResponse> updateStatusSeedIndent(@RequestBody EnquiryInputSupplierSeed enquiryInputSupplierSeed, @PathVariable("enqid") BigInteger enqid)
	{
		try
		{
			inputSupplierEnquiryService.createSeedIndent(enquiryInputSupplierSeed);
			return ResponseEntity.ok(new MessageResponse("Indent Created SuccessFully !"));
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			return ResponseEntity.ok(new MessageResponse("Failed to Create Indent!"));
		}
	}
	
	@PostMapping("/fertilizer/create")
	public ResponseEntity<MessageResponse> createFertilizerIndentSeed(@RequestBody EnquiryInputSupplierFertilizer enquiryInputSupplierFertilizer)
	{
		try
		{
			inputSupplierEnquiryService.createFertilizerIndent(enquiryInputSupplierFertilizer);
			return ResponseEntity.ok(new MessageResponse("Indent Created SuccessFully !"));
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			return ResponseEntity.ok(new MessageResponse("Failed to Create Indent!"));
		}
	}
	
	@PutMapping("/fertilizer/updateStatus/{enqId}")
	public ResponseEntity<MessageResponse> updateStatusFertilizerIndent(@RequestBody EnquiryInputSupplierFertilizer enquiryInputSupplierFertilizer, @PathVariable("enqId") BigInteger enqId)
	{
		try
		{
			inputSupplierEnquiryService.updateFertilizerIndentStatus(enquiryInputSupplierFertilizer, enqId);
			return ResponseEntity.ok(new MessageResponse("Indent Updated SuccessFully !"));
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			return ResponseEntity.ok(new MessageResponse("Failed to Update Indent!"));
		}
	}
	
	@PostMapping("/machinery/create")
	public ResponseEntity<MessageResponse> createFertilizerIndentSeed(@RequestBody EnquiryInputSupplierMachinery enquiryInputSupplierMachinery)
	{
		try
		{
			inputSupplierEnquiryService.createMachineryIndent(enquiryInputSupplierMachinery);
			return ResponseEntity.ok(new MessageResponse("Indent Created SuccessFully !"));
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			return ResponseEntity.ok(new MessageResponse("Failed to Create Indent!"));
		}
	}
	
	
	
	
}
