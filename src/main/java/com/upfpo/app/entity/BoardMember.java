package com.upfpo.app.entity;
import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "board_members")
public class BoardMember implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private long id;
	
	@Column(name = "member_name")
	private String name;

	@Column(name = "member_designation")
	@NotNull(message = "Designation cannot be null")
	private String designation;
	
	@Column(name = "member_contact")
	private BigInteger contactNo;

	@Column(name = "member_email")
	@Email(message = "Please provide valid email id")
	@NotNull(message = "Email Id cannot be null")
	private String email;

	@Column(name = "user_id")
	private Integer refId;

	@Column(name = "updated_by")
	@NotNull(message = "Updated by cannot be null")
	private String updatedBy;
	
	@Column(name="create_date")
	private java.sql.Date createDate;

	@Column(name="update_date")
	private java.sql.Date updateDate;

	@Column(name="delete_date")
	private java.sql.Date deleteDate;

	@Column(name="gender")
	private String gender;
	
	@Column(name="district_id")
	private Integer distId;
	
	@Column(name="block_id")
	private Integer blockId;
	
	@Column(name="panchayat_id")
	private Integer panchayatId;
	
	@Column(name="village_id")
	private Integer villageId;
	
	@Column(name="guardian_name")
	private String guardianName;
	
	@Column(name="is_deleted")
	private Boolean isDeleted;
	
	@Column(name="master_id")
	private Integer masterId;
	
	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public BigInteger getContactNo() {
		return contactNo;
	}

	public void setContactNo(BigInteger contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Integer getRefId() {
		return refId;
	}

	public void setRefId(Integer refId) {
		this.refId = refId;
	}

	public java.sql.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.sql.Date createDate) {
		this.createDate = createDate;
	}

	public java.sql.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.sql.Date updateDate) {
		this.updateDate = updateDate;
	}

	public java.sql.Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(java.sql.Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getDistId() {
		return distId;
	}

	public void setDistId(Integer distId) {
		this.distId = distId;
	}

	public Integer getBlockId() {
		return blockId;
	}

	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}

	public Integer getPanchayatId() {
		return panchayatId;
	}

	public void setPanchayatId(Integer panchayatId) {
		this.panchayatId = panchayatId;
	}

	public Integer getVillageId() {
		return villageId;
	}

	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public Boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
}
