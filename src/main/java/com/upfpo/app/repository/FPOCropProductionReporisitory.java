package com.upfpo.app.repository;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.MarketableSurplus;

@Repository
public interface FPOCropProductionReporisitory extends JpaRepository<MarketableSurplus, Integer>
{
	/*@Query("select sum(m.actualQuantity) from MarketableSurplus m where m.crop_id = :cropId and m.verietyId=:cropVarietyId and m.season=:seasonId and m.masterId=:masterId")
	public double getActulaProduction(int cropId, int cropVarietyId, int seasonId, int masterId);
	
	@Query("select sum(m.marketableQuantity) from MarketableSurplus m where m.crop_id = :cropId and m.verietyId=:cropVarietyId and m.season=:seasonId and m.masterId=:masterId")
	public double getMarketableQty(int cropId, int cropVarietyId, int seasonId, int masterId);*/
	
}
