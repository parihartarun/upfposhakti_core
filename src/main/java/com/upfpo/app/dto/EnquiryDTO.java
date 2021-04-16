package com.upfpo.app.dto;

import java.math.BigInteger;
import java.util.Date;

public class EnquiryDTO 
{
	private String enquieryNumber;
	
	private Integer cropId;
	
	private String cropName;
	
	private Integer verietyId;
	
	private String verietyName;
	
	private String status;
	
	private String deliveryAddress;
	
	private BigInteger quantity;
	
	private Date createDateTime;
	
	private BigInteger enid;
	
	public EnquiryDTO(String enquieryNumber, Integer cropId, String cropName, Integer verietyId, String verietyName,
			String status, String deliveryAddress, BigInteger quantity, Date createDateTime, BigInteger enid) {
		super();
		this.enquieryNumber = enquieryNumber;
		this.cropId = cropId;
		this.cropName = cropName;
		this.verietyId = verietyId;
		this.verietyName = verietyName;
		this.status = status;
		this.deliveryAddress = deliveryAddress;
		this.quantity = quantity;
		this.createDateTime = createDateTime;
		this.enid = enid;
	}

	public String getEnquieryNumber() {
		return enquieryNumber;
	}

	public void setEnquieryNumber(String enquieryNumber) {
		this.enquieryNumber = enquieryNumber;
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

	public Integer getVerietyId() {
		return verietyId;
	}

	public void setVerietyId(Integer verietyId) {
		this.verietyId = verietyId;
	}

	public String getVerietyName() {
		return verietyName;
	}

	public void setVerietyName(String verietyName) {
		this.verietyName = verietyName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public BigInteger getQuantity() {
		return quantity;
	}

	public void setQuantity(BigInteger quantity) {
		this.quantity = quantity;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public BigInteger getEnid() {
		return enid;
	}

	public void setEnid(BigInteger enid) {
		this.enid = enid;
	}

}
