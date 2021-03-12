package com.upfpo.app.dto;

public class InputSupplierDTO {


    Integer inputSupplierId;
    String inputSupplierName;
    long mobile_number;
    String email;

    public InputSupplierDTO() {
    }

    public InputSupplierDTO(Integer inputSupplierId, String inputSupplierName, long mobile_number, String email) {
        this.inputSupplierId = inputSupplierId;
        this.inputSupplierName = inputSupplierName;
        this.mobile_number = mobile_number;
        this.email = email;
    }

    public Integer getInputSupplierId() {
        return inputSupplierId;
    }

    public void setInputSupplierId(Integer inputSupplierId) {
        this.inputSupplierId = inputSupplierId;
    }

    public String getInputSupplierName() {
        return inputSupplierName;
    }

    public void setInputSupplierName(String inputSupplierName) {
        this.inputSupplierName = inputSupplierName;
    }

    public long getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(long mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
