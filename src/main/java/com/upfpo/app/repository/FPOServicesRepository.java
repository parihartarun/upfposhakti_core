package com.upfpo.app.repository;


import com.upfpo.app.entity.FPOServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FPOServicesRepository extends JpaRepository<FPOServices, Integer> {
    List<FPOServices> findByIsDeleted(Boolean b);

    List<FPOServices> findByIsDeletedOrderByIdDesc(boolean b);

    List<FPOServices> findByFpoIdAndIsDeletedOrderByIdDesc(Integer fpoId,boolean b);
}
