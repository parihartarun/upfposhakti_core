package com.upfpo.app.dto;

import java.util.List;

import com.upfpo.app.dto.search.FmbSearchDtoAll;
import com.upfpo.app.dto.search.InputSupplierSearchDtoAll;

public class InputSupplierPagePagableDto {

	public InputSupplierPagePagableDto() {
		super();
	}
	public InputSupplierPagePagableDto(Integer totalElements, List<InputSupplierSearchDtoAll> page) {
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
	public List<InputSupplierSearchDtoAll> getPage() {
		return page;
	}
	public void setPage(List<InputSupplierSearchDtoAll> page) {
		this.page = page;
	}
	private Integer totalElements;
	private List<InputSupplierSearchDtoAll> page;
}
