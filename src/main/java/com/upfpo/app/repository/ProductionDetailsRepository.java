package com.upfpo.app.repository;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upfpo.app.entity.ProductionDetails;

public interface ProductionDetailsRepository extends JpaRepository<ProductionDetails, Integer>
{
	@Query("select p.actualProdcution from ProductionDetails p where p.farmerId=:farmerId and p.verietyRef=:verietyRef and p.cropType=:cropType and p.financialYear =:financialYear and p.seasonName =:seasonName")
	public double getActualProduction(Integer farmerId, String verietyRef, String cropType, String financialYear, String seasonName );

	
	@Query("select sum(p.actualProdcution) from ProductionDetails p where p.cropType = :cropId and p.verietyRef=:verietyRef and p.seasonName=:seasonId and m.masterId")
	public double getActualProductionbyFarmer(int cropId, int cropVarietyId, int seasonId,String financialYear, int masterId);
	
	@Query("select sum(m.marketableQuantity) from MarketableSurplus m where m.crop_id = :cropId and m.verietyId=:cropVarietyId and m.season=:seasonId and m.masterId")
	public double getMarketableQty(int cropId, int cropVarietyId, int seasonId,String financialYear, int masterId);
	
	
	/*@Column(name="season_ref")
	private Integer  seasonName;
    
    @Column(name="crop_type")
	private String  cropType;
    
    @Column(name = "guardian_name")
	private String guardianName;
    
    @Column(name="crop_ref_name")
	private Integer  cropRefName;
    
    @Column(name="veriety_ref")
	private Integer  verietyRef;
    
    @Column(name="financial_year")
	private String  financialYear;
    
    @Column(name="actual_production")
	private Double  actualProdcution;
    
    @Column(name="marketable_surplus")
	private Double marketableSurplus;*/
}
