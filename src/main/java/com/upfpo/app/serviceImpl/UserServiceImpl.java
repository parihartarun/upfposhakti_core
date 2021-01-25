package com.upfpo.app.serviceImpl;

import com.google.common.base.Optional;
import com.upfpo.app.auth.response.LoginResponse;
import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.custom.CustomException;
import com.upfpo.app.dto.UserDetailsDto;
import com.upfpo.app.security.jwt.JwtUtils;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.User;
import com.upfpo.app.repository.UserRepository;
import com.upfpo.app.repository.UserRoleRepository;
import com.upfpo.app.service.FPOService;
import com.upfpo.app.service.UserService;
import com.upfpo.app.util.PasswordResetRequest;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private  EntityManager entityManager;
	
	@Autowired
	UserRoleRepository userRoleRepository;

	@Autowired
	private JwtUtils jwtTokenProvider;

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private FPOService fPOService;


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

	public LoginResponse signin(String username, String password) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			//API call
			User user = userRepository.findByUserName(username);
			//TODO fetch master ID. Fetch master id from join query
			//Integer masterId = fPOService.getFpoUserId(user.getUserId());
			  UserDetailsDto userDetailsDto = userMasterId(user.getUserId()); 
			  Integer masterId = userDetailsDto.getMasterid();
			  String userRoleName     = userDetailsDto.getRole();
			  System.err.print("Role Name"+userRoleName+"Master Id for user::"+masterId);
			return new LoginResponse(jwtTokenProvider.generateToken(user,masterId),user,userRoleName,masterId);
		} catch (AuthenticationException e) {
			throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}


	public String signup(User user) {
		if (!userRepository.existsByUserName(user.getUserName())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return jwtTokenProvider.generateToken(user,0);
		} else {
			throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	public UserDetailsDto userMasterId(Long userId)
	{
		String  sql =  	" select CASE\r\n"
				+ " WHEN ur.role='ROLE_BUYERSELLER'  THEN  buyerSeller_id\r\n"
				+ " WHEN ur.role='ROLE_CHCFMB'  THEN chc_fmb_id\r\n"
				+ " WHEN ur.role='ROLE_INPUTSUPPLIER'  THEN input_supplier_id\r\n"
				+ " WHEN ur.role='ROLE_FPC'  THEN fpo_id\r\n"
				+ " ELSE farmer_id\r\n"
				+ " END as masterid,                                 \r\n"
				+ " ur.role\r\n"
				+ " from Users a\r\n"
				+ " join user_roles ur on ur.role_id=a.role_ref_id\r\n"
				+ " left join chc_fmb b on a.user_id = b.user_id\r\n"
				+ " left join buyer_seller c on a.user_id=c.user_id\r\n"
				+ " left join input_supplier e on a.user_id=e.user_id\r\n"
				+ " left join fpo d on a.user_id=d.user_id\r\n"
				+ " left join farmer f on a.user_id=f.user_id where a.user_id= :userId" ;
		  
		  UserDetailsDto obj =  (UserDetailsDto) entityManager.createNativeQuery(sql,"UserDetailsDto").setParameter("userId", userId).getSingleResult();
		  return obj;
		    
	}

	@Override
	public ResponseEntity<?> resetPassword(PasswordResetRequest request) {
		// TODO Auto-generated method stub
		java.util.Optional<User> userOpt = userRepository.findById(request.getUserId()); 
if(!request.getPassword().contentEquals(request.getConfirmPassword()))
{
return ResponseEntity.badRequest().body("Password does not match with confirm password field");
}
		

if(userOpt.isPresent()) {
	User user = userOpt.get(); 
	user.setPassword(this.passwordEncoder.encode(request.getPassword()));
	   userRepository.save(user);			
}else {
	throw new NotFoundException();
}

//		userOpt.ifPresentOrElse(user->{
//   user.setPassword(this.passwordEncoder.encode(request.getPassword()));
//   userRepository.save(user);			
//   }, ()->{
//	throw new NotFoundException();
//    });
		return new ResponseEntity<String>("Password Updated Successfully", HttpStatus.OK);
	}
	
}
