package com.upfpo.app.dto;

import java.math.BigInteger;
import java.util.List;

public class BuyerSellerDashboardDTO 
{
	private Integer fpos;
	
	private Integer activeIndents;
	
	private Integer fulfilledIndents;
	
	private Integer cancelIndents;
	
	private BigInteger crops;
	
	private List<BuyerSellerIndentDTO> buyerSellerActive;
	
	private List<BuyerSellerIndentDTO> buyerSellerFulfilled;
	
	private List<BuyerSellerIndentDTO> buyerSellerRejected;
	

	public BuyerSellerDashboardDTO() {
		
	}
	public Integer getFpos() {
		return fpos;
	}

	public void setFpos(Integer fpos) {
		this.fpos = fpos;
	}

	public Integer getActiveIndents() {
		return activeIndents;
	}

	public void setActiveIndents(Integer activeIndents) {
		this.activeIndents = activeIndents;
	}

	public Integer getFulfilledIndents() {
		return fulfilledIndents;
	}

	public void setFulfilledIndents(Integer fulfilledIndents) {
		this.fulfilledIndents = fulfilledIndents;
	}

	public Integer getCancelIndents() {
		return cancelIndents;
	}

	public void setCancelIndents(Integer cancelIndents) {
		this.cancelIndents = cancelIndents;
	}

	public BigInteger getCrops() {
		return crops;
	}

	public void setCrops(BigInteger crops) {
		this.crops = crops;
	}
	public List<BuyerSellerIndentDTO> getBuyerSellerActive() {
		return buyerSellerActive;
	}
	public void setBuyerSellerActive(List<BuyerSellerIndentDTO> buyerSellerActive) {
		this.buyerSellerActive = buyerSellerActive;
	}
	public List<BuyerSellerIndentDTO> getBuyerSellerFulfilled() {
		return buyerSellerFulfilled;
	}
	public void setBuyerSellerFulfilled(List<BuyerSellerIndentDTO> buyerSellerFulfilled) {
		this.buyerSellerFulfilled = buyerSellerFulfilled;
	}
	public List<BuyerSellerIndentDTO> getBuyerSellerRejected() {
		return buyerSellerRejected;
	}
	public void setBuyerSellerRejected(List<BuyerSellerIndentDTO> buyerSellerRejected) {
		this.buyerSellerRejected = buyerSellerRejected;
	}

}
