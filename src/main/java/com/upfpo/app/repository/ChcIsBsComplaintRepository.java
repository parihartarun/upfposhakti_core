package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upfpo.app.entity.ChcIsBsComplaints;
import com.upfpo.app.entity.FPOComplaints;

public interface ChcIsBsComplaintRepository extends JpaRepository<ChcIsBsComplaints, Integer>{

	List<ChcIsBsComplaints> findByInputSupplierIdOrderByIdDesc(Integer masterId);

	List<ChcIsBsComplaints> findByChcFmbIdOrderByIdDesc(Integer masterId);

	List<ChcIsBsComplaints> findByBuyerSellerIdOrderByIdDesc(Integer masterId);

	@Query("Select cc from ChcIsBsComplaints cc where cc.role = :role")
	List<ChcIsBsComplaints> findAllComplaintIsChcBsByRole(String role);
}
