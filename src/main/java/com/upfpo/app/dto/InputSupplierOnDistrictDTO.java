package com.upfpo.app.dto;

import java.math.BigInteger;

public class InputSupplierOnDistrictDTO 
{
	private Integer districtId;
	
	private String districtName;
	
	private Integer input_supplier_id;
	
	private String input_supplier_name;
	
	private String email;
	
	private BigInteger mobile_number;
	
	public InputSupplierOnDistrictDTO(Integer districtId, String districtName, Integer input_supplier_id,
			String input_supplier_name, String email, BigInteger mobile_number) {
		super();
		this.districtId = districtId;
		this.districtName = districtName;
		this.input_supplier_id = input_supplier_id;
		this.input_supplier_name = input_supplier_name;
		this.email = email;
		this.mobile_number = mobile_number;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public Integer getInput_supplier_id() {
		return input_supplier_id;
	}

	public void setInput_supplier_id(Integer input_supplier_id) {
		this.input_supplier_id = input_supplier_id;
	}

	public String getInput_supplier_name() {
		return input_supplier_name;
	}

	public void setInput_supplier_name(String input_supplier_name) {
		this.input_supplier_name = input_supplier_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigInteger getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(BigInteger mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	
}
