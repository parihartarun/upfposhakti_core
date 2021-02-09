package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.FPOSaleInfo;

@Repository
public interface FpoSalesInfoMasterRepository extends JpaRepository<FPOSaleInfo, Integer>
{

}
