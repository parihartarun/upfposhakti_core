package com.upfpo.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "complaints_suggestion")
public class Complaints {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String title;

    private String message;

    private String desc;

    private String status;

    @Column(name = "assign_to")
    private String assignTo;

    @Column(name = "create_by")
    private String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date_time")
    private Calendar createDateTime;

    @JsonIgnore
    @OneToMany(mappedBy = "complaints", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ComplaintsComments> comments;

    public Complaints() {
    }

    public Complaints(Long id, String title, String message, String desc, String status, String assignTo, String createBy, Calendar createDateTime, List<ComplaintsComments> comments) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.desc = desc;
        this.status = status;
        this.assignTo = assignTo;
        this.createBy = createBy;
        this.createDateTime = createDateTime;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Calendar getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Calendar createDateTime) {
        this.createDateTime = createDateTime;
    }

    public List<ComplaintsComments> getComments() {
        return comments;
    }

    public void setComments(List<ComplaintsComments> comments) {
        this.comments = comments;
    }
}
