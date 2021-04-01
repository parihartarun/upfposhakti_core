package com.upfpo.app.dto;

import java.math.BigInteger;

public class ChcFmbOnDistrictDTO 
{
	private Integer district_id;
	
	private String district_name;
	
	private Integer chc_fmb_id;
	
	private String chc_fmb_name;
	
	private String email;
	
	private BigInteger mobile_number;
	
	private String machineries;
	
	public ChcFmbOnDistrictDTO(Integer district_id, String district_name, Integer chc_fmb_id, String chc_fmb_name,
			String email, BigInteger mobile_number, String machineries) {
		super();
		this.district_id = district_id;
		this.district_name = district_name;
		this.chc_fmb_id = chc_fmb_id;
		this.chc_fmb_name = chc_fmb_name;
		this.email = email;
		this.mobile_number = mobile_number;
		this.machineries = machineries;
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

	public Integer getChc_fmb_id() {
		return chc_fmb_id;
	}

	public void setChc_fmb_id(Integer chc_fmb_id) {
		this.chc_fmb_id = chc_fmb_id;
	}

	public String getChc_fmb_name() {
		return chc_fmb_name;
	}

	public void setChc_fmb_name(String chc_fmb_name) {
		this.chc_fmb_name = chc_fmb_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigInteger getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(BigInteger mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getMachineries() {
		return machineries;
	}

	public void setMachineries(String machineries) {
		this.machineries = machineries;
	}
}
