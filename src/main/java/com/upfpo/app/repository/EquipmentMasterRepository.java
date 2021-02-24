package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.upfpo.app.entity.EqupmentMaster;



@Repository
public interface EquipmentMasterRepository extends JpaRepository<EqupmentMaster, Integer> {


    List<EqupmentMaster> findByIsDeletedAndEqipType(boolean b, Integer typeId);

    List<EqupmentMaster> findByIsDeleted(boolean b);
}
