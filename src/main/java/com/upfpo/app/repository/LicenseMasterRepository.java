package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.LicenseMaster;


@Repository
public interface LicenseMasterRepository extends JpaRepository<LicenseMaster, Integer> {

}
