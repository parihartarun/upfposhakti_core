package com.upfpo.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.User;
import com.upfpo.app.repository.UserRepository;
import com.upfpo.app.repository.UserRoleRepository;
import com.upfpo.app.service.UserService;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Override
	public User userDetail(String username) {
		User user = userRepository.findByUserName(username);
		return user;
	}

	@Override
	public String getRoleName(String roleId) {
		String roleName = userRoleRepository.roleNameById(roleId);
		return roleName;
		
	}

}
