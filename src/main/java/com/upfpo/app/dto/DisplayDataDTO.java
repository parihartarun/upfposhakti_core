package com.upfpo.app.dto;

import java.math.BigInteger;

public class DisplayDataDTO {
	
	private BigInteger totalFarmers;
	private BigInteger smallFarmers;
	private BigInteger bigFarmers;
	private BigInteger marginalFarmers;
	private Double totalLand;
	
	
	public DisplayDataDTO()
	{
		
	}
	
	public BigInteger getTotalFarmers() {
		return totalFarmers;
	}
	public void setTotalFarmers(BigInteger totalFarmers) {
		this.totalFarmers = totalFarmers;
	}
	public BigInteger getSmallFarmers() {
		return smallFarmers;
	}
	public void setSmallFarmers(BigInteger smallFarmers) {
		this.smallFarmers = smallFarmers;
	}
	public BigInteger getBigFarmers() {
		return bigFarmers;
	}
	public void setBigFarmers(BigInteger bigFarmers) {
		this.bigFarmers = bigFarmers;
	}
	public BigInteger getMarginalFarmers() {
		return marginalFarmers;
	}
	public void setMarginalFarmers(BigInteger marginalFarmers) {
		this.marginalFarmers = marginalFarmers;
	}
	public Double getTotalLand() {
		return totalLand;
	}
	public void setTotalLand(Double totalLand) {
		this.totalLand = totalLand;
	}
}
