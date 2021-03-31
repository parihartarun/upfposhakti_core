package com.upfpo.app.dto;

import java.util.List;

import com.upfpo.app.dto.search.FmbSearchDtoAll;
import com.upfpo.app.dto.search.InputSupplierFertilizerSearchDto;
import com.upfpo.app.dto.search.InputSupplierSearchDtoAll;

public class InputSupplierFertilizersPagePagableDto {

	public InputSupplierFertilizersPagePagableDto() {
		super();
	}
	public InputSupplierFertilizersPagePagableDto(Integer totalElements, List<InputSupplierFertilizerSearchDto> page) {
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
	public List<InputSupplierFertilizerSearchDto> getPage() {
		return page;
	}
	public void setPage(List<InputSupplierFertilizerSearchDto> page) {
		this.page = page;
	}
	private Integer totalElements;
	private List<InputSupplierFertilizerSearchDto> page;
}
