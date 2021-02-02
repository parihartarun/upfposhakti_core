package com.upfpo.app.entity;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Entity
public class FPOServices {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Transient
    private MultipartFile file;

    @Column(name="service_name")
    private String servicename;

    @Column(name="description")
    private String descriptions;

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

    @Column(name="updated_by")
    private String updatedBy;

    @Column(name="update_date")
    private Date updateDate;

    @Column(name="is_deleted")
    private boolean isDeleted;

    @Column(name="delete_date")
    private Date deleteDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    public FPOServices() {
    }

    public FPOServices(String description, String servicename) {
        this.setServicename(servicename);
        this.setDescriptions(description);
    }

    public FPOServices(Integer id, String description, String servicename) {
        this.setId(id);
        this.setServicename(servicename);
        this.setDescriptions(description);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
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

    public void setUploadDate(java.sql.Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
