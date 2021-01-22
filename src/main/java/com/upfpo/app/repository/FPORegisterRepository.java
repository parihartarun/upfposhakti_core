package com.upfpo.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.CollectionCenter;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.User;


@Repository
public interface FPORegisterRepository extends JpaRepository<FPORegister, Integer> {

	List<FPORegister> findByIsDeleted(boolean b);

	FPORegister findByUserName(String username);
	
	@Query("Select fpo.fpoId from  FPORegister fpo where fpo.userFpo.userId = :userId")
	Integer findByUserId(Long userId);
}
