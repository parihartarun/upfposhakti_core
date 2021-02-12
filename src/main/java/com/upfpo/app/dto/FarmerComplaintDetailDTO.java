package com.upfpo.app.dto;

import java.math.BigInteger;

public class FarmerComplaintDetailDTO {
	
	private Integer farmerId;
	private Integer fpoId;
	private String fponame;
	private String fpoemail;
	private BigInteger farmermobile;
	
	public FarmerComplaintDetailDTO(Integer farmerId, Integer fpoId, String fponame, String fpoemail,
			BigInteger farmermobile) {
		super();
		this.farmerId = farmerId;
		this.fpoId = fpoId;
		this.fponame = fponame;
		this.fpoemail = fpoemail;
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
	public String getFponame() {
		return fponame;
	}
	public void setFponame(String fponame) {
		this.fponame = fponame;
	}
	public String getFpoemail() {
		return fpoemail;
	}
	public void setFpoemail(String fpoemail) {
		this.fpoemail = fpoemail;
	}
	public BigInteger getFarmermobile() {
		return farmermobile;
	}
	public void setFarmermobile(BigInteger farmermobile) {
		this.farmermobile = farmermobile;
	}
	
	
	
	

}
