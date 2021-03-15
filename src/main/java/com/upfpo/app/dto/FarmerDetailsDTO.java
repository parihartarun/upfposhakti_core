package com.upfpo.app.dto;

public class FarmerDetailsDTO 
{
	private Integer farmerId;
	
	private String farmerName;
	
	public FarmerDetailsDTO(Integer farmerId, String farmerName) {
		super();
		this.farmerId = farmerId;
		this.farmerName = farmerName;
	}

	public Integer getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Integer farmerId) {
		this.farmerId = farmerId;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}
	
	
}
