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
	private List<Integer> districtIds;
	private List<String> inputSuppliersCategories;
	private List<Integer> inputSupplierIds;
	private List<Integer> fertilizerTypeIds;
	private List<String> brands;
	private List<Integer> machineryTypes;
	private Integer qtymin;
	private Integer qtymax;
	private Integer rentPerHour;
	@NotNull(message="limit key must not be empty.")
	private Integer limit;
	@NotNull(message="page key must not be empty.")
	private Integer page;
	


	
	public List<String> getBrands() {
		return brands;
	}
	public void setBrands(List<String> brands) {
		this.brands = brands;
	}
	public List<Integer> getMachineryTypes() {
		return machineryTypes;
	}
	public void setMachineryTypes(List<Integer> machineryTypes) {
		this.machineryTypes = machineryTypes;
	}
	public Integer getRentPerHour() {
		return rentPerHour;
	}
	public void setRentPerHour(Integer rentPerHour) {
		this.rentPerHour = rentPerHour;
	}

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
	
	public List<Integer> getInputSupplierIds() {
		return inputSupplierIds;
	}
	public void setInputSupplierIds(List<Integer> inputSupplierIds) {
		this.inputSupplierIds = inputSupplierIds;
	}
	public List<Integer> getFertilizerTypeIds() {
		return fertilizerTypeIds;
	}
	public void setFertilizerTypeIds(List<Integer> fertilizerTypeIds) {
		this.fertilizerTypeIds = fertilizerTypeIds;
	}
	public List<String> getInputSuppliersCategories() {
		return inputSuppliersCategories;
	}
	public void setInputSuppliersCategories(List<String> inputSuppliersCategories) {
		this.inputSuppliersCategories = inputSuppliersCategories;
	}
	public SearchRequestDto(@NotNull(message = "In key must not be empty.") String in,
			@NotNull(message = "Value key must not be empty.") String val, List<Integer> fpoIds, List<Integer> cropIds,
			List<Integer> cropverietyIds, List<Integer> districtIds, List<String> inputSuppliersCategories,
			List<Integer> inputSupplierIds, List<Integer> fertilizerTypeIds, List<String> brands,
			List<Integer> machineryTypes, Integer qtymin, Integer qtymax, Integer rentPerHour,
			@NotNull(message = "limit key must not be empty.") Integer limit,
			@NotNull(message = "page key must not be empty.") Integer page) {
		super();
		this.in = in;
		this.val = val;
		this.fpoIds = fpoIds;
		this.cropIds = cropIds;
		this.cropverietyIds = cropverietyIds;
		this.districtIds = districtIds;
		this.inputSuppliersCategories = inputSuppliersCategories;
		this.inputSupplierIds = inputSupplierIds;
		this.fertilizerTypeIds = fertilizerTypeIds;
		this.brands = brands;
		this.machineryTypes = machineryTypes;
		this.qtymin = qtymin;
		this.qtymax = qtymax;
		this.rentPerHour = rentPerHour;
		this.limit = limit;
		this.page = page;
	}
	
	

	
	
	
	
	
}
