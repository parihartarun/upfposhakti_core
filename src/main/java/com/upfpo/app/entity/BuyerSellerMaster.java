package com.upfpo.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name="buyer_seller")
public class BuyerSellerMaster implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="buyerSeller_id")
	private int buyerSellerId;
	
	@Column(name="buyerSeller_name")
	private String buyerSellerName;
	
	@Column(name="building_name")
	private String buildingName;
	
	@Column(name="street_name")
	private String streetName;
	
	@Column(name="area")
	private String area;
	
	@Column(name="pincode")
	private long pincode;
	
	@Column(name="contact_person")
	private String contactPerson;
	
	@Column(name="designation_contact_person")
	private String designationContactPerson;
	
	@Column(name="mobile_number")
	private long mobileNumber;
	
	@Email(message ="Please Provie Valid Email Address")
	@Column(name="email")
	private String email;
	
	@Column(name="website")
	private String webSite;
	
	@Column(name="state_ref_id")
	private Integer stateRefId;
	
	@Column(name="district_ref_id")
	private Integer districtRefId;

	public int getBuyerSellerId() {
		return buyerSellerId;
	}

	public void setBuyerSellerId(int buyerSellerId) {
		this.buyerSellerId = buyerSellerId;
	}

	public String getBuyerSellerName() {
		return buyerSellerName;
	}

	public void setBuyerSellerName(String buyerSellerName) {
		this.buyerSellerName = buyerSellerName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getDesignationContactPerson() {
		return designationContactPerson;
	}

	public void setDesignationContactPerson(String designationContactPerson) {
		this.designationContactPerson = designationContactPerson;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public Integer getStateRefId() {
		return stateRefId;
	}

	public void setStateRefId(Integer stateRefId) {
		this.stateRefId = stateRefId;
	}

	public Integer getDistrictRefId() {
		return districtRefId;
	}

	public void setDistrictRefId(Integer districtRefId) {
		this.districtRefId = districtRefId;
	}
}
