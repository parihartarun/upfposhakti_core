package com.upfpo.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.dto.FpoCropProductionDashboardDTO;
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
	 
	 /*@Query("select distinct new com.upfpo.app.dto.FpoCropProductionDashboardDTO(t.cropMaster.cropId, t.cropMaster.cropName, sum(t.total_actual_prod) as totAcProd, sum(t.totalMarketable) as totMarkProd) from TotalProduction t where t.fpoRegister = :fpoId group by t.cropMaster.cropId order by totAcProd desc"
	 		+ " totMarkProd desc")
	 public List<FpoCropProductionDashboardDTO> getCropProduction(Integer fpoId);*/
	 
}


