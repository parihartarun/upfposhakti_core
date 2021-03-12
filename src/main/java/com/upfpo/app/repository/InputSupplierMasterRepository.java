package com.upfpo.app.repository;

import javax.transaction.Transactional;

import com.upfpo.app.dto.InputSupplierDTO;
import com.upfpo.app.entity.FPORegister;
import jdk.nashorn.internal.objects.AccessorPropertyDescriptor;
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
	
	@Query("select count(i) from InputSupplierMaster i where i.mobile_number = :mobile_number")
	 public int alreadyExists(long mobile_number);
	
	@Query("select count(i) from InputSupplierMaster i where upper(i.userInputSeller.userName) = :userName")
	public int checkUserInputSupplierExists(String userName);

    InputSupplierMaster findByUserInputSeller(Long userId);


	//@Query("select i.inputSupplierId, i.inputSupplierName, i.mobile_number, i.email from InputSupplierMaster i where i.inputSupplierId=:masterId")
	@Query("SELECT new com.upfpo.app.dto.InputSupplierDTO(inputSupplierId, inputSupplierName, mobile_number, email) FROM InputSupplierMaster where inputSupplierId=:masterId")
	InputSupplierDTO getInputSupplierDetail(Integer masterId);
}
