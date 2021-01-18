package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.StateMaster;

@Repository
public interface StateMasterRepository extends JpaRepository<StateMaster, Integer>
{
	
}
