package com.upfpo.app.entity;


import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "photo_upload")
public class PhotoUpload {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="description")
    private String description;

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

    @Column(name="updated_by")
    private String updatedBy;

    @Column(name="is_deleted", columnDefinition = "boolean default false")
    private Boolean isDeleted;

    @Column(name="delete_date")
    private Date deleteDate;

    @Column(name = "create_by")
    private String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Calendar createDate;


    public PhotoUpload() {
    }

    public PhotoUpload(Integer id, String description, String filePath, String fileName, String role,
                       Calendar uploadDate, String uploadedBy, Calendar updateDate,
                       String updatedBy, Boolean isDeleted, Date deleteDate, String createBy, Calendar createDate) {
        this.id = id;
        this.description = description;
        this.filePath = filePath;
        this.fileName = fileName;
        this.role = role;
        this.uploadDate = uploadDate;
        this.uploadedBy = uploadedBy;
        this.updateDate = updateDate;
        this.updatedBy = updatedBy;
        this.isDeleted = isDeleted;
        this.deleteDate = deleteDate;
        this.createBy = createBy;
        this.createDate = createDate;
    }

    public PhotoUpload(String description) {
        this.description=description;
    }

    public PhotoUpload(Integer id, String description) {
        this.id=id;
        this.description=description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Calendar getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Calendar uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Calendar getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Calendar updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
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

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }


    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }
}
