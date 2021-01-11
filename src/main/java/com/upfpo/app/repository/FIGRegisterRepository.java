package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.FIGRegister;


@Repository
public interface FIGRegisterRepository extends JpaRepository<FIGRegister, Integer> {

}
