package com.upfpo.app.repository;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.CropMaster;
import com.upfpo.app.entity.CropVerietyMaster;
import com.upfpo.app.entity.FarmerMaster;
import com.upfpo.app.entity.TotalProduction;

@Repository
public interface TotalProductionRepository extends JpaRepository<TotalProduction, Integer>
{
	//public Optional<TotalProduction> findByMarketableSurplusId(Integer id);
	
	 @Modifying
	 @Transactional
	 @Query("update com.upfpo.app.entity.TotalProduction t set t.total_actual_prod= :actualProduction, t.totalMarketable= :totalMarketable "
	 		+ "where t.cropMaster.cropId= :cropId and t.cropVerityMaster.verietyId= :varietyId and t.fpoRegister= :masterId and t.seasonId = :seasonId and t.finYear = :financialYear")
	 public void updateTotalProduction(Double actualProduction, Double totalMarketable, int cropId, int varietyId, int masterId, int seasonId, String financialYear);
	 
	 @Query("select count(*) from TotalProduction t where t.cropMaster.cropId= :cropId and t.cropVerityMaster.verietyId= :cropVarietyId and t.fpoRegister = :masterId and t.seasonId = :seasonId and t.finYear = :financialYear")
	 public int getCountTotalProductionCount(int cropId, int cropVarietyId, int masterId, int seasonId, String financialYear);
	 
	 @Query("select t.totalMarketable from TotalProduction t where t.cropMaster.cropId= :cropId and t.cropVerityMaster.verietyId= :cropVarietyId and t.fpoRegister = :masterId and t.seasonId = :seasonId and t.finYear = :financialYear")
	 public Double getTotalMarketableQty(int cropId, int cropVarietyId, int masterId, int seasonId, String financialYear);
	
	 @Modifying
	 @Transactional
	 @Query("update com.upfpo.app.entity.TotalProduction t set t.totalSold= :totalSold, t.currentMarketable= :currentMarketable "
	 		+ "where t.cropMaster.cropId= :cropId and t.cropVerityMaster.verietyId= :cropVarietyId and t.fpoRegister= :masterId and t.seasonId = :seasonId and t.finYear = :financialYear")
	 public void updateMarketable(double totalSold, double currentMarketable, int cropId, int cropVarietyId, int masterId, int seasonId, String financialYear);
	 
	 @Query("select count(distinct t.cropMaster.cropId) from TotalProduction t where t.fpoRegister = :fpoId")
	 public Integer getCountCrops(Integer fpoId);
}


