package com.upfpo.app.repository;


import com.upfpo.app.entity.InputSupplierInsecticide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InputSupplierInsecticideRepository extends JpaRepository<InputSupplierInsecticide, Integer> {


    List<InputSupplierInsecticide> findByIsDeletedOrderByIdDesc(boolean b);
}
