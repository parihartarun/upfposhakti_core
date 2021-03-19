package com.upfpo.app.dto.search;

public class InputSupplierSearchDtoAll {

	
	private Integer id;
	private String  itemname;
	private String  itemtype;
	private Double  quantity;
	private Integer inputsupplierid;
	private String  inputsupplier;
	private Integer  districtid;
	private String  district;
	private String  imagepath;
	private String  manufacturer;
	private String  crop;
	private Integer cropid;
	private String  cropveriety;
	private Integer cropverietyid;
	private String  recordtype;
	private String  role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getItemtype() {
		return itemtype;
	}
	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Integer getInputsupplierid() {
		return inputsupplierid;
	}
	public void setInputsupplierid(Integer inputsupplierid) {
		this.inputsupplierid = inputsupplierid;
	}
	public String getInputsupplier() {
		return inputsupplier;
	}
	public void setInputsupplier(String inputsupplier) {
		this.inputsupplier = inputsupplier;
	}
	public Integer getDistrictid() {
		return districtid;
	}
	public void setDistrictid(Integer districtid) {
		this.districtid = districtid;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getCrop() {
		return crop;
	}
	public void setCrop(String crop) {
		this.crop = crop;
	}
	public Integer getCropid() {
		return cropid;
	}
	public void setCropid(Integer cropid) {
		this.cropid = cropid;
	}
	public String getCropveriety() {
		return cropveriety;
	}
	public void setCropveriety(String cropveriety) {
		this.cropveriety = cropveriety;
	}
	public Integer getCropverietyid() {
		return cropverietyid;
	}
	public void setCropverietyid(Integer cropverietyid) {
		this.cropverietyid = cropverietyid;
	}
	public InputSupplierSearchDtoAll(Integer id, String itemname, String itemtype, Double quantity,
			Integer inputsupplierid, String inputsupplier, Integer districtid, String district, String imagepath,
			String manufacturer, String crop, Integer cropid, String cropveriety, Integer cropverietyid,
			String recordtype,String role) {
		super();
		this.id = id;
		this.itemname = itemname;
		this.itemtype = itemtype;
		this.quantity = quantity;
		this.inputsupplierid = inputsupplierid;
		this.inputsupplier = inputsupplier;
		this.districtid = districtid;
		this.district = district;
		this.imagepath = imagepath;
		this.manufacturer = manufacturer;
		this.crop = crop;
		this.cropid = cropid;
		this.cropveriety = cropveriety;
		this.cropverietyid = cropverietyid;
		this.recordtype = recordtype;
		this.role = role;
	}
	
	public InputSupplierSearchDtoAll() {
		super();
	}
	public String getRecordtype() {
		return recordtype;
	}
	public void setRecordtype(String recordtype) {
		this.recordtype = recordtype;
	}
	
	
	

	

	
	
}
