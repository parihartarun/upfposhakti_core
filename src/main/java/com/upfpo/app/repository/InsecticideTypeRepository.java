package com.upfpo.app.repository;

import com.upfpo.app.entity.InsecticideType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InsecticideTypeRepository extends JpaRepository<InsecticideType, Integer> {
}
