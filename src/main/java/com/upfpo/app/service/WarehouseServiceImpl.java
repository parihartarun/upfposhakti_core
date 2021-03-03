package com.upfpo.app.service;


import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.dto.WarehouseDTO;
import com.upfpo.app.entity.Warehouse;
import com.upfpo.app.repository.WarehouseRepository;
import com.upfpo.app.user.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Calendar;
import java.util.List;


@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository seedRepository;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<WarehouseDTO> getAllWarehouse() {
        List<WarehouseDTO> seed = getSeedDetail();
        return seed;
    }

    @Override
    public Warehouse createWarehouse(Warehouse warehouse) {

        warehouse.setCreateBy(warehouse.getDeptId());
        warehouse.setCreateDateTime(Calendar.getInstance());
        warehouse.setDeleted(false);
        return seedRepository.save(warehouse);
    }

    @Override
    public Boolean deleteWarehouse(Integer id) {
        try {
            Warehouse warehouse = seedRepository.findById(id).get();
            warehouse.setDeleted(true);
            warehouse.setDeleteDate(Calendar.getInstance());
            seedRepository.save(warehouse);
            return true;
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }


    @Override
    public Warehouse updateWarehouse(Integer id, Warehouse warehouse1) {


        return seedRepository.findById(id)
                .map(warehouse -> {
                    warehouse.setUpdateBy(warehouse1.getDeptId());
                    warehouse.setUpdateDate(Calendar.getInstance());
                    warehouse.setDeleted(false);
                    warehouse.setWarehouseType(warehouse1.getWarehouseType());
                    warehouse.setWarehouseServices(warehouse1.getWarehouseServices());
                    warehouse.setDeptId(warehouse1.getDeptId());
                    warehouse.setCapacity(warehouse1.getCapacity());
                    warehouse.setIsSeedProcessingUnit(warehouse1.getIsSeedProcessingUnit());
                    warehouse.setDistrictId(warehouse1.getDistrictId());
                    warehouse.setBlockId(warehouse1.getBlockId());
                    warehouse.setAddress(warehouse1.getAddress());
                    warehouse.setLongitude(warehouse1.getLongitude());
                    warehouse.setLatitude(warehouse1.getLatitude());
                    return seedRepository.save(warehouse);
                }).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
    }


    public List<WarehouseDTO> getSeedDetail() {
        List<WarehouseDTO> list = null;
        try {
            String sql = "Select  wm.id, wm.warehouse_type, wm.warehouse_services, wm.capacity, wm.is_seed_processing, d.district_id, d.district_name,b.block_id, b.block_name, \r\n" +
					"wm.address, wm.longitude, wm.latitude \r\n" +
                    "from warehouse_master wm \r\n" +
                    "left join  districts d on d.district_id=wm.district_id \r\n" +
                    "left join block b on b.block_id=wm.block_id \r\n" +
                    "where wm.is_deleted = false";

            List<WarehouseDTO> obj = (List<WarehouseDTO>) entityManager.createNativeQuery(sql, "WarehouseDTO").getResultList();
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}


