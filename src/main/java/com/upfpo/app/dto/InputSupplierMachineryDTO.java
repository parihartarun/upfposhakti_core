package com.upfpo.app.dto;

public class InputSupplierMachineryDTO {

    Integer id;
    String type;
    String equpment_name;
    Integer quantity;
    String manufacturer_name;
    String file_path;

    public InputSupplierMachineryDTO() {
    }

    public InputSupplierMachineryDTO(Integer id, String type, String equpment_name, Integer quantity, String manufacturer_name, String file_path) {
        this.id = id;
        this.type = type;
        this.equpment_name = equpment_name;
        this.quantity = quantity;
        this.manufacturer_name = manufacturer_name;
        this.file_path = file_path;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
