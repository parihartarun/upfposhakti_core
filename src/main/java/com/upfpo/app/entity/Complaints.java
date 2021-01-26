package com.upfpo.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="complaints_suggestions")
public class Complaints {

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Transient
    private MultipartFile file;

    @Column(name="issue_type")
    private String issueType;

    @Column(name="other_type")
    private String otherType;

    @Column(name="description")
    private String descriptions;

    @Column(name="status")
    private String status;

    @Column(name="assigned_to")
    private String assigned_to;

    @Column(name="assigned_other")
    private String otherAssigned;

    @Column(name="assigned_date")
    private String assigned_date;

    @Column(name="resolve_date")
    private String resolve_date;

    @Column(name="remarks")
    private String remarks;

    @Column(name="file_path")
    private String filePath;

    @Column(name="fpo_id")
    private Integer fpoId;

    @Column(name="role")
    private String role;

    @Column(name="upload_date")
    private Date uploadDate;

    @Column(name="uplaoded_by")
    private String uploadedBy;



    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
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

    public Integer getFpoId() {
        return fpoId;
    }

    public void setFpoId(Integer fpoId) {
        this.fpoId = fpoId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }



    public String getAssigned_date() {
        return assigned_date;
    }

    public void setAssigned_date(String assigned_date) {
        this.assigned_date = assigned_date;
    }

    public String getOtherType() {
        return otherType;
    }

    public void setOtherType(String otherType) {
        this.otherType = otherType;
    }

    public String getResolve_date() {
        return resolve_date;
    }

    public void setResolve_date(String resolve_date) {
        this.resolve_date = resolve_date;
    }

    public String getOtherAssigned() {
        return otherAssigned;
    }

    public void setOtherAssigned(String otherAssigned) {
        this.otherAssigned = otherAssigned;
    }



}