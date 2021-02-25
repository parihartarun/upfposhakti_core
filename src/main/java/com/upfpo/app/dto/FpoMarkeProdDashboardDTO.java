package com.upfpo.app.dto;

public class FpoMarkeProdDashboardDTO 
{
	private Integer cropId;
	
	private String cropName;
	
	private Integer seasonId;
	
	private Double totMarkProd;
	
	public FpoMarkeProdDashboardDTO(Integer cropId, String cropName, Integer seasonId, Double totMarkProd) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
		this.seasonId = seasonId;
		this.totMarkProd = totMarkProd;
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

	public Integer getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(Integer seasonId) {
		this.seasonId = seasonId;
	}

	public Double getTotMarkProd() {
		return totMarkProd;
	}

	public void setTotMarkProd(Double totMarkProd) {
		this.totMarkProd = totMarkProd;
	}
	
	
}
