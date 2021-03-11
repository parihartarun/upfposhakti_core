package com.upfpo.app.dto;

import java.math.BigInteger;

public class InputSupplierDashboardDTO 
{
	private Integer insecticideTypeId;
	
	private String insecticideType;
	
	private BigInteger quantity;
	
	public InputSupplierDashboardDTO(Integer insecticideTypeId, String insecticideType, BigInteger quantity) {
		super();
		this.insecticideTypeId = insecticideTypeId;
		this.insecticideType = insecticideType;
		this.quantity = quantity;
	}
	
	public Integer getInsecticideTypeId() {
		return insecticideTypeId;
	}

	public void setInsecticideTypeId(Integer insecticideTypeId) {
		this.insecticideTypeId = insecticideTypeId;
	}

	public String getInsecticideType() {
		return insecticideType;
	}

	public void setInsecticideType(String insecticideType) {
		this.insecticideType = insecticideType;
	}

	public BigInteger getQuantity() {
		return quantity;
	}

	public void setQuantity(BigInteger quantity) {
		this.quantity = quantity;
	}
}
