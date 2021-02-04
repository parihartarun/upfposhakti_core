package com.upfpo.app.repository;


import com.upfpo.app.entity.FPOLevelProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FPOLevelProductionRepository extends JpaRepository<FPOLevelProduction, Integer> {
    List<FPOLevelProduction> findByIsDeleted(Boolean b);
}
