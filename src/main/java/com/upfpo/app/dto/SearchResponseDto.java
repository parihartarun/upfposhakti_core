package com.upfpo.app.dto;

public class SearchResponseDto {

	private Long fpoid;
	private String fpo;
	private String district;
	private String crop;
	private String variety;
	private Double totalMarketable;
	private Double currentMarketable;
	
public Long getFpoid() {
		return fpoid;
	}
	public void setFpoid(Long fpoid) {
		this.fpoid = fpoid;
	}
	public SearchResponseDto() {
		super();
	}
	public SearchResponseDto(Long fpoid, String fpo, String district, String crop, String variety,
			Double totalMarketable, Double currentMarketable) {
		this.fpoid = fpoid;
		this.fpo = fpo;
		this.district = district;
		this.crop = crop;
		this.variety = variety;
		this.totalMarketable = totalMarketable;
		this.currentMarketable = currentMarketable;
	}
	public String getFpo() {
		return fpo;
	}
	public void setFpo(String fpo) {
		this.fpo = fpo;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCrop() {
		return crop;
	}
	public void setCrop(String crop) {
		this.crop = crop;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public Double getTotalMarketable() {
		return totalMarketable;
	}
	public void setTotalMarketable(Double totalMarketable) {
		this.totalMarketable = totalMarketable;
	}
	public Double getCurrentMarketable() {
		return currentMarketable;
	}
	public void setCurrentMarketable(Double currentMarketable) {
		this.currentMarketable = currentMarketable;
	}

}