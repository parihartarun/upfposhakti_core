package com.upfpo.app.dto;

import java.math.BigInteger;
import java.util.Calendar;

public class InputSupplierDashBoardIndentInsecticideDTO 
{
	private String createdBy;
	
	private BigInteger contact_details;
	
	private String role;
	
	private String status;
	
	private String insecticide_type;
	
	private Double indentQty;
	
	private Calendar create_date_time;

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

	public String getInsecticide_type() {
		return insecticide_type;
	}

	public void setInsecticide_type(String insecticide_type) {
		this.insecticide_type = insecticide_type;
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

	public InputSupplierDashBoardIndentInsecticideDTO(String createdBy, BigInteger contact_details, String role,
			String status, String insecticide_type, Double indentQty, Calendar create_date_time) {
		super();
		this.createdBy = createdBy;
		this.contact_details = contact_details;
		this.role = role;
		this.status = status;
		this.insecticide_type = insecticide_type;
		this.indentQty = indentQty;
		this.create_date_time = create_date_time;
	}
	
	
}
