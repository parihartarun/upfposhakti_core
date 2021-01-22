package com.upfpo.app.repository;

import com.upfpo.app.entity.FPOGuidelines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FPOGuidelinesRepository extends JpaRepository<FPOGuidelines, Long> {
}
