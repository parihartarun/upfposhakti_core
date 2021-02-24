package com.upfpo.app.dto;

import java.util.ArrayList;
import java.util.List;

public class CropFilterDto {

	private String name;
	private Integer id;
	private List<CropVerietyFilterDto> cropVeriety;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public CropFilterDto() {
		super();
	}
	public CropFilterDto(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}
	public CropFilterDto(String name, Integer id, List<CropVerietyFilterDto> cropVeriety) {
		
		this.name = name;
		this.id = id;
		this.cropVeriety = cropVeriety;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	public List<CropVerietyFilterDto> getCropVeriety() {
		return cropVeriety;
	}
	public void setCropVeriety(List<CropVerietyFilterDto> cropVeriety) {
		this.cropVeriety = cropVeriety;
	}
	
}
