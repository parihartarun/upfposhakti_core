package com.upfpo.app.service;

import com.upfpo.app.dto.WarehouseDTO;
import com.upfpo.app.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
    List<WarehouseDTO> getAllWarehouse();

    Warehouse createWarehouse(Warehouse warehouse);

    Boolean deleteWarehouse(Integer id);

    Warehouse updateWarehouse(Integer id, Warehouse warehouse1);
}
