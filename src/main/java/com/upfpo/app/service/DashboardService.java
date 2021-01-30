package com.upfpo.app.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.upfpo.app.dto.DataDisplayDto;
import com.upfpo.app.dto.FpoDashboardData;
import com.upfpo.app.dto.ReportDTO;
import com.upfpo.app.entity.DashBoardData;

@Service
public interface DashboardService {

	
	public DashBoardData getDbd();
	public FpoDashboardData getFpoDashboardData(@NotNull Integer masterId);
	public List<DataDisplayDto> getFPOprodzayad(Integer fpoId);
	public List<DataDisplayDto> getFPOprodrabi(Integer fpoId);
	public List<DataDisplayDto> getFPOprodkharif(Integer fpoId);
	public List<DataDisplayDto> getProdZayad();
	public List<DataDisplayDto> getProdRabi();
	public List<DataDisplayDto> getProdKharif();
	public List <ReportDTO> rabiProductionCropWise_actual(Integer masterId);
	public List <ReportDTO> kharifProductionCropWise_actual(Integer masterId);
	public List <ReportDTO> zayadProductionCropWise_actual(Integer masterId);	
	public List <ReportDTO> rabiProductionCropWise_actual_all();
	public List <ReportDTO> kharifProductionCropWise_actual_all();
	public List <ReportDTO> zayadProductionCropWise_actual_all();
	public Double  totalLand();
	public Double  totalLand(Integer fpoid);
	public Integer  numberCrops();
	public Integer  numberCrops(Integer fpoId);
	public Integer totalFarmerCount();
	public Integer totalSmallFarmerCount();
	public Integer totalMarginalFarmerCount();
	public Integer totalOtherFarmerCount();
	public Integer totalFarmerCount(Integer fpoId);
	public Integer totalSmallFarmerCount(Integer fpoId);
	public Integer totalMarginalFarmerCount(Integer fpoId);
	public Integer totalOtherFarmerCount(Integer fpoId);
}
