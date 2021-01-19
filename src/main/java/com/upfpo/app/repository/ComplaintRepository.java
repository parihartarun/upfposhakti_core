package com.upfpo.app.repository;

import com.upfpo.app.entity.Complaints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaints, Long> {
}
