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
    private Date updateDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name="is_deleted")
    private boolean isDeleted;

    @Column(name="delete_date")
    private Date deleteDate;

    @Column(name="delete_By")
    private Date deleteBy;


    public FPOSalesDetails() {
    }

    public Date getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(Date deleteBy) {
        this.deleteBy = deleteBy;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
