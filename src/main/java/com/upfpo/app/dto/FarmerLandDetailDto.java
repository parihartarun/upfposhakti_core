package com.upfpo.app.dto;

import javax.persistence.ColumnResult;

public class FarmerLandDetailDto 
{ 
	 private Integer landId;
	 
	 private double landArea;
	 
	 private Integer masterId;
	 
	 private String isorganc;
	 
	 public FarmerLandDetailDto(Integer landId, double landArea, Integer masterId, String isorganc, Integer farmerId,
			String parantsName, String farmerName) {
		super();
		this.landId = landId;
		this.landArea = landArea;
		this.masterId = masterId;
		this.isorganc = isorganc;
		this.farmerId = farmerId;
		this.parantsName = parantsName;
		this.farmerName = farmerName;
	}

	private Integer farmerId;
	 
	 private String parantsName;
	 
	 private String farmerName;
	
     public Integer getLandId() {
		return landId;
	}

	public void setLandId(Integer landId) {
		this.landId = landId;
	}

	public double getLandArea() {
		return landArea;
	}

	public void setLandArea(double landArea) {
		this.landArea = landArea;
	}

	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public String getIsorganc() {
		return isorganc;
	}

	public void setIsorganc(String isorganc) {
		this.isorganc = isorganc;
	}

	public Integer getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Integer farmerId) {
		this.farmerId = farmerId;
	}

	public String getParantsName() {
		return parantsName;
	}

	public void setParantsName(String parantsName) {
		this.parantsName = parantsName;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

}
