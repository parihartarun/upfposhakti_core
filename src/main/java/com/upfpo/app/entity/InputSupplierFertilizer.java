package com.upfpo.app.entity;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.upfpo.app.dto.InputSupplierDashboardFertilizerDTO;
import com.upfpo.app.dto.InputSupplierFertilizerDTO;


@SqlResultSetMapping(name="InputSupplierFertilizerDTO",
        classes = {
                @ConstructorResult(
                        targetClass = InputSupplierFertilizerDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = Integer.class),
                                @ColumnResult(name = "type_id", type = Integer.class),
                                @ColumnResult(name = "fertilizer_type", type = String.class),
                                @ColumnResult(name = "name_id", type = Integer.class),
                                @ColumnResult(name = "fertilizer_name", type = String.class),
                                @ColumnResult(name = "fertilizer_grade", type = String.class),
                                @ColumnResult(name = "manufacturer_name", type = String.class),
                                @ColumnResult(name = "file_path", type = String.class)
                        })
        })
@SqlResultSetMapping(name="InputSupplierDashboardFertilizerDTO",
classes = {
        @ConstructorResult(
                targetClass = InputSupplierDashboardFertilizerDTO.class,
                columns = {
                        @ColumnResult(name = "fertilizerNameId", type = Integer.class),
                        @ColumnResult(name = "fertilizerName", type = String.class),
                        @ColumnResult(name = "fertilizerGrade", type = String.class),
                        @ColumnResult(name = "fertilizerQty", type = Double.class)
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

    @Column(name = "fertilizer_name")
    private String fertilizerName;

    @Column(name = "fertilizer_grade")
    private String fertilizerGrade;

    @Column(name="manufacturer_name")
    private String manufacturerName;

    @Column(name="quantity")
    private Double quantity;

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

    public InputSupplierFertilizer(Integer fertilizerTypeId, Integer fertilizerNameId, Integer inputSupplierId, String fertilizerName, String fertilizerGrade, String manufacturerName, Double quantity) {

        this.fertilizerType=fertilizerTypeId;
        this.fertilizerNameId=fertilizerNameId;
        this.inputSupplierId=inputSupplierId;
        this.fertilizerName=fertilizerName;
        this.fertilizerGrade=fertilizerGrade;
        this.manufacturerName=manufacturerName;
        this.quantity=quantity;
    }

    public InputSupplierFertilizer(Integer inputSupplierId) {
        this.inputSupplierId=inputSupplierId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getFertilizerName() {
        return fertilizerName;
    }

    public void setFertilizerName(String fertilizerName) {
        this.fertilizerName = fertilizerName;
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

