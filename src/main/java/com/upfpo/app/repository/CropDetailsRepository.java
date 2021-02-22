package com.upfpo.app.repository;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.CropDatails;

@Repository
public interface CropDetailsRepository extends JpaRepository<CropDatails, Integer>
{
	@Query("select sum(c.actualYield) from CropDatails c join c.newSowing n on c.newSowing.sowingId = n.sowingId where "
			+ "c.cropRefName = :cropId and c.verietyRef= :cropVarietyId and c.seasonRefName= :seasonId and n.masterId = :masterId and n.finYear = :financialYear")
	public Double getActualQty(int cropId, int cropVarietyId, int seasonId, int masterId, String financialYear);
	
	@Query("select sum(c.marketableQuantity) from CropDatails c join c.newSowing n on c.newSowing.sowingId = n.sowingId where "
			+ "c.cropRefName = :cropId and c.verietyRef= :cropVarietyId and c.seasonRefName= :seasonId and n.masterId = :masterId and n.finYear = :financialYear")
	public Double getMarketableQty(int cropId, int cropVarietyId, int seasonId, int masterId, String financialYear);

} 
