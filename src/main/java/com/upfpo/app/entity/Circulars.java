package com.upfpo.app.entity;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name="circulars")
public class Circulars implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "upload_date")
    private Date uploadDate;

    @Column(name = "path")
    private String filePath;

    @Column(name = "uploaded_by")
    private String uploadedBy;

    @Column(name = "users_id")
    private Integer usersId;

    @Column(name = "description")
    private String description;

    public Circulars() {
    }

    public Circulars(Integer id, Date uploadDate, String filePath, String uploadedBy, Integer usersId, String description) {
        this.id = id;
        this.uploadDate = uploadDate;
        this.filePath = filePath;
        this.uploadedBy = uploadedBy;
        this.usersId = usersId;
        this.description = description;
    }


    public Circulars(String url) {
    }

    public Circulars(String filePath, String uploadedBy, Integer usersId) {
        this.filePath = filePath;
        this.uploadedBy = uploadedBy;
        this.usersId = usersId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

