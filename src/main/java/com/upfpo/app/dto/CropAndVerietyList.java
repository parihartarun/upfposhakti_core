package com.upfpo.app.dto;

import javax.persistence.ColumnResult;

public class CropAndVerietyList {
	private String cropName;
    private Integer cropId;
	private String verietyName;
    private Integer verietyId;
    
    public CropAndVerietyList(String cropName, Integer cropId, String verietyName, Integer verietyId) {
		super();
		this.cropName = cropName;
		this.cropId = cropId;
		this.verietyName = verietyName;
		this.verietyId = verietyId;
	}
    public CropAndVerietyList() {
		
		this.cropName = cropName;
		this.cropId = cropId;
		this.verietyName = verietyName;
		this.verietyId = verietyId;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public Integer getCropId() {
		return cropId;
	}
	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}
	public String getVerietyName() {
		return verietyName;
	}
	public void setVerietyName(String verietyName) {
		this.verietyName = verietyName;
	}
	public Integer getVerietyId() {
		return verietyId;
	}
	public void setVerietyId(Integer verietyId) {
		this.verietyId = verietyId;
	}

}
