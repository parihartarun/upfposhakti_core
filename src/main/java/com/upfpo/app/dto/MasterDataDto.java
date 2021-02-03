package com.upfpo.app.dto;

public class MasterDataDto 
{
	private Integer district_id	;
	private String district_name;
	
	
	public MasterDataDto(Integer district_id, String district_name) {
		super();
		this.district_id = district_id;
		this.district_name = district_name;
	}
	public Integer getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(Integer district_id) {
		this.district_id = district_id;
	}
	public String getDistrict_name() {
		return district_name;
	}
	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}
	
	
}
