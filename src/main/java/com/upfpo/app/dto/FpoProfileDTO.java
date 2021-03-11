package com.upfpo.app.dto;

import java.math.BigInteger;

public class FpoProfileDTO 
{
	private Integer fpo_id;
	
	private String fpo_name;
	
	private String agency_associated;
	
	private Integer district_id;
	
	private String district_name;
	
	private Integer block_id;
	
	private String block_name;
	
	private String fpo_address;
	
	private BigInteger fpo_landline;
	
	private String fpo_email;
	
	private String fpo_lot_no;
	
	private Integer bank_id;
	
	private String bank_name;
	
	private BigInteger fpo_account_no;
	
	private String fpo_ifsc;
	
	private Integer fmbNo;
	

	public FpoProfileDTO(Integer fpo_id, String fpo_name, String agency_associated, Integer district_id,
			String district_name, Integer block_id, String block_name, String fpo_address, BigInteger fpo_landline,
			String fpo_email, String fpo_lot_no, Integer bank_id, String bank_name, BigInteger fpo_account_no,
			String fpo_ifsc, Integer fmbNo) {
		super();
		this.fpo_id = fpo_id;
		this.fpo_name = fpo_name;
		this.agency_associated = agency_associated;
		this.district_id = district_id;
		this.district_name = district_name;
		this.block_id = block_id;
		this.block_name = block_name;
		this.fpo_address = fpo_address;
		this.fpo_landline = fpo_landline;
		this.fpo_email = fpo_email;
		this.fpo_lot_no = fpo_lot_no;
		this.bank_id = bank_id;
		this.bank_name = bank_name;
		this.fpo_account_no = fpo_account_no;
		this.fpo_ifsc = fpo_ifsc;
		this.fmbNo = fmbNo;
	}

	public Integer getFpo_id() {
		return fpo_id;
	}

	public void setFpo_id(Integer fpo_id) {
		this.fpo_id = fpo_id;
	}

	public String getFpo_name() {
		return fpo_name;
	}

	public void setFpo_name(String fpo_name) {
		this.fpo_name = fpo_name;
	}

	public String getAgency_associated() {
		return agency_associated;
	}

	public void setAgency_associated(String agency_associated) {
		this.agency_associated = agency_associated;
	}

	public Integer getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(Integer district_id) {
		this.district_id = district_id;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	public Integer getBlock_id() {
		return block_id;
	}

	public void setBlock_id(Integer block_id) {
		this.block_id = block_id;
	}

	public String getBlock_name() {
		return block_name;
	}

	public void setBlock_name(String block_name) {
		this.block_name = block_name;
	}

	public String getFpo_address() {
		return fpo_address;
	}

	public void setFpo_address(String fpo_address) {
		this.fpo_address = fpo_address;
	}

	public BigInteger getFpo_landline() {
		return fpo_landline;
	}

	public void setFpo_landline(BigInteger fpo_landline) {
		this.fpo_landline = fpo_landline;
	}

	public String getFpo_email() {
		return fpo_email;
	}

	public void setFpo_email(String fpo_email) {
		this.fpo_email = fpo_email;
	}

	public String getFpo_lot_no() {
		return fpo_lot_no;
	}

	public void setFpo_lot_no(String fpo_lot_no) {
		this.fpo_lot_no = fpo_lot_no;
	}

	public Integer getBank_id() {
		return bank_id;
	}

	public void setBank_id(Integer bank_id) {
		this.bank_id = bank_id;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public BigInteger getFpo_account_no() {
		return fpo_account_no;
	}

	public void setFpo_account_no(BigInteger fpo_account_no) {
		this.fpo_account_no = fpo_account_no;
	}

	public String getFpo_ifsc() {
		return fpo_ifsc;
	}

	public void setFpo_ifsc(String fpo_ifsc) {
		this.fpo_ifsc = fpo_ifsc;
	}

	public Integer getFmbNo() {
		return fmbNo;
	}

	public void setFmbNo(Integer fmbNo) {
		this.fmbNo = fmbNo;
	} 
	
	
}
