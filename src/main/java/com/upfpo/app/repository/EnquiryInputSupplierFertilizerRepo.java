package com.upfpo.app.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upfpo.app.entity.EnquiryInputSupplierFertilizer;

public interface EnquiryInputSupplierFertilizerRepo extends JpaRepository<EnquiryInputSupplierFertilizer, BigInteger>
{
	List<EnquiryInputSupplierFertilizer> findByMasterIdOrderByEnqidDesc(Integer masterId);
	
	List<EnquiryInputSupplierFertilizer> findByCreatedByAndRoleRefIdOrderByEnqidDesc(Integer createdBy, String roleId);
}
