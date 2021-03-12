package com.upfpo.app.dto;

import java.math.BigInteger;
import java.util.Calendar;

public class InputSupplierDashBoardIndentFertilizerDTO 
{
	private String createdBy;
	
	private BigInteger contact_details;
	
	private String role;
	
	private String status;
	
	private String fertilizer_name;
	
	private String fertilizer_grade;
	
	private Double indentQty;
	
	private Calendar create_date_time;
	
	public InputSupplierDashBoardIndentFertilizerDTO(String createdBy, BigInteger contact_details, String role,
			String status, String fertilizer_name, String fertilizer_grade, Double indentQty,
			Calendar create_date_time) {
		super();
		this.createdBy = createdBy;
		this.contact_details = contact_details;
		this.role = role;
		this.status = status;
		this.fertilizer_name = fertilizer_name;
		this.fertilizer_grade = fertilizer_grade;
		this.indentQty = indentQty;
		this.create_date_time = create_date_time;
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

	public String getFertilizer_name() {
		return fertilizer_name;
	}

	public void setFertilizer_name(String fertilizer_name) {
		this.fertilizer_name = fertilizer_name;
	}

	public String getFertilizer_grade() {
		return fertilizer_grade;
	}

	public void setFertilizer_grade(String fertilizer_grade) {
		this.fertilizer_grade = fertilizer_grade;
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
	
}
