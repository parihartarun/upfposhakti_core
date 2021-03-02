package com.upfpo.app.dto;

public class UpAgriBankDataDto {

    Integer bank_id;
    String bank_name;


    public UpAgriBankDataDto() {
    }

    public UpAgriBankDataDto(Integer bank_id, String bank_name) {
        this.bank_id = bank_id;
        this.bank_name = bank_name;
    }

    public Integer getBank_id() {
        return bank_id;
    }

    public void setBank_id(Integer bank_id) {
        this.bank_id = bank_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }
}
