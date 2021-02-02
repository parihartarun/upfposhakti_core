package com.upfpo.app.util;

import javax.validation.constraints.NotNull;

public class PasswordResetRequest {

	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public PasswordResetRequest(Long userId, String password, String confirmPassword) {
		super();
		this.userId = userId;
		Password = password;
		this.confirmPassword = confirmPassword;
	}
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	@NotNull
	private Long userId;
	
	@NotNull
	private String Password;
	
	@NotNull
	private String confirmPassword;	
}
