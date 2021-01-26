package com.upfpo.app.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.upfpo.app.repository.UserRepository;
import com.upfpo.app.util.OTPGenerator;
import com.upfpo.app.util.PasswordReset;
import com.upfpo.app.util.Sender;
import com.upfpo.app.validators.PreLoginValidator;

public class LoginServiceImpl implements LoginService {

	@Resource
	private Sender send;
	
	@Resource
	private OTPGenerator generateOtp;
	
	@Resource
	private PreLoginValidator  preLoginValidator;
	
@Autowired
private UserRepository userRepository;

	@Override
	public boolean sendOtp(PasswordReset passwordReset) {
	
		boolean res = checkUser(passwordReset.getUserName(),passwordReset.getMobNo());
		
		if(res==false)
		{	
		// TODO Auto-generated method stub
		return false;
		}
		return true;
	}

	@Override
	public boolean sendMail() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkUser(String userName, Long mobile) {
	
		
		
		//return userRepository.existsByUserNameAndMobileNumber(userName);

		return false;
	}
	
	
	
	
	//boolean res = loginService.checkUser(passwordReset.getUserName(),passwordReset.getMobNo());
	

}
