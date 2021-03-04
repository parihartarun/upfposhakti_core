package com.upfpo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.dto.BuyerSellerDashboardDTO;
import com.upfpo.app.service.BuyerSellerDashboardService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/buyerSellerDashboard")
@Api(produces = "application/json", value = "Retrive Buyer Seller Dashboard", tags="Buyer Seller Dashboard",description="Buyer Seller dashboard data")	
public class BuyerSellerDashboardController 
{
	@Autowired
	BuyerSellerDashboardService buyerSellerDashboardService;
	
	@GetMapping("/getBuyerSellerDashboardData/{buyerId}")
	public BuyerSellerDashboardDTO getBuyerSellerDashboardData(@PathVariable("buyerId") Integer buyerId)
	{
		return buyerSellerDashboardService.getBuyerSellerDashboardData(buyerId);
	}
}
