package com.upfpo.app.repository;


import com.upfpo.app.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository <Notification, Integer> {
    List<Notification> findByIsDeleted(boolean b);

    List<Notification> findByFarmerId(String farmerId);

    List<Notification> findByFpoId(String fpoId);

    List<Notification> findByDeptId(String deptId);

    List<Notification> findByDeptIdOrderByIdDesc(String deptId);

    List<Notification> findByFarmerIdOrderByIdDesc(String farmerId);

    List<Notification> findByFpoIdOrderByIdDesc(String fpoId);
}
