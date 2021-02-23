package com.upfpo.app.repository;

import com.upfpo.app.entity.FertilizerName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FertilizerNameRepository extends JpaRepository<FertilizerName, Integer> {
}
