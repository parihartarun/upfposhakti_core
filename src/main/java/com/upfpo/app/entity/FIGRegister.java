package com.upfpo.app.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="fig")
public class FIGRegister implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fig_id")
	private Integer figId;
	
	@NotNull(message="Can Not be Null!")
	@Column (name="state_ref")
	private Integer stateref;
	
	@NotNull(message="Can not be Null!")
	@Column(name="sla_ref_id")
	private Integer slaRefId;
	
	@NotNull(message="Can not be Null!")
	@Column(name="dist_ref_id")
	private Integer distRefId;
	
	@NotNull(message="Can not be Null!")
	@Column(name="pincode")
	private Integer pincode;
	
	@NotNull(message="Can not be Null!")
	@Column(name="blockId")
	private Integer blockRef;
	
	@NotNull(message="Can not be Null!")
	@Column(name="fpc_ref_id")
	private Integer fpoRefId;
	
	@NotNull(message="Can not be Null!")
	@Column(name="village_ref_id")
	private Integer villRefId;
	
	@NotBlank(message="Please Provide Valid Name")
	@Column(name="fig_name")
	private String figName;
	
	@NotBlank(message="Please Provide Valid Address")
	@Column(name="ofc_Address")
	private String ofcAddress;
	
	@NotNull(message="Please Select a date")
	@Column(name = "fig_reg_date")
	private String figRegDate;

	@NotNull(message="Can Not be Null!")
	@Column(name="fig_land_number")
	private Long figLandNumber;
	
	@NotBlank(message="Can Not be Empty!")
	@Column(name="fig_email")
	private String figEmail;
	
//	@NotBlank(message="Can Not Be Empty!")
	@Column(name="fig_lot_number")
	private String figLotNumber;
	
	@NotNull(message="Can Not Be Null !")
	@Column(name="bank_ref_id")
	private Integer bankRefId;
	
	@NotBlank(message="Can Not Be Empty !")
	@Column(name="fig_ifsc_code")
	private String figIFSC;
	
	@NotNull(message="Can Not be Null !")
	@Column(name="fig_bank_account_number")
	private Long figBankAccountNumber;
	
	@Column(name="users_id")
	private long userRefId;
	
	@NotBlank(message="Please Select a Valid Username")
	@Column(name="username")
	private String userName;
	
	@Column(name="created_by")
	private String createdBy;

	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="activated_by")
	private String activatedBy;
	
	@Column(name="master_id")
	private Integer masterId;
	
	@Column(name="update_date")
	private Date updateDate;
	

	
	
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
	public String getFigName() {
		return figName;
	}
	public void setFigName(String figName) {
		this.figName = figName;
	}
	public String getOfcAddress() {
		return ofcAddress;
	}
	public void setOfcAddress(String ofcAddress) {
		this.ofcAddress = ofcAddress;
	}

	public String getFigEmail() {
		return figEmail;
	}
	public void setFigEmail(String figEmail) {
		this.figEmail = figEmail;
	}
	public String getFigLotNumber() {
		return figLotNumber;
	}
	public void setFigLotNumber(String figLotNumber) {
		this.figLotNumber = figLotNumber;
	}
	public Integer getBankRefId() {
		return bankRefId;
	}
	public void setBankRefId(Integer bankRefId) {
		this.bankRefId = bankRefId;
	}
	public String getFigIFSC() {
		return figIFSC;
	}
	public void setFigIFSC(String figIFSC) {
		this.figIFSC = figIFSC;
	}
	public Long getFigBankAccountNumber() {
		return figBankAccountNumber;
	}
	public void setFigBankAccountNumber(Long figBankAccountNumber) {
		this.figBankAccountNumber = figBankAccountNumber;
	}
		public Integer getFigId() {
		return figId;
	}
	public void setFigId(Integer figId) {
		this.figId = figId;
	}
	public long getUserRefId() {
		return userRefId;
	}
	public void setUserRefId(long userRefId) {
		this.userRefId = userRefId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getMasterId() {
		return masterId;
	}
	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}
	public String getActivatedBy() {
		return activatedBy;
	}
	public void setActivatedBy(String activatedBy) {
		this.activatedBy = activatedBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Long getFigLandNumber() {
		return figLandNumber;
	}
	public void setFigLandNumber(Long figLandNumber) {
		this.figLandNumber = figLandNumber;
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
	public String getFigRegDate() {
		return figRegDate;
	}
	public void setFigRegDate(String figRegDate) {
		this.figRegDate = figRegDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
