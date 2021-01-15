package com.upfpo.app.repository;


import com.upfpo.app.entity.FPOLevelProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FPOLevelProductionRepository extends JpaRepository<FPOLevelProduction, Integer> {
}
