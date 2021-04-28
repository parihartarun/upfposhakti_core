package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.dto.FarmerCropSowingDTO;
import com.upfpo.app.entity.NewSowing;

@Repository
public interface NewSowingMasterRepository extends JpaRepository<NewSowing, Integer> 
{
	@Query("SELECT new com.upfpo.app.dto.FarmerCropSowingDTO(f.farmerName,f.parantsName, COALESCE(sum(l.land_area),0)) FROM LandDetails l right join l.farmerProfile f where f.farmerId= :farmerId group by l.farmerProfile.farmerName, f.parantsName")
	 public FarmerCropSowingDTO getFarmerDetailsForCropSowing(int farmerId);
	
	@Query("SELECT new com.upfpo.app.dto.FarmerCropSowingDTO(f.farmerName,f.parantsName) FROM FarmerMaster f  where f.farmerId = :farmerId")
	public FarmerCropSowingDTO getFarmerParentDetails(int farmerId);
	
	@Query("select count(n) from NewSowing n where n.farmerId =:farmerId and n.masterId =:masterId and n.finYear =:finYear")
	public Integer existingFarmer(Integer farmerId, Integer masterId, String finYear);
}
