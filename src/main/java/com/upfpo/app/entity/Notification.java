package com.upfpo.app.entity;


import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="notification_id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "user_role")
    private String role;

    @Column(name = "filePath")
    private String filePath;

    @Column(name = "file_name")
    private String filName;

    @Column(name = "farmer_name")
    private String farmerName;

    @Column(name = "receiver_id")
    private Integer receiverId;

    @Column(name = "farmer_id")
    private String farmerId;

    @Column(name = "fpo_id")
    private String fpoId;

    @Column(name = "dept_id")
    private String deptId;

    @Column(name = "farmer_fpo_id")
    private String farmerFpoId;

    @Column(name ="is_read")
    private Boolean isRead;

    @Column(name = "notificaton_type")
    private NotificationType type;

    @Column(name="upload_date")
    private Date uploadDate;

    @Column(name="uplaoded_by")
    private String uploadedBy;

    @Column(name="is_deleted")
    private Boolean isDeleted;

    @Column(name="delete_date")
    private Date deleteDate;

    @Column(name = "create_by")
    private String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Calendar createDate;

    @Column(name="update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Calendar updateDate;


    public Notification() {
    }





    public Notification(String role, String message, String departmentId, String fpoId) {
        this.role=role;
        this.message=message;
        this.deptId=departmentId;
        this.fpoId=fpoId;
    }

    public Notification(String role, String message,String farmerId) {
        this.role=role;
        this.message=message;
        this.farmerId=farmerId;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getFarmerFpoId() {
        return farmerFpoId;
    }

    public void setFarmerFpoId(String farmerFpoId) {
        this.farmerFpoId = farmerFpoId;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public NotificationType getType() {
        return type;
    }


    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }

    public String getFpoId() {
        return fpoId;
    }

    public void setFpoId(String fpoId) {
        this.fpoId = fpoId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilName() {
        return filName;
    }

    public void setFilName(String filName) {
        this.filName = filName;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }
}
