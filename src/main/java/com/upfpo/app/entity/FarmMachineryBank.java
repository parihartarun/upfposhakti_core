package com.upfpo.app.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="farm_manchinery_bank")
public class FarmMachineryBank implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	
	private Integer id;
	
	@Column(name="equpment_name")
	private String equpment_name;
	
	@Column(name="equpment_no")
	private Integer equpment_no;

	@Column(name="equpmnet_capacity")
	private String equpmnet_capacity;

	@Column(name="fpo_ref_id")
	private Integer FpoRefId;
	
	@Column(name="updated_by")
	private String UpdatedBy;
	
	@Column(name="master_id")
	private Integer MasterId;
	
	@Column(name="create_date")
	private java.sql.Date createDate;
	
	@Column(name="is_deleted")
	private Boolean isDeleted;
		
	@Column(name="delete_date")
	private java.sql.Date deleteDate;	
	
	@Column(name="update_date")
	private java.sql.Date updateDate;

	
	
	public String getEqupment_name() {
		return equpment_name;
	}

	public void setEqupment_name(String equpment_name) {
		this.equpment_name = equpment_name;
	}

	public Integer getEqupment_no() {
		return equpment_no;
	}

	public void setEqupment_no(Integer equpment_no) {
		this.equpment_no = equpment_no;
	}

	public String getEqupmnet_capacity() {
		return equpmnet_capacity;
	}

	public void setEqupmnet_capacity(String equpmnet_capacity) {
		this.equpmnet_capacity = equpmnet_capacity;
	}

	public Integer getFpoRefId() {
		return FpoRefId;
	}

	public void setFpoRefId(Integer fpoRefId) {
		FpoRefId = fpoRefId;
	}

	public String getUpdatedBy() {
		return UpdatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}

	public Integer getMasterId() {
		return MasterId;
	}

	public void setMasterId(Integer masterId) {
		MasterId = masterId;
	}

	public java.sql.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.sql.Date createDate) {
		this.createDate = createDate;
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
	
	
							
}
