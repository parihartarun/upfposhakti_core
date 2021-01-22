package com.upfpo.app.entity;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="home_page_data")
public class DashBoardData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="land")
	private Integer land;
	
	@Column(name="farmers")
	private Integer farmers;
	
	@Column(name="small_farmers")
	private Integer smallFarmers;
	
	@Column(name="marginal_farmers")
	private Integer marginalFarmers;
	
	@Column(name="oth_farmers")
	private Integer otherFarmers;
	
	@Column(name="fpcs")
	private String fpcs;
	
	@Column(name="fmbs")
	private BigInteger fmbs;
	
	@Column(name="storage_centers")
	private BigInteger storagecenters;
	
	@Column(name="production_rabi")
	private Integer production_rabi;
	
	@Column(name="production_kharif")
	private Integer production_kharif;
	
	@Column(name="production_zayad")
	private Integer production_zayad;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLand() {
		return land;
	}
	public void setLand(Integer land) {
		this.land = land;
	}
	public Integer getFarmers() {
		return farmers;
	}
	public void setFarmers(Integer farmers) {
		this.farmers = farmers;
	}
	public Integer getSmallFarmers() {
		return smallFarmers;
	}
	public void setSmallFarmers(Integer smallFarmers) {
		this.smallFarmers = smallFarmers;
	}
	public Integer getMarginalFarmers() {
		return marginalFarmers;
	}
	public void setMarginalFarmers(Integer marginalFarmers) {
		this.marginalFarmers = marginalFarmers;
	}
	public Integer getOtherFarmers() {
		return otherFarmers;
	}
	public void setOtherFarmers(Integer otherFarmers) {
		this.otherFarmers = otherFarmers;
	}
	public String getFpcs() {
		return fpcs;
	}
	public void setFpcs(String fpcs) {
		this.fpcs = fpcs;
	}
	public BigInteger getFmbs() {
		return fmbs;
	}
	public void setFmbs(BigInteger fmbs) {
		this.fmbs = fmbs;
	}
	public BigInteger getStoragecenters() {
		return storagecenters;
	}
	public void setStoragecenters(BigInteger storagecenters) {
		this.storagecenters = storagecenters;
	}
	public Integer getProduction_rabi() {
		return production_rabi;
	}
	public void setProduction_rabi(Integer production_rabi) {
		this.production_rabi = production_rabi;
	}
	public Integer getProduction_kharif() {
		return production_kharif;
	}
	public void setProduction_kharif(Integer production_kharif) {
		this.production_kharif = production_kharif;
	}
	public Integer getProduction_zayad() {
		return production_zayad;
	}
	public void setProduction_zayad(Integer production_zayad) {
		this.production_zayad = production_zayad;
	}

}
