package com.upfpo.app.dto.search;

public class FpoServiceSearchDto {

	private Integer id;
	private Integer vendorid;
	private String vendorname;
	private Integer districtid;
	private String district;
	private String servicename;
	private String description;
	
	
	
	
	
	public FpoServiceSearchDto() {
		super();
	}
	public FpoServiceSearchDto(Integer id, Integer vendorid, String vendorname, Integer districtid, String district,
			String servicename, String description) {
		super();
		this.id = id;
		this.vendorid = vendorid;
		this.vendorname = vendorname;
		this.districtid = districtid;
		this.district = district;
		this.servicename = servicename;
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
