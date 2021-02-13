package com.upfpo.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.dto.FPOListDTO;
import com.upfpo.app.dto.FarmerCropSowingDTO;
import com.upfpo.app.entity.FPORegister;


@Repository
public interface FPORegisterRepository extends JpaRepository<FPORegister, Integer> {

	List<FPORegister> findByIsDeleted(boolean b);

	FPORegister findByUserName(String username);
	  
	 @Query("SELECT new com.upfpo.app.dto.FarmerCropSowingDTO(f.parantsName, sum(l.land_area)) FROM LandDetails l join l.farmerProfile f where f.farmerId= :farmerId group by f.parantsName")
	 public FarmerCropSowingDTO getFarmerDetailsForCropSowing(int farmerId);

	Optional<FPORegister> findById(Integer fpoId);
	
	@Query("Select new com.upfpo.app.dto.FPOListDTO(f.fpoId, f.fpoName) from FPORegister f where f.isDeleted = false order by f.fpoName asc")
	List<FPOListDTO> getAllFpoDetails();
	 
}
