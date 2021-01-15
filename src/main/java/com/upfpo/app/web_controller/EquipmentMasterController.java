package com.upfpo.app.web_controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.configuration.exception.ValidationException;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.EqupmentMaster;
import com.upfpo.app.service.EquipmentMasterService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/api/master/equipments")
@Api(produces = "application/json", value = "Add, Update, Delete, and retrieve the Equipment",tags="Equipment", description="Add, Update, Delete, and retrive the Equipment Master")
public class EquipmentMasterController {

	@Autowired
	private EquipmentMasterService equipmentMasterService;
	
	@PostMapping
	@ApiOperation(value="Add new Equipment Master",code=201, produces = "application/json", notes="Api for add new Collection Center",response=EqupmentMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus( HttpStatus.CREATED )
	public EqupmentMaster addNewEquipmentMaster(@RequestBody @Valid EqupmentMaster equipmentMaster)
	{
	if(equipmentMaster==null)
	{
		throw new ValidationException();
	}else {
		return equipmentMasterService.insertEquipmentMaster(equipmentMaster);
	}
	

		
	}
	@PutMapping("/:id")
	@ApiOperation(value="Update Equipment Master", code=200, produces = "application/json", notes="Api for update Equipment Master",response=EqupmentMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	
	public EqupmentMaster updateEquipmentMaster(@PathVariable("id") Integer id,@RequestBody EqupmentMaster updateEquipmentMaster)
	{
		return equipmentMasterService.updateEquipmentMaster(id, updateEquipmentMaster);
	}
	@GetMapping("/:id")
	@ApiOperation(value="Get Equipment Master by id", code=200, produces = "application/json",notes="Api for get Equipment Master by id",response=EqupmentMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public EqupmentMaster getEquipmentMasterById(@PathVariable("id") Integer id)
	{
		return equipmentMasterService.selectEquipmentMasterById(id);
	}
	@DeleteMapping("/:id")
	@ApiOperation(value="Delete Equipment Master by id",code=204,produces = "text/plain",notes="Api for delete Equipment Master by id",response=Boolean.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	@ResponseStatus( HttpStatus.NO_CONTENT)
	public Boolean deleteEquipmentMaster(@PathVariable("id") Integer id)
	{
		return equipmentMasterService.deleteEquipmentMaster(id);
	}
	@GetMapping
	@ApiOperation(value="Get All Equipment Master",code=200,produces = "application/json",notes="Api for view all Equipment Master",response=EqupmentMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public List<EqupmentMaster> getEquipmentMaster()
	{
		return equipmentMasterService.selectEquipmentMaster();
	}
}
