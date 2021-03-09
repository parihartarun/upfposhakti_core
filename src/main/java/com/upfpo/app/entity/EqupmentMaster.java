package com.upfpo.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@Column(name="eqip_type")
	private Integer eqipType;
	
	@Column(name="is_active")
	private Boolean isactive;

	@Column(name="delete_date")
	private java.sql.Date deleteDate;

	@Column(name="is_deleted")
	private boolean isDeleted;
	
	@OneToMany(mappedBy = "machineryNameId", cascade = CascadeType.ALL)
	private List<EnquiryChcFmbMachinery> machineDetailsProfile;
	
	public Integer getEqipType() {
		return eqipType;
	}

	public void setEqipType(Integer eqipType) {
		this.eqipType = eqipType;
	}

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

	public List<EnquiryChcFmbMachinery> getMachineDetailsProfile() {
		return machineDetailsProfile;
	}

	public void setMachineDetailsProfile(List<EnquiryChcFmbMachinery> machineDetailsProfile) {
		this.machineDetailsProfile = machineDetailsProfile;
	}

	
}
