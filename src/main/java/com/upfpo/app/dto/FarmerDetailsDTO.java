package com.upfpo.app.dto;

public class FarmerDetailsDTO 
{
	private Integer farmerId;
	
	private String farmerName;
	
	private String upBSMId;
	
	public FarmerDetailsDTO(Integer farmerId, String farmerName, String upBSMId) {
		super();
		this.farmerId = farmerId;
		this.farmerName = farmerName;
		this.upBSMId = upBSMId;
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

	public String getUpBSMId() {
		return upBSMId;
	}

	public void setUpBSMId(String upBSMId) {
		this.upBSMId = upBSMId;
	}
	
}
