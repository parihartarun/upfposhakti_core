package com.upfpo.app.dto;

public class DepartmentSalesReportDto {
	
	
	private String district_name;
	private String fpo_name;
	private String crop_name;
	private String crop_veriety;
	private Double sold_quantity;
	
	public DepartmentSalesReportDto(String district_name, String fpo_name, String crop_name, String crop_veriety, Double sold_quantity) {
		super();
		this.district_name = district_name;
		this.fpo_name = fpo_name;
		this.crop_name = crop_name;
		this.crop_veriety = crop_veriety;
		this.sold_quantity = sold_quantity;
	}
	public String getDistrict_name() {
		return district_name;
	}
	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}
	public String getFpo_name() {
		return fpo_name;
	}
	public void setFpo_name(String fpo_name) {
		this.fpo_name = fpo_name;
	}
	public String getCrop_name() {
		return crop_name;
	}
	public void setCrop_name(String crop_name) {
		this.crop_name = crop_name;
	}
	public String getCrop_veriety() {
		return crop_veriety;
	}
	public void setCrop_veriety(String crop_veriety) {
		this.crop_veriety = crop_veriety;
	}
	
	public Double getSold_quantity() {
		return sold_quantity;
	}
	public void setSold_quantity(Double sold_quantity) {
		this.sold_quantity = sold_quantity;
	}
	
	
}

