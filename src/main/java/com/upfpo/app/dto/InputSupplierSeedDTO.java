package com.upfpo.app.dto;

public class InputSupplierSeedDTO {


    Integer id;
    Integer crop_id;
    String crop_name;
    Integer veriety_id;
    String crop_veriety;
    String company_brand;
    Double quantity;
    String certification_number;
    String certification_valid_from;
    String certification_valid_to;
    String file_path;


    public InputSupplierSeedDTO() {
    }

    public InputSupplierSeedDTO(Integer id, Integer crop_Id, String crop_name, Integer veriety_id, String crop_veriety, String company_brand, Double quantity,
                                String certification_number, String certification_valid_from, String certification_valid_to, String file_path) {
        this.id = id;
        this.crop_id = crop_Id;
        this.crop_name = crop_name;
        this.veriety_id = veriety_id;
        this.crop_veriety = crop_veriety;
        this.company_brand = company_brand;
        this.quantity = quantity;
        this.certification_number = certification_number;
        this.certification_valid_from = certification_valid_from;
        this.certification_valid_to = certification_valid_to;
        this.file_path = file_path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCrop_name() {
        return crop_name;
    }

    public void setCrop_name(String crop_name) {
        this.crop_name = crop_name;
    }

    public String getCrop_veriety() {
        return crop_veriety;
    }

    public void setCrop_veriety(String crop_veriety) {
        this.crop_veriety = crop_veriety;
    }

    public String getCompany_brand() {
        return company_brand;
    }

    public void setCompany_brand(String company_brand) {
        this.company_brand = company_brand;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getCertification_number() {
        return certification_number;
    }

    public void setCertification_number(String certification_number) {
        this.certification_number = certification_number;
    }

    public String getCertification_valid_from() {
        return certification_valid_from;
    }

    public void setCertification_valid_from(String certification_valid_from) {
        this.certification_valid_from = certification_valid_from;
    }

    public String getCertification_valid_to() {
        return certification_valid_to;
    }

    public void setCertification_valid_to(String certification_valid_to) {
        this.certification_valid_to = certification_valid_to;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public Integer getCrop_Id() {
        return crop_id;
    }

    public void setCrop_Id(Integer crop_Id) {
        this.crop_id = crop_Id;
    }

    public Integer getVeriety_id() {
        return veriety_id;
    }

    public void setVeriety_id(Integer veriety_id) {
        this.veriety_id = veriety_id;
    }
}
