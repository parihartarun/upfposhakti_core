package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.User;
import reactor.core.publisher.Mono;

public interface UserService {

	Mono<User> login(String email,String password);
	
	User userDetail(String username);

	String getRoleName(String roleId);

}
