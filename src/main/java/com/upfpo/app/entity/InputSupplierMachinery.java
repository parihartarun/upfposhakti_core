package com.upfpo.app.entity;

import java.math.BigInteger;
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

import com.upfpo.app.dto.InputSupplierDashboardMachineryDTO;
import com.upfpo.app.dto.InputSupplierMachineryDTO;


@SqlResultSetMapping(name="InputSupplierMachineryDTO",
        classes = {
                @ConstructorResult(
                        targetClass = InputSupplierMachineryDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = Integer.class),
                                @ColumnResult(name = "type_id", type = Integer.class),
                                @ColumnResult(name = "type", type = String.class),
                                @ColumnResult(name = "name_id", type = Integer.class),
                                @ColumnResult(name = "equpment_name", type = String.class),
                                @ColumnResult(name = "quantity", type = Integer.class),
                                @ColumnResult(name = "manufacturer_name", type = String.class),
                                @ColumnResult(name = "file_path", type = String.class)
                        })
        })
@SqlResultSetMapping(name="InputSupplierDashboardMachineryDTO",
classes = {
        @ConstructorResult(
                targetClass = InputSupplierDashboardMachineryDTO.class,
                columns = {
                        @ColumnResult(name = "machineryNameId", type = Integer.class),
                        @ColumnResult(name = "machinerytName", type = String.class),
                        @ColumnResult(name = "machineryQty", type = BigInteger.class)
                })
})
@Entity
@Table(name = "input_supplier_machinery")
public class InputSupplierMachinery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "input_supplier_id")
    private Integer inputSupplierId;

    @Column(name = "machinery_type_id")
    private Integer machineryTypeId;

    @Column(name = "machinery_name_id")
    private Integer machinerynameId;

    @Column(name = "other_equipment_name")
    private String otherEquipmentName;

    @Column(name = "technical_specs")
    private String technicalSpecs;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name="manufacturer_name")
    private String manufacturerName;

    @Column(name="rent_per_day")
    private Double rentPerDay;

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

    public InputSupplierMachinery(Integer mchineryTypeId, Integer machineryNameId, String otherEquipmentName, String specification, Integer quantity,
                                  Integer inputSupplierId, String manufacturerName, Double rentPerDay) {
        this.machineryTypeId=mchineryTypeId;
        this.machinerynameId=machineryNameId;
        this.otherEquipmentName= otherEquipmentName;
        this.technicalSpecs=specification;
        this.quantity=quantity;
        this.inputSupplierId=inputSupplierId;
        this.manufacturerName=manufacturerName;
        this.rentPerDay = rentPerDay;
    }

    public InputSupplierMachinery() {
    }

    public Double getRentPerDay() {
        return rentPerDay;
    }

    public void setRentPerDay(Double rentPerDay) {
        this.rentPerDay = rentPerDay;
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

    public String getOtherEquipmentName() {
        return otherEquipmentName;
    }

    public void setOtherEquipmentName(String otherEquipmentName) {
        this.otherEquipmentName = otherEquipmentName;
    }

    public Integer getMachineryTypeId() {
        return machineryTypeId;
    }

    public void setMachineryTypeId(Integer machineryTypeId) {
        this.machineryTypeId = machineryTypeId;
    }

    public Integer getMachinerynameId() {
        return machinerynameId;
    }

    public void setMachinerynameId(Integer machinerynameId) {
        this.machinerynameId = machinerynameId;
    }

    public String getTechnicalSpecs() {
        return technicalSpecs;
    }

    public void setTechnicalSpecs(String technicalSpecs) {
        this.technicalSpecs = technicalSpecs;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
