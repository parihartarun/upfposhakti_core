package com.upfpo.app.dto;

import com.upfpo.app.entity.Status;

import java.util.Calendar;
import java.util.Date;

public class FarmerComplaintDTO {

	private Integer id;
	private Integer fpoid;
	private String issuetype;
	private String role;
	private String status;
	private String message;
	private String description;
	private String filepath;
	//private Calendar createdate;
	private String othertype;
	private String assignto;
	private String assignby;
	private String deptcomment;
	private String remarks;
	private String filename;
	private String fponame;
	private String fpoemail;
	public FarmerComplaintDTO(Integer id, Integer fpoid, String issuetype, String role, String status, String message,
			String description, String filepath, String othertype, String assignto, String assignby,
			String deptcomment, String remarks, String filename, String fponame, String fpoemail) {
		super();
		this.id = id;
		this.fpoid = fpoid;
		this.issuetype = issuetype;
		this.role = role;
		this.status = status;
		this.message = message;
		this.description = description;
		this.filepath = filepath;
		//this.createdate = createdate;
		this.othertype = othertype;
		this.assignto = assignto;
		this.assignby = assignby;
		this.deptcomment = deptcomment;
		this.remarks = remarks;
		this.filename = filename;
		this.fponame = fponame;
		this.fpoemail = fpoemail;
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
	public String getIssuetype() {
		return issuetype;
	}
	public void setIssuetype(String issuetype) {
		this.issuetype = issuetype;
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
//	public Calendar getCreatedate() {
//		return createdate;
//	}
//	public void setCreatedate(Calendar createdate) {
//		this.createdate = createdate;
//	}
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
	public String getFponame() {
		return fponame;
	}
	public void setFponame(String fponame) {
		this.fponame = fponame;
	}
	public String getFpoemail() {
		return fpoemail;
	}
	public void setFpoemail(String fpoemail) {
		this.fpoemail = fpoemail;
	}
}
