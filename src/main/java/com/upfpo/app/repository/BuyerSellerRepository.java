package com.upfpo.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.BuyerSellerMaster;

@Repository
public interface BuyerSellerRepository extends JpaRepository<BuyerSellerMaster, Integer>
{
	@Modifying
	@Transactional
	@Query("update BuyerSellerMaster b set b.isDeleted=true where b.buyerSellerId = :buyerSellerId")
	public void deleteBuyerSeller(int buyerSellerId);
}
