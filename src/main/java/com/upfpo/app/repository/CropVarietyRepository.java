package com.upfpo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.CropMaster;
import com.upfpo.app.entity.CropVerietyMaster;

@Repository
public interface CropVarietyRepository extends JpaRepository<CropVerietyMaster, Integer>
{
//	public List<CropVerietyMaster> findByCropRefId(int cropRefId);
	public List<CropVerietyMaster> findByCrop(CropMaster crop );
}
