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

import com.upfpo.app.entity.SPRegister;
import com.upfpo.app.service.FIGService;
import com.upfpo.app.service.SPService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value="/api/sps")
@Api(produces = "application/json", value = "Add, Update, Delete, and retrive the SP")
public class SPController {
	@Autowired
	private SPService figService;

	@PostMapping
	@ApiOperation(value="Add new profile of sp",notes="Api for add new sp",response=SPRegister.class)
	public SPRegister addNewSp(@RequestBody SPRegister newSpRegister)
	{
		return null;
	}
	@PutMapping("/:id")
	@ApiOperation(value="Update profile of sp",notes="Api for update sp by id",response=SPRegister.class)
	public SPRegister updateSp(@PathVariable("id") Integer id,@RequestBody SPRegister updateSpRegister)
	{
		return null;
	}
	@GetMapping("/:id")
	@ApiOperation(value="Get sp profile",notes="Api for get sp by id",response=SPRegister.class)
	public SPRegister getSpById(@PathVariable("id") Integer id)
	{
		return null;
	}
	@DeleteMapping("/:id")
	@ApiOperation(value="Delete sp profile",notes="Api for delete sp by id",response=SPRegister.class)
	public SPRegister deleteSp(@PathVariable("id") Integer id)
	{
		return null;
	}
	@ApiOperation(value="get sp profiles",notes="Api forget sp list",response=SPRegister.class)
	@GetMapping
	public List<SPRegister> getSps()
	{
		return null;
	}
}
