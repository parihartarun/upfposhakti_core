package com.upfpo.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="villages")
public class VillageMaster 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "village_id")
	private Integer villageId;

	@Column(name="village_name_hi")
	private String villageNameHi;
	
	@Column(name="sub_district_id")
	private Integer subDistId;
	
	@Column(name="panchayat_id")
	private Integer panchayatId;

	@Column(name = "village_code")
	private String villageCode;

	@Column(name = "village_name")
	private String villageName;

	@Column(name = "district_id")
	private Integer distRefId;

	@Column(name="block_id")
	private Integer blockId;


	
	
	public Integer getVillageId() {
		return villageId;
	}

	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}

	public String getVillageCode() {
		return villageCode;
	}

	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public Integer getDistRefId() {
		return distRefId;
	}

	public void setDistRefId(Integer distRefId) {
		this.distRefId = distRefId;
	}
	
	public Integer getBlockId() {
		return blockId;
	}

	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}

	public String getVillageNameHi() {
		return villageNameHi;
	}

	public void setVillageNameHi(String villageNameHi) {
		this.villageNameHi = villageNameHi;
	}

	public Integer getSubDistId() {
		return subDistId;
	}

	public void setSubDistId(Integer subDistId) {
		this.subDistId = subDistId;
	}

	public Integer getPanchayatId() {
		return panchayatId;
	}

	public void setPanchayatId(Integer panchayatId) {
		this.panchayatId = panchayatId;
	}

}
