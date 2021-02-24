package com.upfpo.app.dto;

import java.util.List;

public class SearchPagePagableDto {

	private Integer pageNumber;
	private Integer size;
	private Integer totalSize;
	private List<SearchResponseDto> page;
	
	public SearchPagePagableDto() {
		super();
	}
	public SearchPagePagableDto(Integer pageNumber, Integer size, Integer totalSize, List<SearchResponseDto> page) {
		super();
		this.pageNumber = pageNumber;
		this.size = size;
		this.totalSize = totalSize;
		this.page = page;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	public List<SearchResponseDto> getPage() {
		return page;
	}
	public void setPage(List<SearchResponseDto> page) {
		this.page = page;
	}
	
}
