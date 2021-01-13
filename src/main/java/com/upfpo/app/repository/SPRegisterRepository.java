package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.SPRegister;

@Repository
public interface SPRegisterRepository extends JpaRepository<SPRegister, Integer> {

}
