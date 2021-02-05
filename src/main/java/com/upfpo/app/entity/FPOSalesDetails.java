package com.upfpo.app.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "fpo_sales_details")
public class FPOSalesDetails {

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
    private Long soldQuantity;

    @Column(name="user_id")
    private Integer fpoId;

    @Column(name="updated_by")
    private String updatedBy;

    @Column(name="update_date")
    private Calendar updateDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Calendar createdDate;

    @Column(name="is_deleted")
    private boolean isDeleted;

    @Column(name="delete_date")
    private Calendar deleteDate;

    @Column(name="delete_By")
    private String deleteBy;

    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pid", referencedColumnName = "pid")
	private TotalProduction totalProduction;

    public FPOSalesDetails() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Long getSoldQuantity() {
		return soldQuantity;
	}

	public void setSoldQuantity(Long soldQuantity) {
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

	public Calendar getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Calendar updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Calendar getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Calendar deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getDeleteBy() {
		return deleteBy;
	}

	public void setDeleteBy(String deleteBy) {
		this.deleteBy = deleteBy;
	}

	public TotalProduction getTotalProduction() {
		return totalProduction;
	}

	public void setTotalProduction(TotalProduction totalProduction) {
		this.totalProduction = totalProduction;
	}

   
}
