package com.upfpo.app.web_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.SPRegister;
import com.upfpo.app.service.FIGService;
import com.upfpo.app.service.FPOService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/fpos")
@Api(produces = "application/json", value = "Add, Update, Delete, and retrive the FPO")
public class FPOController {
	@Autowired
	private FPOService fpoService;
	
	@PostMapping
	@ApiOperation(value="Add new FPO profile",notes="Api for add new FPO",response=SPRegister.class)
	public FPORegister addNewFpo(@RequestBody FPORegister newFpoRegister)
	{
		return fpoService.insertFpo(newFpoRegister);
	}
	@PutMapping("/:id")
	@ApiOperation(value="Update FPO profile",notes="Api for update FPO",response=SPRegister.class)
	public FPORegister updateFpo(@PathVariable("id") Integer id,@RequestBody FPORegister updateFpoRegister)
	{
		return fpoService.updateFpo(id, updateFpoRegister);
	}
	@GetMapping("/:id")
	@ApiOperation(value="Get FPO profile by id",notes="Api for get FPO by id",response=SPRegister.class)
	public FPORegister getFpoById(@PathVariable("id") Integer id)
	{
		return fpoService.selectFpoById(id);
	}
	@DeleteMapping("/:id")
	@ApiOperation(value="Delete FPO profile by id",notes="Api for delete FPO by id",response=Boolean.class)
	public Boolean deleteFpo(@PathVariable("id") Integer id)
	{
		return fpoService.deleteFpo(id);
	}
	@GetMapping
	@ApiOperation(value="Get All FPO profiles",notes="Api for view all FPOs",response=SPRegister.class)
	public List<FPORegister> getFpos()
	{
		return fpoService.selectFpos();
	}
}
