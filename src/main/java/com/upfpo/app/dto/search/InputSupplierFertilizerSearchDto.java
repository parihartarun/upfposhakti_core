package com.upfpo.app.dto.search;

import java.math.BigInteger;

import javax.persistence.ColumnResult;

public class InputSupplierFertilizerSearchDto {

	
	private Integer id;
	private Integer  itemnameid;
	private String  itemname;
	private String  grade;
	private Integer itemtypeid;
	private String  itemtype;
	private Double  quantity;
	private Integer vendorid;
	private String  vendorname;
	private String 	vendorEmail;
	private Integer  districtid;
	private String  district;
	private String  imagepath;
	private String  manufacturer;
	private String  crop;
	private Integer cropid;
	private String  cropveriety;
	private Integer cropverietyid;
	private String  recordtype;
	private String roleid;
	private String  role;
    private BigInteger userid;
    
	
	public BigInteger getUserid() {
		return userid;
	}
	public void setUserid(BigInteger userid) {
		this.userid = userid;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
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
	public Integer getItemtypeid() {
		return itemtypeid;
	}
	public void setItemtypeid(Integer itemtypeid) {
		this.itemtypeid = itemtypeid;
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
	public Integer getVendorid() {
		return vendorid;
	}
	public void setVendorid(Integer vendorid) {
		this.vendorid = vendorid;
	}
	public String getVendorname() {
		return vendorname;
	}
	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
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

	
	public Integer getItemnameid() {
		return itemnameid;
	}
	public void setItemnameid(Integer itemnameid) {
		this.itemnameid = itemnameid;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getRecordtype() {
		return recordtype;
	}
	public void setRecordtype(String recordtype) {
		this.recordtype = recordtype;
	}
	
	public String getVendorEmail() {
		return vendorEmail;
	}
	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}
	public InputSupplierFertilizerSearchDto() {
		super();
	}
	public InputSupplierFertilizerSearchDto(Integer id, Integer itemnameid, String itemname,
			Integer itemtypeid, String itemtype, Double quantity, Integer vendorid, String vendorname, String vendoremail,
			Integer districtid, String district, String imagepath, String manufacturer, String crop, Integer cropid,
			String cropveriety, Integer cropverietyid, String recordtype, String role,String roleid, String grade,BigInteger userid) {
		super();
		this.id = id;
		this.itemnameid = itemnameid;
		this.itemname = itemname;
		this.grade = grade;
		this.itemtypeid = itemtypeid;
		this.itemtype = itemtype;
		this.quantity = quantity;
		this.vendorid = vendorid;
		this.vendorname = vendorname;
		this.vendorEmail = vendoremail;
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
		this.roleid=roleid;
		this.userid = userid;
	}	
	
}
