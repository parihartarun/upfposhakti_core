package com.upfpo.app.dto;

public class TotalProductionDTO 
{
	private double totalActualProdction;
	
	private double totalMarketableQty;
	

	public TotalProductionDTO(double totalActualProdction, double totalMarketableQty) {
		super();
		this.totalActualProdction = totalActualProdction;
		this.totalMarketableQty = totalMarketableQty;
	}

	public double getTotalActualProdction() {
		return totalActualProdction;
	}

	public void setTotalActualProdction(double totalActualProdction) {
		this.totalActualProdction = totalActualProdction;
	}

	public double getTotalMarketableQty() {
		return totalMarketableQty;
	}

	public void setTotalMarketableQty(double totalMarketableQty) {
		this.totalMarketableQty = totalMarketableQty;
	}
	
	
	
}
