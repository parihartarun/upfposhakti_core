package com.upfpo.app.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.upfpo.app.custom.annotations.Mobile;
import com.upfpo.app.dto.BuyerSellerComplaintsDto;
import com.upfpo.app.dto.ChcFmbComplaintsDto;

@Entity
@SqlResultSetMapping(name="ChcFmbComplaintsDto",
classes = {
        @ConstructorResult(
                targetClass = ChcFmbComplaintsDto.class,
                columns = {
                		@ColumnResult(name = "id", type = Integer.class),
                		@ColumnResult(name = "masterId", type = Integer.class),
                		@ColumnResult(name = "role", type = String.class),
                		@ColumnResult(name = "title", type = String.class),
                		@ColumnResult(name = "message", type = String.class),
                		@ColumnResult(name = "status", type = String.class),
                		@ColumnResult(name = "issueType", type = String.class),
                		@ColumnResult(name = "otherType", type = String.class),
                		@ColumnResult(name = "description", type = String.class),
                		@ColumnResult(name = "otherAssigned", type = String.class),
                		@ColumnResult(name = "assignTo", type = String.class),
                		@ColumnResult(name = "assignBy", type = String.class),
                		@ColumnResult(name = "assign_date", type = String.class),
                		@ColumnResult(name = "resolve_date", type = String.class),
                		@ColumnResult(name = "deptComment", type = String.class),
                		@ColumnResult(name = "remarks", type = String.class),
                		@ColumnResult(name = "filePath", type = String.class),
                		@ColumnResult(name = "fileName", type = String.class),
                		@ColumnResult(name = "uploadDate", type = String.class),
                		@ColumnResult(name = "uploadedBy", type = String.class),
                		@ColumnResult(name = "updateDate", type = String.class),
                		@ColumnResult(name = "updateBy", type = String.class),
                		@ColumnResult(name = "isDeleted", type = Boolean.class),
                		@ColumnResult(name = "deleteDate",type = String.class),
                		@ColumnResult(name = "createBy",type = String.class),
                		//@ColumnResult(name = "createDateTime",type = String.class),
                		@ColumnResult(name = "chcFmbName",type = String.class),
                		@ColumnResult(name = "email",type = String.class),
                		@ColumnResult(name = "mobileNumber",type = BigInteger.class),
                })
})
@Table(name="chc_fmb")
public class ChcFmbMaster implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="chc_fmb_id")
	private int chcFmbId;
	
	@Column(name="chc_fmb_name")
	private String chcFmbName;
	
	@Column(name="dist_ref_id")
	private Integer distRefId;
	
	@Column(name="block_ref_id")
	private Integer blockRefId;
	
	@Column(name="village_ref_id")
	private Integer villageRefId;
	
	@Column(name="pincode")
	private long pincode;
	
	@Column(name="email")
	@Email(message = "Please provide valid email Id")
	private String email;
	
	@Mobile
	@NotNull(message = "Mobile number should not be null")
	@Column(name="mobile_number")
	@Min(10)
	private long mobileNumber;
	
	@Column(name="firm_registraion_number")
	private String firmRegistraionNumber;
	
	@Column(name="shop_establishment_number")
	private String shopEstablishmentNumber;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name="allotment_no")
	private String allotmentNo;
	
	@Column(name="is_deleted")
	private boolean isDeleted;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="user_id")
	private User user;

	public int getChcFmbId() {
		return chcFmbId;
	}

	public void setChcFmbId	(int chcFmbId) {
		this.chcFmbId = chcFmbId;
	}

	public String getChcFmbName() {
		return chcFmbName;
	}

	public void setChcFmbName(String chcFmbName) {
		this.chcFmbName = chcFmbName;
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

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFirmRegistraionNumber() {
		return firmRegistraionNumber;
	}

	public void setFirmRegistraionNumber(String firmRegistraionNumber) {
		this.firmRegistraionNumber = firmRegistraionNumber;
	}

	public String getShopEstablishmentNumber() {
		return shopEstablishmentNumber;
	}

	public void setShopEstablishmentNumber(String shopEstablishmentNumber) {
		this.shopEstablishmentNumber = shopEstablishmentNumber;
	}

	public String getAllotmentNo() {
		return allotmentNo;
	}

	public void setAllotmentNo(String allotmentNo) {
		this.allotmentNo = allotmentNo;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
