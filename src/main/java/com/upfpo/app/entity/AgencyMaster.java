
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
@Table(name="association_agency")
public class AgencyMaster implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="agency_id")
	private Integer id;
	
	@Column(name="agency_name")
	private String  agencyName;
	
	@Column(name="deleted_date")
	private java.sql.Date  deleteDate;
	
	@Column(name="is_deleted")
	private boolean  isDeleted;
	
	public AgencyMaster() {
		super();
	}

	public AgencyMaster(Integer id, String agencyName, boolean isDeleted, boolean isActive, boolean isFpo) {
		super();
		this.id = id;
		this.agencyName = agencyName;
		this.isDeleted = isDeleted;
		this.isActive = isActive;
		this.isFpo = isFpo;
	}

	@Column(name="active")
	private boolean isActive;
	
	@Column(name="is_fpo")
	private boolean isFpo;

	@Override
	public String toString() {
		return "AgencyMaster [id=" + id + ", agencyName=" + agencyName + ", isDeleted=" + isDeleted + ", isActive="
				+ isActive + ", isFpo=" + isFpo + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isFpo() {
		return isFpo;
	}

	public void setFpo(boolean isFpo) {
		this.isFpo = isFpo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public java.sql.Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(java.sql.Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public AgencyMaster(Integer id, String agencyName, Date deleteDate, boolean isDeleted, boolean isActive,
			boolean isFpo) {
		super();
		this.id = id;
		this.agencyName = agencyName;
		this.deleteDate = deleteDate;
		this.isDeleted = isDeleted;
		this.isActive = isActive;
		this.isFpo = isFpo;
	}


	

		
}
