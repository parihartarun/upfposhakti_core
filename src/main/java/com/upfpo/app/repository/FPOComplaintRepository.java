package com.upfpo.app.repository;

import com.upfpo.app.entity.FPOComplaints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FPOComplaintRepository extends JpaRepository<FPOComplaints, Integer> {


}
