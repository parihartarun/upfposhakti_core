package com.upfpo.app.dto;

public class ChcFmbMachineryDTO {

    Integer id;
    Integer equipment_type_id;
    String type;
    Integer equipment_name_id;
    String equpment_name;
    Integer equipment_capacity;
    String equip_purchase_year;
    Integer quantity_avail;
    Double rent_per_day;
    String govt_scheme_assistant;
    String file_path;


    public ChcFmbMachineryDTO() {
    }

    public ChcFmbMachineryDTO(Integer id, Integer equipment_type_id, String type, Integer equipment_name_id, String equpment_name, Integer equipment_capacity, String equip_purchase_year, Integer quantity_avail, Double rent_per_day, String govt_scheme_assistant, String file_path) {
        this.id = id;
        this.equipment_type_id = equipment_type_id;
        this.type = type;
        this.equipment_name_id = equipment_name_id;
        this.equpment_name = equpment_name;
        this.equipment_capacity = equipment_capacity;
        this.equip_purchase_year = equip_purchase_year;
        this.quantity_avail = quantity_avail;
        this.rent_per_day = rent_per_day;
        this.govt_scheme_assistant = govt_scheme_assistant;
        this.file_path = file_path;
    }

    public Integer getEquipment_type_id() {
        return equipment_type_id;
    }

    public void setEquipment_type_id(Integer equipment_type_id) {
        this.equipment_type_id = equipment_type_id;
    }

    public Integer getEquipment_name_id() {
        return equipment_name_id;
    }

    public void setEquipment_name_id(Integer equipment_name_id) {
        this.equipment_name_id = equipment_name_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEqupment_name() {
        return equpment_name;
    }

    public void setEqupment_name(String equpment_name) {
        this.equpment_name = equpment_name;
    }

    public Integer getEquipment_capacity() {
        return equipment_capacity;
    }

    public void setEquipment_capacity(Integer equipment_capacity) {
        this.equipment_capacity = equipment_capacity;
    }

    public String getEquip_purchase_year() {
        return equip_purchase_year;
    }

    public void setEquip_purchase_year(String equip_purchase_year) {
        this.equip_purchase_year = equip_purchase_year;
    }

    public Integer getQuantity_avail() {
        return quantity_avail;
    }

    public void setQuantity_avail(Integer quantity_avail) {
        this.quantity_avail = quantity_avail;
    }

    public Double getRent_per_day() {
        return rent_per_day;
    }

    public void setRent_per_day(Double rent_per_day) {
        this.rent_per_day = rent_per_day;
    }

    public String getGovt_scheme_assistant() {
        return govt_scheme_assistant;
    }

    public void setGovt_scheme_assistant(String govt_scheme_assistant) {
        this.govt_scheme_assistant = govt_scheme_assistant;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }
}
