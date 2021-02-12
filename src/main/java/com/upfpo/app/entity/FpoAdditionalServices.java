package com.upfpo.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="fpo_additonal_services")
public class FpoAdditionalServices {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Transient
	private MultipartFile file;
	
	@Column(name="service_name")
	private String servicename;
	
	@Column(name="description")
	private String descriptions;
	
	@Column(name="file_path")
	private String filePath;
	
    @Column(name = "fpo_id")
	private Integer fpoId;
	
	@Column(name="role")
	private String role;
	
	@Column(name="upload_date")
	private java.sql.Date uploadDate;
	
	@Column(name="uplaoded_by")
	private String uploadedBy;
	
	@Column(nullable = true,name="is_deleted")
	private Boolean isDeleted;
	
	@Column(name="delete_date")
	private java.sql.Date deleteDate;
	
	@Column(name="update_date")
	private java.sql.Date updateDate;
	
	@Column(name="updated_by")
	private String updatedBy;

	
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
	  
	  public void setFpoId(Integer fpoId) { this.fpoId = fpoId; }
	 
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public java.sql.Date getUploadDate() {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public java.sql.Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(java.sql.Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public java.sql.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.sql.Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
