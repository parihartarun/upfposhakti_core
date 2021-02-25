package com.upfpo.app.repository;

import com.upfpo.app.entity.ChcFmbMachinery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChcFmbMachineryRepository extends JpaRepository<ChcFmbMachinery, Integer> {


    List<ChcFmbMachinery> findByIsDeletedOrderByIdDesc(boolean b);
}
