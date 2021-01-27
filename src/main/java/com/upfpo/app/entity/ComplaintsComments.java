package com.upfpo.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "complaints_comments")
public class ComplaintsComments {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    private String comment;

    @Column(name = "commented_by")
    private String createBy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="complaints_id")
    @JsonIgnore
    private Complaints  complaints;

    public ComplaintsComments(Integer id, String comment, String createBy, Complaints complaints) {
        this.id = id;
        this.comment = comment;
        this.createBy = createBy;
        this.complaints = complaints;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
