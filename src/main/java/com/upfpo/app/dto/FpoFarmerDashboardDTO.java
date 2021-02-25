package com.upfpo.app.dto;

import java.util.List;

public class FpoFarmerDashboardDTO 
{
	private Integer totalFpoFarmer;
	
	private Double totalMarginalFarmer;
	
	private Double totalSmallFarmer;
	
	private Double totalOtherFarmer;
	
	private Double landArea;
	
	private Integer crops;
	
	private FpoActualProdDashboardDTO fpoActualProduction;
	
	private FpoMarkeProdDashboardDTO  fpoMarketableProduction;

	public Integer getTotalFpoFarmer() {
		return totalFpoFarmer;
	}

	public void setTotalFpoFarmer(Integer totalFpoFarmer) {
		this.totalFpoFarmer = totalFpoFarmer;
	}

	public Double getTotalMarginalFarmer() {
		return totalMarginalFarmer;
	}

	public void setTotalMarginalFarmer(Double totalMarginalFarmer) {
		this.totalMarginalFarmer = totalMarginalFarmer;
	}

	public Double getTotalSmallFarmer() {
		return totalSmallFarmer;
	}

	public void setTotalSmallFarmer(Double totalSmallFarmer) {
		this.totalSmallFarmer = totalSmallFarmer;
	}

	public Double getTotalOtherFarmer() {
		return totalOtherFarmer;
	}

	public void setTotalOtherFarmer(Double totalOtherFarmer) {
		this.totalOtherFarmer = totalOtherFarmer;
	}

	public Double getLandArea() {
		return landArea;
	}

	public void setLandArea(Double landArea) {
		this.landArea = landArea;
	}

	public Integer getCrops() {
		return crops;
	}

	public void setCrops(Integer crops) {
		this.crops = crops;
	}

	public FpoActualProdDashboardDTO getFpoActualProduction() {
		return fpoActualProduction;
	}

	public void setFpoActualProduction(FpoActualProdDashboardDTO fpoActualProduction) {
		this.fpoActualProduction = fpoActualProduction;
	}

	public FpoMarkeProdDashboardDTO getFpoMarketableProduction() {
		return fpoMarketableProduction;
	}

	public void setFpoMarketableProduction(FpoMarkeProdDashboardDTO fpoMarketableProduction) {
		this.fpoMarketableProduction = fpoMarketableProduction;
	}
	
	
	
}
