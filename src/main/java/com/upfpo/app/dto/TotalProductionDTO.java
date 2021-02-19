package com.upfpo.app.dto;

public class TotalProductionDTO 
{
	private Double totalActualProdction;
	
	private Double totalMarketableQty;
	

	public TotalProductionDTO(Double totalActualProdction, Double totalMarketableQty) {
		super();
		this.totalActualProdction = totalActualProdction;
		this.totalMarketableQty = totalMarketableQty;
	}

	public Double getTotalActualProdction() {
		return totalActualProdction;
	}

	public void setTotalActualProdction(Double totalActualProdction) {
		this.totalActualProdction = totalActualProdction;
	}

	public Double getTotalMarketableQty() {
		return totalMarketableQty;
	}

	public void setTotalMarketableQty(Double totalMarketableQty) {
		this.totalMarketableQty = totalMarketableQty;
	}
	
	
	
}
