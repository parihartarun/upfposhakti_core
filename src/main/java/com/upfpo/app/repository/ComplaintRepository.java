package com.upfpo.app.repository;

import com.upfpo.app.entity.Complaints;
import com.upfpo.app.entity.FPORegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaints, Integer> {

    List<Complaints> findByIsDeleted(Boolean b);
}
