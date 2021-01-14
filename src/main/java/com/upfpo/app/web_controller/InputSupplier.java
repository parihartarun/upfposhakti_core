package com.upfpo.app.web_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.entity.InputSupplierMaster;
import com.upfpo.app.service.InputSupplierService;

@RestController
@RequestMapping(value="/api/v1/InputSupplier")
public class InputSupplier 
{
	@Autowired
	InputSupplierService inputSupplierService;
	
	/*
	 * @PutMapping(value="/editInputSupplier") private InputSupplierMaster
	 * editInputSupplier(@RequestBody InputSupplierMaster inputSupplierMaster) {
	 * registerServices.updateInputSupplier(inputSupplierMaster); return
	 * inputSupplierMaster; }
	 * 
	 * @GetMapping(value="/getInputSupplier") private List<InputSupplierMaster>
	 * getInputSupplierDetails() { return
	 * registerServices.getInputSupplierDetails(); }
	 * 
	 * @PutMapping(value="/deleteInputSupplier/{inputSupplierId}") private int
	 * deleteInputSupplier(@PathVariable("inputSupplierId") int inputSupplierId) {
	 * registerServices.deleteInputSupplier(inputSupplierId); return 1; }
	 */
	
	@GetMapping(value="/getInputSupplier")
	private ResponseEntity<List<InputSupplierMaster>> getInputSupplierDetails()
	{
		List<InputSupplierMaster> list = inputSupplierService.getInputSupplierDetails();
		return new ResponseEntity<List<InputSupplierMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping(value="/editInputSupplier/{inputSupplierId}")
	private ResponseEntity<InputSupplierMaster> editInputSupplier(@RequestBody InputSupplierMaster inputSupplier,@PathVariable("inputSupplierId") int inputSupplierId)
	{
		InputSupplierMaster inputSupplierEntity = inputSupplierService.updateInputSupplier(inputSupplier,inputSupplierId);
		return new ResponseEntity<InputSupplierMaster>(inputSupplierEntity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping(value="/deleteInputSupplier/{inputSupplierId}")
	private HttpStatus deleteInputSupplier(@PathVariable("inputSupplierId") int inputSupplierId)
	{
		inputSupplierService.deleteInputSupplier(inputSupplierId);
		return HttpStatus.FORBIDDEN;
	}
}
