package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.MarketableSurplus;

@Repository
public interface FPOCropProductionReporisitory extends JpaRepository<MarketableSurplus, Integer>{


}
