package com.upfpo.app.entity;

import org.hibernate.exception.DataException;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fpo_guidelines")
public class FPOGuidelines {

    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "description")
    private String desc;

    @Column(name = "upload_date")
    private Date uploadDate;

    @Column(name = "registration_type")
    private Integer registrationType;

    @Column(name ="is_active")
    private Boolean isActive;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "notificaton_type")
    private NotificationType type;


    public FPOGuidelines() {
    }

    public FPOGuidelines(Long id, String desc, Date uploadDate, Integer registrationType, Boolean isActive, String filePath, String fileName, NotificationType type) {
        this.id = id;
        this.desc = desc;
        this.uploadDate = uploadDate;
        this.registrationType = registrationType;
        this.isActive = isActive;
        this.filePath = filePath;
        this.fileName = fileName;
        this.type = type;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
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

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }
}


