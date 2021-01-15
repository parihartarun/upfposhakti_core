package com.upfpo.app.service;

import java.util.List;

import com.upfpo.app.entity.BuyerSellerMaster;
import com.upfpo.app.entity.ChcFmbMaster;

public interface BuyerSellerService 
{
	public BuyerSellerMaster updateBuyerSeller(BuyerSellerMaster buyerSeller,int buyerSellerId);
	public List<BuyerSellerMaster> getBuyerSeller();
	public void deleteBuyerSeller(int buyerSellerId);
}
