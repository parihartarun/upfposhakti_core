package com.upfpo.app.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.upfpo.app.entity.User;

public class MyUserDetail implements UserDetails{
	
	private String userName;
	private String password;
	private Boolean isEnabled;
	private String roleRefId;
	
	//for static user
//	public myUserDetail(String userName) {
//		this.userName = userName;
//	}

	//for dynamic user
	public MyUserDetail(User user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.isEnabled = user.isEnabled();
		this.roleRefId = user.getRoleRefId();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isEnabled;
	}

}
