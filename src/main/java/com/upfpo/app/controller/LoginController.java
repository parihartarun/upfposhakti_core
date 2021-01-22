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
import com.upfpo.app.service.FPOService;
import com.upfpo.app.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
//import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/signin")
@Api(produces = "application/json", value = "login", tags="login",description="sign in")
public class LoginController {

	@Autowired
	UserService userService;

	@PostMapping
	@ApiOperation(value="user login" ,code=201, produces = "application/json", notes="Api for user login",response=JwtResponse.class)
	@ApiResponses(value= {
			@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
			@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
			@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class),
			@ApiResponse(code=422, message = "Invalid username/password supplied" , response = ExceptionResponse.class),
			@ApiResponse(code=423, message = "Inactive user!" , response = ExceptionResponse.class),
	})
	@ResponseStatus( HttpStatus.OK)
	public String signin(@Valid @RequestBody LoginRequest loginRequest) throws Exception {
		return userService.signin(loginRequest.getUsername(), loginRequest.getPassword());
	}
}
	