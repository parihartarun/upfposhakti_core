package com.upfpo.app.dto;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

public class ProductionDetailsDTO implements Serializable {


    String crop_name;
    String veriety;
    String season_name;
    BigInteger total_markatable;
    BigInteger total_sold;

    public ProductionDetailsDTO(String crop_name, String veriety, String season_name, BigInteger total_markatable, BigInteger total_sold) {
        this.crop_name = crop_name;
        this.veriety = veriety;
        this.season_name = season_name;
        this.total_markatable = total_markatable;
        this.total_sold = total_sold;
    }

    public ProductionDetailsDTO() {
    }

    public String getCrop_name() {
        return crop_name;
    }

    public void setCrop_name(String crop_name) {
        this.crop_name = crop_name;
    }

    public String getVeriety() {
        return veriety;
    }

    public void setVeriety(String veriety) {
        this.veriety = veriety;
    }

    public String getSeason_name() {
        return season_name;
    }

    public void setSeason_name(String season_name) {
        this.season_name = season_name;
    }

    public BigInteger getTotal_markatable() {
        return total_markatable;
    }

    public void setTotal_markatable(BigInteger total_markatable) {
        this.total_markatable = total_markatable;
    }

    public BigInteger getTotal_sold() {
        return total_sold;
    }

    public void setTotal_sold(BigInteger total_sold) {
        this.total_sold = total_sold;
    }
}

