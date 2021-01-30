package com.upfpo.app.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.auth.response.ErrorResponse;
import com.upfpo.app.dto.DataDisplayDto;
import com.upfpo.app.dto.FpoDashboardData;
import com.upfpo.app.dto.ReportDTO;
import com.upfpo.app.entity.BoardMember;
import com.upfpo.app.entity.DashBoardData;
import com.upfpo.app.service.DashboardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(produces = "application/json", tags="FPO Dashboard", value = "Apis Related To FPO Dashboard")
@RequestMapping("api/fpo/dashboard")
@CrossOrigin(origins="*",allowCredentials = "true")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;
	
	
	
	@GetMapping
	public DashBoardData getData()
	{
	return dashboardService.getDbd();	
	}
	
	//private List<DataDisplayDto> zayadProdList;
	//private List<DataDisplayDto> rabiProdList;
	//private List<DataDisplayDto> kharifProdList;
	//private List<ReportDTO> rabiProdListActual;
	//private List<ReportDTO> kharifProdListActual;
	//private List<ReportDTO> zayadProdListActual;
	
	//code for fpo dashboard counts reference taken from the old code for implementation
	
	@ApiOperation(value="Get Zayad Products By Master Id",code=200,produces = "application/json",notes="Get Zayad Products By Master Id",response=DataDisplayDto.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ErrorResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ErrorResponse.class, message = "Unauthorized"),})
	@GetMapping("/getZayadProducts")
	public List<DataDisplayDto>  getZayadProdList(@NotNull @RequestParam("master_id") Integer masterId)
	{
			return dashboardService.getFPOprodzayad(masterId);	
	}
	@ApiOperation(value="Get Rabi Products By Master Id",code=200,produces = "application/json",notes="API to get Rabi Products By Master Id",response=DataDisplayDto.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ErrorResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ErrorResponse.class, message = "Unauthorized"),})
	@GetMapping("/getRabiProducts")
	public List<DataDisplayDto> getRabiProdList(@NotNull @RequestParam("master_id") Integer masterId)
	{
			return dashboardService.getFPOprodrabi(masterId);	
	}
	@ApiOperation(value="Get Kharif Products By Master Id",code=200,produces = "application/json",notes="API to Get Kharif Products By Master Id",response=DataDisplayDto.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ErrorResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ErrorResponse.class, message = "Unauthorized"),})
	@GetMapping("/getKharifProducts")
	public List<DataDisplayDto> getKharifProdList(@NotNull @RequestParam("master_id") Integer masterId)
	{
			return dashboardService.getFPOprodkharif(masterId);	
	}
	@ApiOperation(value="Get Production List of Actual Rabi crops by master id",code=200,produces = "application/json",notes="API to Get Production List of Actual Rabi crops",response=ReportDTO.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ErrorResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ErrorResponse.class, message = "Unauthorized"),})
	@GetMapping("/getRabiActualProducts")
	public List<ReportDTO> getRabiProdListActual(@NotNull @RequestParam("master_id") Integer masterId)
	{
			return dashboardService.rabiProductionCropWise_actual(masterId);	
	}
	@ApiOperation(value="Get Production List of Actual kharif crops by master id",code=200,produces = "application/json",notes="API to Get Production List of Actual kharif crops",response=ReportDTO.class,responseContainer="list")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ErrorResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ErrorResponse.class, message = "Unauthorized"),})
	@GetMapping("/getKharifActualProducts")
	public List<ReportDTO> getKharifProdListActual(@NotNull @RequestParam("master_id") Integer masterId)
	{
		return dashboardService.kharifProductionCropWise_actual(masterId);
	}
	@ApiOperation(value="Get Production List of Actual zayad crops by master id",code=200,produces = "application/json",notes="Get Production List of Actual zayad crops by master id",response=ReportDTO.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ErrorResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ErrorResponse.class, message = "Unauthorized"),})
	@GetMapping("/getZayadActualProducts")
	public List<ReportDTO> getZayadProdListActual(@NotNull @RequestParam("master_id") Integer masterId)
	{
			return dashboardService.zayadProductionCropWise_actual(masterId);	
	}
	
	@ApiOperation(value="get all charts data of fpo dashboard",code=200,produces = "application/json",notes="API to get all charts data of fpo dashboard",response=FpoDashboardData.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ErrorResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ErrorResponse.class, message = "Unauthorized"),})
	@GetMapping("/getAllFpoDashboardData")
	public FpoDashboardData getAllFpoDashData(@NotNull @RequestParam("master_id") Integer masterId)
	{
			return dashboardService.getFpoDashboardData(masterId);	
	}
	
}



