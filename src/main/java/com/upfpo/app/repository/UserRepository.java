package com.upfpo.app.repository;

import java.util.OptionalDouble;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.User;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByUserName(String userName);

	User findByUserName(String userName);

	

	boolean existsByUserNameAndIsEnabledTrueAndIsDeletedFalse(String username);

	java.util.Optional<User> findByUserNameAndIsEnabledTrueAndIsDeletedFalse(String username);

	
}
