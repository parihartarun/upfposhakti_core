package com.upfpo.app.dto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

public class FarmerLandDTO {

    private Integer landId;

    private String landArea;

    private Integer masterId;

    private String guardianName;

    private String farmerName;

    private String farmerId;

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


/*@SqlResultSetMapping(name="FarmerLandDetailDto",
        classes = {
                @ConstructorResult(
                        targetClass = FarmerLandDTO.class,
                        columns = {
                                @ColumnResult(name = "landId", type = Integer.class),
                                @ColumnResult(name = "landArea", type = double.class),
                                @ColumnResult(name = "masterId", type = Integer.class),
                                @ColumnResult(name = "isorganc", type = String.class),
                                @ColumnResult(name = "ownership", type = String.class),
                                @ColumnResult(name = "farmerId", type = Integer.class),
                                @ColumnResult(name = "guardianName", type = String.class),
                                @ColumnResult(name = "farmerName", type = String.class),
                        })
        })*/