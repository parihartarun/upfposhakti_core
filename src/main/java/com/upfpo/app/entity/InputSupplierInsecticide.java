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

import com.upfpo.app.dto.InputSupplierDashboardDTO;
import com.upfpo.app.dto.InputSupplierInsecticideDTO;


@SqlResultSetMapping(name="InputSupplierInsecticideDTO",
        classes = {
                @ConstructorResult(
                        targetClass = InputSupplierInsecticideDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = Integer.class),
                                @ColumnResult(name = "type_id", type = Integer.class),
                                @ColumnResult(name = "insecticide_type", type = String.class),
                                @ColumnResult(name = "quantity", type = Integer.class),
                                @ColumnResult(name = "manufacturer_name", type = String.class),
                                @ColumnResult(name = "cib_rc_no", type = String.class),
                                @ColumnResult(name = "cib_rc_issuedate", type = String.class),
                                @ColumnResult(name = "file_path", type = String.class)
                        })
        })
@SqlResultSetMapping(name="InputSupplierDashboardDTO",
classes = {
        @ConstructorResult(
                targetClass = InputSupplierDashboardDTO.class,
                columns = {
                        @ColumnResult(name = "insecticideTypeId", type = Integer.class),
                        @ColumnResult(name = "insecticideType", type = String.class),
                        @ColumnResult(name = "quantity", type = BigInteger.class)
                })
})
@Entity
@Table(name = "input_supplier_insecticide")
public class InputSupplierInsecticide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "input_supplier_id")
    private Integer inputSupplierId;

    @Column(name = "insecticide_type_id")
    private Integer insecticideTypeId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "manufacturer_name")
    private String manufacturerName;

    @Column(name="cib_rc_no")
    private String cibRcNumber;

    @Column(name="cib_rc_issuedate")
    private String cibRcIssueDate;

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

    @Column(name = "role")
    private String role;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date_time")
    private Calendar createDateTime;


    public InputSupplierInsecticide() {
    }

    public InputSupplierInsecticide(Integer id, Integer inputSupplierId, Integer insecticideTypeId, Integer quantity, String manufacturerName,
            String cibRcNumber, String cibRcIssueDate, String filePath, String fileName, Calendar updateDate, Integer updateBy, Boolean isDeleted, Calendar deleteDate, Integer deleteBy, Integer createBy, Calendar createDateTime) {
        this.id = id;
        this.inputSupplierId = inputSupplierId;
        this.insecticideTypeId = insecticideTypeId;
        this.quantity = quantity;
        this.manufacturerName = manufacturerName;
        this.cibRcNumber = cibRcNumber;
        this.cibRcIssueDate = cibRcIssueDate;
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

    public InputSupplierInsecticide(Integer insecticideTypeId, String manufacturerName, Integer quantity, Integer inputSupplierId, String cibRcNumber,
                                    String cibRcIssuedate,String role) {

        this.insecticideTypeId=insecticideTypeId;
        this.cibRcNumber=cibRcNumber;
        this.cibRcIssueDate=cibRcIssuedate;
        this.quantity=quantity;
        this.inputSupplierId=inputSupplierId;
        this.manufacturerName=manufacturerName;
        this.role = role;
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

    public Integer getInsecticideTypeId() {
        return insecticideTypeId;
    }

    public void setInsecticideTypeId(Integer insecticideTypeId) {
        this.insecticideTypeId = insecticideTypeId;
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

    public String getCibRcNumber() {
        return cibRcNumber;
    }

    public void setCibRcNumber(String cibRcNumber) {
        this.cibRcNumber = cibRcNumber;
    }

    public String getCibRcIssueDate() {
        return cibRcIssueDate;
    }

    public void setCibRcIssueDate(String cibRcIssueDate) {
        this.cibRcIssueDate = cibRcIssueDate;
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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}