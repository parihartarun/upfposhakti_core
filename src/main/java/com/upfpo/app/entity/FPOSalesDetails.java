package com.upfpo.app.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "fpo_sales_details")
public class FPOSalesDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="users_id")
    private Integer userId;

    @Column(name="selling_crop")
    private String sellingCrop;

    @Column(name="sold_to")
    private String soldTo;

    @Column (name="quantity_sold_to_fpo")
    private double quantitySoldToFpo;

    @Column(name="price_from_fpo")
    private Long priceFromFpo;

    @Column(name="dos_to_fpo")
    private String dosToFpo;

    @Column (name="quantity_sold_to_local")
    private double quantitySoldToLocal;

    @Column(name="price_from_local")
    private Long priceFromLocal;

    @Column(name="dos_to_local")
    private String dosToLocal;

    //@Column(name="master_id")
    //private Integer masterId;

    @Column(name = "create_by")
    private String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date_time")
    private Calendar createDateTime;

    @Column(name = "update_by")
    private String updateBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date_time")
    private Calendar updateDateTime;

    @Column(name="farmer_id")
    private Integer farmerId;

    public FPOSalesDetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSellingCrop() {
        return sellingCrop;
    }

    public void setSellingCrop(String sellingCrop) {
        this.sellingCrop = sellingCrop;
    }

    public String getSoldTo() {
        return soldTo;
    }

    public void setSoldTo(String soldTo) {
        this.soldTo = soldTo;
    }

    public double getQuantitySoldToFpo() {
        return quantitySoldToFpo;
    }

    public void setQuantitySoldToFpo(double quantitySoldToFpo) {
        this.quantitySoldToFpo = quantitySoldToFpo;
    }

    public Long getPriceFromFpo() {
        return priceFromFpo;
    }

    public void setPriceFromFpo(Long priceFromFpo) {
        this.priceFromFpo = priceFromFpo;
    }

    public String getDosToFpo() {
        return dosToFpo;
    }

    public void setDosToFpo(String dosToFpo) {
        this.dosToFpo = dosToFpo;
    }

    public double getQuantitySoldToLocal() {
        return quantitySoldToLocal;
    }

    public void setQuantitySoldToLocal(double quantitySoldToLocal) {
        this.quantitySoldToLocal = quantitySoldToLocal;
    }

    public Long getPriceFromLocal() {
        return priceFromLocal;
    }

    public void setPriceFromLocal(Long priceFromLocal) {
        this.priceFromLocal = priceFromLocal;
    }

    public String getDosToLocal() {
        return dosToLocal;
    }

    public void setDosToLocal(String dosToLocal) {
        this.dosToLocal = dosToLocal;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Calendar getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Calendar createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Calendar getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Calendar updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Integer getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Integer farmerId) {
        this.farmerId = farmerId;
    }
}
