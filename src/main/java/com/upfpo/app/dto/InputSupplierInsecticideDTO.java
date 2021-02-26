package com.upfpo.app.dto;

public class InputSupplierInsecticideDTO {


    Integer id;
    String insecticide_type;
    Integer quantity;
    String manufacturer_name;
    String cib_rc_no;
    String cib_rc_issuedate;
    String file_path;

    public InputSupplierInsecticideDTO() {
    }

    public InputSupplierInsecticideDTO(Integer id, String insecticide_type, Integer quantity, String manufacturer_name, String cib_rc_no, String cib_rc_issuedate, String file_path) {
        this.id = id;
        this.insecticide_type = insecticide_type;
        this.quantity = quantity;
        this.manufacturer_name = manufacturer_name;
        this.cib_rc_no = cib_rc_no;
        this.cib_rc_issuedate = cib_rc_issuedate;
        this.file_path = file_path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInsecticide_type() {
        return insecticide_type;
    }

    public void setInsecticide_type(String insecticide_type) {
        this.insecticide_type = insecticide_type;
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

    public String getCib_rc_no() {
        return cib_rc_no;
    }

    public void setCib_rc_no(String cib_rc_no) {
        this.cib_rc_no = cib_rc_no;
    }

    public String getCib_rc_issuedate() {
        return cib_rc_issuedate;
    }

    public void setCib_rc_issuedate(String cib_rc_issuedate) {
        this.cib_rc_issuedate = cib_rc_issuedate;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }
}
