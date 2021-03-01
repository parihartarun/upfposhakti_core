package com.upfpo.app.dto;

public class FarmerCropProductionDTO 
{
	private Integer cropId;
	
	private String cropName;
	
	private Double production; 
	
	private Integer seasonId;
	
	private String seasonName;
	

	public FarmerCropProductionDTO(Integer cropId, String cropName, Double production, Integer seasonId,
			String seasonName) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
		this.production = production;
		this.seasonId = seasonId;
		this.seasonName = seasonName;
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

	public Double getProduction() {
		return production;
	}

	public void setProduction(Double production) {
		this.production = production;
	}

	public Integer getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(Integer seasonId) {
		this.seasonId = seasonId;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}
	
	
	
}
