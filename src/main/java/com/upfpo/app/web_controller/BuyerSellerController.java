package com.upfpo.app.web_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.entity.BuyerSellerMaster;
import com.upfpo.app.entity.ChcFmbMaster;
import com.upfpo.app.service.BuyerSellerService;

@RestController
@RequestMapping(value="api/v1/BuyerSeller")
public class BuyerSellerController 
{
	@Autowired
	BuyerSellerService buyerSellerService;
	
	@GetMapping(value="/getBuyerSeller")
	private ResponseEntity<List<BuyerSellerMaster>> getBuyerSeller()
	{
		List<BuyerSellerMaster> list = buyerSellerService.getBuyerSeller();
		return new ResponseEntity<List<BuyerSellerMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping(value="/editBuyerSeller/{buyerSellerId}")
	private ResponseEntity<BuyerSellerMaster> editBuyerSeller(@RequestBody BuyerSellerMaster buyerSellerMaster,@PathVariable("buyerSellerId") int buyerSellerId)
	{
		BuyerSellerMaster buyerSellerentity = buyerSellerService.updateBuyerSeller(buyerSellerMaster,buyerSellerId);
		return new ResponseEntity<BuyerSellerMaster>(buyerSellerentity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping(value="/deleteBuyerSeller/{buyerSellerId}")
	private HttpStatus deleteBuyerSeller(@PathVariable("buyerSellerId") int buyerSellerId)
	{
		buyerSellerService.deleteBuyerSeller(buyerSellerId);
		return HttpStatus.FORBIDDEN;
	}
}
