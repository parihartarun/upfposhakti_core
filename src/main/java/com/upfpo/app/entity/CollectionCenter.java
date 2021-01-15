package com.upfpo.app.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name="collection_center")
public class CollectionCenter implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="state_ref_id")
	private Integer stateId;
	
	@Column(name="dist_ref_id")
	private Integer distId;
	
	@Column(name="block_ref_id")
	private Integer blockId;
	
	@Min(value=1,message="Storage capacity should be greater than 0")
	@Column(name="storage_capacity")
	private BigInteger  storageCapacity;
	
	@Column(name="distance_from_fpc")
	private Integer distanceFromFPC;
	
	@Column(name="user_id")
	private Integer fpoRefId;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="center_address")
	private String address;
	
	@Column(name="center_lattitude")
	private String lattitude;
	
	@Column(name="center_longitude")
	private String longitude;
	
	@Column(name="master_id")
	private Integer masterId;
	
	@Column(name="create_date")
	private java.sql.Date createDate;

	@Column(name="update_date")
	private java.sql.Date updateDate;

	@Column(name="delete_date")
	private java.sql.Date deleteDate;
	
	@Column(name="fascilities")
	private String fascilities;
	
	@Column(name="storage_type")
	private String storageType;
	
	@Column(name="is_seed_pro_unit")
	private String isseedprocessingunit;
	
	@Column(name="is_deleted")
	private boolean isDeleted;
	
	
	public String getStorageType() {
		return storageType;
	}
	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDistId() {
		return distId;
	}
	public void setDistId(Integer distId) {
		this.distId = distId;
	}
	
	public BigInteger getStorageCapacity() {
		return storageCapacity;
	}
	public void setStorageCapacity(BigInteger storageCapacity) {
		this.storageCapacity = storageCapacity;
	}
	public Integer getDistanceFromFPC() {
		return distanceFromFPC;
	}
	public void setDistanceFromFPC(Integer distanceFromFPC) {
		this.distanceFromFPC = distanceFromFPC;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public Integer getFpoRefId() {
		return fpoRefId;
	}
	public void setFpoRefId(Integer fpoRefId) {
		this.fpoRefId = fpoRefId;
	}
	public Integer getBlockId() {
		return blockId;
	}
	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getMasterId() {
		return masterId;
	}
	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
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
	public String getFascilities() {
		return fascilities;
	}
	public void setFascilities(String fascilities) {
		this.fascilities = fascilities;
	}
	public String getLattitude() {
		return lattitude;
	}
	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getIsseedprocessingunit() {
		return isseedprocessingunit;
	}
	public void setIsseedprocessingunit(String isseedprocessingunit) {
		this.isseedprocessingunit = isseedprocessingunit;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
