package com.upfpo.app.dto;

import java.math.BigInteger;

public class ChcFmbComplaintsDto {
	
	private Integer id;
    private Integer masterId;
    private String role;
    private String title;
    private String message;
    private String status;
    private String issueType;
    private String otherType;
    private String description;
    private String otherAssigned;
    private String assignTo;
    private String assignBy;
    private String assign_date;
    private String resolve_date;
    private String deptComment;
    private String remarks;
    private String filePath;
    private String fileName;
    private String uploadDate;
    private String uploadedBy;
    private String updateDate;
    private String updateBy;
    private Boolean isDeleted;
    private String deleteDate;
    private String createBy;
   /// private String createDateTime;
    private String chcFmbName;
    private String email;
    private BigInteger mobileNumber;
	public ChcFmbComplaintsDto(Integer id, Integer masterId, String role, String title, String message, String status,
			String issueType, String otherType, String description, String otherAssigned, String assignTo,
			String assignBy, String assign_date, String resolve_date, String deptComment, String remarks,
			String filePath, String fileName, String uploadDate, String uploadedBy, String updateDate, String updateBy,
			Boolean isDeleted, String deleteDate, String createBy, String chcFmbName,
			String email, BigInteger mobileNumber) {
		super();
		this.id = id;
		this.masterId = masterId;
		this.role = role;
		this.title = title;
		this.message = message;
		this.status = status;
		this.issueType = issueType;
		this.otherType = otherType;
		this.description = description;
		this.otherAssigned = otherAssigned;
		this.assignTo = assignTo;
		this.assignBy = assignBy;
		this.assign_date = assign_date;
		this.resolve_date = resolve_date;
		this.deptComment = deptComment;
		this.remarks = remarks;
		this.filePath = filePath;
		this.fileName = fileName;
		this.uploadDate = uploadDate;
		this.uploadedBy = uploadedBy;
		this.updateDate = updateDate;
		this.updateBy = updateBy;
		this.isDeleted = isDeleted;
		this.deleteDate = deleteDate;
		this.createBy = createBy;
		//this.createDateTime = createDateTime;
		this.chcFmbName = chcFmbName;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMasterId() {
		return masterId;
	}
	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	public String getOtherType() {
		return otherType;
	}
	public void setOtherType(String otherType) {
		this.otherType = otherType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOtherAssigned() {
		return otherAssigned;
	}
	public void setOtherAssigned(String otherAssigned) {
		this.otherAssigned = otherAssigned;
	}
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
	public String getAssignBy() {
		return assignBy;
	}
	public void setAssignBy(String assignBy) {
		this.assignBy = assignBy;
	}
	public String getAssign_date() {
		return assign_date;
	}
	public void setAssign_date(String assign_date) {
		this.assign_date = assign_date;
	}
	public String getResolve_date() {
		return resolve_date;
	}
	public void setResolve_date(String resolve_date) {
		this.resolve_date = resolve_date;
	}
	public String getDeptComment() {
		return deptComment;
	}
	public void setDeptComment(String deptComment) {
		this.deptComment = deptComment;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getUploadedBy() {
		return uploadedBy;
	}
	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
//	public String getCreateDateTime() {
//		return createDateTime;
//	}
//	public void setCreateDateTime(String createDateTime) {
//		this.createDateTime = createDateTime;
//	}
	public String getChcFmbName() {
		return chcFmbName;
	}
	public void setChcFmbName(String chcFmbName) {
		this.chcFmbName = chcFmbName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigInteger getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
