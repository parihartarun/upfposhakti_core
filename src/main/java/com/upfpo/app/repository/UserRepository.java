package com.upfpo.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByUserName(String userName);

}
