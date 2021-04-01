package com.upfpo.app.dto;

public class FpoDTO 
{
	private Integer fpoId;
	
	private String fpoName;
	
	public FpoDTO(Integer fpoId, String fpoName) {
		super();
		this.fpoId = fpoId;
		this.fpoName = fpoName;
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
}
