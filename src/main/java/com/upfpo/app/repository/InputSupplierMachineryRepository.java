package com.upfpo.app.repository;

import com.upfpo.app.entity.EqupmentMaster;
import com.upfpo.app.entity.InputSupplierMachinery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InputSupplierMachineryRepository extends JpaRepository<InputSupplierMachinery, Integer> {
    
	List<InputSupplierMachinery> findByIsDeletedOrderByIdDesc(boolean b);
	
	@Query("select count(id) from InputSupplierMachinery where role = '4'")
	Integer fmbCount();


}
