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
	
	private List<FpoMarkeProdDashboardDTO> fpoMarketableQty;
	
	private List<FpoActualProdDashboardDTO> fpoActualQty;
	
	public FpoFarmerDashboardDTO() {
	}

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

	public List<FpoMarkeProdDashboardDTO> getFpoMarketableQty() {
		return fpoMarketableQty;
	}

	public void setFpoMarketableQty(List<FpoMarkeProdDashboardDTO> fpoMarketableQty) {
		this.fpoMarketableQty = fpoMarketableQty;
	}

	public List<FpoActualProdDashboardDTO> getFpoActualQty() {
		return fpoActualQty;
	}

	public void setFpoActualQty(List<FpoActualProdDashboardDTO> fpoActualQty) {
		this.fpoActualQty = fpoActualQty;
	}
	
	
}
