package com.upfpo.app.dto;

import java.math.BigInteger;

public class EnquiryFertilizerDTO 
{
	private BigInteger enqId;
	
	private Integer createdBy;
	
	private String fertilizerType;
	
	private String fertilizerName;
	
	private String status;
	
	private Double indentQty;
	
	private String deliveryaddress;
	
	public EnquiryFertilizerDTO(BigInteger enqId, Integer createdBy, String fertilizerType, String fertilizerName,
			String status, Double indentQty, String deliveryaddress) {
		super();
		this.enqId = enqId;
		this.createdBy = createdBy;
		this.fertilizerType = fertilizerType;
		this.fertilizerName = fertilizerName;
		this.status = status;
		this.indentQty = indentQty;
		this.deliveryaddress = deliveryaddress;
	}

	public BigInteger getEnqId() {
		return enqId;
	}

	public void setEnqId(BigInteger enqId) {
		this.enqId = enqId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getFertilizerType() {
		return fertilizerType;
	}

	public void setFertilizerType(String fertilizerType) {
		this.fertilizerType = fertilizerType;
	}

	public String getFertilizerName() {
		return fertilizerName;
	}

	public void setFertilizerName(String fertilizerName) {
		this.fertilizerName = fertilizerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getIndentQty() {
		return indentQty;
	}

	public void setIndentQty(Double indentQty) {
		this.indentQty = indentQty;
	}

	public String getDeliveryaddress() {
		return deliveryaddress;
	}

	public void setDeliveryaddress(String deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}
	
}
