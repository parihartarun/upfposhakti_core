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

import com.upfpo.app.dto.InputSupplierDashBoardIndentMachineryDTO;


@SqlResultSetMapping(name="InputSupplierDashBoardIndentMachineryDTO",
classes = {
        @ConstructorResult(
                targetClass = InputSupplierDashBoardIndentMachineryDTO.class,
                columns = {
                		@ColumnResult(name = "createdBy", type = String.class),
                		@ColumnResult(name = "contact_details", type = BigInteger.class),
                		@ColumnResult(name = "role", type = String.class),
                		@ColumnResult(name = "status", type = String.class),
                		@ColumnResult(name = "equpment_name", type = String.class),
                		@ColumnResult(name = "no_of_days", type = Integer.class),
                		@ColumnResult(name = "indentQty", type = Double.class),
                		@ColumnResult(name = "create_date_time", type = Calendar.class)
                })
})
@Entity
@Table(name = "enquiry_input_supplier_machinery")
public class EnquiryInputSupplierMachinery 
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
	@JoinColumn(name = "machinery_type_id")
	private  EquipmentType machineryTypId;
	
	@ManyToOne
	@JoinColumn(name = "machinery_name_id")
	private EqupmentMaster machineryNameId;
	
	@Column(name = "machinery_name")
	private String machineryName;
	
	@Column(name = "no_of_days")
	private Integer noOfDays;
	
	@Column(name = "indent_qty")
	private Double indentQty;
	
	@Column(name = "fulfilled_qty")
	private Double fulfilledQty;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "create_date_time")
	private Calendar  createDateTime;
	
	@Column(name = "requested_date_time")
	private Calendar  requestedDateTime;
	
	@Column(name = "fulfillment_date")
	private Calendar fulfillmentDate;
	
	@Column(name = "deliveryaddress")
	private String deliveryaddress;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "role_ref_id")
	private String roleRefId;

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

	public EquipmentType getMachineryTypId() {
		return machineryTypId;
	}

	public void setMachineryTypId(EquipmentType machineryTypId) {
		this.machineryTypId = machineryTypId;
	}

	public EqupmentMaster getMachineryNameId() {
		return machineryNameId;
	}

	public void setMachineryNameId(EqupmentMaster machineryNameId) {
		this.machineryNameId = machineryNameId;
	}

	public String getMachineryName() {
		return machineryName;
	}

	public void setMachineryName(String machineryName) {
		this.machineryName = machineryName;
	}

	public Integer getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
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
	
}
