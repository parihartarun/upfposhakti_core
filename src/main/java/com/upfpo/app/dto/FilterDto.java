package com.upfpo.app.dto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;



public class FilterDto {

     public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public FilterDto(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public FilterDto() {
		super();
	}
	
	private String  name;
	private Integer id;
	 
}
