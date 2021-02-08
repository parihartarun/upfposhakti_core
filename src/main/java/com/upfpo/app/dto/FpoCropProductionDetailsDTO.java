package com.upfpo.app.dto;

public class FpoCropProductionDetailsDTO {
	private String season_name;

	private String category;

	private String crop_name;

	private Integer id;

	private Double marketable_quantity;

	private Double actual_quantity;

	private String financial_year;

	private String crop_variety;

	public FpoCropProductionDetailsDTO(String season_name, String category, String crop_name, Integer id,
			Double marketable_quantity, Double actual_quantity, String financial_year, String crop_variety) {
		super();
		this.season_name = season_name;
		this.category = category;
		this.crop_name = crop_name;
		this.id = id;
		this.marketable_quantity = marketable_quantity;
		this.actual_quantity = actual_quantity;
		this.financial_year = financial_year;
		this.crop_variety = crop_variety;
	}

	public String getSeason_name() {
		return season_name;
	}

	public void setSeason_name(String season_name) {
		this.season_name = season_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCrop_name() {
		return crop_name;
	}

	public void setCrop_name(String crop_name) {
		this.crop_name = crop_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getMarketable_quantity() {
		return marketable_quantity;
	}

	public void setMarketable_quantity(Double marketable_quantity) {
		this.marketable_quantity = marketable_quantity;
	}

	public Double getActual_quantity() {
		return actual_quantity;
	}

	public void setActual_quantity(Double actual_quantity) {
		this.actual_quantity = actual_quantity;
	}

	public String getFinancial_year() {
		return financial_year;
	}

	public void setFinancial_year(String financial_year) {
		this.financial_year = financial_year;
	}

	public String getCrop_variety() {
		return crop_variety;
	}

	public void setCrop_variety(String crop_variety) {
		this.crop_variety = crop_variety;
	}

}
