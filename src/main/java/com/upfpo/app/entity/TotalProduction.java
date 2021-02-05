package com.upfpo.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="current_marketable")
	private Double currentMarketable;

	public TotalProduction(Integer pid, Double totalProduction, Double totalMarketable, Double totalSold,
			Double currentMarketable) {
		super();
		this.pid = pid;
		this.totalProduction = totalProduction;
		this.totalMarketable = totalMarketable;
		this.totalSold = totalSold;
		this.currentMarketable = currentMarketable;
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

	public Double getCurrentMarketable() {
		return currentMarketable;
	}

	public void setCurrentMarketable(Double currentMarketable) {
		this.currentMarketable = currentMarketable;
	}
	
	
	

}
