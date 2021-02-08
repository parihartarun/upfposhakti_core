package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.TotalProduction;

@Repository
public interface TotalProductionRepository extends JpaRepository<TotalProduction, Integer>{

}
