package com.upfpo.app.util;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ForgetPasswordRequest {

	@NotNull
	private String username;
	
	@NotNull
	private Long mobileNo;
	
	public String getUsername() {
		return username;
	}
	public ForgetPasswordRequest() {
		super();
	}
	public ForgetPasswordRequest(String username, Long mobileNo) {
		super();
		this.username = username;
		this.mobileNo = mobileNo;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
}
