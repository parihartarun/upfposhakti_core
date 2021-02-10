package com.upfpo.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.upfpo.app.dto.FpoCropProductionDetailsDTO;

@Entity
@SqlResultSetMapping(name="FpoCropProductionDetailsDTO",
classes = {
    @ConstructorResult(
            targetClass = FpoCropProductionDetailsDTO.class,
            columns = {
            	@ColumnResult(name = "season_id", type = Integer.class),
                @ColumnResult(name = "season_name", type = String.class),
                @ColumnResult(name = "category_id", type = Integer.class),
                @ColumnResult(name = "category", type = String.class),
                @ColumnResult(name = "crop_id", type = Integer.class),
                @ColumnResult(name = "crop_name", type = String.class),
                @ColumnResult(name = "marketable_id", type = Integer.class),
                @ColumnResult(name = "marketable_quantity", type = Double.class),
                @ColumnResult(name = "actual_quantity", type = Double.class),
                @ColumnResult(name = "financial_year", type = String.class),
                @ColumnResult(name = "veriety_id", type = Integer.class),
                @ColumnResult(name = "crop_variety", type = String.class)
           })
})
@Table(name = "marketable_surplus_new")
public class MarketableSurplus implements Serializable {

	private static final long serialVersionUID = -5034497351916605256L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "financial_year")
	private String financialYear;

	@Column(name = "season_id")
	private Integer season;

   /*@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "crop_id", referencedColumnName = "id")*/
	private Integer crop_id;

	@Column(name = "marketable_quantity")
	private Double marketableQuantity;

	@Column(name = "actual_quantity")
	private Double actualQuantity;

	/*@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "veriety_id", referencedColumnName = "veriety_id")*/
	private Integer verietyId;

	@Column(name = "master_id")
	private Integer masterId;

	@Column(name = "updated_by")
	private String updatedBy;

	@CreatedDate
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Column(name = "update_date")
	private Date updateDate;

	@Column(name = "delete_date")
	private Date deleteDate;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	public MarketableSurplus() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public Integer getSeason() {
		return season;
	}

	public void setSeason(Integer season) {
		this.season = season;
	}

	public Integer getCrop_id() {
		return crop_id;
	}

	public void setCrop_id(Integer crop_id) {
		this.crop_id = crop_id;
	}

	public Double getMarketableQuantity() {
		return marketableQuantity;
	}

	public void setMarketableQuantity(Double marketableQuantity) {
		this.marketableQuantity = marketableQuantity;
	}

	public Double getActualQuantity() {
		return actualQuantity;
	}

	public void setActualQuantity(Double actualQuantity) {
		this.actualQuantity = actualQuantity;
	}

	public Integer getVerietyId() {
		return verietyId;
	}

	public void setVerietyId(Integer verietyId) {
		this.verietyId = verietyId;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}



}
