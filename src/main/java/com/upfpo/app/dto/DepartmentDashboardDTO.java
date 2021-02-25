package com.upfpo.app.dto;

public class DepartmentDashboardDTO 
{
	private Integer totalFpo;
	
	private Double landArea;
	
	private Integer totalfarmers;
	
	private Double totalMarginalFarmer;
	
	private Double totalSmallFarmer;
	
	private Double totalOtherFarmer;

	public Double getLandArea() {
		return landArea;
	}

	public void setLandArea(Double landArea) {
		this.landArea = landArea;
	}

	public Integer getTotalFpo() {
		return totalFpo;
	}

	public void setTotalFpo(Integer totalFpo) {
		this.totalFpo = totalFpo;
	}

	public Integer getTotalfarmers() {
		return totalfarmers;
	}

	public void setTotalfarmers(Integer totalfarmers) {
		this.totalfarmers = totalfarmers;
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
	
}
