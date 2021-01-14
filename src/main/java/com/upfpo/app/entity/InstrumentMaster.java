package com.upfpo.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instrument_master")
public class InstrumentMaster implements Serializable {
	
	private static final long serialVersionUID = 1844872452594204705L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="instrument_id")
	private Integer instrumentId;
	
	@Column(name="instrument_name")
	private String instrumentName;
	
	@Column(name="is_active")
	private boolean isActive;

	
	
	public Integer getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(Integer instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
