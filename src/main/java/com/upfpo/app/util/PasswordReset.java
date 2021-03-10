package com.upfpo.app.util;

import java.io.Serializable;

public class PasswordReset implements Serializable {
	
	
	private Integer id;
	
	private String userName;
	
	private String email;
	
	private Long mobNo;
	
	private String captcha;
	
	private String otp;


	public PasswordReset() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobNo() {
		return mobNo;
	}
	public void setMobNo(Long mobNo) {
		this.mobNo = mobNo;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}

}
