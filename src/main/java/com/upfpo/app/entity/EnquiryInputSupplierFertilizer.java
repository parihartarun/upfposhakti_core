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

import com.upfpo.app.dto.EnquiryFertilizerDTO;
import com.upfpo.app.dto.EnquirySeedDTO;
import com.upfpo.app.dto.InputSupplierDashBoardIndentFertilizerDTO;
import com.upfpo.app.dto.InputSupplierDashBoardIndentSeedDTO;


@SqlResultSetMapping(name="InputSupplierDashBoardIndentFertilizerDTO",
classes = {
        @ConstructorResult(
                targetClass = InputSupplierDashBoardIndentFertilizerDTO.class,
                columns = {
                		@ColumnResult(name = "createdBy", type = String.class),
                		@ColumnResult(name = "contact_details", type = BigInteger.class),
                		@ColumnResult(name = "role", type = String.class),
                		@ColumnResult(name = "status", type = String.class),
                		@ColumnResult(name = "fertilizer_name", type = String.class),
                		@ColumnResult(name = "fertilizer_grade", type = String.class),
                		@ColumnResult(name = "indentQty", type = Double.class),
                		@ColumnResult(name = "create_date_time", type = Calendar.class),
                		@ColumnResult(name = "enqId", type = BigInteger.class)
                })
})
@SqlResultSetMapping(name="EnquiryFertilizerDTO",
classes = {
        @ConstructorResult(
                targetClass = EnquiryFertilizerDTO.class,
                columns = {
                		@ColumnResult(name = "enqId", type = BigInteger.class),
                		@ColumnResult(name = "createdBy", type = Integer.class),
                		@ColumnResult(name = "fertilizerType", type = String.class),
                		@ColumnResult(name = "fertilizerName", type = String.class),
                		@ColumnResult(name = "status", type = String.class),
                		@ColumnResult(name = "indentQty", type = Double.class),
                		@ColumnResult(name = "deliveryaddress", type = String.class)
                })
})
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
	
	@ManyToOne
	@JoinColumn(name = "fertilizer_type")
	private FertilizerType fertilizerType;
	
	@ManyToOne
	@JoinColumn(name = "fertilizer_name")
	private FertilizerName fertilizeName;
	
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
	
	@Column(name = "requested_date_time")
	private Calendar requestedDateTime;
	
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

	public FertilizerType getFertilizerType() {
		return fertilizerType;
	}

	public void setFertilizerType(FertilizerType fertilizerType) {
		this.fertilizerType = fertilizerType;
	}

	public FertilizerName getFertilizeName() {
		return fertilizeName;
	}

	public void setFertilizeName(FertilizerName fertilizeName) {
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
