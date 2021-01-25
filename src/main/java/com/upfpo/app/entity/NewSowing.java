package com.upfpo.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="new_sowing_info")
public class NewSowing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sowing_id")
	private Integer sowingId;
	
	@Column(name="fin_year")
	private String finYear;
	
	@Column(name = "guardian_name")
	private String guardianName;

	@Column(name = "season_ref")
	private Integer seasonRefName;
	
	@Column(name = "farmer_id")
	private Integer farmerId;
	
	@Column(name = "land_id")
	private Double baseland;
	
	@Column(name = "user_ref_id")
	private Integer userRefId;
	
	@Column(name = "master_id")
	private Integer masterId;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "create_date")
	private java.sql.Date createDate;

	@Column(name = "update_date")
	private java.sql.Date updateDate;

	@Column(name = "delete_date")
	private java.sql.Date deleteDate;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="sowing_id")
	private List<CropDatails> list;
	
	
	
	
	public Integer getSowingId() {
		return sowingId;
	}

	public void setSowingId(Integer sowingId) {
		this.sowingId = sowingId;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public Integer getSeasonRefName() {
		return seasonRefName;
	}

	public void setSeasonRefName(Integer seasonRefName) {
		this.seasonRefName = seasonRefName;
	}

	public Integer getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Integer farmerId) {
		this.farmerId = farmerId;
	}


	public List<CropDatails> getList() {
		return list;
	}

	public void setList(List<CropDatails> list) {
		this.list = list;
	}

	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public java.sql.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.sql.Date createDate) {
		this.createDate = createDate;
	}

	public java.sql.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.sql.Date updateDate) {
		this.updateDate = updateDate;
	}

	public java.sql.Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(java.sql.Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public Integer getUserRefId() {
		return userRefId;
	}

	public void setUserRefId(Integer userRefId) {
		this.userRefId = userRefId;
	}

	public Double getBaseland() {
		return baseland;
	}

	public void setBaseland(Double baseland) {
		this.baseland = baseland;
	}

	public String getFinYear() {
		return finYear;
	}

	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}
	
}

