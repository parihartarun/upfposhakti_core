package com.upfpo.app.service;

import com.upfpo.app.dto.WarehouseDTO;
import com.upfpo.app.entity.Warehouse;
import com.upfpo.app.entity.WarehouseFacilities;
import com.upfpo.app.entity.WarehouseFacilityMaster;

import java.util.List;

public interface WarehouseService {
    List<WarehouseDTO> getAllWarehouse();

    List<WarehouseFacilityMaster> getAllFacilities();

    Warehouse createWarehouse(Warehouse warehouse);

    Boolean deleteWarehouse(Integer id);

    Warehouse updateWarehouse(Integer id, Warehouse warehouse1);
}
