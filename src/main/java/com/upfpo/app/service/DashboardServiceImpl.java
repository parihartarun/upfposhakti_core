package com.upfpo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.DataDisplayDto;
import com.upfpo.app.dto.FpoDashboardData;
import com.upfpo.app.dto.ReportDTO;
import com.upfpo.app.entity.DashBoardData;
import com.upfpo.app.repository.DashBoardRepository;
import com.upfpo.app.repository.DataDisplayRepository;
import com.upfpo.app.util.GetFinYear;

@Service
public class DashboardServiceImpl implements DashboardService {
	@Autowired 
	private DashBoardRepository dashBoardRepository;

	@Autowired 
	private DataDisplayRepository dataDisplayRepository;
	
	@Override
	public DashBoardData getDbd() {
		// TODO Auto-generated method stub
		return dashBoardRepository.getFarmCropDetailsForDepatment();
	}
	
	
	
	

	@Override
	public FpoDashboardData getFpoDashboardData(Integer masterId) {
		
		FpoDashboardData fpoDashboardData = new FpoDashboardData();
		fpoDashboardData.setCropNo(null);
		fpoDashboardData.setFarmers(null);
		fpoDashboardData.setLand(null);
		fpoDashboardData.setSmallFarmers(null);
		fpoDashboardData.setMarginalFarmers(null);
		fpoDashboardData.setOtherfarmers(null);
		
		fpoDashboardData.setRabiProdList(getFPOprodrabi(masterId));
		fpoDashboardData.setRabiProdListActual(rabiProductionCropWise_actual(masterId));
		fpoDashboardData.setZayadProdList(getFPOprodzayad(masterId));
		fpoDashboardData.setZayadProdListActual(zayadProductionCropWise_actual(masterId));
		fpoDashboardData.setKharifProdList(getFPOprodkharif(masterId));
		fpoDashboardData.setKharifProdListActual(kharifProductionCropWise_actual(masterId));
		
		
		
//		mav.addAttribute("land",(int) Math.round(masterServices.totalLand((Integer) httpSession.getAttribute("masterId"))));
//		mav.addAttribute("cropno",masterServices.numberCrops((Integer) httpSession.getAttribute("masterId")));
//
//		mav.addAttribute("zayadprodList",displayServices.getFPOprodzayad((Integer) httpSession.getAttribute("masterId"),GetFinYear.getCurrentFinYear()));
//		mav.addAttribute("rabiprodList",displayServices.getFPOprodrabi((Integer) httpSession.getAttribute("masterId"),GetFinYear.getCurrentFinYear()));
//		mav.addAttribute("kharifprodList",displayServices.getFPOprodkharif((Integer) httpSession.getAttribute("masterId"),GetFinYear.getCurrentFinYear()));
//        mav.addAttribute("rabiprodList_actual",fPCReportServices.rabiProductionCropWise_actual((Integer) httpSession.getAttribute("masterId"),GetFinYear.getCurrentFinYear()));
//        mav.addAttribute("kharifprodList_actual",fPCReportServices.kharifProductionCropWise_actual((Integer) httpSession.getAttribute("masterId"),GetFinYear.getCurrentFinYear()));
//        mav.addAttribute("zayadprodList_actual",fPCReportServices.zayadProductionCropWise_actual((Integer) httpSession.getAttribute("masterId"),GetFinYear.getCurrentFinYear()));
//        mav.addAttribute("farmers",masterServices.totalFarmerCount((Integer) httpSession.getAttribute("masterId")));
//		mav.addAttribute("smallfarmers",masterServices.totalSmallFarmerCount((Integer) httpSession.getAttribute("masterId")));
//		mav.addAttribute("marginalfarmers",masterServices.totalMarginalFarmerCount((Integer) httpSession.getAttribute("masterId")));
//		mav.addAttribute("otherfarmers",masterServices.totalOtherFarmerCount((Integer) httpSession.getAttribute("masterId")));// TODO Auto-generated method stub
		return fpoDashboardData;
	}





	@Override
	public List<DataDisplayDto> getFPOprodzayad(Integer fpoId) {
		// TODO Auto-generated method stub
		return dataDisplayRepository.getFPOprodzayad(fpoId,GetFinYear.getCurrentFinYear());
	}





	@Override
	public List<DataDisplayDto> getFPOprodrabi(Integer fpoId) {
		
		return dataDisplayRepository.getFPOprodrabi(fpoId, GetFinYear.getCurrentFinYear());
	}





	@Override
	public List<DataDisplayDto> getFPOprodkharif(Integer fpoId) {
		// TODO Auto-generated method stub
		return dataDisplayRepository.getFPOprodkharif(fpoId,GetFinYear.getCurrentFinYear());
	}





	@Override
	public List<DataDisplayDto> getProdZayad() {
		return dataDisplayRepository.getProdZayad(GetFinYear.getCurrentFinYear());
	}





	@Override
	public List<DataDisplayDto> getProdRabi() {
		return dataDisplayRepository.getProdRabi(GetFinYear.getCurrentFinYear());

	}





	@Override
	public List<DataDisplayDto> getProdKharif() {
		// TODO Auto-generated method stub
		return dataDisplayRepository.getProdKharif(GetFinYear.getCurrentFinYear());
	}





	@Override
	public List<ReportDTO> rabiProductionCropWise_actual(Integer masterId) {
		// TODO Auto-generated method stub
		return dataDisplayRepository.rabiProductionCropWise_actual(masterId, GetFinYear.getCurrentFinYear());
	}





	@Override
	public List<ReportDTO> kharifProductionCropWise_actual(Integer masterId) {
		// TODO Auto-generated method stub
		return dataDisplayRepository.kharifProductionCropWise_actual(masterId, GetFinYear.getCurrentFinYear());
	}





	@Override
	public List<ReportDTO> zayadProductionCropWise_actual(Integer masterId) {
		// TODO Auto-generated method stub
		return dataDisplayRepository.zayadProductionCropWise_actual(masterId, GetFinYear.getCurrentFinYear());
	}





	@Override
	public List<ReportDTO> rabiProductionCropWise_actual_all() {
		
		return dataDisplayRepository.rabiProductionCropWise_actual_all(GetFinYear.getCurrentFinYear());
	}





	@Override
	public List<ReportDTO> kharifProductionCropWise_actual_all() {
		// TODO Auto-generated method stub
		return dataDisplayRepository.kharifProductionCropWise_actual_all(GetFinYear.getCurrentFinYear());
	}





	@Override
	public List<ReportDTO> zayadProductionCropWise_actual_all() {
		
		return dataDisplayRepository.zayadProductionCropWise_actual_all(GetFinYear.getCurrentFinYear());
	}





	@Override
	public Double totalLand() {
		// TODO Auto-generated method stub
return null;	
	}





	@Override
	public Double totalLand(Integer fpoid) {
		// TODO Auto-generated method stub
		return this.dataDisplayRepository.totalLand(fpoid);
	}





	@Override
	public Integer numberCrops() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Integer numberCrops(Integer fpoId) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Integer totalFarmerCount() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Integer totalSmallFarmerCount() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Integer totalMarginalFarmerCount() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Integer totalOtherFarmerCount() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Integer totalFarmerCount(Integer fpoId) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Integer totalSmallFarmerCount(Integer fpoId) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Integer totalMarginalFarmerCount(Integer fpoId) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Integer totalOtherFarmerCount(Integer fpoId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
