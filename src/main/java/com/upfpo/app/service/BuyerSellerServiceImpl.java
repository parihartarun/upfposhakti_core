package com.upfpo.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.entity.BuyerSellerMaster;
import com.upfpo.app.repository.BuyerSellerRepository;

@Service
public class BuyerSellerServiceImpl implements BuyerSellerService
{
	@Autowired
	BuyerSellerRepository buyerSellerRepositoy;
	
	@Override
	public List<BuyerSellerMaster> getBuyerSeller() 
	{
		List<BuyerSellerMaster> buyerSellerList = new ArrayList<BuyerSellerMaster>();
		buyerSellerRepositoy.findAll().forEach(buyerSellerList1->buyerSellerList.add(buyerSellerList1));
		return buyerSellerList;
	}
	
	@Override
	public BuyerSellerMaster updateBuyerSeller(BuyerSellerMaster buyerSellerMaster, int buyerSellerId) 
	{
		Optional<BuyerSellerMaster> buyerSeller = buyerSellerRepositoy.findById(buyerSellerId);
		if(buyerSeller.isPresent())
		{
			BuyerSellerMaster newBuyerSeller = buyerSeller.get();
			newBuyerSeller.setBuyerSellerName(buyerSellerMaster.getBuyerSellerName());
			newBuyerSeller.setBuildingName(buyerSellerMaster.getBuildingName());
			newBuyerSeller.setArea(buyerSellerMaster.getArea());
			newBuyerSeller.setStreetName(buyerSellerMaster.getStreetName());
			newBuyerSeller.setPincode(buyerSellerMaster.getPincode());
			newBuyerSeller.setMobileNumber(buyerSellerMaster.getMobileNumber());
			newBuyerSeller.setEmail(buyerSellerMaster.getEmail());
			newBuyerSeller.setStateRefId(buyerSellerMaster.getStateRefId());
			newBuyerSeller.setDistrictRefId(buyerSellerMaster.getDistrictRefId());
			newBuyerSeller.setDesignationContactPerson(buyerSellerMaster.getDesignationContactPerson());
			newBuyerSeller.setWebSite(buyerSellerMaster.getWebSite());
			newBuyerSeller.setDistrictRefId(buyerSellerMaster.getDistrictRefId());
			newBuyerSeller.setContactPerson(buyerSellerMaster.getContactPerson());
			
			
			newBuyerSeller = buyerSellerRepositoy.save(newBuyerSeller);
			
			return newBuyerSeller;
		}
		else
		{
			buyerSellerMaster = buyerSellerRepositoy.save(buyerSellerMaster);
			return buyerSellerMaster;
		}
	}
	
	@Override
	public void deleteBuyerSeller(int buyerSellerId) 
	{
		buyerSellerRepositoy.deleteBuyerSeller(buyerSellerId);
	}
}
