package com.upfpo.app.entity;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "crop_details")
public class CropDatails implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "crop_id")
	private Integer cropId;

	@Column(name = "user_ref_id")
	private Integer userRefId;

	/*
	 * @Column(name = "guardian_name") private String guardianName;
	 */
	@Column(name = "season_ref")
	private Integer seasonRefName;

	@Column(name = "crop_ref")
	private Integer cropRefName;

	@Column(name = "veriety_ref")
	private String verietyRef;

	/*
	 * @Column(name = "sown_date_from") private String sowingDateFrom;
	 * 
	 * @Column(name = "sown_date_to") private String sowingDateTo;
	 */
	/*
	 * @Column(name = "ex_harvest_date_from") private String
	 * expectedHarvestDateFrom;
	 * 
	 * @Column(name = "ex_harvest_date_to") private String expectedHarvestDateTO;
	 */

	@Column(name = "ex_yield")
	private double expectedYield;

	@Column(name = "actual_yield")
	private double actualYield;

	@Column(name = "sowing_area")
	private Double sowingArea;

	/*
	 * @Column(name = "crop_type") private Integer cropType;
	 */

	/*
	 * @Column(name = "sustainable") private double forSustainable;
	 * 
	 * @Column(name = "for_planting") private double forPlanting;
	 */

	@Column(name = "master_id")
	private Integer masterId;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "create_date")
	private java.sql.Date createDate;

	@Column(name = "update_date")
	private java.sql.Date updateDate;

	@Column(name = "delete_date")
	private java.sql.Date deleteDate;

	@Column(name = "farmer_id")
	private Integer farmerId;
	
	@ManyToOne(cascade=CascadeType.ALL)
    private NewSowing newSowing;

	/*
	 * @Column(name = "croping_type") private String cropingType;
	 */

	@Column(name = "land_id")
	private Integer baseland;

	@Column(name = "financial_year")
	private String finYear;
	
	@Column(name="is_deleted")
    private boolean isDeleted;
   
	
	
	
	public Integer getCropId() {
		return cropId;
	}

	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}

	public Integer getUserRefId() {
		return userRefId;
	}

	public void setUserRefId(Integer userRefId) {
		this.userRefId = userRefId;
	}

	public Integer getCropRefName() {
		return cropRefName;
	}

	public void setCropRefName(Integer cropRefName) {
		this.cropRefName = cropRefName;
	}

	public String getVerietyRef() {
		return verietyRef;
	}

	public void setVerietyRef(String verietyRef) {
		this.verietyRef = verietyRef;
	}

	public double getExpectedYield() {
		return expectedYield;
	}

	public void setExpectedYield(double expectedYield) {
		this.expectedYield = expectedYield;
	}

	public Double getSowingArea() {
		return sowingArea;
	}

	public void setSowingArea(Double sowingArea) {
		this.sowingArea = sowingArea;
	}


	public double getActualYield() {
		return actualYield;
	}

	public void setActualYield(double actualYield) {
		this.actualYield = actualYield;
	}



	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public java.sql.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.sql.Date createDate) {
		this.createDate = createDate;
	}

	public java.sql.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.sql.Date updateDate) {
		this.updateDate = updateDate;
	}

	public java.sql.Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(java.sql.Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public Integer getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Integer farmerId) {
		this.farmerId = farmerId;
	}


	public Integer getBaseland() {
		return baseland;
	}

	public void setBaseland(Integer baseland) {
		this.baseland = baseland;
	}



	public Integer getSeasonRefName() {
		return seasonRefName;
	}

	public void setSeasonRefName(Integer seasonRefName) {
		this.seasonRefName = seasonRefName;
	}

	public String getFinYear() {
		return finYear;
	}

	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}


	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public NewSowing getNewSowing() {
		return newSowing;
	}

	public void setNewSowing(NewSowing newSowing) {
		this.newSowing = newSowing;
	}

}


