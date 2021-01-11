//package com.upfpo.app.entity;
//import java.io.Serializable;
//import java.util.Date;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//import javax.validation.constraints.NotNull;
//import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.Length;
//import org.hibernate.validator.constraints.NotBlank;
//import com.upfpo.app.custom.annotations.LandLine;
//import com.upfpo.app.custom.annotations.Mobile;
//import com.upfpo.app.custom.annotations.UserName;
//
//@Entity
//@Table(name="sla")
//public class SLARegister implements Serializable{
//	
//	private static final long serialVersionUID = 1L;
//    
//	@Id 
//	@GeneratedValue
//	@Column(name="sla_id")
//    private Integer sla_id;
//	
//	@Length(min=2,max=20)
//	@Column(name="unit_as_sla")
//	private String unitAsSLA;
//	
//	@Length(min=2,max=20,message="Please Enter Name Between 2 and 20 Characters")
//	@Column(name="nodal_officer_name")
//	private String nodalOfficerName;
//	
//	@Length(min=2,max=20,message="Please Enter Name Between 2 and 20 Characters")
//	@Column (name="nodal_officer_designation")
//	private String nodalOfficerDesignation;
//
//	@Column(name="date_associated")
//	private String dateAssociated;
//	
//    @Id
//    @LandLine
//	@Column(name="sla_land_line")
//	private Long slaLandLine;
//
//    @Id
//    @Mobile
//	@Column(name="sla_mobile")
//	private Long slaMobile;
//    
//    @Id
//    @Email(message ="Please Provie Valid Email Address")
//	@Column (name="sla_email")
//	private String slaEmail;
//
//    @NotNull(message="Please Select State")
//	@Column (name="state_ref")
//	private Integer stateref;
//	
//	@NotNull(message="Please Select district")
//	@Column (name="dist_ref")
//	private Integer distref;
//	
//	@Column(name="blockId")
//	private Integer blockRef;
//	
//	@Column(name="pincode")
//	private Integer pincode;
//	
//	@Column(name="users_id")
//	private long userRefId;
//	
//	@Column(name="created_by")
//	private String createdBy;
//	
//	@UserName
//	@Column(name="username")
//	private String userName;
//	
//	@Column(name="update_date")
//	private Date updateDate;
//	
//	@Column(name="create_date")
//	private Date createdate;
//	
//	@Transient
//	private String years;
//
//	public SLARegister() {}
//	
//	public String getUnitAsSLA() {
//		return unitAsSLA;
//	}
//
//	public void setUnitAsSLA(String unitAsSLA) {
//		this.unitAsSLA = unitAsSLA;
//	}
//
//	public String getNodalOfficerName() {
//		return nodalOfficerName;
//	}
//
//	public void setNodalOfficerName(String nodalOfficerName) {
//		this.nodalOfficerName = nodalOfficerName;
//	}
//
//	public String getNodalOfficerDesignation() {
//		return nodalOfficerDesignation;
//	}
//
//	public void setNodalOfficerDesignation(String nodalOfficerDesignation) {
//		this.nodalOfficerDesignation = nodalOfficerDesignation;
//	}
//	
//
//	public String getDateAssociated() {
//		return dateAssociated;
//	}
//
//
//	public void setDateAssociated(String dateAssociated) {
//		this.dateAssociated = dateAssociated;
//	}
//
//
//	public Long getSlaLandLine() {
//		return slaLandLine;
//	}
//
//	public void setSlaLandLine(Long slaLandLine) {
//		this.slaLandLine = slaLandLine;
//	}
//
//	public Long getSlaMobile() {
//		return slaMobile;
//	}
//
//	public void setSlaMobile(Long slaMobile) {
//		this.slaMobile = slaMobile;
//	}
//
//	public String getSlaEmail() {
//		return slaEmail;
//	}
//
//	public void setSlaEmail(String slaEmail) {
//		this.slaEmail = slaEmail;
//	}
//
//	public Integer getStateref() {
//		return stateref;
//	}
//
//	public void setStateref(Integer stateref) {
//		this.stateref = stateref;
//	}
//	
//
//	public Integer getSla_id() {
//		return sla_id;
//	}
//
//	public void setSla_id(Integer sla_id) {
//		this.sla_id = sla_id;
//	}
//
//	public Integer getDistref() {
//		return distref;
//	}
//
//	public void setDistref(Integer distref) {
//		this.distref = distref;
//	}
//
//	public long getUserRefId() {
//		return userRefId;
//	}
//
//	public void setUserRefId(long userRefId) {
//		this.userRefId = userRefId;
//	}
//
//	public String getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public Date getCreatedate() {
//		return createdate;
//	}
//
//	public void setCreatedate(Date createdate) {
//		this.createdate = createdate;
//	}
//
//	public Date getUpdateDate() {
//		return updateDate;
//	}
//
//
//	public void setUpdateDate(Date updateDate) {
//		this.updateDate = updateDate;
//	}
//
//
//	public Integer getBlockRef() {
//		return blockRef;
//	}
//
//	public void setBlockRef(Integer blockRef) {
//		this.blockRef = blockRef;
//	}
//
//	public Integer getPincode() {
//		return pincode;
//	}
//
//	public void setPincode(Integer pincode) {
//		this.pincode = pincode;
//	}
//
//
//	public String getYears() {
//		return years;
//	}
//
//
//	public void setYears(String years) {
//		this.years = years;
//	}
//	
//	
//
//}
