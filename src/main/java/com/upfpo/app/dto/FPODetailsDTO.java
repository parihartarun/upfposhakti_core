package com.upfpo.app.dto;

import java.math.BigInteger;

public class FPODetailsDTO {
	
	private Integer id;
	private String unitassla;
	private String state;
	private String district;
	private String nodal;
	private BigInteger mobile;
	private String email;
	private String fpo_lot_no;
	private String associationdate;
	private String crops;
	private String services;
	   
	public String getMarketableSurplus() {
		return marketableSurplus;
	}



	public void setMarketableSurplus(String marketableSurplus) {
		this.marketableSurplus = marketableSurplus;
	}



	public String getActualProduction() {
		return actualProduction;
	}



	public void setActualProduction(String actualProduction) {
		this.actualProduction = actualProduction;
	}



	public String getCropVeriety() {
		return cropVeriety;
	}



	public void setCropVeriety(String cropVeriety) {
		this.cropVeriety = cropVeriety;
	}



	private String marketableSurplus;
	private String actualProduction;
	private String cropVeriety;
	
	
	
	public FPODetailsDTO(Integer id, String unitassla, String state, String district, String nodal, BigInteger mobile,
			String email, String fpo_lot_no, String associationdate, String crops, String services) {
		super();
		this.id = id;
		this.unitassla = unitassla;
		this.state = state;
		this.district = district;
		this.nodal = nodal;
		this.mobile = mobile;
		this.email = email;
		this.fpo_lot_no = fpo_lot_no;
		this.associationdate = associationdate;
		this.crops = crops;
		this.services = services;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getUnitassla() {
		return unitassla;
	}



	public void setUnitassla(String unitassla) {
		this.unitassla = unitassla;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getDistrict() {
		return district;
	}



	public void setDistrict(String district) {
		this.district = district;
	}



	public String getNodal() {
		return nodal;
	}



	public void setNodal(String nodal) {
		this.nodal = nodal;
	}



	public BigInteger getMobile() {
		return mobile;
	}



	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getFpo_lot_no() {
		return fpo_lot_no;
	}



	public void setFpo_lot_no(String fpo_lot_no) {
		this.fpo_lot_no = fpo_lot_no;
	}



	public String getAssociationdate() {
		return associationdate;
	}



	public void setAssociationdate(String associationdate) {
		this.associationdate = associationdate;
	}



	public String getCrops() {
		return crops;
	}



	public void setCrops(String crops) {
		this.crops = crops;
	}



	public String getServices() {
		return services;
	}



	public void setServices(String services) {
		this.services = services;
	}

}
