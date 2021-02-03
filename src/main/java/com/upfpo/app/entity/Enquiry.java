package com.upfpo.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "enquiry")
public class Enquiry implements Serializable {

	private static final long serialVersionUID = 8235023558272315275L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private Long quantity;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fulfillmentDate;

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

	@OneToOne
	@JoinColumn(name = "crop_id")
	private CropMaster cropMaster;

	@OneToOne
	@JoinColumn(name = "fpo_id")
	private FPORegister fpo;

	public Enquiry(Long id, Long quantity, Date fulfillmentDate, String status, String reason, User user,
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