package com.upfpo.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.dto.CropSearchPagePagableDto;
import com.upfpo.app.dto.DisplayDataDTO;
import com.upfpo.app.dto.FPODetailsDTO;
import com.upfpo.app.dto.ProductionDTO;
import com.upfpo.app.dto.SearchRequestDto;
import com.upfpo.app.service.CollectionCenterService;
import com.upfpo.app.service.InputSupplierMachineryService;
import com.upfpo.app.service.MasterService;
import com.upfpo.app.service.NewSearchService;
import com.upfpo.app.util.GetCurrentDate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/home")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(produces = "application/json", value = "Retrive Data on Homepage")
public class UtilController {
	
	@Autowired
	private MasterService  masterServices;
	
	@Autowired
	private InputSupplierMachineryService inputSupplierMachineryService;
	
	@Autowired
	private NewSearchService  newSearchService;
	
	@Autowired
	private CollectionCenterService collectionCenterService;
	
	@GetMapping("/farmer")
	@ApiOperation(value="Get farmer's Data on homepage",code=200,produces = "application/json",notes="API to view farmer's data on homepage",response=DisplayDataDTO.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public DisplayDataDTO getFarmers()
	{
		return masterServices.farmers();
	}
	
	
	@GetMapping("/production")
	@ApiOperation(value="Production categorization",code=200,produces = "application/json",notes="API to view production data on homepage",response=DisplayDataDTO.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	public ProductionDTO getProductions(String finYear)
	{
		return masterServices.productions(GetCurrentDate.getCurrentFinYear());
	}
	
	
	@GetMapping("/search")
	@ApiOperation(value="Search results",code=200,produces = "application/json",notes="API for search Results",response=FPODetailsDTO.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	
	public List<FPODetailsDTO> homeSearch(@RequestParam("val") String searchVal, @RequestParam("in") String searchIn,@RequestParam(value = "filterdist",required = false) List<String> districts,@RequestParam(value = "filterqty",required = false) List<Integer> qty,@RequestParam(value = "filtercrop",required = false) List<String> crops,@RequestParam(value = "fpo",required = false) List<String> fpos)
	{

		return masterServices.homeSearch(searchVal,searchIn,districts,qty,crops,fpos);
		//return null;	
	}
	
	
	@PostMapping("/search")
	@ApiOperation(value="new Search api",code=200,produces = "application/json",notes="new API for search Results",response=CropSearchPagePagableDto.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})	
	public CropSearchPagePagableDto homeSearch(@Validated @RequestBody SearchRequestDto searchRequestDto)
	{
		return masterServices.newHomeSearch(searchRequestDto);
		
		//searchRequestDto.getLimit(),searchRequestDto.getPage(),searchRequestDto.getQtymin(),searchRequestDto.getQtymax(),searchRequestDto.getVal(),searchRequestDto.getIn(),searchRequestDto.getDistrictIds(),searchRequestDto.getCropverietyIds(),searchRequestDto.getCropIds(), searchRequestDto.getFpoIds()
		//return null;	
	}
	
	@PutMapping("/search")
	@ApiOperation(value="new Search api",code=200,produces = "application/json",notes="new API for search Results",response=CropSearchPagePagableDto.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})	
	public  ResponseEntity<?> testhomeSearch(@Validated @RequestBody SearchRequestDto searchRequestDto)
	{
		
		return newSearchService.newHomeSearch(searchRequestDto);
		
		
     //		 SearchServiceImpl searchServiceImpl = new SearchServiceImpl();
    //		return searchServiceImpl.getFilterStrategyOption(searchRequestDto).toString();
		
		//searchRequestDto.getLimit(),searchRequestDto.getPage(),searchRequestDto.getQtymin(),searchRequestDto.getQtymax(),searchRequestDto.getVal(),searchRequestDto.getIn(),searchRequestDto.getDistrictIds(),searchRequestDto.getCropverietyIds(),searchRequestDto.getCropIds(), searchRequestDto.getFpoIds()
		
		
	}
	
	@GetMapping(value= {"/seedProcessing"})
	@ApiOperation(value="Returns number of Seed processing units",code=200,produces = "application/json",notes="API for seed Processing Unit",response=HashMap.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})	
	public @ResponseBody HashMap<String, Integer> seedProcessingUnits()
	{
		Map<String, Integer> hm = new HashMap<String, Integer>(0);
		hm.put("seedprocessingunit", collectionCenterService.seedProcessingUnits());
		return  (HashMap<String, Integer>) hm;
	}
	
	
	@GetMapping(value= {"/coldStorages"})
	@ApiOperation(value="Returns number of Cold storages",code=200,produces = "application/json",notes="API for Cold Storages/Warehouse",response=HashMap.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})	
	public @ResponseBody HashMap<String, Integer> coldStorages()
	{
		
		Map<String, Integer> hm = new HashMap<String, Integer>(0);
		
		hm.put("coldstorage", collectionCenterService.totalColdStorage());
		
		return (HashMap<String, Integer>) hm;		
	
	}
	
	
	
	@GetMapping(value= {"/fmbs"})
	@ApiOperation(value="Returns number of Farm Machinery Banks",code=200,produces = "application/json",notes="API for Farm Machinery Bank count on Homepage",response=HashMap.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})	
	public @ResponseBody HashMap<String, Integer> fmbCount()
	{
		
		Map<String, Integer> hm = new HashMap<String, Integer>(0);
		
		hm.put("fmbscount", inputSupplierMachineryService.fmbsCount());
		
		return (HashMap<String, Integer>) hm;		
	
	}
	
	
	
	
	
	
	
	
	
}