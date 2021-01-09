package com.upfpo.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "panchayats")
public class Panchayats implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="panchayat_id")
	private Integer panchayat_id;
	
	@Column(name="panchayat_name")
	private String panchayat_name;
	
	@Column(name="panchayat_name_hi")
	private String panchayatNameHi;
	
	@Column(name="block_id")
	private Integer blockRef;
	
	@Column(name="sub_district_id")
	private Integer subDistId;
	
	@Column(name="district_id")
	private Integer distId;


	
	
	
	public Integer getPanchayat_id() {
		return panchayat_id;
	}

	public void setPanchayat_id(Integer panchayat_id) {
		this.panchayat_id = panchayat_id;
	}

	public String getPanchayat_name() {
		return panchayat_name;
	}

	public void setPanchayat_name(String panchayat_name) {
		this.panchayat_name = panchayat_name;
	}

	public String getPanchayatNameHi() {
		return panchayatNameHi;
	}

	public void setPanchayatNameHi(String panchayatNameHi) {
		this.panchayatNameHi = panchayatNameHi;
	}

	public Integer getBlockRef() {
		return blockRef;
	}

	public void setBlockRef(Integer blockRef) {
		this.blockRef = blockRef;
	}

	public Integer getSubDistId() {
		return subDistId;
	}

	public void setSubDistId(Integer subDistId) {
		this.subDistId = subDistId;
	}

	public Integer getDistId() {
		return distId;
	}

	public void setDistId(Integer distId) {
		this.distId = distId;
	}
	
}
