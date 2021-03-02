package com.upfpo.app.entity;
import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.upfpo.app.dto.CropListOfFarmersDTO;
import com.upfpo.app.dto.FarmerCropProductionDTO;
import com.upfpo.app.dto.TotalProductionDTO;

@Entity
@SqlResultSetMapping(name="CropListOfFarmersDTO",
classes = {
    @ConstructorResult(
            targetClass = CropListOfFarmersDTO.class,
            columns = {
                @ColumnResult(name = "id", type = Integer.class),
                @ColumnResult(name = "farmer_id", type = Integer.class),
                @ColumnResult(name = "farmer_name", type = String.class),
                @ColumnResult(name = "father_husband_name", type = String.class),
                @ColumnResult(name = "financial_year", type = String.class),
                @ColumnResult(name = "season_id", type = Integer.class),
                @ColumnResult(name = "season_name", type = String.class),
                @ColumnResult(name = "sowing_id", type = Integer.class),
                @ColumnResult(name = "crop_id", type = Integer.class),
                @ColumnResult(name = "crop_name", type = String.class),
                @ColumnResult(name = "crop_veriety", type = String.class),
                @ColumnResult(name = "sowing_area", type = Double.class),
                @ColumnResult(name = "ex_yield", type = BigInteger.class),
                @ColumnResult(name = "veriety_id", type = Integer.class),
           })
})
@SqlResultSetMapping(name="TotalProductionDTOCrop",
classes = {
    @ConstructorResult(
            targetClass = TotalProductionDTO.class,
            columns = {
                @ColumnResult(name = "totalActualProdction", type = Double.class),
                @ColumnResult(name = "totalMarketableQty", type = Double.class)
           })
})
@SqlResultSetMapping(name="FarmerCropProductionDTO",
classes = {
    @ConstructorResult(
            targetClass = FarmerCropProductionDTO.class,
            columns = {
                @ColumnResult(name = "cropId", type = Integer.class),
                @ColumnResult(name = "cropName", type = String.class),
                @ColumnResult(name = "production", type = Double.class),
                @ColumnResult(name = "seasonId", type = Integer.class),
                @ColumnResult(name = "seasonName", type = String.class),
           })
})
@Table(name = "crop_details")
public class CropDatails implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "crop_id")
	private Integer cropId;

	@Column(name = "user_ref_id")
	private Integer userRefId;

	@Column(name = "season_ref")
	private Integer seasonRefName;

	@Column(name = "crop_ref")
	private Integer cropRefName;

	@Column(name = "veriety_ref")
	private Integer verietyRef;

	@Column(name = "ex_yield")
	private double expectedYield;

	@Column(name = "actual_yield")
	private Double actualYield;

	@Column(name = "sowing_area")
	private Double sowingArea;

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
	@JoinColumn(name = "sowing_id")
    private NewSowing newSowing;

	@Column(name = "land_id")
	private Integer baseland;

	@Column(name = "financial_year")
	private String finYear;
	
	@Column(name="is_deleted")
    private boolean isDeleted;
	
	@Column(name = "marketable_quantity")
	private Double marketableQuantity;
   
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

	public Integer getVerietyRef() {
		return verietyRef;
	}

	public void setVerietyRef(Integer verietyRef) {
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


	public Double getActualYield() {
		return actualYield;
	}

	public void setActualYield(Double actualYield) {
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
	
	public Double getMarketableQuantity() {
		return marketableQuantity;
	}

	public void setMarketableQuantity(Double marketableQuantity) {
		this.marketableQuantity = marketableQuantity;
	}
	
}


