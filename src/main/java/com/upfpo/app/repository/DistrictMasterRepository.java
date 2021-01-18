package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.DistrictMaster;

@Repository
public interface DistrictMasterRepository extends JpaRepository<DistrictMaster, Integer>
{
	@Query("Select d from DistrictMaster d where d.state_id= :state_id")
	List<DistrictMaster> getDistrictsByStateId(int state_id);
}
