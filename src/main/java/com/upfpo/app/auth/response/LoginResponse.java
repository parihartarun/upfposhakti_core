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
	private String userRole;
	private Integer masterId;

	
	public LoginResponse(String token, User user, String userRole, Integer masterId) {
		super();
		this.token = token;
		this.user = user;
		this.userRole = userRole;
		this.masterId = masterId;
	}

	public String getToken() {
		return token;
	}

	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public Integer getMasterId() {
		return masterId;
	}
	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
