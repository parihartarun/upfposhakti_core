package com.upfpo.app.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reasons_mst")
public class ReasonsMaster implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reason_id")
	private Integer reasonId;
	
	@Column(name="reasons")
	private String reason;
	
	@Column(name="reasons_hi")
	private String reasonHi;

	public String getReasonHi() {
		return reasonHi;
	}

	public void setReasonHi(String reasonHi) {
		this.reasonHi = reasonHi;
	}

	public Integer getReasonId() {
		return reasonId;
	}

	public void setReasonId(Integer reasonId) {
		this.reasonId = reasonId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
