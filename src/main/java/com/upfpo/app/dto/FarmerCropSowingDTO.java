package com.upfpo.app.dto;

public class FarmerCropSowingDTO 
{
	private String farmerName;
	
	private String parantsName;
	
	private double land_area;
	
	public FarmerCropSowingDTO(String farmerName, String parantsName, double land_area) {
		super();
		this.farmerName = farmerName;
		this.parantsName = parantsName;
		this.land_area = land_area;
	}
	
	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getParantsName() {
		return parantsName;
	}

	public void setParantsName(String parantsName) {
		this.parantsName = parantsName;
	}

	public double getLand_area() {
		return land_area;
	}

	public void setLand_area(double land_area) {
		this.land_area = land_area;
	}

}
