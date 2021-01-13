package com.upfpo.app.service;

import com.upfpo.app.entity.User;

public interface LoginService {

	User userDetail(String username);

	String getRoleName(String roleId);

}
