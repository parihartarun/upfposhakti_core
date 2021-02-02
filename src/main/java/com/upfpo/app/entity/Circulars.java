package com.upfpo.app.entity;

import java.io.Serializable;
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
	private Date uploadDate;

	@Column(name="uploaded_by")
	private String uploadedBy;

	@Column(name="update_date")
	private Date updateDate;

	@Column(name="updated_by")
	private String updatedBy;

	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_by")
	private Date createBy;

	@Column(name="delete_date")
	private Date deleteDate;

	@Column(name="delete_by")
	private Date deleteBy;

	@Column(name="is_deleted")
	private boolean isDeleted;

	public Circulars(String description) {
		this.setDescription(description);
	}

	public Circulars() {

	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Date createBy) {
		this.createBy = createBy;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public Date getDeleteBy() {
		return deleteBy;
	}

	public void setDeleteBy(Date deleteBy) {
		this.deleteBy = deleteBy;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean deleted) {
		isDeleted = deleted;
	}

	/* fields needed
	 * @Column(name="is_deleted") private boolean isDeleted;
	 * 
	 * @Column(name="delete_date") private java.sql.Date deleteDate;
	 * 
	 * @Column(name="update_date") private java.sql.Date updateDate;
	 * 
	 * @Column(name="updated_by") private String updatedBy;
	 */





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
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
}