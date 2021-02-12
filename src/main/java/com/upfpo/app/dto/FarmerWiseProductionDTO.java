package com.upfpo.app.dto;

import java.math.BigInteger;

public class FarmerWiseProductionDTO 
{
	private String farmer_name;
	
	private String father_husband_name;
	
	private BigInteger mobile;
	
	private String gender;
	
	private String category;
	
	private String season_name;
	
	private String crop_name;
	
	private String crop_veriety;
	
	private Double marketable_surplus;
	
	

	public FarmerWiseProductionDTO(String farmer_name, String father_husband_name, BigInteger mobile, String gender,
			String category, String season_name, String crop_name, String crop_veriety, Double marketable_surplus) {
		super();
		this.farmer_name = farmer_name;
		this.father_husband_name = father_husband_name;
		this.mobile = mobile;
		this.gender = gender;
		this.category = category;
		this.season_name = season_name;
		this.crop_name = crop_name;
		this.crop_veriety = crop_veriety;
		this.marketable_surplus = marketable_surplus;
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

	public BigInteger getMobile() {
		return mobile;
	}

	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSeason_name() {
		return season_name;
	}

	public void setSeason_name(String season_name) {
		this.season_name = season_name;
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

	public Double getMarketable_surplus() {
		return marketable_surplus;
	}

	public void setMarketable_surplus(Double marketable_surplus) {
		this.marketable_surplus = marketable_surplus;
	}	
	
}
