package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.upfpo.app.entity.FpoLicenceDetails;


@Repository
public interface FpoLicenseDetailsRepository extends JpaRepository<FpoLicenceDetails, Integer> {
	
	@Query("Select fl from FpoLicenceDetails fl order by fl.id desc")
	List<FpoLicenceDetails> findByIsDeleted(boolean b);
}
