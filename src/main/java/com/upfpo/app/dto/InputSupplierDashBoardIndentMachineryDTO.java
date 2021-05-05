package com.upfpo.app.dto;

import java.math.BigInteger;
import java.util.Calendar;

public class InputSupplierDashBoardIndentMachineryDTO 
{
	private String createdBy;
	
	private BigInteger contact_details;
	
	private String role;
	
	private String status;
	
	private String equpment_name;
	
	private Integer no_of_days;
	
	private Double indentQty;
	
	private Calendar create_date_time;
	
	private BigInteger enqId;
	
	private String enquieryNumber;

	public InputSupplierDashBoardIndentMachineryDTO(String createdBy, BigInteger contact_details, String role,
			String status, String equpment_name, Integer no_of_days, Double indentQty, Calendar create_date_time,
			BigInteger enqId, String enquieryNumber) {
		super();
		this.createdBy = createdBy;
		this.contact_details = contact_details;
		this.role = role;
		this.status = status;
		this.equpment_name = equpment_name;
		this.no_of_days = no_of_days;
		this.indentQty = indentQty;
		this.create_date_time = create_date_time;
		this.enqId = enqId;
		this.enquieryNumber = enquieryNumber;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public BigInteger getContact_details() {
		return contact_details;
	}

	public void setContact_details(BigInteger contact_details) {
		this.contact_details = contact_details;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEqupment_name() {
		return equpment_name;
	}

	public void setEqupment_name(String equpment_name) {
		this.equpment_name = equpment_name;
	}

	public Integer getNo_of_days() {
		return no_of_days;
	}

	public void setNo_of_days(Integer no_of_days) {
		this.no_of_days = no_of_days;
	}

	public Double getIndentQty() {
		return indentQty;
	}

	public void setIndentQty(Double indentQty) {
		this.indentQty = indentQty;
	}

	public Calendar getCreate_date_time() {
		return create_date_time;
	}

	public void setCreate_date_time(Calendar create_date_time) {
		this.create_date_time = create_date_time;
	}

	public BigInteger getEnqId() {
		return enqId;
	}

	public void setEnqId(BigInteger enqId) {
		this.enqId = enqId;
	}

	public String getEnquieryNumber() {
		return enquieryNumber;
	}

	public void setEnquieryNumber(String enquieryNumber) {
		this.enquieryNumber = enquieryNumber;
	}
}
