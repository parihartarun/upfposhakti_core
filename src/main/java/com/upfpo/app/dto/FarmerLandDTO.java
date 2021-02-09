package com.upfpo.app.dto;

public class FarmerLandDTO {

    private Integer landId;

    private String landArea;

    private Integer masterId;

    private String guardianName;

    private String farmerName;

    private String ownership;

    private String isorganc;


    public Integer getLandId() {
        return landId;
    }

    public void setLandId(Integer landId) {
        this.landId = landId;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public String getIsorganc() {
        return isorganc;
    }

    public void setIsorganc(String isorganc) {
        this.isorganc = isorganc;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getLandArea() {
        return landArea;
    }

    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }
}
