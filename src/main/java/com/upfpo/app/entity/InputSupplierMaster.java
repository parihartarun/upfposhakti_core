package com.upfpo.app.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="input_supplier")
public class InputSupplierMaster implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "input_supplier_id")
	private Integer inputSupplierId;
	
	@Column(name="input_supplier_name")
	private String inputSupplierName;
	
	@Column(name="input_supplier_type")
	private Integer inputSupplierType;
	
	@Column(name="dist_ref_id")
	private Integer distRefId;
	
	@Column(name="block_ref_id")
	private Integer blockRefId;
	
	@Column(name="village_ref_id")
	private Integer villageRefId;
	
	@Column(name="pincode")
	private long pincode;
	
	@Column(name="email")
	@Email(message = "Please provide valid email id")
	private String email;
	
	@Column(name="mobile_number")
	@NotNull(message = "Mobile number should not be null")
	private long mobile_number;
	
	@Column(name="contact_person")
	private String contact_person;
	
	@Column(name="license_number")
	private String license_number;
	
	@Column(name="gst_number")
	private String gstNumber;
	
	@Column(name="seed_id")
	private Integer seed_id;
	
	@Column(name="is_deleted")
	private boolean isDeleted;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="user_id")
	private User userInputSeller;


	public User getUserInputSeller() {
		return userInputSeller;
	}

	public void setUserInputSeller(User userInputSeller) {
		this.userInputSeller = userInputSeller;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getInputSupplierId() {
		return inputSupplierId;
	}

	public void setInputSupplierId(Integer inputSupplierId) {
		this.inputSupplierId = inputSupplierId;
	}

	public String getInputSupplierName() {
		return inputSupplierName;
	}

	public void setInputSupplierName(String inputSupplierName) {
		this.inputSupplierName = inputSupplierName;
	}

	public Integer getInputSupplierType() {
		return inputSupplierType;
	}

	public void setInputSupplierType(Integer inputSupplierType) {
		this.inputSupplierType = inputSupplierType;
	}

	public Integer getDistRefId() {
		return distRefId;
	}

	public void setDistRefId(Integer distRefId) {
		this.distRefId = distRefId;
	}

	public Integer getBlockRefId() {
		return blockRefId;
	}

	public void setBlockRefId(Integer blockRefId) {
		this.blockRefId = blockRefId;
	}

	public Integer getVillageRefId() {
		return villageRefId;
	}

	public void setVillageRefId(Integer villageRefId) {
		this.villageRefId = villageRefId;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getContact_person() {
		return contact_person;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	public String getLicense_number() {
		return license_number;
	}

	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public Integer getSeed_id() {
		return seed_id;
	}

	public void setSeed_id(Integer seed_id) {
		this.seed_id = seed_id;
	}
}
