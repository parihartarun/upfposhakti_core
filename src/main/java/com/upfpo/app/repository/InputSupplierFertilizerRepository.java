package com.upfpo.app.repository;

import com.upfpo.app.entity.InputSupplierFertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InputSupplierFertilizerRepository extends JpaRepository<InputSupplierFertilizer, Integer> {


    List<InputSupplierFertilizer> findByIsDeletedOrderByIdDesc(boolean b);
}
