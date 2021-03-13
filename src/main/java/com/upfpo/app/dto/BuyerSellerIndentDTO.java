package com.upfpo.app.dto;

import java.math.BigInteger;

public class BuyerSellerIndentDTO 
{
	private Integer cropId;
	
	private String cropName;
	
	private BigInteger indentQty;
	
	public BuyerSellerIndentDTO(Integer cropId, String cropName, BigInteger indentQty) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
		this.indentQty = indentQty;
	}

	public BigInteger getIndentQty() {
		return indentQty;
	}

	public void setIndentQty(BigInteger indentQty) {
		this.indentQty = indentQty;
	}

	public Integer getCropId() {
		return cropId;
	}

	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

}
