package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.upfpo.app.entity.ProductionDetails;

public interface ProductionDetailsRepository extends JpaRepository<ProductionDetails, Integer>
{
	@Query("select p.actualProdcution from ProductionDetails p where p.farmerId=:farmerId and p.verietyRef=:verietyRef and p.cropType=:cropType and p.financialYear =:financialYear and p.seasonName =:seasonName")
	public double getActualProduction(Integer farmerId, String verietyRef, String cropType, String financialYear, String seasonName );

}
