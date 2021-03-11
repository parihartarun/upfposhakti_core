package com.upfpo.app.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.ValidationException;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.CropFilterDto;
import com.upfpo.app.dto.FilterDto;
import com.upfpo.app.entity.AgencyMaster;
import com.upfpo.app.entity.CollectionCenter;
import com.upfpo.app.service.AgencyMasterService;
import com.upfpo.app.service.CollectionCenterService;
import com.upfpo.app.service.FilterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/search/filters")
@Api(produces = "application/json", value = "One Controller to get All Dynamic Filters", tags="Search Filters",description="One Controller to get All Dynamic Filters")
public class FiltersController {

	@Autowired
	private FilterService filterService;
	
	@GetMapping("/districts")
	@ApiOperation(value="Get Districts List By Search Criteria",code=201, produces = "application/json", notes="Api for getting districts according to the search criteria",response=FilterDto.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus( HttpStatus.CREATED)
	public List<FilterDto> getFilterDistricts(@RequestParam("in") String in,@RequestParam("val") String value)
	{	
		//System.out.println("In  = "+in);
		//System.out.println("Val  = "+value);
		return filterService.getDistrictFilterListBySearchKeys(value, in);	
	}
	
	@GetMapping("/fpos")
	@ApiOperation(value="Get Fpo List By Search Criteria",code=201, produces = "application/json", notes="Get Fpo List By Search Criteria",response=FilterDto.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus(HttpStatus.CREATED)
	public List<FilterDto> getFilterFpos(@RequestParam("in") String in,@RequestParam("val") String value)
	{	
		//System.out.println("In  = "+in);
		//System.out.println("Val  = "+value);
		return filterService.getFpoFilterListBySearchKeys(value, in);	
	}
	
	@GetMapping("/crops")
	@ApiOperation(value="Get Crop list By Search Criteria",code=201, produces = "application/json", notes="Get Crop List By Search Criteria",response=CropFilterDto.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus(HttpStatus.CREATED)
	public List<CropFilterDto> getFilterCrops(@RequestParam("in") String in,@RequestParam("val") String value)
	{	
		//System.out.println("In  = "+in);
		//System.out.println("Val  = "+value);
		return filterService.getCropFilterListBySearchKeys(value, in);	
	}
	
	@GetMapping("/inputSuppliers")
	@ApiOperation(value="Get Input Supplier list By Search Criteria",code=201, produces = "application/json", notes="Get Input Supplier List By Search Criteria",response=FilterDto.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus(HttpStatus.CREATED)
	public List<FilterDto> getFilterInputSuppliers(@RequestParam("in") String in,@RequestParam("val") String value)
	{	
		//System.out.println("In  = "+in);
		//System.out.println("Val  = "+value);
		return filterService.getInputSuppliersByFilterKeys(value, in);	
	}
	
	@GetMapping("/fertilizertypes")
	@ApiOperation(value="Get Fertilizer Type list By Search Criteria",code=201, produces = "application/json", notes="Get Fertilizer Type List By Search Criteria",response=FilterDto.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus(HttpStatus.CREATED)
	public List<FilterDto> getFertilizerTypes(@RequestParam("in") String in,@RequestParam("val") String value)
	{	
		//System.out.println("In  = "+in);
		//System.out.println("Val  = "+value);
		return filterService.getFertilizerTypesByFilterKeys(value, in);	
	}
	@GetMapping("/subcategories")
	@ApiOperation(value="Get Fertilizer Type list By Search Criteria",code=201, produces = "application/json", notes="Get Fertilizer Type List By Search Criteria",response=String.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus(HttpStatus.CREATED)
	public List<String> getCategoriesByFilterKeys(@RequestParam("in") String in,@RequestParam("val") String value)
	{	
		//System.out.println("In  = "+in);
		//System.out.println("Val  = "+value);
		return filterService.getCategoriesByFilterKeys(value, in);	
	}
	
	@GetMapping("/brands")
	@ApiOperation(value="Get Brand /  Company list By Search Criteria",code=201, produces = "application/json", notes="Get Brand /  Company List By Search Criteria",response=String.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus(HttpStatus.CREATED)
	public List<String> getMachineryBrandsByFilterKeys(@RequestParam("in") String in,@RequestParam("val") String value)
	{	
		//System.out.println("In  = "+in);
		//System.out.println("Val  = "+value);
		return filterService.getMachineryBrandsByFilterKeys(value, in);	
	}	
	//List<CropFilterDto> getCropsByFilterKeys

	
	@GetMapping("/machinerytypes")
	@ApiOperation(value="Get machinery Type list By Search Criteria",code=201, produces = "application/json", notes="Get machinery Type List By Search Criteria",response=String.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus(HttpStatus.CREATED)
	public List<FilterDto> getMachineryTypesByFilterKeys(@RequestParam("in") String in,@RequestParam("val") String value)
	{	
		//System.out.println("In  = "+in);
		//System.out.println("Val  = "+value);
		return filterService.getMachineryTypesByFilterKeys(value, in);	
	}

		
}
