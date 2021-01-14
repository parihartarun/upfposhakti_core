package com.upfpo.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.InputSupplierMaster;

@Repository
public interface InputSupplierMasterRepository extends JpaRepository<InputSupplierMaster, Integer>
{
	@Modifying
	@Transactional
	@Query("update InputSupplierMaster i set i.isDeleted=true where i.inputSupplierId = :inputSupplierId")
	public void deleteInputSupplier(int inputSupplierId);
}
