package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.BankMaster;

@Repository
public interface BankMasterRepository extends JpaRepository<BankMaster, Integer>
{

}
