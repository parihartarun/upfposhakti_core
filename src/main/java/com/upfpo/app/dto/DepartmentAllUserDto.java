package com.upfpo.app.dto;

import java.math.BigInteger;

public class DepartmentAllUserDto {
	
	private Integer user_id;
	private String user_name;
	private String fpo_name;
	private String district_name;
	//private String fpo_address;
	private String date_of_regi;
	private BigInteger fpo_landline;
	private String fpo_email;
	private Boolean enabled;
	
	
	public DepartmentAllUserDto(Integer user_id, String user_name, String fpo_name, String district_name,
			String date_of_regi, BigInteger fpo_landline, String fpo_email, Boolean enabled) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.fpo_name = fpo_name;
		this.district_name = district_name;
		this.date_of_regi = date_of_regi;
		this.fpo_landline = fpo_landline;
		this.fpo_email = fpo_email;
		this.enabled = enabled;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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
//	public String getFpo_address() {
//		return fpo_address;
//	}
//	public void setFpo_address(String fpo_address) {
//		this.fpo_address = fpo_address;
//	}
	
	public String getFpo_email() {
		return fpo_email;
	}
	public void setFpo_email(String fpo_email) {
		this.fpo_email = fpo_email;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getDate_of_regi() {
		return date_of_regi;
	}
	
	public void setDate_of_regi(String date_of_regi) {
		this.date_of_regi = date_of_regi;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public BigInteger getFpo_landline() {
		return fpo_landline;
	}
	public void setFpo_landline(BigInteger fpo_landline) {
		this.fpo_landline = fpo_landline;
	}
}
