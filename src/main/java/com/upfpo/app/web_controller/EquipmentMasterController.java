package com.upfpo.app.web_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.entity.FIGRegister;
import com.upfpo.app.entity.SPRegister;
import com.upfpo.app.service.FIGService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value="/api/equipments")
@Api(produces = "application/json", value = "Add, Update, Delete, and retrieve Equipments")
public class EquipmentMasterController {

	@Autowired
	private FIGService figService;
	@PostMapping
	@ApiOperation(value="Add new fig profile",notes="Api for add new FIG",response=SPRegister.class)
	public FIGRegister addNewFig(@RequestBody FIGRegister newFigRegister)
	{
		return null;
	}
	@PutMapping("/:id")
	@ApiOperation(value="Update fig profile",notes="Api for update FIG",response=SPRegister.class)
	public FIGRegister updateFig(@PathVariable("id") Integer id,@RequestBody FIGRegister updateFigRegister)
	{
		return null;
	}
	@GetMapping("/:id")
	@ApiOperation(value="get fig profile",notes="Api for get FIG by id",response=SPRegister.class)
	public FIGRegister getFigById(@PathVariable("id") Integer id)
	{
		return null;
	}
	@DeleteMapping("/:id")
	@ApiOperation(value="delete fig profile",notes="Api for delete FIG by id",response=SPRegister.class)
	public FIGRegister deleteFig(@PathVariable("id") Integer id)
	{
		return null;
	}
	
	@GetMapping
	@ApiOperation(value="get all fig profiles",notes="Api for getting all FIGs",response=SPRegister.class)
	public List<FIGRegister> getFigs()
	{
		return null;
	}
}
