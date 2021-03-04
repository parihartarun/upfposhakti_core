package com.upfpo.app.entity;


import javax.persistence.*;

@Entity
@Table(name = "warehouse_facility_master")
public class WarehouseFacilityMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "warehouse_facility_name")
    private String warehouseFacilityName;


    public WarehouseFacilityMaster() {
    }

    public WarehouseFacilityMaster(Integer id, String warehouseFacilityName) {

        this.id = id;
        this.warehouseFacilityName = warehouseFacilityName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWarehouseFacilityName() {
        return warehouseFacilityName;
    }

    public void setWarehouseFacilityName(String warehouseFacilityName) {
        this.warehouseFacilityName = warehouseFacilityName;
    }
}
