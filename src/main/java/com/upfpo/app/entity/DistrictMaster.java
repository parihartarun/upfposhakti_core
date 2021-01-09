package com.upfpo.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="districts")
public class DistrictMaster implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="district_id")
	private Integer district_id	;
	
	@Column(name="district_code")
	private Integer district_code;
	
	@Column(name="district_name")
	private String district_name;
	
	@Column(name="district_name_hi")
	private String district_name_hi;
	
	@Column(name="state_id")
	private Integer state_id;
	
	@Column(name="state_code")
	private Integer state_code;
	
	@Column(name="is_active")
	private Integer is_active;
	
	@Column(name="census")
	private String census;
	
	
	
	
	
	
	public Integer getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(Integer district_id) {
		this.district_id = district_id;
	}
	public Integer getDistrict_code() {
		return district_code;
	}
	public void setDistrict_code(Integer district_code) {
		this.district_code = district_code;
	}
	public String getDistrict_name() {
		return district_name;
	}
	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}
	public Integer getState_id() {
		return state_id;
	}
	public void setState_id(Integer state_id) {
		this.state_id = state_id;
	}
	public Integer getState_code() {
		return state_code;
	}
	public void setState_code(Integer state_code) {
		this.state_code = state_code;
	}
	public Integer getIs_active() {
		return is_active;
	}
	public void setIs_active(Integer is_active) {
		this.is_active = is_active;
	}
	public String getCensus() {
		return census;
	}
	public void setCensus(String census) {
		this.census = census;
	}
	public String getDistrict_name_hi() {
		return district_name_hi;
	}
	public void setDistrict_name_hi(String district_name_hi) {
		this.district_name_hi = district_name_hi;
	}

}
