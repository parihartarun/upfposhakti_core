package com.upfpo.app.dto;

public class FpoCropProductionDetailsDTO 
{
	private Integer season_id;
	
	private String season_name;
	
	private Integer category_id;

	private String category;
	
	private Integer crop_id;

	private String crop_name;

	private Integer marketable_id;

	private Double marketable_quantity;

	private Double actual_quantity;

	private String financial_year;

	private Integer veriety_id;
	
	private String crop_variety;

	public Integer getSeason_id() {
		return season_id;
	}

	public void setSeason_id(Integer season_id) {
		this.season_id = season_id;
	}

	public String getSeason_name() {
		return season_name;
	}

	public void setSeason_name(String season_name) {
		this.season_name = season_name;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getCrop_id() {
		return crop_id;
	}

	public void setCrop_id(Integer crop_id) {
		this.crop_id = crop_id;
	}

	public String getCrop_name() {
		return crop_name;
	}

	public void setCrop_name(String crop_name) {
		this.crop_name = crop_name;
	}

	public Integer getMarketable_id() {
		return marketable_id;
	}

	public void setMarketable_id(Integer marketable_id) {
		this.marketable_id = marketable_id;
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

	public Integer getVeriety_id() {
		return veriety_id;
	}

	public void setVeriety_id(Integer veriety_id) {
		this.veriety_id = veriety_id;
	}

	public String getCrop_variety() {
		return crop_variety;
	}

	public void setCrop_variety(String crop_variety) {
		this.crop_variety = crop_variety;
	}

	public FpoCropProductionDetailsDTO(Integer season_id, String season_name, Integer category_id, String category,
			Integer crop_id, String crop_name, Integer marketable_id, Double marketable_quantity,
			Double actual_quantity, String financial_year, Integer veriety_id, String crop_variety) {
		super();
		this.season_id = season_id;
		this.season_name = season_name;
		this.category_id = category_id;
		this.category = category;
		this.crop_id = crop_id;
		this.crop_name = crop_name;
		this.marketable_id = marketable_id;
		this.marketable_quantity = marketable_quantity;
		this.actual_quantity = actual_quantity;
		this.financial_year = financial_year;
		this.veriety_id = veriety_id;
		this.crop_variety = crop_variety;
	}
	
}