package com.upfpo.app.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.EnquiryInputSupplierSeed;

@Repository
public interface EnquiryInputSupplierSeedRepository extends JpaRepository<EnquiryInputSupplierSeed, BigInteger>
{

}
