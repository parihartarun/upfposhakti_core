package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.upfpo.app.entity.FpoLicenceDetails;

import com.upfpo.app.entity.FIGRegister;
import com.upfpo.app.entity.FarmMachineryBank;


@Repository
public interface FarmMachineryBankRepository extends JpaRepository<FarmMachineryBank, Integer> {

}
