package com.upfpo.app.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.auth.request.LoginRequest;
import com.upfpo.app.auth.response.JwtResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.User;
import com.upfpo.app.security.UserDetailServiceImpl;
import com.upfpo.app.security.jwt.JwtUtils;
import com.upfpo.app.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/signin")
@Api(produces = "application/json", value = "login", tags="login",description="sign in")
public class LoginController {
		
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserDetailServiceImpl userDetailService;

	@Autowired
	JwtUtils jwtUtils;
	
	//private String csrf_token = RandomString.getAlphaNumericString();
	
	@RequestMapping(value="/home")
	private String home()
	{
		System.out.println("Inside home");
		return "home page";
	}
	
	@PostMapping
	@ApiOperation(value="user login" ,code=201, produces = "application/json", notes="Api for user login",response=JwtResponse.class)
	@ApiResponses(value= {
	@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
	@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
	@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class)
	})
	@ResponseStatus( HttpStatus.OK)
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			final UserDetails userDetails = userDetailService.loadUserByUsername(loginRequest.getUsername());
			String jwt = jwtUtils.generateToken(userDetails);
			
			User fullUserdetail;
			String userRole = null;
			Long userId = (long) 0;
			if(userDetails.getUsername() != null && userDetails.isEnabled() == true) {
				fullUserdetail = userService.userDetail(userDetails.getUsername());
				if(fullUserdetail != null) {
					String roleId = fullUserdetail.getRoleRefId();
					userId = fullUserdetail.getUserId();
					if(roleId != null) {
						userRole = userService.getRoleName(roleId);
					}
				}
			}
			
			return ResponseEntity.ok(new JwtResponse(jwt,userId ,userDetails.getUsername(),userRole));
		}
		catch(BadCredentialsException e){
			throw new Exception("incorrect credential"+e);
			
		}
	}
}
	