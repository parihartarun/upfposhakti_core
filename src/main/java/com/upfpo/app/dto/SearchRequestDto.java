package com.upfpo.app.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class SearchRequestDto {

	public SearchRequestDto() {
	
	}

	
	@NotNull(message="In key must not be empty.")
	private String in;
	@NotNull(message="Value key must not be empty.")
	private String val;
	private List<Integer> fpoIds;
	private List<Integer> cropIds;
	private List<Integer> cropverietyIds;
	private Integer qtymin;
	private Integer qtymax;
	private List<Integer> districtIds;
	@NotNull(message="limit key must not be empty.")
	private Integer limit;
	@NotNull(message="page key must not be empty.")
	private Integer page;
	


	
	public List<Integer> getCropIds() {
		return cropIds;
	}
	public void setCropIds(List<Integer> cropIds) {
		this.cropIds = cropIds;
	}
	public String getIn() {
		return in;
	}
	public void setIn(String in) {
		this.in = in;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public List<Integer> getFpoIds() {
		return fpoIds;
	}
	public void setFpoIds(List<Integer> fpoIds) {
		this.fpoIds = fpoIds;
	}
	public List<Integer> getCropverietyIds() {
		return cropverietyIds;
	}
	public void setCropverietyIds(List<Integer> cropverietyIds) {
		this.cropverietyIds = cropverietyIds;
	}

	public List<Integer> getDistrictIds() {
		return districtIds;
	}
	public void setDistrictIds(List<Integer> districtIds) {
		this.districtIds = districtIds;
	}
	
	public SearchRequestDto(@NotNull(message = "In key must not be empty.") String in,
			@NotNull(message = "Value key must not be empty.") String val, List<Integer> fpoIds, List<Integer> cropIds,
			List<Integer> cropverietyIds, Integer qtymin, Integer qtymax, List<Integer> districtIds,
			@NotNull(message = "limit key must not be empty.") Integer limit,
			@NotNull(message = "page key must not be empty.") Integer page) {
		super();
		this.in = in;
		this.val = val;
		this.fpoIds = fpoIds;
		this.cropIds = cropIds;
		this.cropverietyIds = cropverietyIds;
		this.qtymin = qtymin;
		this.qtymax = qtymax;
		this.districtIds = districtIds;
		this.limit = limit;
		this.page = page;
	}
	public Integer getQtymin() {
		return qtymin;
	}
	public void setQtymin(Integer qtymin) {
		this.qtymin = qtymin;
	}
	public Integer getQtymax() {
		return qtymax;
	}
	public void setQtymax(Integer qtymax) {
		this.qtymax = qtymax;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
}
