package com.upfpo.app.dto;

import java.math.BigInteger;

import javax.persistence.ColumnResult;

public class CropListOfFarmersDTO 
{	
	private Integer id;  
    private Integer farmer_id; 
    private String farmer_name;
    private String father_husband_name;
    private String financial_year;
    private Integer season_id;
    
    public CropListOfFarmersDTO(Integer id, Integer farmer_id, String farmer_name, String father_husband_name,
			String financial_year, Integer season_id, String season_name, Integer sowing_id, Integer crop_id,
			String crop_name, String crop_veriety, Double sowing_area, BigInteger ex_yield, Integer veriety_id) {
		super();
		this.id = id;
		this.farmer_id = farmer_id;
		this.farmer_name = farmer_name;
		this.father_husband_name = father_husband_name;
		this.financial_year = financial_year;
		this.season_id = season_id;
		this.season_name = season_name;
		this.sowing_id = sowing_id;
		this.crop_id = crop_id;
		this.crop_name = crop_name;
		this.crop_veriety = crop_veriety;
		this.sowing_area = sowing_area;
		this.ex_yield = ex_yield;
		this.veriety_id = veriety_id;
	}
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getFinancial_year() {
		return financial_year;
	}
	public void setFinancial_year(String financial_year) {
		this.financial_year = financial_year;
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
	public Integer getSowing_id() {
		return sowing_id;
	}
	public void setSowing_id(Integer sowing_id) {
		this.sowing_id = sowing_id;
	}
	public Integer getCrop_id() {
		return crop_id;
	}
	public void setCrop_id(Integer crop_id) {
		this.crop_id = crop_id;
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
	public Double getSowing_area() {
		return sowing_area;
	}
	public void setSowing_area(Double sowing_area) {
		this.sowing_area = sowing_area;
	}
	public BigInteger getEx_yield() {
		return ex_yield;
	}
	public void setEx_yield(BigInteger ex_yield) {
		this.ex_yield = ex_yield;
	}
	public Integer getVeriety_id() {
		return veriety_id;
	}
	public void setVeriety_id(Integer veriety_id) {
		this.veriety_id = veriety_id;
	}
	private String season_name;  
    private Integer sowing_id;
    private Integer crop_id;
    private String crop_name;
    private String crop_veriety;
    private Double sowing_area; 
    private BigInteger ex_yield;
    private Integer veriety_id;

}
