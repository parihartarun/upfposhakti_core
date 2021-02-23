package com.upfpo.app.dto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;



public class DistrictFilterDto {

	private String  districtName;
	 private Integer districtId;
	 
 public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public DistrictFilterDto(String districtName, Integer districtId) {
		
		this.districtName = districtName;
		this.districtId = districtId;
	}
	

}
