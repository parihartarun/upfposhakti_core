package com.upfpo.app.dto;

import java.math.BigInteger;

public class EnquirySeedDTO 
{
	private BigInteger enqId;
	
	private Integer createdBy;
	
	private String cropName;
	
	private String cropVeriety;
	
	private String status;
	
	private Double indentQty;
	
	private String deliveryaddress;
	

	public EnquirySeedDTO(BigInteger enqId, Integer createdBy, String cropName, String cropVeriety, String status,
			Double indentQty, String deliveryaddress) {
		super();
		this.enqId = enqId;
		this.createdBy = createdBy;
		this.cropName = cropName;
		this.cropVeriety = cropVeriety;
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

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getCropVeriety() {
		return cropVeriety;
	}

	public void setCropVeriety(String cropVeriety) {
		this.cropVeriety = cropVeriety;
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
