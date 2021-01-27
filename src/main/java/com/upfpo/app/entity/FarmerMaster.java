package com.upfpo.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import com.upfpo.app.custom.annotations.Mobile;

@Entity
@Table(name = "farmer", uniqueConstraints = { @UniqueConstraint(columnNames = "farmer_mob"),
		@UniqueConstraint(columnNames = "aadhaar") })
public class FarmerMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "farmer_id")
	private Integer farmerId;

	@Column(name = "state_ref")
	private Integer stateref;

	@Column(name = "pincode")
	private Integer pincode;

	@Column(name = "blockId")
	private Integer blockRef;

	@Column(name = "sla_ref_id")
	private Integer slaRefId;

	@NotNull(message = "Please provide district")
	@Column(name = "district_ref_id")
	private Integer distRefId;

	@Column(name = "bank_ref_id")
	private Integer bankRefId;

	@Column(name = "fpo_ref_id")
	private Integer fpoRefId;

	@Column(name = "village_ref_id")
	private Integer villRefId;

	@Column(name = "fig_ref_id")
	private Integer figRefId;

	@Column(name = "education_ref_id")
	private Integer educationId;

	@Column(name = "farmer_name")
	private String farmerName;

	@Column(name = "aadhaar")
	private String farmerAdhaar;

	@Column(name = "address")
	private String farmerAddress;

	@Column(name = "date_associated")
	private String registerDate;

	@Mobile
	@NotNull(message = "Please provide mobile number")
	@Column(name = "farmer_mob")
	private Long farmerMob;

	@Column(name = "farmerlotno")
	private String farmerLotNo;

	@Column(name = "ifsccode")
	private String ifscCode;

	@Column(name = "accountno")
	private Long accountNo;

	@Column(name = "kccno")
	private Long kccno;

	@Column(name = "farmer_parants")
	private String parantsName;

	/*
	 * @Column(name="user_id") private long userRefId;
	 */

	@Column(name = "create_date")
	private java.sql.Date createDate;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "farm_gen")
	private String gender;

	@Column(name = "distance_from_fpc")
	private Integer distanceFromFpc;

	@Column(name = "username")
	private String userName;

	@Column(name = "farm_category")
	private String category;

	@Column(name = "update_date")
	private Date updateDate;

	@Column(name = "agency_associated")
	private String agency;

	@Column(name = "upbsm_id")
	private String upBSMId;

	@Column(name = "vill_panchayat_ref_id")
	private Integer villagePanchayatId;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@Column(name = "delete_date")
	private java.sql.Date deleteDate;

	@Column(name = "updated_by")
	private String updatedBy;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "user_id")
	private User userFar;

	@OneToMany(mappedBy = "farmerProfile")
	private List<LandDetails> landDetailsProfile = new ArrayList<LandDetails>();

	public FarmerMaster() {

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

	public Integer getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Integer farmerId) {
		this.farmerId = farmerId;
	}

	public String getParantsName() {
		return parantsName;
	}

	public void setParantsName(String parantsName) {
		this.parantsName = parantsName;
	}

	/*
	 * public long getUserRefId() { return userRefId; }
	 * 
	 * public void setUserRefId(long userRefId) { this.userRefId = userRefId; }
	 */

	public java.sql.Date getCreateDate() {
		return createDate;
	}

	public User getUserFar() {
		return userFar;
	}

	public void setUserFar(User userFar) {
		this.userFar = userFar;
	}

	public void setCreateDate(java.sql.Date createDate) {
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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

	public Long getKccno() {
		return kccno;
	}

	public void setKccno(Long kccno) {
		this.kccno = kccno;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public java.sql.Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(java.sql.Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
