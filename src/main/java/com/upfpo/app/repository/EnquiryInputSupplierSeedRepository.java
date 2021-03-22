package com.upfpo.app.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.EnquiryInputSupplierSeed;

@Repository
public interface EnquiryInputSupplierSeedRepository extends JpaRepository<EnquiryInputSupplierSeed, BigInteger>
{
	List<EnquiryInputSupplierSeed> findByMasterIdOrderByEnqidDesc(Integer masterId);
	
	List<EnquiryInputSupplierSeed> findByCreatedByOrderByEnqidDesc(Integer createdBy);
}
