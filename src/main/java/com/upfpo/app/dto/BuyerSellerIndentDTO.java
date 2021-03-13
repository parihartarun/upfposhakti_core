package com.upfpo.app.dto;

public class BuyerSellerIndentDTO 
{
	private Integer cropId;
	
	private String cropName;
	
	private String status;
	
	public BuyerSellerIndentDTO(Integer cropId, String cropName, String status) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
		this.status = status;
	}

	public Integer getCropId() {
		return cropId;
	}

	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
