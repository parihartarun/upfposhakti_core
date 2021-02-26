package com.upfpo.app.dto;

import java.util.List;

public class DepartmentDashboardDTO 
{
	private Integer totalFpo;
	
	private Double landArea;
	
	private Integer totalfarmers;
	
	private Double totalMarginalFarmer;
	
	private Double totalSmallFarmer;
	
	private Double totalOtherFarmer;
	
	private DeptActualProductionDTO deptActualProduction;
	
	private DeptMarketableProductionDTO deptMarketableProduction;
	
	private List<DeptFpoAgencyDTO> deptFpoAgency;
	
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
	
	public DeptActualProductionDTO getDeptActualProduction() {
		return deptActualProduction;
	}

	public void setDeptActualProduction(DeptActualProductionDTO deptActualProduction) {
		this.deptActualProduction = deptActualProduction;
	}

	public DeptMarketableProductionDTO getDeptMarketableProduction() {
		return deptMarketableProduction;
	}

	public void setDeptMarketableProduction(DeptMarketableProductionDTO deptMarketableProduction) {
		this.deptMarketableProduction = deptMarketableProduction;
	}

	public List<DeptFpoAgencyDTO> getDeptFpoAgency() {
		return deptFpoAgency;
	}

	public void setDeptFpoAgency(List<DeptFpoAgencyDTO> deptFpoAgency) {
		this.deptFpoAgency = deptFpoAgency;
	}
	
}