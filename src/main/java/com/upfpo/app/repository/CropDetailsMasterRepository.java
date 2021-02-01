package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.CropMaster;

@Repository
public interface CropDetailsMasterRepository extends JpaRepository<CropMaster, Integer>
{

}
