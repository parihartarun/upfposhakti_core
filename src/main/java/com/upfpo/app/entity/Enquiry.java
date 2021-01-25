package com.upfpo.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "enquiry")
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private Long quantity;

    private Date fulfillmentDate;

    private String status;

    private String reason;

    @Column(name = "assign_to")
    private String assignTo;

    @Column(name = "create_by")
    private String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date_time")
    private Calendar createDateTime;

    @JsonIgnore
    @OneToMany(mappedBy = "enquiry", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EnquiryComments> comments;

    public Enquiry() {
    }

    public Enquiry(Long id, Long quantity, Date fulfillmentDate, String status, String reason, String assignTo, String createBy, Calendar createDateTime, List<EnquiryComments> comments) {
        this.id = id;
        this.quantity = quantity;
        this.fulfillmentDate = fulfillmentDate;
        this.status = status;
        this.reason = reason;
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Date getFulfillmentDate() {
        return fulfillmentDate;
    }

    public void setFulfillmentDate(Date fulfillmentDate) {
        this.fulfillmentDate = fulfillmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public List<EnquiryComments> getComments() {
        return comments;
    }

    public void setComments(List<EnquiryComments> comments) {
        this.comments = comments;
    }
}
