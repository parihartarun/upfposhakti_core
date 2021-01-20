package com.upfpo.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "complaints_comments")
public class ComplaintsComments {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String comment;

    @Column(name = "commented_by")
    private String createBy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "complaint_id", nullable = false)
    @JsonIgnore
    private Complaints complaints;

    public ComplaintsComments(Long id, String comment, String createBy, Complaints complaints) {
        this.id = id;
        this.comment = comment;
        this.createBy = createBy;
        this.complaints = complaints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Complaints getComplaints() {
        return complaints;
    }

    public void setComplaints(Complaints complaints) {
        this.complaints = complaints;
    }
}
