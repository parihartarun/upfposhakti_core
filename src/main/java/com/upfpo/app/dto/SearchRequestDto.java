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
	private Double qtymin;
	private Double qtymax;
	private Integer rentMin;
	private Integer rentMax;
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
	public Double getQtymin() {
		return qtymin;
	}
	public void setQtymin(Double qtymin) {
		this.qtymin = qtymin;
	}
	public Double getQtymax() {
		return qtymax;
	}
	public void setQtymax(Double qtymax) {
		this.qtymax = qtymax;
	}
	public Integer getRentMin() {
		return rentMin;
	}
	public void setRentMin(Integer rentMin) {
		this.rentMin = rentMin;
	}
	public Integer getRentMax() {
		return rentMax;
	}
	public void setRentMax(Integer rentMax) {
		this.rentMax = rentMax;
	}
	public SearchRequestDto(@NotNull(message = "In key must not be empty.") String in,
			@NotNull(message = "Value key must not be empty.") String val, List<Integer> fpoIds, List<Integer> cropIds,
			List<Integer> cropverietyIds, List<Integer> districtIds, List<String> inputSuppliersCategories,
			List<Integer> inputSupplierIds, List<Integer> fertilizerTypeIds, List<String> brands,
			List<Integer> machineryTypes, Double qtymin, Double qtymax, Integer rentMin, Integer rentMax,
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
		this.rentMin = rentMin;
		this.rentMax = rentMax;
		this.limit = limit;
		this.page = page;
	}

	
	

	
	
	
	
	
}
