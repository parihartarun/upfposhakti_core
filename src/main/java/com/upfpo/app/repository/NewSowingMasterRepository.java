package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.NewSowing;

@Repository
public interface NewSowingMasterRepository extends JpaRepository<NewSowing, Integer> 
{

}
