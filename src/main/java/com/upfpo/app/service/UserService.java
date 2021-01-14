package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.User;

public interface UserService {
	
	User userDetail(String username);

	String getRoleName(String roleId);

}
