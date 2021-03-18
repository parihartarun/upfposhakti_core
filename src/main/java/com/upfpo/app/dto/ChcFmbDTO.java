package com.upfpo.app.dto;

public class ChcFmbDTO {

    Integer chc_fmb_id;
    String chc_fmb_name;
    String user_name;
    Integer district_id;
    String district_name;
    Integer block_id;
    String block_name;
    Integer village_id;
    String village_name;
    Long pincode;
    String email;
    Long mobile_number;
    String firm_registraion_number;
    String shop_establishment_number;
    String allotment_no;

    public ChcFmbDTO() {
    }

    public ChcFmbDTO(Integer chc_fmb_id, String chc_fmb_name, String user_name, Integer district_id, String district_name, Integer block_id, String block_name, Integer village_id,
                     String village_name, Long pincode, String email, Long mobile_number, String firm_registraion_number, String shop_establishment_number, String allotment_no) {
        this.chc_fmb_id = chc_fmb_id;
        this.chc_fmb_name = chc_fmb_name;
        this.user_name = user_name;
        this.district_id = district_id;
        this.district_name = district_name;
        this.block_id = block_id;
        this.block_name = block_name;
        this.village_id = village_id;
        this.village_name = village_name;
        this.pincode = pincode;
        this.email = email;
        this.mobile_number = mobile_number;
        this.firm_registraion_number = firm_registraion_number;
        this.shop_establishment_number = shop_establishment_number;
        this.allotment_no = allotment_no;
    }

    public Integer getChc_fmb_id() {
        return chc_fmb_id;
    }

    public void setChc_fmb_id(Integer chc_fmb_id) {
        this.chc_fmb_id = chc_fmb_id;
    }

    public String getChc_fmb_name() {
        return chc_fmb_name;
    }

    public void setChc_fmb_name(String chc_fmb_name) {
        this.chc_fmb_name = chc_fmb_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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

    public String getFirm_registraion_number() {
        return firm_registraion_number;
    }

    public void setFirm_registraion_number(String firm_registraion_number) {
        this.firm_registraion_number = firm_registraion_number;
    }

    public String getShop_establishment_number() {
        return shop_establishment_number;
    }

    public void setShop_establishment_number(String shop_establishment_number) {
        this.shop_establishment_number = shop_establishment_number;
    }

    public String getAllotment_no() {
        return allotment_no;
    }

    public void setAllotment_no(String allotment_no) {
        this.allotment_no = allotment_no;
    }
}
