package com.upfpo.app.service;

import com.upfpo.app.auth.response.LoginResponse;
import com.upfpo.app.entity.User;
import com.upfpo.app.util.PasswordResetRequest;

<<<<<<< HEAD
import java.util.Optional;
=======
import java.util.List;
>>>>>>> 9f5eed78101ca9f03db6070a5c29660b1d4814ab

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
//import reactor.core.publisher.Mono;

public interface UserService {

	User userDetail(String username);

	String getRoleName(String roleId);

	LoginResponse signin(String username, String password);

	ResponseEntity<?> resetPassword(PasswordResetRequest request);
	
	Optional<User> findById(Long userId);
	
	User registerUser(User user);

	List<User> getAllUsers();

	User getUserById(Long userId);

	User updateUser(Long userId, User user);
	
	void deleteUserById(Long userId);	
}
