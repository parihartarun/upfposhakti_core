package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.FPORegister;

@Repository
public interface FpoMasterRepository extends JpaRepository<FPORegister, Integer>
{
	@Query("select count(f) from FPORegister f where f.fpoEmail = :fpoEmail")
	 public int alreadyExists(String  fpoEmail);
	
	@Query("select count(f) from FPORegister f where upper(f.userFpo.userName) = :userName")
	public int checkUserFpoExists(String userName);
}
