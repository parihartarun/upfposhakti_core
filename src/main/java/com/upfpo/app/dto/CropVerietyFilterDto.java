package com.upfpo.app.dto;

public class CropVerietyFilterDto {

	public CropVerietyFilterDto() {
		super();
	}
	public CropVerietyFilterDto(String verietyName, Integer verietyId) {
		super();
		this.verietyName = verietyName;
		this.verietyId = verietyId;
	}
	public String getVerietyName() {
		return verietyName;
	}
	public void setVerietyName(String verietyName) {
		this.verietyName = verietyName;
	}
	public Integer getVerietyId() {
		return verietyId;
	}
	public void setVerietyId(Integer verietyId) {
		this.verietyId = verietyId;
	}
	private String verietyName;
	private Integer verietyId;
	
}
