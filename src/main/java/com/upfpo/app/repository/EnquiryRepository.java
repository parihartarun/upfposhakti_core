package com.upfpo.app.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.Enquiry;
import com.upfpo.app.entity.FPORegister;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {
	
	List<Enquiry> findByMasterId(int masterId);


	Enquiry findByEnid(long id);


	List<Enquiry> findByFpo(FPORegister fpo);
	
	@Query("select count(e.fpo.fpoId) from Enquiry e where e.masterId = :buyerId")
	public Integer getFpoCount(Integer buyerId);
	
	@Query("select count(e) from Enquiry e where e.status = :status and e.masterId = :masterId")
	public Integer getIndents(String status, Integer masterId);
	
	@Query("select distinct count(e.cropMaster.cropId) from Enquiry e where e.masterId = :masterId")
	public BigInteger getCropCount(Integer masterId);
	
}
