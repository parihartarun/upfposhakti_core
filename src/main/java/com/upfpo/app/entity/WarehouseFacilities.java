package com.upfpo.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "warehouse_facilities")
public class WarehouseFacilities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "warehouse_facility_id")
    private Integer warehouseFacilityId;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "warehouse_id")
    @JsonIgnore
    private Warehouse warehouse;

    public WarehouseFacilities() {
    }

    public WarehouseFacilities(Integer id, Integer warehouseFacilityId, Warehouse warehouse) {
        this.id = id;
        this.warehouseFacilityId = warehouseFacilityId;
        this.warehouse = warehouse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWarehouseFacilityId() {
        return warehouseFacilityId;
    }

    public void setWarehouseFacilityId(Integer warehouseFacilityId) {
        this.warehouseFacilityId = warehouseFacilityId;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}

