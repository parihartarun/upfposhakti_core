package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.AgencyMaster;
import com.upfpo.app.entity.BankMaster;

@Repository
public interface AgencyMasterRepository extends JpaRepository<AgencyMaster, Integer>
{

	List<AgencyMaster> findByIsDeleted(boolean b);

}
