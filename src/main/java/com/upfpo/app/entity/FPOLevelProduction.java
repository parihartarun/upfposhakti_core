package com.upfpo.app.entity;

import javax.persistence.*;
import java.math.BigInteger;


@Entity
@Table(name = "fpo_level_production")
public class FPOLevelProduction {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="production_id")
    private Integer id;

    @Transient
    private String  seasonName;

    @Transient
    private String  cropType;

    @Transient
    private String  cropRefName;

    @Transient
    private String  verietyRef;

    @Column(name="actual_production")
    private Double  actualProdcution;

    @Column(name="marketable_surplus")
    private Double marketableSurplus;

    @Column(name="land_id")
    private Integer land_id;

    @Transient
    private String crop_name;

    @Transient
    private String season_name;

    @Transient
    private String category;

    @Transient
    private String crop_veriety;

    @Column(name="sowing_area")
    private Double sowing_area;

    @Column(name="expected_yield")
    private BigInteger expectedYield;

    @Column(name="season_id")
    private Integer seasonId;

    @Column(name="crop_id")
    private Integer cropId;

    @Column(name="category_id")
    private Integer catId;

    @Column(name="veriety_id")
    private Integer verietyId;

    public FPOLevelProduction() {
    }

    public Integer getProductionId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public String getCropRefName() {
        return cropRefName;
    }

    public void setCropRefName(String cropRefName) {
        this.cropRefName = cropRefName;
    }

    public String getVerietyRef() {
        return verietyRef;
    }

    public void setVerietyRef(String verietyRef) {
        this.verietyRef = verietyRef;
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

    public Integer getLand_id() {
        return land_id;
    }

    public void setLand_id(Integer land_id) {
        this.land_id = land_id;
    }

    public String getCrop_name() {
        return crop_name;
    }

    public void setCrop_name(String crop_name) {
        this.crop_name = crop_name;
    }

    public String getSeason_name() {
        return season_name;
    }

    public void setSeason_name(String season_name) {
        this.season_name = season_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCrop_veriety() {
        return crop_veriety;
    }

    public void setCrop_veriety(String crop_veriety) {
        this.crop_veriety = crop_veriety;
    }

    public Double getSowing_area() {
        return sowing_area;
    }

    public void setSowing_area(Double sowing_area) {
        this.sowing_area = sowing_area;
    }

    public BigInteger getExpectedYield() {
        return expectedYield;
    }

    public void setExpectedYield(BigInteger expectedYield) {
        this.expectedYield = expectedYield;
    }

    public Integer getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Integer getVerietyId() {
        return verietyId;
    }

    public void setVerietyId(Integer verietyId) {
        this.verietyId = verietyId;
    }
}
