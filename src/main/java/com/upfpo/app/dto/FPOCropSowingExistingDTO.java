 package com.upfpo.app.dto;

import java.math.BigInteger;

public class FPOCropSowingExistingDTO 
{

	private Integer sowing_id;
	
	private String fin_year;
	
	private Integer crop_id;
	
	private Integer season_ref;
	
	private Integer veriety_ref;
	
	private Integer crop_ref;
	
	private BigInteger ex_yield;
	
	private Double actual_yield;
	
	private Double sowing_area;
	
	private Integer crop_master_id;
	
	private String crop_name;
	
	private Integer farmer_id;
	
	private String farmer_name;
	
	private String father_husband_name;
	
	private Integer season_id;
	
	private String season_name;
	
	private Integer veriety_id;
	
	private String crop_veriety;
	

	public FPOCropSowingExistingDTO(Integer sowing_id, String fin_year, Integer crop_id, Integer season_ref,
			Integer veriety_ref, Integer crop_ref, BigInteger ex_yield, Double actual_yield, Double sowing_area,
			Integer crop_master_id, String crop_name, Integer farmer_id, String farmer_name, String father_husband_name,
			Integer season_id, String season_name, Integer veriety_id, String crop_veriety) {
		super();
		this.sowing_id = sowing_id;
		this.fin_year = fin_year;
		this.crop_id = crop_id;
		this.season_ref = season_ref;
		this.veriety_ref = veriety_ref;
		this.crop_ref = crop_ref;
		this.ex_yield = ex_yield;
		this.actual_yield = actual_yield;
		this.sowing_area = sowing_area;
		this.crop_master_id = crop_master_id;
		this.crop_name = crop_name;
		this.farmer_id = farmer_id;
		this.farmer_name = farmer_name;
		this.father_husband_name = father_husband_name;
		this.season_id = season_id;
		this.season_name = season_name;
		this.veriety_id = veriety_id;
		this.crop_veriety = crop_veriety;
	}

	public Integer getSowing_id() {
		return sowing_id;
	}

	public void setSowing_id(Integer sowing_id) {
		this.sowing_id = sowing_id;
	}

	public String getFin_year() {
		return fin_year;
	}

	public void setFin_year(String fin_year) {
		this.fin_year = fin_year;
	}

	public Integer getCrop_id() {
		return crop_id;
	}

	public void setCrop_id(Integer crop_id) {
		this.crop_id = crop_id;
	}

	public Integer getSeason_ref() {
		return season_ref;
	}

	public void setSeason_ref(Integer season_ref) {
		this.season_ref = season_ref;
	}

	public Integer getVeriety_ref() {
		return veriety_ref;
	}

	public void setVeriety_ref(Integer veriety_ref) {
		this.veriety_ref = veriety_ref;
	}

	public Integer getCrop_ref() {
		return crop_ref;
	}

	public void setCrop_ref(Integer crop_ref) {
		this.crop_ref = crop_ref;
	}

	public BigInteger getEx_yield() {
		return ex_yield;
	}

	public void setEx_yield(BigInteger ex_yield) {
		this.ex_yield = ex_yield;
	}

	public Double getActual_yield() {
		return actual_yield;
	}

	public void setActual_yield(Double actual_yield) {
		this.actual_yield = actual_yield;
	}

	public Double getSowing_area() {
		return sowing_area;
	}

	public void setSowing_area(Double sowing_area) {
		this.sowing_area = sowing_area;
	}

	public Integer getCrop_master_id() {
		return crop_master_id;
	}

	public void setCrop_master_id(Integer crop_master_id) {
		this.crop_master_id = crop_master_id;
	}

	public String getCrop_name() {
		return crop_name;
	}

	public void setCrop_name(String crop_name) {
		this.crop_name = crop_name;
	}

	public Integer getFarmer_id() {
		return farmer_id;
	}

	public void setFarmer_id(Integer farmer_id) {
		this.farmer_id = farmer_id;
	}

	public String getFarmer_name() {
		return farmer_name;
	}

	public void setFarmer_name(String farmer_name) {
		this.farmer_name = farmer_name;
	}

	public String getFather_husband_name() {
		return father_husband_name;
	}

	public void setFather_husband_name(String father_husband_name) {
		this.father_husband_name = father_husband_name;
	}

	public Integer getSeason_id() {
		return season_id;
	}

	public void setSeason_id(Integer season_id) {
		this.season_id = season_id;
	}

	public String getSeason_name() {
		return season_name;
	}

	public void setSeason_name(String season_name) {
		this.season_name = season_name;
	}

	public Integer getVeriety_id() {
		return veriety_id;
	}

	public void setVeriety_id(Integer veriety_id) {
		this.veriety_id = veriety_id;
	}

	public String getCrop_veriety() {
		return crop_veriety;
	}

	public void setCrop_veriety(String crop_veriety) {
		this.crop_veriety = crop_veriety;
	}
	
	
	
}
