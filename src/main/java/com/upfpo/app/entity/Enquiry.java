package com.upfpo.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "enquiry")
public class Enquiry implements Serializable {

	private static final long serialVersionUID = 8235023558272315275L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private Double quantity;

	private String enquieryNumber;
	
	

	public Enquiry(Long id, Double quantity, String enquieryNumber, String fulfillmentDate, String status,
			String reason, User user, Date createDateTime, List<EnquiryComments> comments, CropMaster cropMaster,
			FPORegister fpo) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.enquieryNumber = enquieryNumber;
		this.fulfillmentDate = fulfillmentDate;
		this.status = status;
		this.reason = reason;
		this.user = user;
		this.createDateTime = createDateTime;
		this.comments = comments;
		this.cropMaster = cropMaster;
		this.fpo = fpo;
	}

	public String getEnquieryNumber() {
		return enquieryNumber;
	}

	public void setEnquieryNumber(String enquieryNumber) {
		this.enquieryNumber = enquieryNumber;
	}

	private String fulfillmentDate;

	private String status;

	private String reason;

	@OneToOne
	@JoinColumn(name = "created_by")
	private User user;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date_time")
	private Date createDateTime;

	@JsonIgnore
	@OneToMany(mappedBy = "enquiry", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EnquiryComments> comments;

	@ManyToOne
	@JoinColumn(name = "crop_id")
	private CropMaster cropMaster;

	@OneToOne
	@JoinColumn(name = "fpo_id")
	private FPORegister fpo;

	public Enquiry(Long id, Double quantity, String fulfillmentDate, String status, String reason, User user,
			Date createDateTime, List<EnquiryComments> comments, CropMaster cropMaster, FPORegister fpo) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.fulfillmentDate = fulfillmentDate;
		this.status = status;
		this.reason = reason;
		this.user = user;
		this.createDateTime = createDateTime;
		this.comments = comments;
		this.cropMaster = cropMaster;
		this.fpo = fpo;
	}

	public Enquiry() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getFulfillmentDate() {
		return fulfillmentDate;
	}

	public void setFulfillmentDate(String fulfillmentDate) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public List<EnquiryComments> getComments() {
		return comments;
	}

	public void setComments(List<EnquiryComments> comments) {
		this.comments = comments;
	}

	public CropMaster getCropMaster() {
		return cropMaster;
	}

	public void setCropMaster(CropMaster cropMaster) {
		this.cropMaster = cropMaster;
	}

	public FPORegister getFpo() {
		return fpo;
	}

	public void setFpo(FPORegister fpo) {
		this.fpo = fpo;
	}

}