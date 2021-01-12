package com.upfpo.app.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.User;
import com.upfpo.app.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// for static username
		//return new myUserDetail(username);
		
		//for dynamic user check from database
		System.err.println("hello username "+username);
		User user = userRepository.findByUserName(username);
		return new MyUserDetail(user);
	}

}
