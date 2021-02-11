package com.upfpo.app.repository;

import java.util.List;
import java.util.OptionalDouble;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.User;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByUserName(String userName);

	User findByUserName(String userName);

	

	boolean existsByUserNameAndIsEnabledTrueAndIsDeletedFalse(String username);

	java.util.Optional<User> findByUserNameAndIsEnabledTrueAndIsDeletedFalse(String username);

    List<User> findByRoleRefId(String id);

	//DeActivate user by department user
	
	@Modifying
	@Transactional
	@Query("update User u set u.isEnabled=false, u.deActivatedBy= :masterId, u.reason= :reason where u.userId = :uid")
	public void deActivateUserByDept(Long uid, String reason, Integer masterId);
	
	//Activate user by department user
	@Modifying
	@Transactional
	@Query("update User u set u.isEnabled=true, u.activatedBy= :masterId where u.userId = :uid")
	public void activateUserByDept(Long uid, Integer masterId);
}
