package com.upfpo.app.service;

import com.upfpo.app.entity.User;
import com.upfpo.app.util.PasswordReset;

public interface LoginService {

	
	public boolean sendMail();
	public boolean checkUser(String userName,Long mobile);
	boolean sendOtp(PasswordReset passwordReset);	
	
}
