package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.BankMaster;

@Repository
public interface BankMasterRepository extends JpaRepository<BankMaster, Integer>
{


    @Query("Select bankId, bankName from BankMaster v where v.bankName= :bank_name")
    Object findByBankName(String bank_name);
}
