package com.upfpo.app.repository;

import com.upfpo.app.entity.WarehouseFacilities;
import com.upfpo.app.entity.WarehouseFacilityMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseFacilitiesRepository extends JpaRepository<WarehouseFacilities, Integer> {
}
