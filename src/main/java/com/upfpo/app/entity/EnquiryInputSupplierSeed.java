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

import com.upfpo.app.dto.EnquirySeedDTO;
import com.upfpo.app.dto.InputSupplierDashBoardIndentSeedDTO;

@SqlResultSetMapping(name="InputSupplierDashBoardIndentSeedDTO",
classes = {
        @ConstructorResult(
                targetClass = InputSupplierDashBoardIndentSeedDTO.class,
                columns = {
                		@ColumnResult(name = "createdBy", type = String.class),
                		@ColumnResult(name = "contact_details", type = BigInteger.class),
                		@ColumnResult(name = "role", type = String.class),
                		@ColumnResult(name = "status", type = String.class),
                		@ColumnResult(name = "crop_name", type = String.class),
                		@ColumnResult(name = "varietyName", type = String.class),
                		@ColumnResult(name = "indentQty", type = Double.class),
                		@ColumnResult(name = "enqId", type = BigInteger.class),
                		@ColumnResult(name = "enquieryNumber", type = String.class)
                })
})
@SqlResultSetMapping(name="EnquirySeedDTO",
classes = {
        @ConstructorResult(
                targetClass = EnquirySeedDTO.class,
                columns = {
                		@ColumnResult(name = "enqId", type = BigInteger.class),
                		@ColumnResult(name = "createdBy", type = Integer.class),
                		@ColumnResult(name = "cropName", type = String.class),
                		@ColumnResult(name = "cropVeriety", type = String.class),
                		@ColumnResult(name = "status", type = String.class),
                		@ColumnResult(name = "indentQty", type = Double.class),
                		@ColumnResult(name = "deliveryaddress", type = String.class)
                })
})

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
		
	@ManyToOne
	@JoinColumn(name = "crop_id")
	private CropMaster cropId;
	
	@ManyToOne
	@JoinColumn(name = "veriety_id")
	private CropVerietyMaster verietyId;
	
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
	
	@Column(name = "requested_date_time")
	private Calendar requestedDateTime;
	
	@Column(name = "fulfillment_date")
	private  String  fulfillmentDate;
	
	@Column(name = "deliveryaddress")
	private String deliveryaddress;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "role_ref_id")
	private String roleRefId;
	
	@Column(name = "master_role_id")
	private String masterRoleId;
	
	@Column(name = "master_user_id")
	private Integer masterUserId;
	
	@Column(name = "enquierynumber")
	private String enquieryNumber;

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

	public CropMaster getCropId() {
		return cropId;
	}

	public void setCropId(CropMaster cropId) {
		this.cropId = cropId;
	}

	public CropVerietyMaster getVerietyId() {
		return verietyId;
	}

	public void setVerietyId(CropVerietyMaster verietyId) {
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

	public Calendar getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Calendar createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Calendar getRequestedDateTime() {
		return requestedDateTime;
	}

	public void setRequestedDateTime(Calendar requestedDateTime) {
		this.requestedDateTime = requestedDateTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRoleRefId() {
		return roleRefId;
	}

	public void setRoleRefId(String roleRefId) {
		this.roleRefId = roleRefId;
	}

	public String getMasterRoleId() {
		return masterRoleId;
	}

	public void setMasterRoleId(String masterRoleId) {
		this.masterRoleId = masterRoleId;
	}

	public Integer getMasterUserId() {
		return masterUserId;
	}

	public void setMasterUserId(Integer masterUserId) {
		this.masterUserId = masterUserId;
	}

	public String getEnquieryNumber() {
		return enquieryNumber;
	}

	public void setEnquieryNumber(String enquieryNumber) {
		this.enquieryNumber = enquieryNumber;
	}
}
