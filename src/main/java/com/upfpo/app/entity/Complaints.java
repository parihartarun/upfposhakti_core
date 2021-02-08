package com.upfpo.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "complaints")
public class Complaints {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="message")
    private String message;

    @Column(name="status")
    private Status status;
    
    @Column(name="fpo_id")
    private Integer fpoId;

    @Column(name="issue_type")
    private String issueType;

    @Column(name="other_type")
    private String otherType;

    @Column(name="description")
    private String description;

    @Column(name="assigned_other")
    private String otherAssigned;

    @Column(name="assigned_to")
    private String assignTo;

    @Column(name="assigned_By")
    private String assignBy;

    @Column(name="assigned_date")
    private Date assigned_date;

    @Column(name="resolve_date")
    private Date resolve_date;

    @Column(name="comment")
    private String deptComment;

    @Column(name="remarks")
    private String remarks;

    @Column(name="file_path")
    private String filePath;

    @Column(name="file_name")
    private String fileName;

    @Column(name="role")
    private String role;

    @Column(name="upload_date")
    private Calendar uploadDate;

    @Column(name="uplaoded_by")
    private String uploadedBy;

    @Column(name="update_date")
    private Calendar updateDate;

    @Column(name="update_by")
    private String updateBy;

    @Column(name="is_deleted")
    private Boolean isDeleted;

    @Column(name="delete_date")
    private Calendar deleteDate;

    @Column(name = "create_by")
    private String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date_time")
    private Calendar createDateTime;

    @JsonIgnore
    @OneToMany(mappedBy = "complaints", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ComplaintsComments> complaintsComments;



    public Complaints() {
    }

    public Complaints(Integer id, String title, String message, Status status, Integer fpoId, String issueType,
                      String otherType, String description, String otherAssigned, String assignTo, String assignBy,
                      Date assigned_date, Date resolve_date, String deptComment, String remarks, String filePath, String role, Date uploadDate, String uploadedBy,
                      Boolean isDeleted, Date deleteDate, String createBy, Calendar createDateTime, List<ComplaintsComments> complaintsComments) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.status = status;
        this.fpoId = fpoId;
        this.issueType = issueType;
        this.otherType = otherType;
        this.description = description;
        this.otherAssigned = otherAssigned;
        this.assignTo = assignTo;
        this.assignBy = assignBy;
        this.assigned_date = assigned_date;
        this.resolve_date = resolve_date;
        this.deptComment = deptComment;
        this.remarks = remarks;
        this.filePath = filePath;
        this.role = role;

        this.uploadedBy = uploadedBy;
        this.isDeleted = isDeleted;

        this.createBy = createBy;
        this.createDateTime = createDateTime;
        this.complaintsComments = complaintsComments;
    }

    public String getAssignBy() {
        return assignBy;
    }

    public void setAssignBy(String assignBy) {
        this.assignBy = assignBy;
    }

    public String getDeptComment() {
        return deptComment;
    }

    public void setDeptComment(String deptComment) {
        this.deptComment = deptComment;
    }



    public Complaints(String description, String title, String issueType) {

        this.setIssueType(issueType);
        this.setDescription(description);
        this.setTitle(title);

    }


    public Calendar getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Calendar updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getFpoId() {
        return fpoId;
    }

    public void setFpoId(Integer fpoId) {
        this.fpoId = fpoId;
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

    public Date getAssigned_date() {
        return assigned_date;
    }

    public void setAssigned_date(Date assigned_date) {
        this.assigned_date = assigned_date;
    }

    public Date getResolve_date() {
        return resolve_date;
    }

    public void setResolve_date(Date resolve_date) {
        this.resolve_date = resolve_date;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Calendar getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Calendar uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Calendar getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Calendar deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Calendar getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Calendar createDateTime) {
        this.createDateTime = createDateTime;
    }

    public List<ComplaintsComments> getComplaintsComments() {
        return complaintsComments;
    }

    public void setComplaintsComments(List<ComplaintsComments> complaintsComments) {
        this.complaintsComments = complaintsComments;
    }
}
