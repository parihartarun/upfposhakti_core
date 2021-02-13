package com.upfpo.app.dto;

import java.math.BigInteger;

public class FarmerComplaintDetailDTO {
	
	private Integer farmerId;
	private Integer fpoId;
	private String farmername;
	//private String farmeremail;
	private BigInteger farmermobile;
	
	public FarmerComplaintDetailDTO(Integer farmerId, Integer fpoId, String fponame,
			BigInteger farmermobile) {
		super();
		this.farmerId = farmerId;
		this.fpoId = fpoId;
		this.farmername = fponame;
		this.farmermobile = farmermobile;
	}
	
	public Integer getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(Integer farmerId) {
		this.farmerId = farmerId;
	}
	public Integer getFpoId() {
		return fpoId;
	}
	public void setFpoId(Integer fpoId) {
		this.fpoId = fpoId;
	}
	
	public String getFarmername() {
		return farmername;
	}

	public void setFarmername(String farmername) {
		this.farmername = farmername;
	}

	public BigInteger getFarmermobile() {
		return farmermobile;
	}
	public void setFarmermobile(BigInteger farmermobile) {
		this.farmermobile = farmermobile;
	}
	
	
	
	

}
