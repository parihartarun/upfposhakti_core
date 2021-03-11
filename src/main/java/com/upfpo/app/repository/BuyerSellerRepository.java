package com.upfpo.app.repository;

import javax.transaction.Transactional;

import com.upfpo.app.entity.FPORegister;
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
	
	//@Query("select count(b) from BuyerSellerMaster b where b.mobileNumber = :mobileNumber")
	@Query("select count(c) from BuyerSellerMaster c where c.mobileNumber = :mobileNumber")
	 public int alreadyExists(long mobileNumber);
	
	@Query("select count(b) from BuyerSellerMaster b where upper(b.userBuyerSeller.userName) = :userName")
	public int checkUserBuyerSellerExists(String userName);



    BuyerSellerMaster findByUserBuyerSeller(Long userId);
}
