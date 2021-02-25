package com.upfpo.app.entity;

import com.upfpo.app.dto.InputSupplierFertilizerDTO;


import javax.persistence.*;
import java.util.Calendar;


@SqlResultSetMapping(name="InputSupplierFertilizerDTO",
        classes = {
                @ConstructorResult(
                        targetClass = InputSupplierFertilizerDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = Integer.class),
                                @ColumnResult(name = "fertilizer_type", type = String.class),
                                @ColumnResult(name = "fertilizer_name", type = String.class),
                                @ColumnResult(name = "fertilizer_grade", type = String.class),
                                @ColumnResult(name = "manufacturer_name", type = String.class),
                                @ColumnResult(name = "file_path", type = String.class)
                        })
        })
@Entity
@Table(name = "input_supplier_fertilizer")
public class InputSupplierFertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "input_supplier_id")
    private Integer inputSupplierId;

    @Column(name = "fertilizer_type_id")
    private Integer fertilizerType;

    @Column(name = "fertilizer_name_id")
    private Integer fertilizerNameId;

    @Column(name = "fertilizer_grade")
    private String fertilizerGrade;

    @Column(name="manufacturer_name")
    private String manufacturerName;

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


    public InputSupplierFertilizer() {
    }

    public InputSupplierFertilizer(Integer fertilizerTypeId, Integer fertilizerNameId, Integer inputSupplierId, String fertilizerGrade, String manufacturerName) {

        this.fertilizerType=fertilizerTypeId;
        this.fertilizerNameId=fertilizerNameId;
        this.inputSupplierId=inputSupplierId;
        this.fertilizerGrade=fertilizerGrade;
        this.manufacturerName=manufacturerName;
    }

    public InputSupplierFertilizer(Integer inputSupplierId) {
        this.inputSupplierId=inputSupplierId;
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

    public Integer getFertilizerType() {
        return fertilizerType;
    }

    public void setFertilizerType(Integer fertilizerType) {
        this.fertilizerType = fertilizerType;
    }

    public Integer getFertilizerNameId() {
        return fertilizerNameId;
    }

    public void setFertilizerNameId(Integer fertilizerNameId) {
        this.fertilizerNameId = fertilizerNameId;
    }

    public String getFertilizerGrade() {
        return fertilizerGrade;
    }

    public void setFertilizerGrade(String fertilizerGrade) {
        this.fertilizerGrade = fertilizerGrade;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
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

    public Calendar getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Calendar updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
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

