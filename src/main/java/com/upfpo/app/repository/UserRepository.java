package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.User;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByUserName(String userName);

	User findByUserName(String userName);


}
