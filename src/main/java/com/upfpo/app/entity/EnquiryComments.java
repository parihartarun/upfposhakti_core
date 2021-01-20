package com.upfpo.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "enquiry_comments")
public class EnquiryComments {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String comment;

    @Column(name = "commented_by")
    private String createBy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "enquiry_id",referencedColumnName="id", nullable = false)
    @JsonIgnore
    private Enquiry enquiry;

    public EnquiryComments(Long id, String comment, String createBy, Enquiry enquiry) {
        this.id = id;
        this.comment = comment;
        this.createBy = createBy;
        this.enquiry = enquiry;
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

    public Enquiry getEnquiry() {
        return enquiry;
    }

    public void setEnquiry(Enquiry enquiry) {
        this.enquiry = enquiry;
    }
}
