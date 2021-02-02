package com.upfpo.app.util;

import javax.validation.constraints.NotNull;

public class OtpVerifyRequest {
	public String getOtp() {
		return Otp;
	}

	public void setOtp(String otp) {
		Otp = otp;
	}

	public OtpVerifyRequest() {
		super();
	}

	public OtpVerifyRequest(String otp) {
		super();
		Otp = otp;
	}

	@NotNull
	private String Otp;
}
