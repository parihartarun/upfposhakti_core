package com.upfpo.app.service;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.User;
import com.upfpo.app.util.ForgetPasswordRequest;
import com.upfpo.app.util.OtpVerifyRequest;
import com.upfpo.app.util.PasswordReset;

@Service
public interface LoginService {

	public ExceptionResponse  generateOtp(@Valid ForgetPasswordRequest forgetPasswordRequest,HttpSession session);
	public ExceptionResponse  verifyOtp(@Valid OtpVerifyRequest otpVerifyRequest,HttpSession session);
  public boolean checkUser(String username,Long mobilenNumber);
}
