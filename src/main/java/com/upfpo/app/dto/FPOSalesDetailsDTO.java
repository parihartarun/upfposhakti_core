package com.upfpo.app.dto;

public class FPOSalesDetailsDTO 
{
	private Integer id;
	
	private Integer season_id;
	
	private String season_name;
	
	private Integer category_id;

	private String category;
	
	private Integer crop_id;

	private String crop_name;

	private Double sold_quantity;

	private String financial_year;

	private Integer veriety_id;
	
	private String crop_variety;
	
	private Integer veriety_ref;
	
	private Integer crop_ref_name;
	
	private Integer season_ref;
	
	

	public FPOSalesDetailsDTO(Integer id, Integer season_id, String season_name, Integer category_id, String category,
			Integer crop_id, String crop_name, Double sold_quantity, String financial_year, Integer veriety_id,
			String crop_variety, Integer veriety_ref, Integer crop_ref_name, Integer season_ref) {
		super();
		this.id = id;
		this.season_id = season_id;
		this.season_name = season_name;
		this.category_id = category_id;
		this.category = category;
		this.crop_id = crop_id;
		this.crop_name = crop_name;
		this.sold_quantity = sold_quantity;
		this.financial_year = financial_year;
		this.veriety_id = veriety_id;
		this.crop_variety = crop_variety;
		this.veriety_ref = veriety_ref;
		this.crop_ref_name = crop_ref_name;
		this.season_ref = season_ref;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Double getSold_quantity() {
		return sold_quantity;
	}

	public void setSold_quantity(Double sold_quantity) {
		this.sold_quantity = sold_quantity;
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

	public Integer getVeriety_ref() {
		return veriety_ref;
	}

	public void setVeriety_ref(Integer veriety_ref) {
		this.veriety_ref = veriety_ref;
	}

	public Integer getCrop_ref_name() {
		return crop_ref_name;
	}

	public void setCrop_ref_name(Integer crop_ref_name) {
		this.crop_ref_name = crop_ref_name;
	}

	public Integer getSeason_ref() {
		return season_ref;
	}

	public void setSeason_ref(Integer season_ref) {
		this.season_ref = season_ref;
	}
	
	
}
