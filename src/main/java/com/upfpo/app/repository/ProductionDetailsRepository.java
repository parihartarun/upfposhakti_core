package com.upfpo.app.repository;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upfpo.app.entity.ProductionDetails;

public interface ProductionDetailsRepository extends JpaRepository<ProductionDetails, Integer>
{
	/*@Query("select p.actualProdcution from ProductionDetails p where p.farmerId=:farmerId and p.verietyRef=:verietyRef and p.cropType=:cropType and p.financialYear =:financialYear and p.seasonName =:seasonName")
	public double getActualProduction(Integer farmerId, String verietyRef, String cropType, String financialYear, String seasonName );*/

	
	@Query("select sum(p.actualProdcution) from ProductionDetails p join p.farmerProfile f where p.farmerProfile.farmerId = f.farmerId and "
			+ "p.crop_id = :cropId and p.veriety_id=:cropVarietyId and p.season_id=:seasonId and f.fpoRefId=:masterId")
	public double getActualProductionbyFarmer(int cropId, int cropVarietyId, int seasonId, int masterId);
	
	@Query("select sum(p.marketableSurplus) from ProductionDetails p join p.farmerProfile f where p.farmerProfile.farmerId = f.farmerId and "
			+ "p.crop_id = :cropId and p.veriety_id=:cropVarietyId and p.season_id=:seasonId and f.fpoRefId=:masterId")
	public double getMarketableQty(int cropId, int cropVarietyId, int seasonId, int masterId);
	
}
