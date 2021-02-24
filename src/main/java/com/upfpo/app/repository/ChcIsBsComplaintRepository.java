package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upfpo.app.entity.ChcIsBsComplaints;
import com.upfpo.app.entity.FPOComplaints;

public interface ChcIsBsComplaintRepository extends JpaRepository<ChcIsBsComplaints, Integer>{

	List<ChcIsBsComplaints> findByInputSupplierIdOrderByIdDesc(Integer supplierId);
}
