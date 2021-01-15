package com.upfpo.app.entity;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name ="fpo")
public class FPORegister implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fpo_id")
	private Integer fpoId;
	
	@Column (name="state_ref")
	private Integer stateref;
	
	@Column(name = "dist_ref_id")
	private Integer distRefId;
	
	@Column(name="agency_associated")
	private String agency;
	
	@Column(name="pincode")
	private Integer pincode;
	
	@Column(name="blockId")
	private Integer blockRef;
	
	@Column(name="delete_date")
	private java.sql.Date deleteDate;

	@Column(name="is_deleted")
	private boolean isDeleted;

	
    public java.sql.Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(java.sql.Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getFpoId() {
		return fpoId;
	}

	public void setFpoId(Integer fpoId) {
		this.fpoId = fpoId;
	}

	public Integer getStateref() {
		return stateref;
	}

	public void setStateref(Integer stateref) {
		this.stateref = stateref;
	}

	public Integer getDistRefId() {
		return distRefId;
	}

	public void setDistRefId(Integer distRefId) {
		this.distRefId = distRefId;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Integer getBlockRef() {
		return blockRef;
	}

	public void setBlockRef(Integer blockRef) {
		this.blockRef = blockRef;
	}
	
}

