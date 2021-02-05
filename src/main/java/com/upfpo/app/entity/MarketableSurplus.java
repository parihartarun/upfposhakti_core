package com.upfpo.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="marketable_surplus")
public class MarketableSurplus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="financial_year")
	private String finYear;
	
	@Column(name="season_ref")
	private String season;
	
	@Column(name="crop_type")
	private String cropId;
	
	@Column(name="crop_ref_name")
	private Integer cropRefName;
	
//	@Min(value=1,message="Should be at least greater than 0")
	@Column(name="marketable_quantity")
	private Double marketableQuantity;
	
	@Column(name="actual_quantity")
	private Double actualQuantity;

	@Column(name="veriety_ref")
	private String verietyId;
	
	@Column(name="user_id")
	private Integer fpoId;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="master_id")
	private Integer masterId;
	
	@CreatedDate
	@Column(name="create_date")
	private Date createDate;
	
	@UpdateTimestamp
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="delete_date")
	private Date deleteDate;
	
	@Column(name="is_deleted")
	private boolean isDeleted;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getCropId() {
		return cropId;
	}

	public void setCropId(String cropId) {
		this.cropId = cropId;
	}

	public String getVerietyId() {
		return verietyId;
	}

	public void setVerietyId(String verietyId) {
		this.verietyId = verietyId;
	}

	public Integer getFpoId() {
		return fpoId;
	}

	public void setFpoId(Integer fpoId) {
		this.fpoId = fpoId;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Double getMarketableQuantity() {
		return marketableQuantity;
	}

	public void setMarketableQuantity(Double marketableQuantity) {
		this.marketableQuantity = marketableQuantity;
	}

	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(java.sql.Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public Integer getCropRefName() {
		return cropRefName;
	}

	public void setCropRefName(Integer cropRefName) {
		this.cropRefName = cropRefName;
	}

	public String getFinYear() {
		return finYear;
	}

	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}
	public Double getActualQuantity() {
		return actualQuantity;
	}

	public void setActualQuantity(Double actualQuantity) {
		this.actualQuantity = actualQuantity;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
