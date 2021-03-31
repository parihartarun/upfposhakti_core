package com.upfpo.app.dto;

import java.math.BigInteger;

public class FpoOnDistrictDTO 
{
	private Integer districtId;
	
	private String districtName;
	
	private Integer fpoId;
	
	private String fpoName;
	
	private String fpoEmail;
	
	private BigInteger fpoLandline;
	
	private String crops;
	
	private String additionalServices;
	
	public FpoOnDistrictDTO(Integer districtId, String districtName, Integer fpoId, String fpoName, String fpoEmail,
			BigInteger fpoLandline, String crops, String additionalServices) {
		super();
		this.districtId = districtId;
		this.districtName = districtName;
		this.fpoId = fpoId;
		this.fpoName = fpoName;
		this.fpoEmail = fpoEmail;
		this.fpoLandline = fpoLandline;
		this.crops = crops;
		this.additionalServices = additionalServices;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public Integer getFpoId() {
		return fpoId;
	}

	public void setFpoId(Integer fpoId) {
		this.fpoId = fpoId;
	}

	public String getFpoName() {
		return fpoName;
	}

	public void setFpoName(String fpoName) {
		this.fpoName = fpoName;
	}

	public String getFpoEmail() {
		return fpoEmail;
	}

	public void setFpoEmail(String fpoEmail) {
		this.fpoEmail = fpoEmail;
	}

	public BigInteger getFpoLandline() {
		return fpoLandline;
	}

	public void setFpoLandline(BigInteger fpoLandline) {
		this.fpoLandline = fpoLandline;
	}

	public String getCrops() {
		return crops;
	}

	public void setCrops(String crops) {
		this.crops = crops;
	}

	public String getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(String additionalServices) {
		this.additionalServices = additionalServices;
	}
}
