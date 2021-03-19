package com.upfpo.app.dto;

public class DepartmentSalesReportDto {
	
	private String fpo_name;
	private String district_name;
	private Integer cropId;
	private String crop_name;
	private Integer verietyId;
	private String crop_veriety;
	private Double sold_quantity;
	
	public DepartmentSalesReportDto(String fpo_name, String district_name, Integer cropId, String crop_name,
			Integer verietyId, String crop_veriety, Double sold_quantity) {
		super();
		this.fpo_name = fpo_name;
		this.district_name = district_name;
		this.cropId = cropId;
		this.crop_name = crop_name;
		this.verietyId = verietyId;
		this.crop_veriety = crop_veriety;
		this.sold_quantity = sold_quantity;
	}
	public String getFpo_name() {
		return fpo_name;
	}
	public void setFpo_name(String fpo_name) {
		this.fpo_name = fpo_name;
	}
	public String getDistrict_name() {
		return district_name;
	}
	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}
	public Integer getCropId() {
		return cropId;
	}
	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}
	public String getCrop_name() {
		return crop_name;
	}
	public void setCrop_name(String crop_name) {
		this.crop_name = crop_name;
	}
	public Integer getVerietyId() {
		return verietyId;
	}
	public void setVerietyId(Integer verietyId) {
		this.verietyId = verietyId;
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

