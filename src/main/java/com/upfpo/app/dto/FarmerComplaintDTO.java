package com.upfpo.app.dto;

import com.upfpo.app.entity.Status;

import java.util.Calendar;
import java.util.Date;

public class FarmerComplaintDTO {

    Integer id;

    Integer fpoid;

    String issuetype;

    Status status;

    String message;

    String description;

    Calendar createdate;

    String filepath;

    String role;

    String othertype;

    String assignto;

     String assignby;

     Date assigndate;

     Date resolvedate;

     String deptcomment;

     String remarks;

     String filename;

    public FarmerComplaintDTO() {
    }

    public FarmerComplaintDTO(Integer id, Integer fpoid, String issuetype, Status status, String message, String description, Calendar createdate, String filepath, String role, String othertype, String assignto, String assignby, Date assigndate, Date resolvedate, String deptcomment, String remarks, String filename) {
        this.id = id;
        this.fpoid = fpoid;
        this.issuetype = issuetype;
        this.status = status;
        this.message = message;
        this.description = description;
        this.createdate = createdate;
        this.filepath = filepath;
        this.role = role;
        this.othertype = othertype;
        this.assignto = assignto;
        this.assignby = assignby;
        this.assigndate = assigndate;
        this.resolvedate = resolvedate;
        this.deptcomment = deptcomment;
        this.remarks = remarks;
        this.filename = filename;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getAssigndate() {
        return assigndate;
    }

    public void setAssigndate(Date assigndate) {
        this.assigndate = assigndate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public Date getResolvedate() {
        return resolvedate;
    }

    public void setResolvedate(Date resolvedate) {
        this.resolvedate = resolvedate;
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

    public Calendar getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Calendar createdate) {
        this.createdate = createdate;
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
}
