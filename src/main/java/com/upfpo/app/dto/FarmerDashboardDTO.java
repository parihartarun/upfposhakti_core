package com.upfpo.app.dto;

import java.util.List;

public class FarmerDashboardDTO 
{
	private Double landArea;
	
	private Double cultivatedLand;
	
	private Double uncultivatedLand;
	
	private Integer crops;
	
	private List<FarmerCropProductionDTO> expectedYeildRabi;
	
	private List<FarmerCropProductionDTO> expectedYeildZayad;
	
	private List<FarmerCropProductionDTO> expectedYeildKhrif;
	
	private List<FarmerCropProductionDTO> actualYeildRabi;
	
	private List<FarmerCropProductionDTO> actualYeildZayad;
	
	private List<FarmerCropProductionDTO> actualYeildKharif;

	public Double getLandArea() {
		return landArea;
	}

	public void setLandArea(Double landArea) {
		this.landArea = landArea;
	}

	public Double getCultivatedLand() {
		return cultivatedLand;
	}

	public void setCultivatedLand(Double cultivatedLand) {
		this.cultivatedLand = cultivatedLand;
	}

	public Double getUncultivatedLand() {
		return uncultivatedLand;
	}

	public void setUncultivatedLand(Double uncultivatedLand) {
		this.uncultivatedLand = uncultivatedLand;
	}

	public Integer getCrops() {
		return crops;
	}

	public void setCrops(Integer crops) {
		this.crops = crops;
	}

	public List<FarmerCropProductionDTO> getExpectedYeildRabi() {
		return expectedYeildRabi;
	}

	public void setExpectedYeildRabi(List<FarmerCropProductionDTO> expectedYeildRabi) {
		this.expectedYeildRabi = expectedYeildRabi;
	}

	public List<FarmerCropProductionDTO> getExpectedYeildZayad() {
		return expectedYeildZayad;
	}

	public void setExpectedYeildZayad(List<FarmerCropProductionDTO> expectedYeildZayad) {
		this.expectedYeildZayad = expectedYeildZayad;
	}

	public List<FarmerCropProductionDTO> getExpectedYeildKhrif() {
		return expectedYeildKhrif;
	}

	public void setExpectedYeildKhrif(List<FarmerCropProductionDTO> expectedYeildKhrif) {
		this.expectedYeildKhrif = expectedYeildKhrif;
	}

	public List<FarmerCropProductionDTO> getActualYeildRabi() {
		return actualYeildRabi;
	}

	public void setActualYeildRabi(List<FarmerCropProductionDTO> actualYeildRabi) {
		this.actualYeildRabi = actualYeildRabi;
	}

	public List<FarmerCropProductionDTO> getActualYeildZayad() {
		return actualYeildZayad;
	}

	public void setActualYeildZayad(List<FarmerCropProductionDTO> actualYeildZayad) {
		this.actualYeildZayad = actualYeildZayad;
	}

	public List<FarmerCropProductionDTO> getActualYeildKharif() {
		return actualYeildKharif;
	}

	public void setActualYeildKharif(List<FarmerCropProductionDTO> actualYeildKharif) {
		this.actualYeildKharif = actualYeildKharif;
	}
	
}
