package com.upfpo.app.dto;

import java.math.BigInteger;

public class CollectionCenterDTO 
{
	private Integer collectionId;
	
	private String address;
	
	private Integer blockId;
	
	private String blockName;
	
	private Integer district_id;
	
	private String district_name;
	
	private String fascilities;
	
	private Integer masterId;
	
	private String isseedprocessingunit;
	
	private Integer state_ref_id;
	
	private BigInteger storageCapacity;
	
	private String storageType;
	
	private String updatedBy;
	
	

	public Integer getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getBlockId() {
		return blockId;
	}

	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public Integer getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(Integer district_id) {
		this.district_id = district_id;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	public String getFascilities() {
		return fascilities;
	}

	public void setFascilities(String fascilities) {
		this.fascilities = fascilities;
	}

	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public String getIsseedprocessingunit() {
		return isseedprocessingunit;
	}

	public void setIsseedprocessingunit(String isseedprocessingunit) {
		this.isseedprocessingunit = isseedprocessingunit;
	}

	public Integer getState_ref_id() {
		return state_ref_id;
	}

	public void setState_ref_id(Integer state_ref_id) {
		this.state_ref_id = state_ref_id;
	}

	public BigInteger getStorageCapacity() {
		return storageCapacity;
	}

	public void setStorageCapacity(BigInteger storageCapacity) {
		this.storageCapacity = storageCapacity;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public CollectionCenterDTO(Integer collectionId, String address, Integer blockId, String blockName,
			Integer district_id, String district_name, String fascilities, Integer masterId,
			String isseedprocessingunit, Integer state_ref_id, BigInteger storageCapacity, String storageType,
			String updatedBy) {
		super();
		this.collectionId = collectionId;
		this.address = address;
		this.blockId = blockId;
		this.blockName = blockName;
		this.district_id = district_id;
		this.district_name = district_name;
		this.fascilities = fascilities;
		this.masterId = masterId;
		this.isseedprocessingunit = isseedprocessingunit;
		this.state_ref_id = state_ref_id;
		this.storageCapacity = storageCapacity;
		this.storageType = storageType;
		this.updatedBy = updatedBy;
	}


	
}
