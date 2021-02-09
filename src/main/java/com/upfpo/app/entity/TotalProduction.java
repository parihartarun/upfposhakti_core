package com.upfpo.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="total_production")
public class TotalProduction implements Serializable {
	
	private static final long serialVersionUID = -6418872506669794191L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pid")
	private Integer pid;
	
	@Column(name="total_production")
	private Double totalProduction;
	
	@Column(name="total_marketable")
	private Double totalMarketable; 
	
	@Column(name="total_sold")
	private Double totalSold;
	
	
	@Column(name="total_actual_prod")
	private Double total_actual_prod;
	
	@Column(name="total_expected_prod")
	private Double total_expected_prod;
	
	@Column(name="total_sowing")
	private Double total_sowing;
   
	 @OneToOne(cascade = CascadeType.MERGE)
	 @JoinColumn(name = "crop_id", referencedColumnName = "id")
	 private CropMaster cropMaster;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "veriety_id", referencedColumnName = "veriety_id")
	private CropVerietyMaster cropVerityMaster;

	@Column(name="fpo_id")
	private Integer fpoRegister;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "farmer_id", referencedColumnName = "farmer_id")
	private FarmerMaster farmerMaster;
	
	@Column(name = "marketable_surplus_id")
	private Integer marketableSurplusId;

	public TotalProduction() {
		
	}


	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Double getTotalProduction() {
		return totalProduction;
	}

	public void setTotalProduction(Double totalProduction) {
		this.totalProduction = totalProduction;
	}

	public Double getTotalMarketable() {
		return totalMarketable;
	}

	public void setTotalMarketable(Double totalMarketable) {
		this.totalMarketable = totalMarketable;
	}

	public Double getTotalSold() {
		return totalSold;
	}

	public void setTotalSold(Double totalSold) {
		this.totalSold = totalSold;
	}

	public Double getTotal_actual_prod() {
		return total_actual_prod;
	}

	public void setTotal_actual_prod(Double total_actual_prod) {
		this.total_actual_prod = total_actual_prod;
	}

	public Double getTotal_expected_prod() {
		return total_expected_prod;
	}

	public void setTotal_expected_prod(Double total_expected_prod) {
		this.total_expected_prod = total_expected_prod;
	}

	public Double getTotal_sowing() {
		return total_sowing;
	}

	public void setTotal_sowing(Double total_sowing) {
		this.total_sowing = total_sowing;
	}

	public CropMaster getCropMaster() {
		return cropMaster;
	}

	public void setCropMaster(CropMaster cropMaster) {
		this.cropMaster = cropMaster;
	}

	public CropVerietyMaster getCropVerityMaster() {
		return cropVerityMaster;
	}

	public void setCropVerityMaster(CropVerietyMaster cropVerityMaster) {
		this.cropVerityMaster = cropVerityMaster;
	}

	public Integer getFpoRegister() {
		return fpoRegister;
	}

	public void setFpoRegister(Integer fpoRegister) {
		this.fpoRegister = fpoRegister;
	}

	public FarmerMaster getFarmerMaster() {
		return farmerMaster;
	}

	public void setFarmerMaster(FarmerMaster farmerMaster) {
		this.farmerMaster = farmerMaster;
	}


	public Integer getMarketableSurplusId() {
		return marketableSurplusId;
	}


	public void setMarketableSurplusId(Integer marketableSurplusId) {
		this.marketableSurplusId = marketableSurplusId;
	}


	
	
	
}
