package com.upfpo.app.dto;

public class UpAgriFarmerDetailDTO {

    String farmerName;
    String fatherName;
    Integer districtId;
    String districtName;
    Integer blockId;
    String blockName;
    Integer villageId;
    String villageName;
    String category;
    String mobile;
    Integer bankId;
    String bankName;
    String ifsc;
    String accountNo;
    String gender;


    public UpAgriFarmerDetailDTO() {
    }

    public UpAgriFarmerDetailDTO(String farmerName, String fatherName, Integer districtId, String districtName, Integer blockId, String blockName, Integer villageId, String villageName, String category, String mobile, Integer bankId,
                                 String bankName, String ifsc, String accountNo, String gender) {
        this.farmerName = farmerName;
        this.fatherName = fatherName;
        this.districtId = districtId;
        this.districtName = districtName;
        this.blockId = blockId;
        this.blockName = blockName;
        this.villageId = villageId;
        this.villageName = villageName;
        this.category = category;
        this.mobile = mobile;
        this.bankId = bankId;
        this.bankName = bankName;
        this.ifsc = ifsc;
        this.accountNo = accountNo;
        this.gender = gender;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
