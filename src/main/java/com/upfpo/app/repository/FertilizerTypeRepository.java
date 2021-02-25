package com.upfpo.app.repository;

import com.upfpo.app.entity.FertilizerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FertilizerTypeRepository extends JpaRepository<FertilizerType, Integer> {
}
