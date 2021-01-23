package com.upfpo.app.auth.response;

import com.upfpo.app.entity.User;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginResponse implements Serializable {
	
	private String token;
	private User user;

	public LoginResponse(String generateToken, User user) 
	{
		this.token = generateToken;
		this.user  = user;
	}


}
