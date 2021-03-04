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
}
