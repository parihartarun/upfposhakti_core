package com.upfpo.app.dto;

import java.util.List;

public class FpoDashboardData {

	private Integer land;
	private Integer cropNo;
	private Integer farmers;
	private Integer smallFarmers;
	private Integer marginalFarmers;
	private Integer otherfarmers;
	private List<DataDisplayDto> zayadProdList;
	private List<DataDisplayDto> rabiProdList;
	private List<DataDisplayDto> kharifProdList;
	private List<ReportDTO> rabiProdListActual;
	private List<ReportDTO> kharifProdListActual;
	private List<ReportDTO> zayadProdListActual;
	
	public FpoDashboardData(Integer land, Integer cropNo, Integer farmers, Integer smallFarmers,
			Integer marginalFarmers, Integer otherfarmers, List<DataDisplayDto> zayadProdList,
			List<DataDisplayDto> rabiProdList, List<DataDisplayDto> kharifProdList, List<ReportDTO> rabiProdListActual,
			List<ReportDTO> kharifProdListActual, List<ReportDTO> zayadProdListActual) {
		super();
		this.land = land;
		this.cropNo = cropNo;
		this.farmers = farmers;
		this.smallFarmers = smallFarmers;
		this.marginalFarmers = marginalFarmers;
		this.otherfarmers = otherfarmers;
		this.zayadProdList = zayadProdList;
		this.rabiProdList = rabiProdList;
		this.kharifProdList = kharifProdList;
		this.rabiProdListActual = rabiProdListActual;
		this.kharifProdListActual = kharifProdListActual;
		this.zayadProdListActual = zayadProdListActual;
	}
	public FpoDashboardData() {
		// TODO Auto-generated constructor stub
	}
	public Integer getLand() {
		return land;
	}
	public void setLand(Integer land) {
		this.land = land;
	}
	public Integer getCropNo() {
		return cropNo;
	}
	public void setCropNo(Integer cropNo) {
		this.cropNo = cropNo;
	}
	public Integer getFarmers() {
		return farmers;
	}
	public void setFarmers(Integer farmers) {
		this.farmers = farmers;
	}
	public Integer getSmallFarmers() {
		return smallFarmers;
	}
	public void setSmallFarmers(Integer smallFarmers) {
		this.smallFarmers = smallFarmers;
	}
	public Integer getMarginalFarmers() {
		return marginalFarmers;
	}
	public void setMarginalFarmers(Integer marginalFarmers) {
		this.marginalFarmers = marginalFarmers;
	}
	public Integer getOtherfarmers() {
		return otherfarmers;
	}
	public void setOtherfarmers(Integer otherfarmers) {
		this.otherfarmers = otherfarmers;
	}
	public List<DataDisplayDto> getZayadProdList() {
		return zayadProdList;
	}
	public void setZayadProdList(List<DataDisplayDto> zayadProdList) {
		this.zayadProdList = zayadProdList;
	}
	public List<DataDisplayDto> getRabiProdList() {
		return rabiProdList;
	}
	public void setRabiProdList(List<DataDisplayDto> rabiProdList) {
		this.rabiProdList = rabiProdList;
	}
	public List<DataDisplayDto> getKharifProdList() {
		return kharifProdList;
	}
	public void setKharifProdList(List<DataDisplayDto> kharifProdList) {
		this.kharifProdList = kharifProdList;
	}
	public List<ReportDTO> getRabiProdListActual() {
		return rabiProdListActual;
	}
	public void setRabiProdListActual(List<ReportDTO> rabiProdListActual) {
		this.rabiProdListActual = rabiProdListActual;
	}
	public List<ReportDTO> getKharifProdListActual() {
		return kharifProdListActual;
	}
	public void setKharifProdListActual(List<ReportDTO> kharifProdListActual) {
		this.kharifProdListActual = kharifProdListActual;
	}
	public List<ReportDTO> getZayadProdListActual() {
		return zayadProdListActual;
	}
	public void setZayadProdListActual(List<ReportDTO> zayadProdListActual) {
		this.zayadProdListActual = zayadProdListActual;
	}
	
	
}
