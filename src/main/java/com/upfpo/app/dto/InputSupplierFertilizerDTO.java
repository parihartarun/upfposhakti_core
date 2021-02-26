package com.upfpo.app.dto;

public class InputSupplierFertilizerDTO {


    Integer id;
    String fertilizer_type;
    String fertilizer_name;
    String fertilizer_grade;
    String manufacturer_name;
    String file_path;

    public InputSupplierFertilizerDTO(Integer id, String fertilizer_type, String fertilizer_name, String fertilizer_grade, String manufacturer_name, String file_path) {
        this.id = id;
        this.fertilizer_type = fertilizer_type;
        this.fertilizer_name = fertilizer_name;
        this.fertilizer_grade = fertilizer_grade;
        this.manufacturer_name = manufacturer_name;
        this.file_path = file_path;
    }

    public InputSupplierFertilizerDTO() {
    }

    public String getFertilizer_type() {
        return fertilizer_type;
    }

    public void setFertilizer_type(String fertilizer_type) {
        this.fertilizer_type = fertilizer_type;
    }

    public String getFertilizer_name() {
        return fertilizer_name;
    }

    public void setFertilizer_name(String fertilizer_name) {
        this.fertilizer_name = fertilizer_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getFertilizer_grade() {
        return fertilizer_grade;
    }

    public void setFertilizer_grade(String fertilizer_grade) {
        this.fertilizer_grade = fertilizer_grade;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }
}
