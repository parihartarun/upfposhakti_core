package com.upfpo.app.entity;

//import sun.util.resources.ext.CalendarData_ar;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "input_supplier_seed")
public class InputSupplierSeed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "input_supplier_id")
    private Integer inputSupplierId;

    @Column(name = "crop_id")
    private Integer cropId;

    @Column(name = "variety_id")
    private Integer variety;

    @Column(name="company_brand")
    private String companyBrand;

    @Column(name="quantity")
    private Double quantity;

    @Column(name="certification_number")
    private String certificationNumber;

    @Column(name="certification_valid_from")
    private Calendar certificationValidFrom;

    @Column(name="certification_valid_to")
    private Calendar certificationValidTo;

    @Column(name="file_path")
    private String filePath;

    @Column(name="file_name")
    private String fileName;

    @Column(name="update_date")
    private Calendar updateDate;

    @Column(name="update_by")
    private Integer updateBy;

    @Column(name="is_deleted")
    private Boolean isDeleted;

    @Column(name="delete_date")
    private Calendar deleteDate;

    @Column(name="delete_by")
    private Integer deleteBy;

    @Column(name = "create_by")
    private Integer createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date_time")
    private Calendar createDateTime;

    public InputSupplierSeed(Integer id, Integer inputSupplierId, Integer cropId, Integer variety, String companyBrand, Double quantity,
                             String certificationNumber, Calendar certificationValidFrom, Calendar certificationValidTo, String filePath, String fileName, Calendar updateDate, Integer updateBy,
                             Boolean isDeleted, Calendar deleteDate, Integer deleteBy, Integer createBy, Calendar createDateTime) {
        this.id = id;
        this.inputSupplierId = inputSupplierId;
        this.cropId = cropId;
        this.variety = variety;
        this.companyBrand = companyBrand;
        this.quantity = quantity;
        this.certificationNumber = certificationNumber;
        this.certificationValidFrom = certificationValidFrom;
        this.certificationValidTo = certificationValidTo;
        this.filePath = filePath;
        this.fileName = fileName;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
        this.isDeleted = isDeleted;
        this.deleteDate = deleteDate;
        this.deleteBy = deleteBy;
        this.createBy = createBy;
        this.createDateTime = createDateTime;
    }

    public InputSupplierSeed() {
    }

    public InputSupplierSeed(Integer cropId, Integer inputSupplierId, Integer varietyId,
                             String company, String certificationNo, Calendar validFrom, Calendar validTo, Double quantity) {

        this.cropId=cropId;
        this.inputSupplierId=inputSupplierId;
        this.variety=varietyId;
        this.companyBrand=company;
        this.certificationNumber=certificationNo;
        this.certificationValidFrom=validFrom;
        this.certificationValidTo=validTo;
        this.quantity=quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInputSupplierId() {
        return inputSupplierId;
    }

    public void setInputSupplierId(Integer inputSupplierId) {
        this.inputSupplierId = inputSupplierId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public Integer getVariety() {
        return variety;
    }

    public void setVariety(Integer variety) {
        this.variety = variety;
    }

    public String getCompanyBrand() {
        return companyBrand;
    }

    public void setCompanyBrand(String companyBrand) {
        this.companyBrand = companyBrand;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getCertificationNumber() {
        return certificationNumber;
    }

    public void setCertificationNumber(String certificationNumber) {
        this.certificationNumber = certificationNumber;
    }

    public Calendar getCertificationValidFrom() {
        return certificationValidFrom;
    }

    public void setCertificationValidFrom(Calendar certificationValidFrom) {
        this.certificationValidFrom = certificationValidFrom;
    }

    public Calendar getCertificationValidTo() {
        return certificationValidTo;
    }

    public void setCertificationValidTo(Calendar certificationValidTo) {
        this.certificationValidTo = certificationValidTo;
    }

    public Calendar getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Calendar updateDate) {
        this.updateDate = updateDate;
    }


    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Calendar getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Calendar deleteDate) {
        this.deleteDate = deleteDate;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(Integer deleteBy) {
        this.deleteBy = deleteBy;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Calendar getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Calendar createDateTime) {
        this.createDateTime = createDateTime;
    }
}

