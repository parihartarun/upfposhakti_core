package com.upfpo.app.dto;

import java.math.BigInteger;

public class DepartmentProdReportDto {
	
	
	private String district_name;
	private String fpo_name;
	private String fpo_address;
	private BigInteger fpo_landline;
	private String crop_name;
	private String crop_veriety;
	private BigInteger total_farmers;
	private Integer sowing_area;
	private BigInteger estimated_production;
	private BigInteger actual_production;
	//private Double sold_quantity;
	
	public DepartmentProdReportDto(String district_name, String fpo_name, String fpo_address, BigInteger fpo_landline,
			String crop_name, String crop_veriety, BigInteger total_farmers, Integer sowing_area,
			BigInteger estimated_production, BigInteger actual_production) {
		super();
		this.district_name = district_name;
		this.fpo_name = fpo_name;
		this.fpo_address = fpo_address;
		this.fpo_landline = fpo_landline;
		this.crop_name = crop_name;
		this.crop_veriety = crop_veriety;
		this.total_farmers = total_farmers;
		this.sowing_area = sowing_area;
		this.estimated_production = estimated_production;
		this.actual_production = actual_production;
		//this.sold_quantity = sold_quantity;
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

	public String getFpo_address() {
		return fpo_address;
	}

	public void setFpo_address(String fpo_address) {
		this.fpo_address = fpo_address;
	}

	public BigInteger getFpo_landline() {
		return fpo_landline;
	}

	public void setFpo_landline(BigInteger fpo_landline) {
		this.fpo_landline = fpo_landline;
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

	public BigInteger getTotal_farmers() {
		return total_farmers;
	}

	public void setTotal_farmers(BigInteger total_farmers) {
		this.total_farmers = total_farmers;
	}

	public Integer getSowing_area() {
		return sowing_area;
	}

	public void setSowing_area(Integer sowing_area) {
		this.sowing_area = sowing_area;
	}

	public BigInteger getEstimated_production() {
		return estimated_production;
	}

	public void setEstimated_production(BigInteger estimated_production) {
		this.estimated_production = estimated_production;
	}

	public BigInteger getActual_production() {
		return actual_production;
	}

	public void setActual_production(BigInteger actual_production) {
		this.actual_production = actual_production;
	}

//	public Double getSold_quantity() {
//		return sold_quantity;
//	}
//
//	public void setSold_quantity(Double sold_quantity) {
//		this.sold_quantity = sold_quantity;
//	}
	
	
}

