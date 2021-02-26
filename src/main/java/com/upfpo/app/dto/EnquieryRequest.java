package com.upfpo.app.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class EnquieryRequest {

	@NotNull(message = "Fpo id must not be null")
	private Integer fpoId;
	@NotNull(message = "Crop Id Must Not Be null")
	private Integer cropId;
	@NotNull(message = "Fpo Delivery Address Must Not Be Null")
	private String  fpoDeliveryAddress;
    @NotNull(message = "User Id Must Not be Null")
	private Integer userId;
    @NotNull(message = "Fullfillment date must not be null")
    private String fulfillmentDate; 
    @NotNull(message = "Quantity must not be null")
    private Double quantity;
    private String cropVeriety;
    
	public String getCropVeriety() {
		return cropVeriety;
	}
	public void setCropVeriety(String cropVeriety) {
		this.cropVeriety = cropVeriety;
	}
	public Integer getFpoId() {
		return fpoId;
	}
	public void setFpoId(Integer fpoId) {
		this.fpoId = fpoId;
	}
	public Integer getCropId() {
		return cropId;
	}
	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}
	public String getFpoDeliveryAddress() {
		return fpoDeliveryAddress;
	}
	public void setFpoDeliveryAddress(String fpoDeliveryAddress) {
		this.fpoDeliveryAddress = fpoDeliveryAddress;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFulfillmentDate() {
		return fulfillmentDate;
	}
	public void setFulfillmentDate(String fulfillmentDate) {
		this.fulfillmentDate = fulfillmentDate;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
}
