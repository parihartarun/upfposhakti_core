package com.upfpo.app.repository;

import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.FPOGuidelineType;
import com.upfpo.app.entity.FPOGuidelines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FPOGuidelinesRepository extends JpaRepository<FPOGuidelines, Long> {

    List<FPOGuidelines> findByIsDeleted(Boolean b);

    List<FPOGuidelines> findByFpoGuidelineType(FPOGuidelineType type);
}
