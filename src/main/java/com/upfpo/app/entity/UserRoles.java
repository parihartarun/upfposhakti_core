package com.upfpo.app.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.upfpo.app.dto.DepartmentAllUserDto;

@Entity
@SqlResultSetMapping(name="DepartmentAllUserDto",
classes = {
    @ConstructorResult(
            targetClass = DepartmentAllUserDto.class,
            columns = {
            	@ColumnResult(name = "user_id", type = Integer.class),
            	@ColumnResult(name = "user_name", type = String.class),
            	@ColumnResult(name = "fpo_name", type = String.class),
                @ColumnResult(name = "district_name", type = String.class),
                @ColumnResult(name = "date_of_regi", type = String.class),
                @ColumnResult(name = "fpo_landline", type = BigInteger.class),
                @ColumnResult(name = "fpo_email", type = String.class),
                @ColumnResult(name = "enabled", type = Boolean.class),
           })
})
@Table(name="user_roles",catalog = "upfpo")
@NamedQuery(name = "ROLE_NAME_BY_ID", query = "select ur.role from UserRoles ur where ur.roleId = :roleId")

public class UserRoles {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private String roleId;
	
	@Column(name="isactive")
	private Long isActive;
	
	public UserRoles(String roleId, Long isActive, String role) {
		super();
		this.roleId = roleId;
		this.isActive = isActive;
		this.role = role;
	}
	
	@Column(name="role")
	private String role;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Long getIsActive() {
		return isActive;
	}

	public void setIsActive(Long isActive) {
		this.isActive = isActive;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	
}
