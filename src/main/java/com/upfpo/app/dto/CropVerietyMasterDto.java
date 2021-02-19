package com.upfpo.app.dto;

public class CropVerietyMasterDto {
	private Integer verietyId;
	private String verityName;
	public CropVerietyMasterDto(Integer verietyId, String verityName) {
		super();
		this.verietyId = verietyId;
		this.verityName = verityName;
	}
	public Integer getVerietyId() {
		return verietyId;
	}
	public void setVerietyId(Integer verietyId) {
		this.verietyId = verietyId;
	}
	public String getVerityName() {
		return verityName;
	}
	public void setVerityName(String verityName) {
		this.verityName = verityName;
	}
	
}
