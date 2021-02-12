package com.upfpo.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.ReasonsMaster;

@Repository
public interface DepartmentRepository extends JpaRepository<ReasonsMaster, Integer> {

}
