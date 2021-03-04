package com.upfpo.app.entity;

import java.math.BigInteger;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enquiry_input_supplier_fertilizer")
public class EnquiryInputSupplierFertilizer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enqid")
	private BigInteger enqid;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "master_id")
	private Integer masterId;
	
	@Column(name = "fertilizer_type")
	private Integer fertilizerType;
	
	@Column(name = "fertilizer_name")
	private Integer fertilizeName;
	
	@Column(name = "fertilizer_grade")
	private String fertilizerGrade;
	
	@Column(name = "indent_qty")
	private Double indentQty;
	
	@Column(name = "fulfilled_qty")
	private Double fulfilledQty;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "create_date_time")
	private Calendar createDateTime;
	
	@Column(name = "fulfillment_date")
	private Calendar fulfillmentDate;
	
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

	public Integer getFertilizerType() {
		return fertilizerType;
	}

	public void setFertilizerType(Integer fertilizerType) {
		this.fertilizerType = fertilizerType;
	}

	public Integer getFertilizeName() {
		return fertilizeName;
	}

	public void setFertilizeName(Integer fertilizeName) {
		this.fertilizeName = fertilizeName;
	}

	public String getFertilizerGrade() {
		return fertilizerGrade;
	}

	public void setFertilizerGrade(String fertilizerGrade) {
		this.fertilizerGrade = fertilizerGrade;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public Calendar getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Calendar createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Calendar getFulfillmentDate() {
		return fulfillmentDate;
	}

	public void setFulfillmentDate(Calendar fulfillmentDate) {
		this.fulfillmentDate = fulfillmentDate;
	}

	public String getDeliveryaddress() {
		return deliveryaddress;
	}

	public void setDeliveryaddress(String deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}
	
}
