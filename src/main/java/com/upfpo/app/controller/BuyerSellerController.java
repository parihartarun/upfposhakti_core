package com.upfpo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.entity.BuyerSellerMaster;
import com.upfpo.app.entity.InputSupplierMaster;
import com.upfpo.app.service.BuyerSellerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="api/v1/BuyerSeller")
public class BuyerSellerController 
{
	@Autowired
	BuyerSellerService buyerSellerService;
	
	@GetMapping(value="/getBuyerSeller")
	@ApiOperation(value="Get All Buyer Seller details",code=200,produces = "application/json",notes="Api for view all Buyer Seller",response=BuyerSellerMaster.class,responseContainer="List")
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Items Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	private ResponseEntity<List<BuyerSellerMaster>> getBuyerSeller()
	{
		List<BuyerSellerMaster> list = buyerSellerService.getBuyerSeller();
		return new ResponseEntity<List<BuyerSellerMaster>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping(value="/editBuyerSeller/{buyerSellerId}")
	@ApiOperation(value="Update Buyer Seller", code=200, produces = "application/json", notes="Api for update Input Supplier",response=InputSupplierMaster.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response = ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	private ResponseEntity<BuyerSellerMaster> editBuyerSeller(@RequestBody BuyerSellerMaster buyerSellerMaster,@PathVariable("buyerSellerId") int buyerSellerId)
	{
		BuyerSellerMaster buyerSellerentity = buyerSellerService.updateBuyerSeller(buyerSellerMaster,buyerSellerId);
		return new ResponseEntity<BuyerSellerMaster>(buyerSellerentity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping(value="/deleteBuyerSeller/{buyerSellerId}")
	@ApiOperation(value="Delete Buyer Seller by id",code=204,produces = "text/plain",notes="Api for delete Buyer Seller by id",response=HttpStatus.class)
	@ApiResponses(value= {
	@ApiResponse(code=404,response=ExceptionResponse.class, message = "Item Not Found"),
	@ApiResponse(code=401,response=ExceptionResponse.class, message = "Unauthorized"),
	@ApiResponse(code=400,response=ExceptionResponse.class, message = "Validation Failed"),
	@ApiResponse(code=403,response=ExceptionResponse.class, message = "Forbidden")
	})
	private HttpStatus deleteBuyerSeller(@PathVariable("buyerSellerId") int buyerSellerId)
	{
		buyerSellerService.deleteBuyerSeller(buyerSellerId);
		return HttpStatus.FORBIDDEN;
	}
}
