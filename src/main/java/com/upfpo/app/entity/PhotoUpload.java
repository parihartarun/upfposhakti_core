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

    @Column(name="is_deleted", columnDefinition = "boolean default false")
    private Boolean isDeleted;

    @Column(name="delete_date")
    private Calendar deleteDate;

    @Column(name = "create_by")
    private String createBy;
    
    @Column(name = "fpo_id")
    private Integer fpoId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Calendar createdDate;
    
    @Column(name = "update_by")
    private String updateBy;

	public PhotoUpload(Integer id, String description, String filePath, String fileName, String role,
			Calendar uploadDate, String uploadedBy, Calendar updateDate, Boolean isDeleted, Calendar deleteDate,
			String createBy, Integer fpoId, Calendar createdDate, String updateBy) {
	
		this.id = id;
		this.description = description;
		this.filePath = filePath;
		this.fileName = fileName;
		this.role = role;
		this.uploadDate = uploadDate;
		this.uploadedBy = uploadedBy;
		this.updateDate = updateDate;
		this.isDeleted = isDeleted;
		this.deleteDate = deleteDate;
		this.createBy = createBy;
		this.fpoId = fpoId;
		this.createdDate = createdDate;
		this.updateBy = updateBy;
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

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public Calendar getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Calendar updateDate) {
		this.updateDate = updateDate;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Calendar getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Calendar deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Integer getFpoId() {
		return fpoId;
	}

	public void setFpoId(Integer fpoId) {
		this.fpoId = fpoId;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
}

    
    