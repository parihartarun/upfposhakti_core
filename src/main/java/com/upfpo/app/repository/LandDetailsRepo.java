package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upfpo.app.entity.LandDetails;

public interface LandDetailsRepo extends JpaRepository<LandDetails, Integer>
{
	@Query("select sum(l.land_area) from LandDetails l join l.farmerProfile f where l.farmerProfile.farmerId = f.farmerId and f.fpoRefId = :fpoId and f.isDeleted = false and l.isDeleted = false")
	public Double getTotalFpoLand(Integer fpoId);
	
	@Query("select sum(l.land_area) from LandDetails l join l.farmerProfile f where l.farmerProfile.farmerId = f.farmerId and f.isDeleted = false and l.isDeleted = false")
	public Double getTotalLand();
}
