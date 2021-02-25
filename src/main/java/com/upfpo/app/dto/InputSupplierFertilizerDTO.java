package com.upfpo.app.dto;

public class InputSupplierFertilizerDTO {


    Integer id;
    String fertilizer_type_id;
    String fertilizer_name_id;
    String fertilizer_grade;
    String manufacturer_name;
    String file_path;


    public InputSupplierFertilizerDTO() {
    }

    public InputSupplierFertilizerDTO(Integer id, String fertilizer_type_id, String fertilizer_name_id, String fertilizer_grade, String manufacturer_name, String file_path) {
        this.id = id;
        this.fertilizer_type_id = fertilizer_type_id;
        this.fertilizer_name_id = fertilizer_name_id;
        this.fertilizer_grade = fertilizer_grade;
        this.manufacturer_name = manufacturer_name;
        this.file_path = file_path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFertilizer_type_id() {
        return fertilizer_type_id;
    }

    public void setFertilizer_type_id(String fertilizer_type_id) {
        this.fertilizer_type_id = fertilizer_type_id;
    }

    public String getFertilizer_name_id() {
        return fertilizer_name_id;
    }

    public void setFertilizer_name_id(String fertilizer_name_id) {
        this.fertilizer_name_id = fertilizer_name_id;
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
