package com.upfpo.app.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.dto.DataDisplayDto;
import com.upfpo.app.dto.FpoDashboardData;
import com.upfpo.app.dto.ReportDTO;
import com.upfpo.app.entity.DashBoardData;
import com.upfpo.app.service.DashboardService;

@RestController
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
	@GetMapping("/getZayadProducts")
	public List<DataDisplayDto>  getZayadProdList(@NotNull @RequestParam("master_id") Integer masterId)
	{
			return dashboardService.getFPOprodzayad(masterId);	
	}
	
	@GetMapping("/getRabiProducts")
	public List<DataDisplayDto> getRabiProdList(@NotNull @RequestParam("master_id") Integer masterId)
	{
			return dashboardService.getFPOprodrabi(masterId);	
	}
	
	@GetMapping("/getKharifProducts")
	public List<DataDisplayDto> getKharifProdList(@NotNull @RequestParam("master_id") Integer masterId)
	{
			return dashboardService.getFPOprodkharif(masterId);	
	}
	
	@GetMapping("/getRabiActualProducts")
	public List<ReportDTO> getRabiProdListActual(@NotNull @RequestParam("master_id") Integer masterId)
	{
			return dashboardService.rabiProductionCropWise_actual(masterId);	
	}
	
	@GetMapping("/getKharifActualProducts")
	public List<ReportDTO> getKharifProdListActual(@NotNull @RequestParam("master_id") Integer masterId)
	{
		return dashboardService.kharifProductionCropWise_actual(masterId);
	}
	
	@GetMapping("/getZayadActualProducts")
	public List<ReportDTO> getZayadProdListActual(@NotNull @RequestParam("master_id") Integer masterId)
	{
			return dashboardService.zayadProductionCropWise_actual(masterId);	
	}
	
	
	@GetMapping("/getAllFpoDashboardData")
	public FpoDashboardData getAllFpoDashData(@NotNull @RequestParam("master_id") Integer masterId)
	{
			return dashboardService.getFpoDashboardData(masterId);	
	}
	
}



