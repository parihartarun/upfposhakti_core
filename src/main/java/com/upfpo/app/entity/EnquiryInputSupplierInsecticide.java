package com.upfpo.app.entity;

import java.math.BigInteger;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.upfpo.app.dto.InputSupplierDashBoardIndentInsecticideDTO;

@SqlResultSetMapping(name="InputSupplierDashBoardIndentInsecticideDTO",
classes = {
        @ConstructorResult(
                targetClass = InputSupplierDashBoardIndentInsecticideDTO.class,
                columns = {
                		@ColumnResult(name = "createdBy", type = String.class),
                		@ColumnResult(name = "contact_details", type = BigInteger.class),
                		@ColumnResult(name = "role", type = String.class),
                		@ColumnResult(name = "status", type = String.class),
                		@ColumnResult(name = "insecticide_type", type = String.class),
                		@ColumnResult(name = "indentQty", type = Double.class),
                		@ColumnResult(name = "create_date_time", type = Calendar.class)
                })
})
@Entity
@Table(name = "enquiry_input_supplier_insecticide")
public class EnquiryInputSupplierInsecticide 
{
	@Id
	@Column(name = "enqid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger enqid;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "master_id")
	private Integer masterId;
	
	@ManyToOne
	@JoinColumn(name = "insecticide_type_id")
	private InsecticideType insecticideTypeId;
	
	@Column(name = "manufacturer_name")
	private String manufacturerName;
	
	@Column(name = "indent_qty")
	private Double indentQty;
	
	@Column(name = "fulfilled_qty")
	private Double fulfilledQty;
	
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

	public InsecticideType getInsecticideTypeId() {
		return insecticideTypeId;
	}

	public void setInsecticideTypeId(InsecticideType insecticideTypeId) {
		this.insecticideTypeId = insecticideTypeId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
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
