package com.upfpo.app.dto.search;

public class FpoServiceSearchDto {

	private Integer id;
	private Integer vendorid;
	private String vendorname;
	private Integer districtid;
	private String districtname;
	private String servicename;
	private String description;
	
	
	
	
	
	public FpoServiceSearchDto() {
		super();
	}
	public FpoServiceSearchDto(Integer id, Integer vendorid, String vendorname, Integer districtid, String districtname,
			String servicename, String description) {
		super();
		this.id = id;
		this.vendorid = vendorid;
		this.vendorname = vendorname;
		this.districtid = districtid;
		this.districtname = districtname;
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
	public String getDistrictname() {
		return districtname;
	}
	public void setDistrictname(String districtname) {
		this.districtname = districtname;
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
