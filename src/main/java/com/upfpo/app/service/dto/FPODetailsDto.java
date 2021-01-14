package com.upfpo.app.service.dto;

public class FPODetailsDto {
	
	private String fpo_name;
	private Integer district_id;
	private String district_name;
	private Integer sla_id;
	private String nodal_officer_name;
	private Integer fpo_id;
	private Integer state_id;
	private String state_name;
	private String agency_associated;
	
	
	
	public String getFpo_name() {
		return fpo_name;
	}
	public void setFpo_name(String fpo_name) {
		this.fpo_name = fpo_name;
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
	public Integer getSla_id() {
		return sla_id;
	}
	public void setSla_id(Integer sla_id) {
		this.sla_id = sla_id;
	}
	public String getNodal_officer_name() {
		return nodal_officer_name;
	}
	public void setNodal_officer_name(String nodal_officer_name) {
		this.nodal_officer_name = nodal_officer_name;
	}
	public Integer getFpo_id() {
		return fpo_id;
	}
	public void setFpo_id(Integer fpo_id) {
		this.fpo_id = fpo_id;
	}
	public Integer getState_id() {
		return state_id;
	}
	public void setState_id(Integer state_id) {
		this.state_id = state_id;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public String getAgency_associated() {
		return agency_associated;
	}
	public void setAgency_associated(String agency_associated) {
		this.agency_associated = agency_associated;
	}
}

