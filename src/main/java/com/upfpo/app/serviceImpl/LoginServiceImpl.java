package com.upfpo.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.User;
import com.upfpo.app.repository.UserRepository;
import com.upfpo.app.repository.UserRoleRepository;
import com.upfpo.app.service.LoginService;
import com.upfpo.app.util.PasswordReset;

@Service
public class LoginServiceImpl implements LoginService{

	

	@Override
	public boolean sendMail() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkUser(String userName, Long mobile) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sendOtp(PasswordReset passwordReset) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
