package com.upfpo.app.dto;

import java.util.List;

import com.upfpo.app.entity.CropVerietyMaster;

public class CropMasterDto {

	private Integer cropId;
	private String  cropName;
	private Integer seasonRefId;
	private Boolean isActive;
	
	public CropMasterDto(Integer cropId, String cropName, Integer seasonRefId, Boolean isActive) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
		this.seasonRefId = seasonRefId;
		this.isActive = isActive;
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

	public Integer getSeasonRefId() {
		return seasonRefId;
	}

	public void setSeasonRefId(Integer seasonRefId) {
		this.seasonRefId = seasonRefId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
	