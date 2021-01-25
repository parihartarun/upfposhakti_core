package com.upfpo.app.service;

import javax.annotation.Resource;

import com.upfpo.app.util.OTPGenerator;
import com.upfpo.app.util.Sender;
import com.upfpo.app.validators.PreLoginValidator;

public class LoginServiceImpl implements LoginService {

	@Resource
	private Sender send;
	
	@Resource
	private OTPGenerator generateOtp;
	
	@Resource
	private PreLoginValidator  preLoginValidator;
	@Override
	public boolean sendOtp() {
	
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sendMail() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
