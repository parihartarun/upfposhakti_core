package com.upfpo.app.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

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
	
	public CollectionCenter() {
		super();
	}

	public CollectionCenter(Integer id, Integer stateId, Integer distId, Integer blockId,
			@Min(value = 1, message = "Storage capacity should be greater than 0") BigInteger storageCapacity,
			Integer distanceFromFPC, Integer fpoRefId, String updatedBy, String address, String lattitude,
			String longitude, Integer masterId, Date createDate, Date updateDate, Date deleteDate, String fascilities,
			String storageType, String isseedprocessingunit, boolean isDeleted) {
		super();
		this.id = id;
		this.stateId = stateId;
		this.distId = distId;
		this.blockId = blockId;
		this.storageCapacity = storageCapacity;
		this.distanceFromFPC = distanceFromFPC;
		this.fpoRefId = fpoRefId;
		this.updatedBy = updatedBy;
		this.address = address;
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.masterId = masterId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
		this.fascilities = fascilities;
		this.storageType = storageType;
		this.isseedprocessingunit = isseedprocessingunit;
		this.isDeleted = isDeleted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getDistId() {
		return distId;
	}

	public void setDistId(Integer distId) {
		this.distId = distId;
	}

	public Integer getBlockId() {
		return blockId;
	}

	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
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

	public Integer getFpoRefId() {
		return fpoRefId;
	}

	public void setFpoRefId(Integer fpoRefId) {
		this.fpoRefId = fpoRefId;
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

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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
	
	

}
