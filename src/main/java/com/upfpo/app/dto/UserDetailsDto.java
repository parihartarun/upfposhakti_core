package com.upfpo.app.dto;

public class UserDetailsDto {
	
	private String role;
    private Integer masterid;

    
    public UserDetailsDto(String role, Integer masterid) {
		super();
		this.role = role;
		this.masterid = masterid;
	}
 
	public Integer getMasterid() {
		return masterid;
	}
	public void setMasterid(Integer masterid) {
		this.masterid = masterid;

	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
