package com.upfpo.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.dto.DeptFpoAgencyDTO;
import com.upfpo.app.dto.FPOListDTO;
import com.upfpo.app.entity.FPORegister;


@Repository
public interface FPORegisterRepository extends JpaRepository<FPORegister, Integer> {

	List<FPORegister> findByIsDeleted(boolean b);

	FPORegister findByUserName(String username);
	  
	Optional<FPORegister> findById(Integer fpoId);
	
	@Query("Select new com.upfpo.app.dto.FPOListDTO(f.fpoId, f.fpoName) from FPORegister f where f.isDeleted = false order by f.fpoName asc")
	List<FPOListDTO> getAllFpoDetails();
	
	@Query("select count(f) from FPORegister f where f.isDeleted = false")
	public Integer getAllFpoCount();
	
	@Query("select distinct new com.upfpo.app.dto.DeptFpoAgencyDTO(count(f), agency) from FPORegister f where f.isDeleted = false group by agency")
	public List<DeptFpoAgencyDTO> getAgency();
}
