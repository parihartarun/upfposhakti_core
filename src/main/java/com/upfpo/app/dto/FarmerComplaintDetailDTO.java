package com.upfpo.app.dto;

import java.math.BigInteger;

public class FarmerComplaintDetailDTO {
	
	private Integer id;
	private Integer fpoid;
	private Integer farmerId;
	private String issuetype;
	private String ftitle;
	private String role;
	private String status;
	private String message;
	private String description;
	private String filepath;
	private String createdate;
	private String othertype;
	private String assignto;
	private String assignby;
	private String deptcomment;
	private String remarks;
	private String filename;
	private String assigneddate;
	private String farmername;
	private BigInteger farmermobile;
	public FarmerComplaintDetailDTO(Integer id, Integer fpoid, Integer farmerId, String issuetype, String ftitle,
			String role, String status, String message, String description, String filepath, String createdate,
			String othertype, String assignto, String assignby, String deptcomment, String remarks, String filename,
			String assigneddate, String farmername, BigInteger farmermobile) {
		super();
		this.id = id;
		this.fpoid = fpoid;
		this.farmerId = farmerId;
		this.issuetype = issuetype;
		this.ftitle = ftitle;
		this.role = role;
		this.status = status;
		this.message = message;
		this.description = description;
		this.filepath = filepath;
		this.createdate = createdate;
		this.othertype = othertype;
		this.assignto = assignto;
		this.assignby = assignby;
		this.deptcomment = deptcomment;
		this.remarks = remarks;
		this.filename = filename;
		this.assigneddate = assigneddate;
		this.farmername = farmername;
		this.farmermobile = farmermobile;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFpoid() {
		return fpoid;
	}
	public void setFpoid(Integer fpoid) {
		this.fpoid = fpoid;
	}
	public Integer getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(Integer farmerId) {
		this.farmerId = farmerId;
	}
	public String getIssuetype() {
		return issuetype;
	}
	public void setIssuetype(String issuetype) {
		this.issuetype = issuetype;
	}
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getOthertype() {
		return othertype;
	}
	public void setOthertype(String othertype) {
		this.othertype = othertype;
	}
	public String getAssignto() {
		return assignto;
	}
	public void setAssignto(String assignto) {
		this.assignto = assignto;
	}
	public String getAssignby() {
		return assignby;
	}
	public void setAssignby(String assignby) {
		this.assignby = assignby;
	}
	public String getDeptcomment() {
		return deptcomment;
	}
	public void setDeptcomment(String deptcomment) {
		this.deptcomment = deptcomment;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getAssigneddate() {
		return assigneddate;
	}
	public void setAssigneddate(String assigneddate) {
		this.assigneddate = assigneddate;
	}
	public String getFarmername() {
		return farmername;
	}
	public void setFarmername(String farmername) {
		this.farmername = farmername;
	}
	public BigInteger getFarmermobile() {
		return farmermobile;
	}
	public void setFarmermobile(BigInteger farmermobile) {
		this.farmermobile = farmermobile;
	}

}
