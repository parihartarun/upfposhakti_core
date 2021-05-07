package com.upfpo.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.upfpo.app.entity.FarmerRegister;
import com.upfpo.app.entity.User;

public interface FarmerRegisterRepo extends JpaRepository<FarmerRegister, Integer>{

    Optional<FarmerRegister> findByUserName(String username);

    FarmerRegister findByUserRefId(Long userId);
    
    @Modifying
   	@Transactional
   	@Query("update FarmerMaster f set userFar= :u where f.farmerId=:id")
   	public void updateUserId(User u,Integer id);
}
