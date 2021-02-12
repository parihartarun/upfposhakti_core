package com.upfpo.app.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="license_details")
public class FpoLicenceDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="lic_type")
    private String licenceType;
	
	@Column(name="lic_issue_date")
	private String issuedate;
	
	@Column(name="lic_issused_by")
	private String licenceIssuedBy;
	
	@Column(name="license_number")
	private String liceneceNumber;
	
	@Column(name="lic_valid_till")
	private String licenceValidTill;
	
	@Column(name="user_ref_id")
	private Integer userRefId;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="master_id")
	private Integer masterId;
	
	@Column(name="create_date")
	private java.sql.Date createDate;

	@Column(name="update_date")
	private java.sql.Date updateDate;

	@Column(name="delete_date")
	private java.sql.Date deleteDate;
	
	 @Column(name="is_deleted")
	private Boolean isDeleted;						
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLicenceType() {
		return licenceType;
	}

	public void setLicenceType(String licenceType) {
		this.licenceType = licenceType;
	}

	public String getLicenceIssuedBy() {
		return licenceIssuedBy;
	}

	public void setLicenceIssuedBy(String licenceIssuedBy) {
		this.licenceIssuedBy = licenceIssuedBy;
	}

	public String getLiceneceNumber() {
		return liceneceNumber;
	}

	public void setLiceneceNumber(String liceneceNumber) {
		this.liceneceNumber = liceneceNumber;
	}

	public Integer getUserRefId() {
		return userRefId;
	}

	public void setUserRefId(Integer userRefId) {
		this.userRefId = userRefId;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
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

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public String getLicenceValidTill() {
		return licenceValidTill;
	}

	public void setLicenceValidTill(String licenceValidTill) {
		this.licenceValidTill = licenceValidTill;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
}
