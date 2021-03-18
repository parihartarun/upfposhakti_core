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
import com.upfpo.app.entity.EnquiryChcFmbMachinery;
import com.upfpo.app.service.ChcFmbEnquiryService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/chcFmbIndent")
@Api(produces = "application/json", tags="CHC FMB Indent", value = "Create indents for machinaries")
public class ChcFmbEnquiryController 
{
	@Autowired
	ChcFmbEnquiryService chcFmbEnquiryService;
	
	@PostMapping("/machineryIndent/create")
	public ResponseEntity<MessageResponse> createIndentSeed(@RequestBody EnquiryChcFmbMachinery enquiryChcFmbMachinery)
	{
		try
		{
			if(enquiryChcFmbMachinery.getCreatedBy() == enquiryChcFmbMachinery.getMasterId())
			{
				return ResponseEntity.ok(new MessageResponse("Same user can't create an indent!"));
			}
			chcFmbEnquiryService.createMachineryIndent(enquiryChcFmbMachinery);
			return ResponseEntity.ok(new MessageResponse("Indent Created SuccessFully !"));
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			return ResponseEntity.ok(new MessageResponse("Failed to Create Indent!"));
		}
	}
	
	@PutMapping("/machineryIndent/updateStatus")
	public ResponseEntity<MessageResponse> updateStatusFertilizerIndent(@RequestBody EnquiryChcFmbMachinery enquiryChcFmbMachinery, @PathVariable("enqId") BigInteger enqId)
	{
		try
		{
			chcFmbEnquiryService.updateMachineryStatus(enquiryChcFmbMachinery, enqId);
			return ResponseEntity.ok(new MessageResponse("Indent Updated SuccessFully !"));
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			return ResponseEntity.ok(new MessageResponse("Failed to Update Indent!"));
		}
	}
	
	@GetMapping("/machineryIndent/get/{masterId}")
	public List<EnquiryChcFmbDTO> getMachineryIndent(@PathVariable("masterId") Integer masterId)
	{
		return chcFmbEnquiryService.getMachineryData(masterId);
	}
	
	@GetMapping("/machineryIndentd/get/{masterId}")
	public List<EnquiryChcFmbMachinery> getMachineryIndentd(Integer masterId)
	{
		return chcFmbEnquiryService.getMachineryDatad(masterId);
	}
}
