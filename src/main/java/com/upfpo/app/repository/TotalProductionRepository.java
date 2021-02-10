package com.upfpo.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.TotalProduction;

@Repository
public interface TotalProductionRepository extends JpaRepository<TotalProduction, Integer>
{
	//public Optional<TotalProduction> findByMarketableSurplusId(Integer id);
	
	 /*@Modifying
	 @Transactional
	 @Query("update TotalProduction t set t.total_actual_prod= :actualProduction and t.totalMarketable = :totalMarketable where t.cropMaster.cropId= :cropId and t.cropVerityMaster.verietyId= :varietyId and t.fpoRegister = :masterId")
	 public void updateTotalProduction(Double actualProduction, Double totalMarketable, int cropId, int varietyId, int masterId);*/
}