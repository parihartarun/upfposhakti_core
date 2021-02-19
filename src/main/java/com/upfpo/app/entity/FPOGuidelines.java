package com.upfpo.app.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "fpo_guidelines")
public class FPOGuidelines implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    @ApiModelProperty(notes = "Serializable fpo_guidelines_id",name="id",required=true)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "hindi_description")
    private String hindiDescription;

    @Column(name = "registration_type")
    private Integer registrationType;

    @Column(name ="is_active")
    private Boolean isActive;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "hin_file_path")
    private String hinFilePath;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "url")
    private String url;

    @Column(name="is_deleted")
    private Boolean isDeleted;

    @Column(name="delete_by")
    private String deleteBy;

    @Column(name="delete_date")
    private Calendar deleteDate;

    @Column(name = "create_by")
    private String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Calendar createDate;

    @Column(name="update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Calendar updateDate;

    @Column(name="upload_by")
    private String uploadBy;

    @Column(name = "upload_date")
    private Calendar uploadDate;

    @Column(name="fpo_guideline_type")
    private FPOGuidelineType fpoGuidelineType;



    public FPOGuidelines(String description, FPOGuidelineType fpoGuidelineType, String url, String hindiDescription) {
        this.description=description;
        this.fpoGuidelineType=fpoGuidelineType;
        this.url=url;
        this.hindiDescription=hindiDescription;
    }

    public FPOGuidelines() {

    }


    public String getUrl() {
        return url;
    }

    public String getHindiDescription() {
        return hindiDescription;
    }

    public void setHindiDescription(String hindiDescription) {
        this.hindiDescription = hindiDescription;
    }

    public String getHinFilePath() {
        return hinFilePath;
    }

    public void setHinFilePath(String hinFilePath) {
        this.hinFilePath = hinFilePath;
    }

    public String getDescription() {
        return description;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Calendar getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Calendar updateDate) {
        this.updateDate = updateDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    public void setUrl(String url) {
        this.url = url;
    }

    public FPOGuidelineType getFpoGuidelineType() {
        return fpoGuidelineType;
    }

    public void setFpoGuidelineType(FPOGuidelineType fpoGuidelineType) {
        this.fpoGuidelineType = fpoGuidelineType;
    }

    public String getUploadBy() {
        return uploadBy;
    }

    public void setUploadBy(String uploadBy) {
        this.uploadBy = uploadBy;
    }

    public Calendar getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Calendar uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(String deleteBy) {
        this.deleteBy = deleteBy;
    }

    public Calendar getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Calendar deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }


    public Integer getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(Integer registrationType) {
        this.registrationType = registrationType;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


}


