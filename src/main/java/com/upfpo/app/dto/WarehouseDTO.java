package com.upfpo.app.dto;

public class WarehouseDTO {


    Integer id;
    String warehouse_type;
    String warehouse_facilities;
    Double capacity;
    String is_seed_processing;
    Integer district_id;
    String district_name;
    Integer block_id;
    String block_name;
    String address;
    String longitude;
    String latitude;

    public WarehouseDTO() {
    }

    public WarehouseDTO(Integer id, String warehouse_type, String warehouse_facility_name, Double capacity, String is_seed_processing, Integer district_id, String district_name, Integer block_id, String block_name, String address, String longitude, String latitude) {
        this.id = id;
        this.warehouse_type = warehouse_type;
        this.warehouse_facilities = warehouse_facility_name;
        this.capacity = capacity;
        this.is_seed_processing = is_seed_processing;
        this.district_id = district_id;
        this.district_name = district_name;
        this.block_id = block_id;
        this.block_name = block_name;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public String getWarehouse_type() {
        return warehouse_type;
    }

    public void setWarehouse_type(String warehouse_type) {
        this.warehouse_type = warehouse_type;
    }

    public String getWarehouse_facilities() {
        return warehouse_facilities;
    }

    public void setWarehouse_facilities(String warehouse_facilities) {
        this.warehouse_facilities = warehouse_facilities;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public String getIs_seed_processing() {
        return is_seed_processing;
    }

    public void setIs_seed_processing(String is_seed_processing) {
        this.is_seed_processing = is_seed_processing;
    }

    public Integer getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Integer district_id) {
        this.district_id = district_id;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public Integer getBlock_id() {
        return block_id;
    }

    public void setBlock_id(Integer block_id) {
        this.block_id = block_id;
    }

    public String getBlock_name() {
        return block_name;
    }

    public void setBlock_name(String block_name) {
        this.block_name = block_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
