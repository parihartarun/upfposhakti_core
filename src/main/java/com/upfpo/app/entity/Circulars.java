package com.upfpo.app.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="circulars")
public class Circulars implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="path")
	private String filePath;

	@Column(name="users_id")
	private Integer usersId;

	@Column(name="description")
	private String description;

	@Column(name="upload_date")
	private Calendar uploadDate;

	@Column(name="uploaded_by")
	private String uploadedBy;

	@Column(name="update_date")
	private Calendar updateDate;

	@Column(name="updated_by")
	private String updatedBy;

	@Column(name="create_date")
	private Calendar createDate;

	@Column(name="create_by")
	private String createBy;

	@Column(name="delete_date")
	private Calendar deleteDate;

	@Column(name="delete_by")
	private String deleteBy;

	@Column(name="is_deleted")
	private boolean isDeleted;

	@Column(name = "file_name")
	private String fileName;

	public Circulars(String description) {
		this.setDescription(description);
	}

	public Circulars() {

	}

	public Circulars(Integer id, String filePath, Integer usersId, String description, Calendar uploadDate, String uploadedBy, Calendar updateDate, String updatedBy, Calendar createDate, String createBy, Calendar deleteDate, String deleteBy, boolean isDeleted, String fileName) {
		this.id = id;
		this.filePath = filePath;
		this.usersId = usersId;
		this.description = description;
		this.uploadDate = uploadDate;
		this.uploadedBy = uploadedBy;
		this.updateDate = updateDate;
		this.updatedBy = updatedBy;
		this.createDate = createDate;
		this.createBy = createBy;
		this.deleteDate = deleteDate;
		this.deleteBy = deleteBy;
		this.isDeleted = isDeleted;
		this.fileName = fileName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Calendar getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Calendar deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getDeleteBy() {
		return deleteBy;
	}

	public void setDeleteBy(String deleteBy) {
		this.deleteBy = deleteBy;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean deleted) {
		isDeleted = deleted;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}