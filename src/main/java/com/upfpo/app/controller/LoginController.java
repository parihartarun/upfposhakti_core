package com.upfpo.app.controller;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.upfpo.app.auth.request.LoginRequest;
import com.upfpo.app.auth.response.LoginResponse;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.service.LoginService;
import com.upfpo.app.service.UserService;
import com.upfpo.app.util.ForgetPasswordRequest;
import com.upfpo.app.util.OtpVerifyRequest;
import com.upfpo.app.util.PasswordResetRequest;

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
	
	@Autowired
	LoginService loginService;

	@PostMapping
	@ApiOperation(value="user login" ,code=201, produces = "application/json", notes="Api for user login",response= LoginResponse.class)
	@ApiResponses(value= {
			@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
			@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
			@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class),
			@ApiResponse(code=422, message = "Invalid username/password supplied" , response = ExceptionResponse.class),
			@ApiResponse(code=423, message = "Inactive user!" , response = ExceptionResponse.class),
	})
	@ResponseStatus( HttpStatus.OK)
	public ResponseEntity<LoginResponse> signin(@Valid @RequestBody LoginRequest loginRequest) throws Exception {
		return new ResponseEntity<>(userService.signin(loginRequest.getUsername(), loginRequest.getPassword()),HttpStatus.OK);
	}

	@GetMapping("/test")
	public String test() throws Exception {
		return "Pass";
	}
	

	@ApiOperation(value="user password reset " ,code=201, produces = "application/json", notes="Api for user password change after first login", response = String.class)
	@ApiResponses(value= {
			@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
			@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
			@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class),
			@ApiResponse(code=422, message = "Invalid username/password supplied" , response = ExceptionResponse.class),
			@ApiResponse(code=423, message = "Inactive user!" , response = ExceptionResponse.class),
	})
	@ResponseStatus( HttpStatus.OK)
	@PostMapping("/password/reset")
	public ResponseEntity<?> resetPass( @Valid @RequestBody PasswordResetRequest passwordResetRequest) throws Exception {
		return new ResponseEntity<>(userService.resetPassword(passwordResetRequest),HttpStatus.OK);
	}
	
	@ApiOperation(value="Forget Password Otp Generation" ,code=201, produces = "application/json", notes="First Api of Forget Password where we submit username and mobile number for otp generation ", response = String.class)
	@ApiResponses(value= {
			@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
			@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
			@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class),
			@ApiResponse(code=422, message = "Invalid username/password supplied" , response = ExceptionResponse.class),
			@ApiResponse(code=423, message = "Inactive user!" , response = ExceptionResponse.class),
	})
	
	@ResponseStatus( HttpStatus.OK)
	@PostMapping("/password/otp/generate")
	public ResponseEntity<?> generateOtp(@Valid @RequestBody ForgetPasswordRequest forgetPasswordRequest,HttpSession session) throws Exception {
		
		return ResponseEntity.ok().body(loginService.generateOtp(forgetPasswordRequest,session));
		
	}
	
	@ApiOperation(value="Forget Password Otp Verification" ,code=201, produces = "application/json", notes="First Api of Forget Password where we verify the Given Otp with the sent one ", response = String.class)
	@ApiResponses(value= {
			@ApiResponse(code=401,message = "Unauthorized" ,response = ExceptionResponse.class),
			@ApiResponse(code=400, message = "Validation Failed" , response = ExceptionResponse.class),
			@ApiResponse(code=403, message = "Forbidden" , response = ExceptionResponse.class),
			@ApiResponse(code=422, message = "Invalid username/password supplied" , response = ExceptionResponse.class),
			@ApiResponse(code=423, message = "Inactive user!" , response = ExceptionResponse.class),
	})
	
	@ResponseStatus( HttpStatus.OK)
	@PostMapping("/password/otp/verify")
	public ResponseEntity<?> verifyOtp( @Valid @RequestBody OtpVerifyRequest otpVerifyRequest,HttpSession session) throws Exception {
		

		//return loginService.verifyOtp(otpVerifyRequest,session);	
  return null;
	}
	
	
}
	