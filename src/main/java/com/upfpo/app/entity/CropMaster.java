package com.upfpo.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="crop_master")
public class CropMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer cropId;
	
	@Column(name="crop_name")
	private String  cropName;
	
	@Column(name="season_ref_id")
	private Integer seasonRefId;
	
	@Column(name="crop_cat_ref_id")
	private Integer cropTypeRefId;
	
	@Column(name="is_active")
	private Boolean isActive;
	

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

	public Integer getCropTypeRefId() {
		return cropTypeRefId;
	}

	public void setCropTypeRefId(Integer cropTypeRefId) {
		this.cropTypeRefId = cropTypeRefId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
