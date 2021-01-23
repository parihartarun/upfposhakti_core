package com.upfpo.app.serviceImpl;

import com.upfpo.app.auth.response.LoginResponse;
import com.upfpo.app.custom.CustomException;
import com.upfpo.app.dto.UserDetailsDto;
import com.upfpo.app.security.jwt.JwtUtils;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
			UserDetailsDto userDetailsDto = userMasterId(username);
			Integer masterId = userDetailsDto.getSessionid();
			System.err.print("Master Id for user::"+masterId);
			return new LoginResponse(jwtTokenProvider.generateToken(user),user);
		} catch (AuthenticationException e) {
			throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	public String signup(User user) {
		if (!userRepository.existsByUserName(user.getUserName())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return jwtTokenProvider.generateToken(user);
		} else {
			throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	public UserDetailsDto userMasterId(String userName)
	{
		String  sql =  	" select CASE\r\n"
				+ " WHEN ur.role='ROLE_BUYERSELLER'  THEN  buyerSeller_id\r\n"
				+ " WHEN ur.role='ROLE_CHCFMB'  THEN chc_fmb_id\r\n"
				+ " WHEN ur.role='ROLE_INPUTSUPPLIER'  THEN input_supplier_id\r\n"
				+ " WHEN ur.role='ROLE_FPC'  THEN fpo_id\r\n"
				+ " ELSE farmer_id\r\n"
				+ " END as sessionid,                                 \r\n"
				+ " CASE\r\n"
				+ " WHEN ur.role='ROLE_BUYERSELLER' THEN c.buyerSeller_name\r\n"
				+ " WHEN ur.role='ROLE_CHCFMB'  THEN b.chc_fmb_name\r\n"
				+ " WHEN ur.role='ROLE_INPUTSUPPLIER'  THEN e.input_supplier_name\r\n"
				+ " WHEN ur.role='ROLE_FPC'  THEN d.fpo_name\r\n"
				+ " ELSE  f.farmer_name\r\n"
				+ " END as userdetail_name,\r\n"
				+ " a.user_id,a.user_name,a.pass,ur.role,a.enabled,a.is_changed\r\n"
				+ " from Users a\r\n"
				+ " join user_roles ur on ur.role_id=a.role_ref_id\r\n"
				+ " left join chc_fmb b on a.user_id = b.user_id\r\n"
				+ " left join buyer_seller c on a.user_id=c.user_id\r\n"
				+ " left join input_supplier e on a.user_id=e.user_id\r\n"
				+ " left join fpo d on a.user_id=d.user_id\r\n"
				+ " left join farmer f on a.user_id=f.user_id where a.user_name= :userName and ur.isactive=1" ;
		  
		  UserDetailsDto obj =  (UserDetailsDto) entityManager.createNativeQuery(sql,"UserDetailsDto").setParameter("user_name", userName).getSingleResult();
		  return obj;
		    
	}

}
