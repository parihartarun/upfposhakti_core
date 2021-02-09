package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upfpo.app.entity.FarmerRegister;

import java.util.Optional;

public interface FarmerRegisterRepo extends JpaRepository<FarmerRegister, Integer>{

    Optional<FarmerRegister> findByUserName(String username);
}
