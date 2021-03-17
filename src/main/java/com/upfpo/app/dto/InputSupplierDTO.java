package com.upfpo.app.dto;

public class InputSupplierDTO {

    Integer input_supplier_id;
    String input_supplier_name;
    String user_name;
    Integer input_supplier_type;
    Integer district_id;
    String district_name;
    Integer block_id;
    String block_name;
    Integer village_id;
    String village_name;
    Long pincode;
    String email;
    Long mobile_number;
    String contact_person;
    String license_number;
    String gst_number;
    String equipment;
    String fertilizer;
    String cide;
    String category_deal;

    public InputSupplierDTO() {
    }

    public InputSupplierDTO(Integer input_supplier_id, String input_supplier_name, String user_name, Integer input_supplier_type, Integer district_id, String district_name, Integer block_id, String block_name, Integer village_id, String village_name, Long pincode, String email, Long mobile_number, String contact_person, String license_number, String gst_number, String equipment, String fertilizer, String cide, String category_deal) {
        this.input_supplier_id = input_supplier_id;
        this.input_supplier_name = input_supplier_name;
        this.user_name = user_name;
        this.input_supplier_type = input_supplier_type;
        this.district_id = district_id;
        this.district_name = district_name;
        this.block_id = block_id;
        this.block_name = block_name;
        this.village_id = village_id;
        this.village_name = village_name;
        this.pincode = pincode;
        this.email = email;
        this.mobile_number = mobile_number;
        this.contact_person = contact_person;
        this.license_number = license_number;
        this.gst_number = gst_number;
        this.equipment = equipment;
        this.fertilizer = fertilizer;
        this.cide = cide;
        this.category_deal = category_deal;
    }

    public Integer getInput_supplier_id() {
        return input_supplier_id;
    }

    public void setInput_supplier_id(Integer input_supplier_id) {
        this.input_supplier_id = input_supplier_id;
    }

    public String getInput_supplier_name() {
        return input_supplier_name;
    }

    public void setInput_supplier_name(String input_supplier_name) {
        this.input_supplier_name = input_supplier_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getInput_supplier_type() {
        return input_supplier_type;
    }

    public void setInput_supplier_type(Integer input_supplier_type) {
        this.input_supplier_type = input_supplier_type;
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

    public Integer getVillage_id() {
        return village_id;
    }

    public void setVillage_id(Integer village_id) {
        this.village_id = village_id;
    }

    public String getVillage_name() {
        return village_name;
    }

    public void setVillage_name(String village_name) {
        this.village_name = village_name;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(Long mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getLicense_number() {
        return license_number;
    }

    public void setLicense_number(String license_number) {
        this.license_number = license_number;
    }

    public String getGst_number() {
        return gst_number;
    }

    public void setGst_number(String gst_number) {
        this.gst_number = gst_number;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getFertilizer() {
        return fertilizer;
    }

    public void setFertilizer(String fertilizer) {
        this.fertilizer = fertilizer;
    }

    public String getCide() {
        return cide;
    }

    public void setCide(String cide) {
        this.cide = cide;
    }

    public String getCategory_deal() {
        return category_deal;
    }

    public void setCategory_deal(String category_deal) {
        this.category_deal = category_deal;
    }
}
