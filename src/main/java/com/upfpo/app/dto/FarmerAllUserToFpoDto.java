package com.upfpo.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.upfpo.app.custom.annotations.Mobile;

public class FarmerAllUserToFpoDto {

	private Integer farmerId;
	private Integer stateref;
	private Integer pincode;
	private Integer blockRef;
	private Integer slaRefId;
	private Integer distRefId;
	private Integer bankRefId;
	private Integer fpoRefId;
	private Integer villRefId;
	private Integer figRefId;
	private Integer educationId;
	private String farmerName;
	private String farmerAdhaar;
	private String farmerAddress;
	private String registerDate;
	private Long farmerMob;
	private String farmerLotNo;
	private String ifscCode;
	private Long accountNo;
	private Long kccno;
	private String parantsName;
	private String createDate;
	private String createdBy;
	private boolean enabled;
	private String gender;
	private Integer distanceFromFpc;
	private String farmerUserName;
	private String category;
	private String updateDate;
	private String agency;
	private String upBSMId;
	private Integer villagePanchayatId;
	private boolean isDeleted;
	private String deleteDate;
	private String updatedBy;
	private Integer userId;
	private String userName;
	private boolean userEnabled;
	private String districtName;
	
	public FarmerAllUserToFpoDto(Integer farmerId, Integer stateref, Integer pincode, Integer blockRef,
			Integer slaRefId, Integer distRefId, Integer bankRefId, Integer fpoRefId, Integer villRefId,
			Integer figRefId, Integer educationId, String farmerName, String farmerAdhaar, String farmerAddress,
			String registerDate, Long farmerMob, String farmerLotNo, String ifscCode, Long accountNo, Long kccno,
			String parantsName, String createDate, String createdBy, boolean enabled, String gender,
			Integer distanceFromFpc, String farmerUserName, String category, String updateDate, String agency,
			String upBSMId, Integer villagePanchayatId, boolean isDeleted, String deleteDate, String updatedBy,
			Integer userId, String userName, boolean userEnabled,String districtName) {
		super();
		this.farmerId = farmerId;
		this.stateref = stateref;
		this.pincode = pincode;
		this.blockRef = blockRef;
		this.slaRefId = slaRefId;
		this.distRefId = distRefId;
		this.bankRefId = bankRefId;
		this.fpoRefId = fpoRefId;
		this.villRefId = villRefId;
		this.figRefId = figRefId;
		this.educationId = educationId;
		this.farmerName = farmerName;
		this.farmerAdhaar = farmerAdhaar;
		this.farmerAddress = farmerAddress;
		this.registerDate = registerDate;
		this.farmerMob = farmerMob;
		this.farmerLotNo = farmerLotNo;
		this.ifscCode = ifscCode;
		this.accountNo = accountNo;
		this.kccno = kccno;
		this.parantsName = parantsName;
		this.createDate = createDate;
		this.createdBy = createdBy;
		this.enabled = enabled;
		this.gender = gender;
		this.distanceFromFpc = distanceFromFpc;
		this.farmerUserName = farmerUserName;
		this.category = category;
		this.updateDate = updateDate;
		this.agency = agency;
		this.upBSMId = upBSMId;
		this.villagePanchayatId = villagePanchayatId;
		this.isDeleted = isDeleted;
		this.deleteDate = deleteDate;
		this.updatedBy = updatedBy;
		this.userId = userId;
		this.userName = userName;
		this.districtName = districtName;
		this.userEnabled = userEnabled;
	}
	public Integer getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(Integer farmerId) {
		this.farmerId = farmerId;
	}
	public Integer getStateref() {
		return stateref;
	}
	public void setStateref(Integer stateref) {
		this.stateref = stateref;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public Integer getBlockRef() {
		return blockRef;
	}
	public void setBlockRef(Integer blockRef) {
		this.blockRef = blockRef;
	}
	public Integer getSlaRefId() {
		return slaRefId;
	}
	public void setSlaRefId(Integer slaRefId) {
		this.slaRefId = slaRefId;
	}
	public Integer getDistRefId() {
		return distRefId;
	}
	public void setDistRefId(Integer distRefId) {
		this.distRefId = distRefId;
	}
	public Integer getBankRefId() {
		return bankRefId;
	}
	public void setBankRefId(Integer bankRefId) {
		this.bankRefId = bankRefId;
	}
	public Integer getFpoRefId() {
		return fpoRefId;
	}
	public void setFpoRefId(Integer fpoRefId) {
		this.fpoRefId = fpoRefId;
	}
	public Integer getVillRefId() {
		return villRefId;
	}
	public void setVillRefId(Integer villRefId) {
		this.villRefId = villRefId;
	}
	public Integer getFigRefId() {
		return figRefId;
	}
	public void setFigRefId(Integer figRefId) {
		this.figRefId = figRefId;
	}
	public Integer getEducationId() {
		return educationId;
	}
	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}
	public String getFarmerName() {
		return farmerName;
	}
	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}
	public String getFarmerAdhaar() {
		return farmerAdhaar;
	}
	public void setFarmerAdhaar(String farmerAdhaar) {
		this.farmerAdhaar = farmerAdhaar;
	}
	public String getFarmerAddress() {
		return farmerAddress;
	}
	public void setFarmerAddress(String farmerAddress) {
		this.farmerAddress = farmerAddress;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public Long getFarmerMob() {
		return farmerMob;
	}
	public void setFarmerMob(Long farmerMob) {
		this.farmerMob = farmerMob;
	}
	public String getFarmerLotNo() {
		return farmerLotNo;
	}
	public void setFarmerLotNo(String farmerLotNo) {
		this.farmerLotNo = farmerLotNo;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public Long getKccno() {
		return kccno;
	}
	public void setKccno(Long kccno) {
		this.kccno = kccno;
	}
	public String getParantsName() {
		return parantsName;
	}
	public void setParantsName(String parantsName) {
		this.parantsName = parantsName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getDistanceFromFpc() {
		return distanceFromFpc;
	}
	public void setDistanceFromFpc(Integer distanceFromFpc) {
		this.distanceFromFpc = distanceFromFpc;
	}
	public String getFarmerUserName() {
		return farmerUserName;
	}
	public void setFarmerUserName(String farmerUserName) {
		this.farmerUserName = farmerUserName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getUpBSMId() {
		return upBSMId;
	}
	public void setUpBSMId(String upBSMId) {
		this.upBSMId = upBSMId;
	}
	public Integer getVillagePanchayatId() {
		return villagePanchayatId;
	}
	public void setVillagePanchayatId(Integer villagePanchayatId) {
		this.villagePanchayatId = villagePanchayatId;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public boolean isUserEnabled() {
		return userEnabled;
	}
	public void setUserEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	} 
}
