package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.dto.FarmerCropSowingDTO;
import com.upfpo.app.entity.NewSowing;

@Repository
public interface NewSowingMasterRepository extends JpaRepository<NewSowing, Integer> 
{
	@Query("SELECT new com.upfpo.app.dto.FarmerCropSowingDTO(f.parantsName, sum(l.land_area)) FROM LandDetails l join l.farmerProfile f where f.farmerId= :farmerId group by f.parantsName")
	 public FarmerCropSowingDTO getFarmerDetailsForCropSowing(int farmerId);
}
