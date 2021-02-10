package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.CropMaster;
import com.upfpo.app.entity.DistrictMaster;

@Repository
public interface CropDetailsMasterRepository extends JpaRepository<CropMaster, Integer>
{
	@Query("Select cm from CropMaster cm where cm.seasonRefId = :seasonId")
	List<CropMaster> getDistrictsByStateId(Integer seasonId);

}
