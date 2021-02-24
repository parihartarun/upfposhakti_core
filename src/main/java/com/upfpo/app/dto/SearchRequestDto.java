package com.upfpo.app.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class SearchRequestDto {

	public SearchRequestDto() {
		super();
	}
	public SearchRequestDto(@NotNull(message = "In key must not be empty.") String in,
			@NotNull(message = "Value key must not be empty.") String val, List<Integer> fpoIds,
			List<Integer> cropverietyIds, List<Integer> quantity, List<Integer> districtIds, Integer limit,
			Integer page) {
		super();
		this.in = in;
		this.val = val;
		this.fpoIds = fpoIds;
		this.cropverietyIds = cropverietyIds;
		this.quantity = quantity;
		this.districtIds = districtIds;
		this.limit = limit;
		this.page = page;
	}
	
	@NotNull(message="In key must not be empty.")
	private String in;
	@NotNull(message="Value key must not be empty.")
	private String val;
	private List<Integer> fpoIds;
	private List<Integer> cropverietyIds;
	private List<Integer> quantity;
	private List<Integer> districtIds;
	private Integer limit;
	private Integer page;
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
	public List<Integer> getQuantity() {
		return quantity;
	}
	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}
	public List<Integer> getDistrictIds() {
		return districtIds;
	}
	public void setDistrictIds(List<Integer> districtIds) {
		this.districtIds = districtIds;
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
