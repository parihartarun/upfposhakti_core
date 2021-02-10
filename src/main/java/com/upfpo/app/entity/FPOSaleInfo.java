package com.upfpo.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.upfpo.app.dto.FPOSalesDetailsDTO;

@Entity
@SqlResultSetMapping(name="FPOSalesDetailsDTO",
classes = {
    @ConstructorResult(
            targetClass = FPOSalesDetailsDTO.class,
            columns = {
                @ColumnResult(name = "id", type = Integer.class),
                @ColumnResult(name = "season_id", type = Integer.class),
                @ColumnResult(name = "season_name", type = String.class),
                @ColumnResult(name = "category_id", type = Integer.class),
                @ColumnResult(name = "category", type = String.class),
                @ColumnResult(name = "crop_id", type = Integer.class),
                @ColumnResult(name = "crop_name", type = String.class),
                @ColumnResult(name = "sold_quantity", type = Double.class),
                @ColumnResult(name = "financial_year", type = String.class),
                @ColumnResult(name = "veriety_id", type = Integer.class),
                @ColumnResult(name = "crop_variety", type = String.class),
                @ColumnResult(name = "veriety_ref", type = Integer.class),
                @ColumnResult(name = "crop_ref_name", type = Integer.class),
                @ColumnResult(name = "season_ref", type = Integer.class),
           })
    
})
@Table(name="fpo_sale_info")
public class FPOSaleInfo implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="financial_year")
	private String finYear;
	
	@Column(name="season_ref")
	private String season;
	
	@Column(name="crop_ref_name")
	private Integer cropRefName;
	
	@Column(name="veriety_ref")
	private String verietyId;
	

	@Column(name="sold_quantity")
	private Double soldQuantity;
	
	@Column(name="user_id")
	private Integer fpoId;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="master_id")
	private Integer masterId;
	
	@Column(name="create_date")
	private java.sql.Date createDate;

	@Column(name="update_date")
	private java.sql.Date updateDate;
	
	@Column(name="is_deleted")
	private boolean isDeleted;

	@Column(name="delete_date")
	private java.sql.Date deleteDate;
	
	

	public String getFinYear() {
		return finYear;
	}

	public void setFinYear(String finYear) {
		this.finYear = finYear;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public Integer getCropRefName() {
		return cropRefName;
	}

	public void setCropRefName(Integer cropRefName) {
		this.cropRefName = cropRefName;
	}

	public String getVerietyId() {
		return verietyId;
	}

	public void setVerietyId(String verietyId) {
		this.verietyId = verietyId;
	}

	public Double getSoldQuantity() {
		return soldQuantity;
	}

	public void setSoldQuantity(Double soldQuantity) {
		this.soldQuantity = soldQuantity;
	}

	public Integer getFpoId() {
		return fpoId;
	}

	public void setFpoId(Integer fpoId) {
		this.fpoId = fpoId;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}

