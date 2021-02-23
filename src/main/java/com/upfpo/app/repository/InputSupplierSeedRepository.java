package com.upfpo.app.repository;

import com.upfpo.app.entity.InputSupplierSeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

@Repository
public interface InputSupplierSeedRepository extends JpaRepository<InputSupplierSeed, Integer> {

    List<InputSupplierSeed> findByIsDeleted(boolean b);
}
