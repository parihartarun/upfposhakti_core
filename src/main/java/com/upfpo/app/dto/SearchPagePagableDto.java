package com.upfpo.app.dto;

import java.util.List;

public class SearchPagePagableDto {


	private Integer totalElements;
	private List<SearchResponseDto> page;
	
	public SearchPagePagableDto() {
		super();
	
		
	}
	public SearchPagePagableDto(Integer totalElements, List<SearchResponseDto> page) {
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
	public List<SearchResponseDto> getPage() {
		return page;
	}
	public void setPage(List<SearchResponseDto> page) {
		this.page = page;
	}
	
}
