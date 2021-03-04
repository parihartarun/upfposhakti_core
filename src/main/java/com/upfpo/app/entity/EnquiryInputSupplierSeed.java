package com.upfpo.app.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enquiry_input_supplier_seed")
public class EnquiryInputSupplierSeed 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enqid")
	private BigInteger enqid;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "master_id")
	private Integer masterId;
	
	@Column(name = "crop_id")
	private Integer cropId;
	
	@Column(name = "veriety_id")
	private Integer verietyId;
	
	@Column(name = "indent_qty")
	private Double indentQty;
	
	@Column(name = "fulfilled_qty")
	private Double fulfilledQty;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "fulfillment_date")
	private  String  fulfillmentDate;
	
	@Column(name = "deliveryaddress")
	private String deliveryaddress;

	public BigInteger getEnqid() {
		return enqid;
	}

	public void setEnqid(BigInteger enqid) {
		this.enqid = enqid;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public Integer getCropId() {
		return cropId;
	}

	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}

	public Integer getVerietyId() {
		return verietyId;
	}

	public void setVerietyId(Integer verietyId) {
		this.verietyId = verietyId;
	}

	public Double getIndentQty() {
		return indentQty;
	}

	public void setIndentQty(Double indentQty) {
		this.indentQty = indentQty;
	}

	public Double getFulfilledQty() {
		return fulfilledQty;
	}

	public void setFulfilledQty(Double fulfilledQty) {
		this.fulfilledQty = fulfilledQty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getFulfillmentDate() {
		return fulfillmentDate;
	}

	public void setFulfillmentDate(String fulfillmentDate) {
		this.fulfillmentDate = fulfillmentDate;
	}

	public String getDeliveryaddress() {
		return deliveryaddress;
	}

	public void setDeliveryaddress(String deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}
	
}
