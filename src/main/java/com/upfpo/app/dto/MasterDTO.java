package com.upfpo.app.dto;

public class MasterDTO 
{
	private Integer id;
	
	private String blockName;
	
	public MasterDTO(Integer id, String blockName) {
		super();
		this.id = id;
		this.blockName = blockName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	
}
