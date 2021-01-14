package com.upfpo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upfpo.app.entity.BuyerSellerMaster;

public interface BuyerSellerRepository extends JpaRepository<BuyerSellerMaster, Integer>
{

}
