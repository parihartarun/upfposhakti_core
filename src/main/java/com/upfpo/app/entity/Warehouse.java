package com.upfpo.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upfpo.app.dto.InputSupplierSeedDTO;
import com.upfpo.app.dto.WarehouseDTO;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;


@SqlResultSetMapping(name="WarehouseDTO",
        classes = {
                @ConstructorResult(
                        targetClass = WarehouseDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = Integer.class),
                                @ColumnResult(name = "warehouse_type", type = String.class),
                                @ColumnResult(name = "warehouse_facility_name", type = String.class),
                                @ColumnResult(name = "capacity", type = Double.class),
                                @ColumnResult(name = "is_seed_processing", type = String.class),
                                @ColumnResult(name = "district_id", type = Integer.class),
                                @ColumnResult(name = "district_name", type = String.class),
                                @ColumnResult(name = "block_id", type = Integer.class),
                                @ColumnResult(name = "block_name", type = String.class),
                                @ColumnResult(name = "address", type = String.class),
                                @ColumnResult(name = "longitude", type = String.class),
                                @ColumnResult(name = "latitude", type = String.class)
                        })
        })
@Entity
@Table(name = "warehouse_master")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "warehouse_type")
    private String warehouseType;

    @Column(name = "capacity")
    private Double capacity;

    @Column(name = "is_seed_processing")
    private String isSeedProcessingUnit;

    @Column(name="district_id")
    private Integer districtId;

    @Column(name="block_id")
    private Integer blockId;

    @Column(name="address")
    private String address;

    @Column(name="longitude")
    private String longitude;

    @Column(name="latitude")
    private String latitude;

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

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="id")
    private List<WarehouseFacilities> facilities;

    public Warehouse() {
    }


    public Warehouse(Integer id, Integer deptId, String warehouseType, Double capacity, String isSeedProcessingUnit,
                     Integer districtId, Integer blockId, String address, String longitude, String latitude, Calendar updateDate,
                     Integer updateBy, Boolean isDeleted, Calendar deleteDate, Integer deleteBy, Integer createBy,
                     Calendar createDateTime, List<WarehouseFacilities> facilities) {
        this.id = id;
        this.deptId = deptId;
        this.warehouseType = warehouseType;
        this.capacity = capacity;
        this.isSeedProcessingUnit = isSeedProcessingUnit;
        this.districtId = districtId;
        this.blockId = blockId;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
        this.isDeleted = isDeleted;
        this.deleteDate = deleteDate;
        this.deleteBy = deleteBy;
        this.createBy = createBy;
        this.createDateTime = createDateTime;
        this.facilities = facilities;
    }

    public Warehouse(String typeName, Integer deptId,List<WarehouseFacilities> facilities, Double capacity, String isSeedProcessing, Integer districtId,
                     Integer blockId, String address, String longitude, String latitude) {
        this.warehouseType=typeName;
        this.deptId = deptId;
        this.facilities=facilities;
        this.capacity = capacity;
        this.isSeedProcessingUnit = isSeedProcessing;
        this.districtId = districtId;
        this.blockId = blockId;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public List<WarehouseFacilities> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<WarehouseFacilities> facilities) {
        this.facilities = facilities;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWarehouseType() {
        return warehouseType;
    }

    public void setWarehouseType(String warehouseType) {
        this.warehouseType = warehouseType;
    }


    public String getIsSeedProcessingUnit() {
        return isSeedProcessingUnit;
    }

    public void setIsSeedProcessingUnit(String isSeedProcessingUnit) {
        this.isSeedProcessingUnit = isSeedProcessingUnit;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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
