package com.upfpo.app.service;

import com.upfpo.app.auth.response.LoginResponse;
import com.upfpo.app.entity.User;
import com.upfpo.app.util.PasswordResetRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
//import reactor.core.publisher.Mono;

public interface UserService{

	User userDetail(String username);

	String getRoleName(String roleId);

	LoginResponse signin(String username, String password);
	

	ResponseEntity<?> resetPassword(String username,PasswordResetRequest request);
	
	
	
}
