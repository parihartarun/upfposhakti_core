package com.upfpo.app.dto;

public class UpAgriDataDto {
	private Integer district_id;
	private String district_name;
	private Integer block_id;
	private String block_name;
	private Integer village_id;
	private String village_name;
	
	public UpAgriDataDto(Integer district_id, String district_name, Integer block_id, String block_name,
			Integer village_id, String village_name) {
		super();
		this.district_id = district_id;
		this.district_name = district_name;
		this.block_id = block_id;
		this.block_name = block_name;
		this.village_id = village_id;
		this.village_name = village_name;
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
	public Integer getBlock_id() {
		return block_id;
	}
	public void setBlock_id(Integer block_id) {
		this.block_id = block_id;
	}
	public String getBlock_name() {
		return block_name;
	}
	public void setBlock_name(String block_name) {
		this.block_name = block_name;
	}
	public Integer getVillage_id() {
		return village_id;
	}
	public void setVillage_id(Integer village_id) {
		this.village_id = village_id;
	}
	public String getVillage_name() {
		return village_name;
	}
	public void setVillage_name(String village_name) {
		this.village_name = village_name;
	}
}
