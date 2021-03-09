package com.upfpo.app.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upfpo.app.entity.EnquiryInputSupplierInsecticide;

public interface EnquiryInputSupplierInsecticideRepo extends JpaRepository<EnquiryInputSupplierInsecticide, BigInteger>
{
	List<EnquiryInputSupplierInsecticide> findByMasterId(Integer masterId);
}
