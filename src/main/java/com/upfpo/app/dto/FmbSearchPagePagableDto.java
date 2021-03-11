package com.upfpo.app.dto;

import java.util.List;

import com.upfpo.app.dto.search.FmbSearchDtoAll;

public class FmbSearchPagePagableDto {
	
	public FmbSearchPagePagableDto() {
		super();
	}
	public FmbSearchPagePagableDto(Integer totalElements, List<FmbSearchDtoAll> page) {
		super();
		this.totalElements = totalElements;
		this.page = page;
	}
	public Integer getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}
	public List<FmbSearchDtoAll> getPage() {
		return page;
	}
	public void setPage(List<FmbSearchDtoAll> page) {
		this.page = page;
	}
	private Integer totalElements;
	private List<FmbSearchDtoAll> page;
}
