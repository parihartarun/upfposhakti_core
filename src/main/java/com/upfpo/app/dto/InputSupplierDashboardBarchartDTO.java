package com.upfpo.app.dto;

import java.util.List;

public class InputSupplierDashboardBarchartDTO 
{
	private List<InputSupplierDashboardDTO> insecticidesBarChart;
	
	private List<InputSupplierDashBoardSeedDTO> seedsBarChart;
	
	private List<InputSupplierDashboardFertilizerDTO> fertilizerBarChart;
	
	private List<InputSupplierDashboardMachineryDTO> machineryBarChart;

	public List<InputSupplierDashboardDTO> getInsecticidesBarChart() {
		return insecticidesBarChart;
	}

	public void setInsecticidesBarChart(List<InputSupplierDashboardDTO> insecticidesBarChart) {
		this.insecticidesBarChart = insecticidesBarChart;
	}

	public List<InputSupplierDashBoardSeedDTO> getSeedsBarChart() {
		return seedsBarChart;
	}

	public void setSeedsBarChart(List<InputSupplierDashBoardSeedDTO> seedsBarChart) {
		this.seedsBarChart = seedsBarChart;
	}

	public List<InputSupplierDashboardFertilizerDTO> getFertilizerBarChart() {
		return fertilizerBarChart;
	}

	public void setFertilizerBarChart(List<InputSupplierDashboardFertilizerDTO> fertilizerBarChart) {
		this.fertilizerBarChart = fertilizerBarChart;
	}

	public List<InputSupplierDashboardMachineryDTO> getMachineryBarChart() {
		return machineryBarChart;
	}

	public void setMachineryBarChart(List<InputSupplierDashboardMachineryDTO> machineryBarChart) {
		this.machineryBarChart = machineryBarChart;
	}
	
}
