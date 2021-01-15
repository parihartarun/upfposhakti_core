package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.upfpo.app.entity.FpoLicenceDetails;
import com.upfpo.app.entity.EqupmentMaster;
import com.upfpo.app.entity.FIGRegister;
import com.upfpo.app.entity.FarmMachineryBank;


@Repository
public interface FarmMachineryBankRepository extends JpaRepository<FarmMachineryBank, Integer> {

	List<FarmMachineryBank> findByIsDeleted(boolean b);
}
