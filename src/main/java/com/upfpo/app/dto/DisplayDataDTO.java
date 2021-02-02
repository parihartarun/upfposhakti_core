package com.upfpo.app.dto;

import java.math.BigInteger;

public class DisplayDataDTO {

	private BigInteger totalfarmers;
	private BigInteger smalltotal;
	private BigInteger bigfarmers;
	private BigInteger marginalfarmers;
	private Double totalland;


	public DisplayDataDTO(BigInteger totalfarmers, BigInteger smalltotal, BigInteger bigfarmers,
			BigInteger marginalfarmers, Double totalland) {
		super();
		this.totalfarmers = totalfarmers;
		this.smalltotal = smalltotal;
		this.bigfarmers = bigfarmers;
		this.marginalfarmers = marginalfarmers;
		this.totalland = totalland;
	}


	public BigInteger getTotalfarmers() {
		return totalfarmers;
	}

	public void setTotalfarmers(BigInteger totalfarmers) {
		this.totalfarmers = totalfarmers;
	}

	public BigInteger getSmalltotal() {
		return smalltotal;
	}

	public void setSmalltotal(BigInteger smalltotal) {
		this.smalltotal = smalltotal;
	}

	public BigInteger getBigfarmers() {
		return bigfarmers;
	}

	public void setBigfarmers(BigInteger bigfarmers) {
		this.bigfarmers = bigfarmers;
	}

	public BigInteger getMarginalfarmers() {
		return marginalfarmers;
	}

	public void setMarginalfarmers(BigInteger marginalfarmers) {
		this.marginalfarmers = marginalfarmers;
	}

	public Double getTotalland() {
		return totalland;
	}

	public void setTotalland(Double totalland) {
		this.totalland = totalland;
	}

}
