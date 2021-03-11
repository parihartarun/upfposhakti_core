package com.upfpo.app.dto;

public class InputSupplierDashBoardSeedDTO 
{
	private Integer cropId;
	
	private String cropName;
	
	private Integer varietyId;
	
	private String varietyName;
	
	private Double seedQuantity;
	

	public InputSupplierDashBoardSeedDTO(Integer cropId, String cropName, Integer varietyId, String varietyName,
			Double seedQuantity) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
		this.varietyId = varietyId;
		this.varietyName = varietyName;
		this.seedQuantity = seedQuantity;
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

	public Integer getVarietyId() {
		return varietyId;
	}

	public void setVarietyId(Integer varietyId) {
		this.varietyId = varietyId;
	}

	public String getVarietyName() {
		return varietyName;
	}

	public void setVarietyName(String varietyName) {
		this.varietyName = varietyName;
	}

	public Double getSeedQuantity() {
		return seedQuantity;
	}

	public void setSeedQuantity(Double seedQuantity) {
		this.seedQuantity = seedQuantity;
	}
	
	
}
