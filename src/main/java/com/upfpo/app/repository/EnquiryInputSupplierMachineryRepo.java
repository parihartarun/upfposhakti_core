package com.upfpo.app.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upfpo.app.entity.EnquiryInputSupplierMachinery;

public interface EnquiryInputSupplierMachineryRepo extends JpaRepository<EnquiryInputSupplierMachinery, BigInteger>
{
	List<EnquiryInputSupplierMachinery> findByMasterId(Integer masterId);
}
