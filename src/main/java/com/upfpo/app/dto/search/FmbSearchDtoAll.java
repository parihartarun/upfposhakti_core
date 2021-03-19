package com.upfpo.app.dto.search;

public class FmbSearchDtoAll {

	private Integer vendorid; 
	private String vendorname;
	private String imagepath; 
	private String company;
	private Integer machinetypeid;
	private String machinetype;
	private Integer quantity;
	private Integer districtid;
	private String district;
	private Double rent;
	private Integer machinenameid;
	private String machinename;
	private String recordtype;
	private String role;
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public FmbSearchDtoAll() {
		super();
	}
	public FmbSearchDtoAll(Integer vendorid, String vendorname, String imagepath, String company, Integer machinetypeid,
			String machinetype, Integer quantity, Integer districtid, String district, Double rent,
			Integer machinenameid, String machinename, String recordtype,String role) {
		super();
		this.vendorid = vendorid;
		this.vendorname = vendorname;
		this.imagepath = imagepath;
		this.company = company;
		this.machinetypeid = machinetypeid;
		this.machinetype = machinetype;
		this.quantity = quantity;
		this.districtid = districtid;
		this.district = district;
		this.rent = rent;
		this.machinenameid = machinenameid;
		this.machinename = machinename;
		this.recordtype = recordtype;
		this.role = role;
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
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getMachinetypeid() {
		return machinetypeid;
	}
	public void setMachinetypeid(Integer machinetypeid) {
		this.machinetypeid = machinetypeid;
	}
	public String getMachinetype() {
		return machinetype;
	}
	public void setMachinetype(String machinetype) {
		this.machinetype = machinetype;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	public Double getRent() {
		return rent;
	}
	public void setRent(Double rent) {
		this.rent = rent;
	}
	public Integer getMachinenameid() {
		return machinenameid;
	}
	public void setMachinenameid(Integer machinenameid) {
		this.machinenameid = machinenameid;
	}
	public String getMachinename() {
		return machinename;
	}
	public void setMachinename(String machinename) {
		this.machinename = machinename;
	}
	public String getRecordtype() {
		return recordtype;
	}
	public void setRecordtype(String recordtype) {
		this.recordtype = recordtype;
	}

}
