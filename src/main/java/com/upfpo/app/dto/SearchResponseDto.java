package com.upfpo.app.dto;

public class SearchResponseDto {

	private Long fpoid;
	private String fpo;
	private Integer districtid;
	private String district;
	private Integer cropid;
	private String crop;
	private Integer varietyid;
	private String variety;
	private Double currentMarketable;
	private String role;
	
	public SearchResponseDto(Long fpoid, String fpo, Integer districtid, String district, Integer cropid, String crop,
			Integer varietyid, String variety, Double currentMarketable,String role) {
		super();
		this.fpoid = fpoid;
		this.fpo = fpo;
		this.districtid = districtid;
		this.district = district;
		this.cropid = cropid;
		this.crop = crop;
		this.varietyid = varietyid;
		this.variety = variety;
		this.currentMarketable = currentMarketable;
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getDistrictid() {
		return districtid;
	}
	public void setDistrictid(Integer districtid) {
		this.districtid = districtid;
	}
	
	public Integer getCropid() {
		return cropid;
	}
	public void setCropid(Integer cropid) {
		this.cropid = cropid;
	}
	public Integer getVarietyid() {
		return varietyid;
	}
	public void setVarietyid(Integer varietyid) {
		this.varietyid = varietyid;
	}
	
	
public Long getFpoid() {
		return fpoid;
	}
	public void setFpoid(Long fpoid) {
		this.fpoid = fpoid;
	}
	public SearchResponseDto() {
		super();
	}
	public SearchResponseDto(Long fpoid, String fpo, String district, Integer cropid, String crop, Integer varietyid,
			String variety, Double currentMarketable) {
		super();
		this.fpoid = fpoid;
		this.fpo = fpo;
		this.district = district;
		this.cropid = cropid;
		this.crop = crop;
		this.varietyid = varietyid;
		this.variety = variety;
		this.currentMarketable = currentMarketable;
	}
	public SearchResponseDto(Long fpoid, String fpo, String district, String crop, String variety,
			 Double currentMarketable) {
		this.fpoid = fpoid;
		this.fpo = fpo;
		this.district = district;
		this.crop = crop;
		this.variety = variety;
	
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

	public Double getCurrentMarketable() {
		return currentMarketable;
	}
	public void setCurrentMarketable(Double currentMarketable) {
		this.currentMarketable = currentMarketable;
	}

}