package com.upfpo.app.controller;


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

import com.upfpo.app.configuration.exception.ValidationException;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.CollectionCenter;


import com.upfpo.app.service.CollectionCenterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/api/collectioncenters")
@Api(produces = "application/json", value = "Add, Update, Delete, and retrive the Collection Center", tags="Collection Center",description="Add, Update, Delete, and retrive the Collection Center")
public class CollectionCenterController {

	@Autowired
	private CollectionCenterService collectionCenterService;
	
	@PostMapping
	@ApiOperation(value="Add new Collection Center",code=201, produces = "application/json", notes="Api for add new Collection Center",response=CollectionCenter.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus( HttpStatus.CREATED )
	public CollectionCenter addNewCollectionCenter(@RequestBody @Valid CollectionCenter collectionCenter)
	{
	if(collectionCenter==null)
	{
		throw new ValidationException();
	}else {
		return collectionCenterService.insertCollectionCenter(collectionCenter);
	}
	

		
	}
	@PutMapping("/:id")
	@ApiOperation(value="Update Collection Center", code=200, produces = "application/json", notes="Api for update Collection Center",response=CollectionCenter.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	
	public CollectionCenter updateCollectionCenter(@PathVariable("id") Integer id,@RequestBody CollectionCenter updateCollectionCenter)
	{
		return collectionCenterService.updateCollectionCenter(id, updateCollectionCenter);
	}
	@GetMapping("/:id")
	@ApiOperation(value="Get Collection Center by id", code=200, produces = "application/json",notes="Api for get Collection Center by id",response=CollectionCenter.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=Boolean.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=Boolean.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public CollectionCenter getCollectionCenterById(@PathVariable("id") Integer id)
	{
		return collectionCenterService.selectCollectionCenterById(id);
	}
	@DeleteMapping("/:id")
	@ApiOperation(value="Delete Collection Center by id",code=204,produces = "text/plain",notes="Api for delete Collection Center by id",response=Boolean.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	@ResponseStatus( HttpStatus.NO_CONTENT)
	public Boolean deleteCollectionCenter(@PathVariable("id") Integer id)
	{
		return collectionCenterService.deleteCollectionCenter(id);
	}
	@GetMapping
	@ApiOperation(value="Get All Collection Center profiles",code=200,produces = "application/json",notes="Api for view all Collection Centers",response=CollectionCenter.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public List<CollectionCenter> getCollectionCenters()
	{
		return collectionCenterService.selectCollectionCenter();
	}
}
