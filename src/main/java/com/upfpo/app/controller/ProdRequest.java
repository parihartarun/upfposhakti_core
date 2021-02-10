package com.upfpo.app.controller;

public class ProdRequest {
	
	private String finYear; 
	private Integer distId; 
	private Integer cropId;
	private Integer seasonId;
	
	public String getFinYear() {
		return finYear;
	}
	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}
	public Integer getDistId() {
		return distId;
	}
	public void setDistId(Integer distId) {
		this.distId = distId;
	}
	public Integer getCropId() {
		return cropId;
	}
	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}
	public Integer getSeasonId() {
		return seasonId;
	}
	public void setSeasonId(Integer seasonId) {
		this.seasonId = seasonId;
	} 

}
