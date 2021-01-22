package com.upfpo.app.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="land_details")
public class LandDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="land_id")
	private Integer landId;
	
	@Column(name="guardian_name")
	private String guardianName;
	
	@Column(name="land_area")
	private double land_area;
	
	@Column(name="user_ref_id")
	private Integer userRefId;
	
	@Column(name="master_id")
	private Integer masterId;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="create_date")
	private java.sql.Date createDate;
	
	@Column(name="update_date")
	private java.sql.Date updateDate;
	
	@Column(name="delete_date")
	private java.sql.Date deleteDate;
	
	@Column(name="farmer_id")
	private Integer farmerId;
	
	@Column(name="is_organic")
	private String isorganc;
	
	@Column(name="is_deleted")
    private boolean isDeleted;

	
	
	
	public Integer getLandId() {
		return landId;
	}

	public void setLandId(Integer landId) {
		this.landId = landId;
	}

	public Integer getUserRefId() {
		return userRefId;
	}

	public void setUserRefId(Integer userRefId) {
		this.userRefId = userRefId;
	}



	public double getLand_area() {
		return land_area;
	}

	public void setLand_area(double land_area) {
		this.land_area = land_area;
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

	public Integer getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Integer farmerId) {
		this.farmerId = farmerId;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getIsorganc() {
		return isorganc;
	}

	public void setIsorganc(String isorganc) {
		this.isorganc = isorganc;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
