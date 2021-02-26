package com.upfpo.app.dto;

public class DeptActProdKharifDTO 
{
	private Integer cropId;
	
	private String cropName;
	
	private Integer seasonId;	
	
	private Double totAcProd;
	
	public DeptActProdKharifDTO(Integer cropId, String cropName, Integer seasonId, Double totAcProd) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
		this.seasonId = seasonId;
		this.totAcProd = totAcProd;
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

	public Double getTotAcProd() {
		return totAcProd;
	}

	public void setTotAcProd(Double totAcProd) {
		this.totAcProd = totAcProd;
	}

}
