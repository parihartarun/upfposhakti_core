package com.upfpo.app.dto;

public class UserDetailsDto {
	
	private Integer user_id;
	private String user_name;
	private String role;
    private String pass;
    private boolean enabled;
    private boolean is_changed;
    private Integer sessionid;
    private String name;
    private String userdetail_name;

	
    
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isIs_changed() {
		return is_changed;
	}
	public void setIs_changed(boolean is_changed) {
		this.is_changed = is_changed;
	}
	public Integer getSessionid() {
		return sessionid;
	}
	public void setSessionid(Integer sessionid) {
		this.sessionid = sessionid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserdetail_name() {
		return userdetail_name;
	}
	public void setUserdetail_name(String userdetail_name) {
		this.userdetail_name = userdetail_name;
	}
	
	
	
}
