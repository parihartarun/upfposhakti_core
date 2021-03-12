package com.upfpo.app.dto;

import java.math.BigInteger;

public class InputSupplierDashBoardIndentSeedDTO 
{
	private String createdBy;
	
	private BigInteger contact_details;
	
	private String role;
	
	private String status;
	
	private String crop_name;
	
	private String varietyName;
	
	private Double indentQty;
	
	public InputSupplierDashBoardIndentSeedDTO(String createdBy, BigInteger contact_details, String role, String status,
			String crop_name, String varietyName, Double indentQty) {
		super();
		this.createdBy = createdBy;
		this.contact_details = contact_details;
		this.role = role;
		this.status = status;
		this.crop_name = crop_name;
		this.varietyName = varietyName;
		this.indentQty = indentQty;
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

	public String getCrop_name() {
		return crop_name;
	}

	public void setCrop_name(String crop_name) {
		this.crop_name = crop_name;
	}

	public String getVarietyName() {
		return varietyName;
	}

	public void setVarietyName(String varietyName) {
		this.varietyName = varietyName;
	}

	public Double getIndentQty() {
		return indentQty;
	}

	public void setIndentQty(Double indentQty) {
		this.indentQty = indentQty;
	}
}
