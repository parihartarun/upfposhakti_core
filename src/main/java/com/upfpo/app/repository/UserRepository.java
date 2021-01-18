package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUserName(String userName);

	@Query("SELECT u FROM User u WHERE u.userName = :username AND u.password= :password")
	Mono<User> login(String username, String password);

}
