package com.upfpo.app.repository;

import com.upfpo.app.entity.FPOComplaints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FPOComplaintRepository extends JpaRepository<FPOComplaints, Integer> {


    List<FPOComplaints> findByInputSupplierId(Integer supplierId);

    List<FPOComplaints> findByChcFmbId(Integer chcId);

    List<FPOComplaints> findByFpoId(Integer fpoId);

    List<FPOComplaints> findByChcFmbIdOrderByIdDesc(Integer chcId);

    List<FPOComplaints> findByIsDeletedOrderByIdDesc(Boolean b);
}
