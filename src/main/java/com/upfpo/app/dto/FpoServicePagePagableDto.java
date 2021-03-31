package com.upfpo.app.dto;

import java.util.List;

import com.upfpo.app.dto.search.FmbSearchDtoAll;
import com.upfpo.app.dto.search.FpoServiceSearchDto;
import com.upfpo.app.dto.search.InputSupplierSearchDtoAll;

public class FpoServicePagePagableDto {

	public FpoServicePagePagableDto() {
		super();
	}
	public FpoServicePagePagableDto(Integer totalElements, List<FpoServiceSearchDto> page) {
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
	public List<FpoServiceSearchDto> getPage() {
		return page;
	}
	public void setPage(List<FpoServiceSearchDto> page) {
		this.page = page;
	}
	private Integer totalElements;
	private List<FpoServiceSearchDto> page;
}
