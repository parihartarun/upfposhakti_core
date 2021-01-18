package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import reactor.core.publisher.Mono;

public interface UserService{

	User userDetail(String username);

	String getRoleName(String roleId);

}
