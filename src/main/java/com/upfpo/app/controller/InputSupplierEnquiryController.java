package com.upfpo.app.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.auth.response.MessageResponse;
import com.upfpo.app.dto.EnquiryChcFmbDTO;
import com.upfpo.app.dto.EnquiryFertilizerDTO;
import com.upfpo.app.dto.EnquiryInsecticideDTO;
import com.upfpo.app.dto.EnquirySeedDTO;
import com.upfpo.app.entity.EnquiryInputSupplierFertilizer;
import com.upfpo.app.entity.EnquiryInputSupplierInsecticide;
import com.upfpo.app.entity.EnquiryInputSupplierMachinery;
import com.upfpo.app.entity.EnquiryInputSupplierSeed;
import com.upfpo.app.requestStrings.ReportRequestString;
import com.upfpo.app.service.InputSupplierEnquiryService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/inputSupplierIndent")
@Api(produces = "application/json", tags="Input Supplier Indent", value = "Create indents for seeds, fertilizer, insecticides")
public class InputSupplierEnquiryController 
{
	@Autowired
	InputSupplierEnquiryService inputSupplierEnquiryService; 
	
	@GetMapping("/seedIndent/get/{masterId}")
	public List<EnquirySeedDTO> getSeedIndents(@PathVariable("masterId") Integer masterId)
	{
		return inputSupplierEnquiryService.getSeedIndentMasterId(masterId);
	}
	
	@PostMapping("/seedIndent/getCreatedBy")
	public List<EnquirySeedDTO> getSeedIndentsCreatedBy(@RequestBody ReportRequestString reportRequestString)
	{
		return inputSupplierEnquiryService.getSeedIndentCreatedBy(reportRequestString);
	}
	
	@PostMapping("/seedIndent/create")
	public ResponseEntity<MessageResponse> createIndentSeed(@RequestBody EnquiryInputSupplierSeed enquiryInputSupplierSeed)
	{
		try
		{
			if(enquiryInputSupplierSeed.getCreatedBy() == enquiryInputSupplierSeed.getMasterId())
			{
				return ResponseEntity.ok(new MessageResponse("Same user can't create an indent!"));
			}
			inputSupplierEnquiryService.createSeedIndent(enquiryInputSupplierSeed);
			return ResponseEntity.ok(new MessageResponse("Indent Created SuccessFully !"));
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			return ResponseEntity.ok(new MessageResponse("Failed to Create Indent!"));
		}
	}
	
	@PutMapping("/seedIndent/updateStatus/{enqId}")
	public ResponseEntity<MessageResponse> updateStatusSeedIndent(@RequestBody EnquiryInputSupplierSeed enquiryInputSupplierSeed, @PathVariable("enqId") BigInteger enqId)
	{
		try
		{
			inputSupplierEnquiryService.updateSeedIndentStatus(enquiryInputSupplierSeed, enqId);
			return ResponseEntity.ok(new MessageResponse("Indent Created SuccessFully !"));
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			return ResponseEntity.ok(new MessageResponse("Failed to Create Indent!"));
		}
	}
	
	@GetMapping("/fertilizer/get/{masterId}")
	public List<EnquiryFertilizerDTO> getFertilizerIndents(@PathVariable("masterId") Integer masterId)
	{
		return inputSupplierEnquiryService.getFertilizerIndentByMasterId(masterId);
	}
	
	@PostMapping("/fertilizer/getCreatedBy")
	public List<EnquiryFertilizerDTO> getFertilizerIndentsCreatedBy(@RequestBody ReportRequestString reportRequestString)
	{
		return inputSupplierEnquiryService.getFertilizerIndentCreatedBy(reportRequestString);
	}
	
	@PostMapping("/fertilizer/create")
	public ResponseEntity<MessageResponse> createFertilizerIndentSeed(@RequestBody EnquiryInputSupplierFertilizer enquiryInputSupplierFertilizer)
	{
		try
		{	
			if(enquiryInputSupplierFertilizer.getCreatedBy() == enquiryInputSupplierFertilizer.getMasterId())
			{
				return ResponseEntity.ok(new MessageResponse("Same user can't create an indent!"));
			}
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
	
	@GetMapping("/machinery/get1/{masterId}")
	public List<EnquiryInputSupplierMachinery> getMachineryIndents(@PathVariable("masterId") Integer masterId)
	{
		return inputSupplierEnquiryService.getMachineryIndentByMasterId(masterId);
	}
	
	@GetMapping("/machinery/get/{masterId}")
	public List<EnquiryChcFmbDTO> getMachinaryIndentData(@PathVariable("masterId") Integer masterId)
	{
		return inputSupplierEnquiryService.getIndentData(masterId);
	}
	
	@PostMapping("/machinery/getCreatedBy")
	public List<EnquiryChcFmbDTO> getMachinaryIndentDataCreatedBy(@RequestBody ReportRequestString reportRequestString)
	{
		return inputSupplierEnquiryService.getIndentDataCreatedBy(reportRequestString);
	}
	
	@PostMapping("/machinery/create")
	public ResponseEntity<MessageResponse> createFertilizerIndentSeed(@RequestBody EnquiryInputSupplierMachinery enquiryInputSupplierMachinery)
	{
		try
		{
			if(enquiryInputSupplierMachinery.getCreatedBy() == enquiryInputSupplierMachinery.getMasterId())
			{
				return ResponseEntity.ok(new MessageResponse("Same user can't create an indent!"));
			}
			inputSupplierEnquiryService.createMachineryIndent(enquiryInputSupplierMachinery);
			return ResponseEntity.ok(new MessageResponse("Indent Created SuccessFully !"));
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			return ResponseEntity.ok(new MessageResponse("Failed to Create Indent!"));
		}
	}
	
	@PutMapping("/machinery/updateStatus/{enqId}")
	public ResponseEntity<MessageResponse> updateStatusMachineryIndent(@RequestBody EnquiryInputSupplierMachinery enquiryInputSupplierMachinery, @PathVariable("enqId") BigInteger enqId)
	{
		try
		{
			inputSupplierEnquiryService.updateMachineryIndent(enquiryInputSupplierMachinery, enqId);
			return ResponseEntity.ok(new MessageResponse("Indent Updated SuccessFully !"));
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			return ResponseEntity.ok(new MessageResponse("Failed to Update Indent!"));
		}
	}
	
	@GetMapping("/insecticides/get/{masterId}")
	public List<EnquiryInsecticideDTO> getInsecticidesIndents(@PathVariable("masterId") Integer masterId)
	{
		return inputSupplierEnquiryService.getInsecticideIndentByMasterId(masterId);
	}
	
	@PostMapping("/insecticides/getCreatedBy")
	public List<EnquiryInsecticideDTO> getInsecticidesIndentsCreatedBy(@RequestBody ReportRequestString reportRequestString)
	{
		return inputSupplierEnquiryService.getInsecticideIndentCreatedBy(reportRequestString);
	}
	
	@PostMapping("/insecticides/create")
	public ResponseEntity<MessageResponse> createInsecticidesIndentSeed(@RequestBody EnquiryInputSupplierInsecticide enquiryInputSupplierInsecticide)
	{
		try
		{
			if(enquiryInputSupplierInsecticide.getCreatedBy() == enquiryInputSupplierInsecticide.getMasterId())
			{
				return ResponseEntity.ok(new MessageResponse("Same user can't create an indent!"));
			}
			inputSupplierEnquiryService.createInsecticide(enquiryInputSupplierInsecticide);
			return ResponseEntity.ok(new MessageResponse("Indent Created SuccessFully !"));
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			return ResponseEntity.ok(new MessageResponse("Failed to Create Indent!"));
		}
	}
	
	@PutMapping("/insecticides/updateStatus/{enqId}")
	public ResponseEntity<MessageResponse> updateStatusInsecticidesIndent(@RequestBody EnquiryInputSupplierInsecticide enquiryInputSupplierInsecticide, @PathVariable("enqId") BigInteger enqId)
	{
		try
		{
			inputSupplierEnquiryService.updateInsecticideIndent(enquiryInputSupplierInsecticide, enqId);
			return ResponseEntity.ok(new MessageResponse("Indent Updated SuccessFully !"));
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			return ResponseEntity.ok(new MessageResponse("Failed to Update Indent!"));
		}
	}
}
