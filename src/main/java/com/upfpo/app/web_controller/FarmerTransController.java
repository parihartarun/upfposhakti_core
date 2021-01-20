package com.upfpo.app.web_controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.upfpo.app.entity.FarmerRegister;
import com.upfpo.app.service.FarmerServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/api/farmer")
@Api(produces = "application/json", value = "Add, Update, Delete, and retrive the Farmers")
public class FarmerTransController {
	
	@Resource
	private FarmerServices farmerServices;
	
	@PostMapping
	@ApiOperation(value="Add new Farmer",code=201, produces = "application/json", notes="Api for add new Farmer",response=FarmerRegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"), })
	@ResponseStatus(HttpStatus.CREATED)
	public FarmerRegister addNewFpo(@RequestBody FarmerRegister farmerRegister)
	{
	    return farmerServices.addFarmer(farmerRegister);
	}
	
	@GetMapping
	@ApiOperation(value="Get All Farmers profile",code=200,produces = "application/json",notes="Api to view all Farmers")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public List<FarmerRegister> getFarmers()
	{
		return farmerServices.getAllFarmers();
	}
	
	@GetMapping("{id}")
	@ApiOperation(value="Get Farmer by id", code=200, produces = "application/json",notes="Api to get Farmer by id",response=FarmerRegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	})
	public FarmerRegister getFarmerById(@PathVariable("id") Integer id)
	{
		return farmerServices.getFarmerById(id);
	}
	
	@PutMapping("{id}")
	@ApiOperation(value="Delete Farmer by Id",code=201,produces = "application/json",notes="API to delete Farmer by ID",response=FarmerRegister.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),})
	public FarmerRegister deleteBoardMemberById(@PathVariable("id")Integer id)
	{
		return farmerServices.deleteFarmerById(id);
	}
}
