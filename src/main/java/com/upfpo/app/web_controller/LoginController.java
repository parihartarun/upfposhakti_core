package com.upfpo.app.web_controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.auth.request.LoginRequest;
import com.upfpo.app.auth.response.JwtResponse;
import com.upfpo.app.repository.UserRepository;
import com.upfpo.app.security.MyUserDetail;
import com.upfpo.app.security.MyUserDetailService;
import com.upfpo.app.security.jwt.JwtUtils;
import com.upfpo.app.util.RandomString;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping("/UPFPO")
public class LoginController {
		
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	MyUserDetailService myUserDetailService;

	@Autowired
	JwtUtils jwtUtils;
	
	private String csrf_token = RandomString.getAlphaNumericString();
	
	@RequestMapping(value="/home")
	private String home()
	{
		System.out.println("Inside home");
		return "home page";
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws Exception {
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		}
		catch(BadCredentialsException e){
			throw new Exception("incorrect credential"+e);
			
		}
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		String jwt = jwtUtils.generateJwtToken(authentication);
		
		final UserDetails userDetails = myUserDetailService.loadUserByUsername(loginRequest.getUsername());
		String jwt = jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(jwt,userDetails.getUsername()));
	}
}
	