package com.upfpo.app.entity;


import com.upfpo.app.dto.ChcFmbMachineryDTO;
import com.upfpo.app.dto.InputSupplierMachineryDTO;
import io.swagger.models.auth.In;

import javax.persistence.*;
import java.util.Calendar;

@SqlResultSetMapping(name="ChcFmbMachineryDTO",
        classes = {
                @ConstructorResult(
                        targetClass = ChcFmbMachineryDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = Integer.class),
                                @ColumnResult(name = "type", type = String.class),
                                @ColumnResult(name = "equpment_name", type = String.class),
                                @ColumnResult(name = "equipment_capacity", type = Integer.class),
                                @ColumnResult(name = "equip_purchase_year", type = String.class),
                                @ColumnResult(name = "quantity_avail", type = Integer.class),
                                @ColumnResult(name = "rent_per_day", type = Double.class),
                                @ColumnResult(name = "govt_scheme_assistant", type = String.class),
                                @ColumnResult(name = "file_path", type = String.class)
                        })
        })
@Entity
@Table(name = "chc_fmb_machinery")
public class ChcFmbMachinery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "chc_fmb_id")
    private Integer chcFmbId;

    @Column(name = "equipment_type_id")
    private Integer equipmentTypeId;

    @Column(name = "equipment_name_id")
    private Integer equipmentNameId;

    @Column(name = "equipment_capacity")
    private Integer equipmentCapacity;

    @Column(name = "equip_purchase_year")
    private String equipmentYear;

    @Column(name = "quantity_avail")
    private Integer quantityAvailable;

    @Column(name = "rent_per_day")
    private Double rentPerDay;

    @Column(name = "company")
    private String company;

    @Column(name = "govt_scheme_assistant")
    private String govtSchemeAssistant;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "update_date")
    private Calendar updateDate;

    @Column(name = "update_by")
    private Integer updateBy;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "delete_date")
    private Calendar deleteDate;

    @Column(name = "delete_by")
    private Integer deleteBy;

    @Column(name = "create_by")
    private Integer createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date_time")
    private Calendar createDateTime;

    public ChcFmbMachinery() {
    }

    public ChcFmbMachinery(Integer typeId, Integer nameId, Integer chcFmbId, Integer capacity, String year, Integer quantity, String company, String govtScheme, Double rentPerDay) {
    this.equipmentTypeId=typeId;
    this.equipmentNameId=nameId;
    this.chcFmbId=chcFmbId;
    this.equipmentCapacity=capacity;
    this.equipmentYear=year;
    this.quantityAvailable=quantity;
    this.company=company;
    this.govtSchemeAssistant=govtScheme;
    this.rentPerDay=rentPerDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChcFmbId() {
        return chcFmbId;
    }

    public void setChcFmbId(Integer chcFmbId) {
        this.chcFmbId = chcFmbId;
    }

    public Integer getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(Integer equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    public Integer getEquipmentNameId() {
        return equipmentNameId;
    }

    public void setRentPerDay(Double rentPerDay) {
        this.rentPerDay = rentPerDay;
    }

    public String getGovtSchemeAssistant() {
        return govtSchemeAssistant;
    }

    public void setGovtSchemeAssistant(String govtSchemeAssistant) {
        this.govtSchemeAssistant = govtSchemeAssistant;
    }

    public void setEquipmentNameId(Integer equipmentNameId) {
        this.equipmentNameId = equipmentNameId;
    }

    public Integer getEquipmentCapacity() {
        return equipmentCapacity;
    }

    public void setEquipmentCapacity(Integer equipmentCapacity) {
        this.equipmentCapacity = equipmentCapacity;
    }



    public Double getRentPerDay() {
        return rentPerDay;
    }

    public String getEquipmentYear() {
        return equipmentYear;
    }

    public void setEquipmentYear(String equipmentYear) {
        this.equipmentYear = equipmentYear;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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