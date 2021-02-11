package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.entity.User;
import com.upfpo.app.repository.UserRepository;
import com.upfpo.app.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping(value = "/api/v1/user")
@Api(produces = "application/json", value = "Create,Update, Delete, and Retrive the User", tags="User Operations",description="User Create, Update, Delete, and Retrive the FPO")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;
	
	@PostMapping(value="")
	@ApiOperation(value="Create User", code=200, produces = "application/json", notes="Api for create user",response=User.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response = ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	})
	//@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.registerUser(user), HttpStatus.OK);
	}
	
	@GetMapping(value="")
	@ApiOperation(value="Get all user", code=200, produces = "application/json", notes="Api for get all user",response=User.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response = ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	})
	//@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{userId}")
	@ApiOperation(value="Get user by id", code=200, produces = "application/json", notes="Api for get user by id",response=User.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response = ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	})
//	@RequestMapping(path = "/userId", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
		return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	@PutMapping(value="/{userId}")
	@ApiOperation(value="Update user", code=200, produces = "application/json", notes="Api for update user",response=User.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response = ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	})
	//@RequestMapping(path = "/userId", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User user) {
		User updatedUser = userService.updateUser(userId, user);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{userId}")
	@ApiOperation(value="Delete user", code=200, produces = "application/json", notes="Api for delete user",response=User.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response = ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	})
	//@RequestMapping(path = "/userId", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteUserById(@PathVariable("userId") Long userId) {
		userService.deleteUserById(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@GetMapping("/dept/{role_id}")
	@ApiOperation(value="Get user with role Department", code=200, produces = "application/json", notes="Api for get user with role department",response=User.class)
	@ApiResponses(value= {
			@ApiResponse(code=404,response = ExceptionResponse.class, message = "Item Not Found"),
			@ApiResponse(code=401,response=Boolean.class, message = "Unauthorized"),
			@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	})
	//@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUserByDepartment(@PathVariable(value = "role_id") String roleid) {
		return new ResponseEntity<List<User>>(userService.getByDepartment(roleid), HttpStatus.OK);
	}
}