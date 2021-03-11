package com.upfpo.app.dto;

public class InputSupplierDashboardFertilizerDTO 
{
	private Integer fertilizerNameId;
	
	private String fertilizerName;
	
	private String fertilizerGrade;
	
	private Double fertilizerQty;
	
	public InputSupplierDashboardFertilizerDTO(Integer fertilizerNameId, String fertilizerName, String fertilizerGrade,
			Double fertilizerQty) {
		super();
		this.fertilizerNameId = fertilizerNameId;
		this.fertilizerName = fertilizerName;
		this.fertilizerGrade = fertilizerGrade;
		this.fertilizerQty = fertilizerQty;
	}

	public Integer getFertilizerNameId() {
		return fertilizerNameId;
	}

	public void setFertilizerNameId(Integer fertilizerNameId) {
		this.fertilizerNameId = fertilizerNameId;
	}

	public String getFertilizerName() {
		return fertilizerName;
	}

	public void setFertilizerName(String fertilizerName) {
		this.fertilizerName = fertilizerName;
	}

	public String getFertilizerGrade() {
		return fertilizerGrade;
	}

	public void setFertilizerGrade(String fertilizerGrade) {
		this.fertilizerGrade = fertilizerGrade;
	}

	public Double getFertilizerQty() {
		return fertilizerQty;
	}

	public void setFertilizerQty(Double fertilizerQty) {
		this.fertilizerQty = fertilizerQty;
	}
	
	
}
