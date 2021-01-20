package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.CollectionCenter;
import com.upfpo.app.entity.FPORegister;


@Repository
public interface FPORegisterRepository extends JpaRepository<FPORegister, Integer> {

	List<FPORegister> findByIsDeleted(boolean b);
}
