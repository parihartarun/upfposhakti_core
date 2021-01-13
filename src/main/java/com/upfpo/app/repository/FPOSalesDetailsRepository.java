package com.upfpo.app.repository;

import com.upfpo.app.entity.FPOSalesDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FPOSalesDetailsRepository extends JpaRepository<FPOSalesDetails, Integer> {

}
