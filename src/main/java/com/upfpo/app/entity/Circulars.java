package com.upfpo.app.entity;
import java.io.Serializable;

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
	
	@Column(name="upload_date")
	private java.sql.Date uploadDate;
	
	@Column(name="path")
	private String filePath;
	
	@Column(name="uploaded_by")
	private String uploadedBy;
	
	@Column(name="users_id")
	private Integer usersId;

	@Column(name="description")
	private String description;
	
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

	public java.sql.Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(java.sql.Date uploadDate) {
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
