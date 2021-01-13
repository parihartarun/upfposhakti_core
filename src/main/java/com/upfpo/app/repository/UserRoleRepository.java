package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.UserRoles;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRoles, Integer> {
	
	@Query(name = "ROLE_NAME_BY_ID")
	String roleNameById(String roleId);

}
