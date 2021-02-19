package com.upfpo.app.util;

import javax.validation.constraints.NotNull;

public class PasswordResetRequest {
	@NotNull
	private Long userId;
	
	@NotNull
	private String password;
	
	@NotNull
	private String confirmPassword;	
	
	@NotNull
	private String oldPassword;
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}
}
