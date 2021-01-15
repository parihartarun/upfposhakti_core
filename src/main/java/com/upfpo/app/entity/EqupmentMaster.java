package com.upfpo.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equip_master")
public class EqupmentMaster implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="equpment_name")
	private String equpmentname;
	
	@Column(name="is_active")
	private Boolean isactive;

<<<<<<< HEAD
=======
	@Column(name="delete_date")
	private java.sql.Date deleteDate;

	@Column(name="is_deleted")
	private boolean isDeleted;
	
	public java.sql.Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(java.sql.Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

>>>>>>> 59d46102dd140e11137a7db1dab74af93542a326
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEqupmentname() {
		return equpmentname;
	}

	public void setEqupmentname(String equpmentname) {
		this.equpmentname = equpmentname;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	
	

}
