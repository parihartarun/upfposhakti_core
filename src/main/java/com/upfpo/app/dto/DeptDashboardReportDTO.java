package com.upfpo.app.dto;

public class DeptDashboardReportDTO 
{
	private String fpo_name;
	
	private String district_name; 
	
	private Integer cropId;
	
	private String cropName;
	
	private Integer verietyId;
	
	private String verietyName;
	
	private Double actualFpoProduction;
	
	private Double marketable ;
	
	public DeptDashboardReportDTO(String fpo_name, String district_name, Integer cropId, String cropName,
			Integer verietyId, String verietyName, Double actualFpoProduction, Double marketable) {
		super();
		this.fpo_name = fpo_name;
		this.district_name = district_name;
		this.cropId = cropId;
		this.cropName = cropName;
		this.verietyId = verietyId;
		this.verietyName = verietyName;
		this.actualFpoProduction = actualFpoProduction;
		this.marketable = marketable;
	}

	public String getFpo_name() {
		return fpo_name;
	}

	public void setFpo_name(String fpo_name) {
		this.fpo_name = fpo_name;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
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

	public Integer getVerietyId() {
		return verietyId;
	}

	public void setVerietyId(Integer verietyId) {
		this.verietyId = verietyId;
	}

	public String getVerietyName() {
		return verietyName;
	}

	public void setVerietyName(String verietyName) {
		this.verietyName = verietyName;
	}

	public Double getActualFpoProduction() {
		return actualFpoProduction;
	}

	public void setActualFpoProduction(Double actualFpoProduction) {
		this.actualFpoProduction = actualFpoProduction;
	}

	public Double getMarketable() {
		return marketable;
	}

	public void setMarketable(Double marketable) {
		this.marketable = marketable;
	}
	
	
}
