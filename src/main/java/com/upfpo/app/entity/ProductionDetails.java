package com.upfpo.app.entity;
import java.io.Serializable;
import java.math.BigInteger;

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

import com.upfpo.app.dto.FarmerWiseProductionDTO;
import com.upfpo.app.dto.ProductionDTO;
import com.upfpo.app.dto.ProductionDetailsDTO;

@Entity
@SqlResultSetMapping(name="ProductionDTO",
classes = {
    @ConstructorResult(
            targetClass = ProductionDTO.class,
            columns = {
                @ColumnResult(name = "totalprod", type = Double.class),
                @ColumnResult(name = "rabiprod", type = Double.class),
                @ColumnResult(name = "kharifprod", type = Double.class),
                @ColumnResult(name = "zayadprod", type = Double.class)
           })
})
@SqlResultSetMapping(name="FarmerWiseProductionDTO",
classes = {
    @ConstructorResult(
            targetClass = FarmerWiseProductionDTO.class,
            columns = {
                @ColumnResult(name = "farmer_name", type = String.class),
                @ColumnResult(name = "father_husband_name", type = String.class),
                @ColumnResult(name = "mobile", type = BigInteger.class),
                @ColumnResult(name = "gender", type = String.class),
                @ColumnResult(name = "category", type = String.class),
                @ColumnResult(name = "season_name", type = String.class),
                @ColumnResult(name = "crop_name", type = String.class),
                @ColumnResult(name = "crop_veriety", type = String.class),
                @ColumnResult(name = "marketable_surplus", type = Double.class)
           })
})
@SqlResultSetMapping(name="ProductionDetailDTO",
		classes = {
				@ConstructorResult(
						targetClass = ProductionDetailsDTO.class,
						columns = {
								@ColumnResult(name = "farmer_name", type = String.class),
								@ColumnResult(name = "father_husband_name", type = String.class),
								@ColumnResult(name = "mobile", type = BigInteger.class),
								@ColumnResult(name = "gender", type = String.class),
								@ColumnResult(name = "category", type = String.class),
								@ColumnResult(name = "season_name", type = String.class),
								@ColumnResult(name = "crop_name", type = String.class),
								@ColumnResult(name = "crop_veriety", type = String.class),
								@ColumnResult(name = "marketable_surplus", type = Double.class)
						})
		})
@Table(name="production_details")
public class ProductionDetails implements Serializable {

	private static final long serialVersionUID = 1L;
		
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="id")
		private Integer id;

	    @Column(name="season_ref")
		private Integer  seasonName;
	    
	    @Column(name="crop_type")
		private String  cropType;
	    
	    @Column(name = "guardian_name")
		private String guardianName;
	    
	    @Column(name="crop_ref_name")
		private Integer  cropRefName;
	    
	    @Column(name="veriety_ref")
		private Integer  verietyRef;
	    
	    @Column(name="financial_year")
		private String  financialYear;
	    
	    @Column(name="actual_production")
		private Double  actualProdcution;
	    
	    @Column(name="marketable_surplus")
		private Double marketableSurplus;
	    
	    @Column(name="updated_by")
		private String  updatedBy;
	    
	    @Column(name="user_id")
		private Integer userId;
	    
	    @Column(name="master_id")
		private Integer masterId;
	    
	    @Column(name="create_date")
	    private java.sql.Date createDate;

	    @Column(name="update_date")
	    private java.sql.Date updateDate;

	    @Column(name="delete_date")
	    private java.sql.Date deleteDate;
	    
	    /*@Column(name="farmer_id")
		private Integer farmerId;*/
	    
	    @Column(name="base_land") 
	    private Integer baseland;
	    
	    @Column(name="sowing_area")
		private Double sowing_area;
	    
	    @Column(name="expected_yield")
		private BigInteger ex_yield;
	    
	    @Column(name="veriety_id")
		private Integer veriety_id;

	    @Column(name="land_id")
	    private Integer land_id;
	    
	    @Column(name="crop_id")
		private Integer crop_id;
	    
	    @Column(name="season_id")
		private Integer season_id;

	    @Column(name="is_deleted")
	    private boolean isDeleted;
	    
	    @ManyToOne
		@JoinColumn(name="farmer_id",updatable = true)
		private FarmerMaster farmerProfile;
	    

	    
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}


		public String getCropType() {
			return cropType;
		}

		public void setCropType(String cropType) {
			this.cropType = cropType;
		}

		public Integer getVerietyRef() {
			return verietyRef;
		}

		public void setVerietyRef(Integer verietyRef) {
			this.verietyRef = verietyRef;
		}

		public String getFinancialYear() {
			return financialYear;
		}

		public void setFinancialYear(String financialYear) {
			this.financialYear = financialYear;
		}

		public Double getActualProdcution() {
			return actualProdcution;
		}

		public void setActualProdcution(Double actualProdcution) {
			this.actualProdcution = actualProdcution;
		}

		public Double getMarketableSurplus() {
			return marketableSurplus;
		}

		public void setMarketableSurplus(Double marketableSurplus) {
			this.marketableSurplus = marketableSurplus;
		}


		public String getUpdatedBy() {
			return updatedBy;
		}

		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public Integer getMasterId() {
			return masterId;
		}

		public void setMasterId(Integer masterId) {
			this.masterId = masterId;
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

		/*public Integer getFarmerId() {
			return farmerId;
		}

		public void setFarmerId(Integer farmerId) {
			this.farmerId = farmerId;
		}*/

		public String getGuardianName() {
			return guardianName;
		}

		public void setGuardianName(String guardianName) {
			this.guardianName = guardianName;
		}

		public Double getSowing_area() {
			return sowing_area;
		}

		public void setSowing_area(Double sowing_area) {
			this.sowing_area = sowing_area;
		}

		public BigInteger getEx_yield() {
			return ex_yield;
		}

		public void setEx_yield(BigInteger ex_yield) {
			this.ex_yield = ex_yield;
		}

		public Integer getVeriety_id() {
			return veriety_id;
		}

		public void setVeriety_id(Integer veriety_id) {
			this.veriety_id = veriety_id;
		}

		public Integer getLand_id() {
			return land_id;
		}

		public void setLand_id(Integer land_id) {
			this.land_id = land_id;
		}

		public Integer getCrop_id() {
			return crop_id;
		}

		public void setCrop_id(Integer crop_id) {
			this.crop_id = crop_id;
		}

		public Integer getSeason_id() {
			return season_id;
		}

		public void setSeason_id(Integer season_id) {
			this.season_id = season_id;
		}

		public Integer getSeasonName() {
			return seasonName;
		}

		public void setSeasonName(Integer seasonName) {
			this.seasonName = seasonName;
		}

		public Integer getCropRefName() {
			return cropRefName;
		}

		public void setCropRefName(Integer cropRefName) {
			this.cropRefName = cropRefName;
		}

		public Integer getBaseland() {
			return baseland;
		}

		public void setBaseland(Integer baseland) {
			this.baseland = baseland;
		}

		public boolean isDeleted() {
			return isDeleted;
		}

		public void setDeleted(boolean isDeleted) {
			this.isDeleted = isDeleted;
		}

		public FarmerMaster getFarmerProfile() {
			return farmerProfile;
		}

		public void setFarmerProfile(FarmerMaster farmerProfile) {
			this.farmerProfile = farmerProfile;
		}		
	}
