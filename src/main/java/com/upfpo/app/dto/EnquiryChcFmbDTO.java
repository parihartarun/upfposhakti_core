package com.upfpo.app.dto;

import java.math.BigInteger;

public class EnquiryChcFmbDTO 
{
	private BigInteger enqId;
	
	private Integer createdBy;
	
	private Integer machineTypeId;
	
	private String equipType;
	
	private Integer machineId;
	
	private String equpmentName;
	
	private String status;
	
	private String deliveryaddress;
	

	public EnquiryChcFmbDTO(BigInteger enqId, Integer createdBy, Integer machineTypeId, String equipType,
			Integer machineId, String equpmentName, String status, String deliveryaddress) {
		super();
		this.enqId = enqId;
		this.createdBy = createdBy;
		this.machineTypeId = machineTypeId;
		this.equipType = equipType;
		this.machineId = machineId;
		this.equpmentName = equpmentName;
		this.status = status;
		this.deliveryaddress = deliveryaddress;
	}

	public BigInteger getEnqId() {
		return enqId;
	}

	public void setEnqId(BigInteger enqId) {
		this.enqId = enqId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getMachineTypeId() {
		return machineTypeId;
	}

	public void setMachineTypeId(Integer machineTypeId) {
		this.machineTypeId = machineTypeId;
	}

	public String getEquipType() {
		return equipType;
	}

	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}

	public Integer getMachineId() {
		return machineId;
	}

	public void setMachineId(Integer machineId) {
		this.machineId = machineId;
	}

	public String getEqupmentName() {
		return equpmentName;
	}

	public void setEqupmentName(String equpmentName) {
		this.equpmentName = equpmentName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeliveryaddress() {
		return deliveryaddress;
	}

	public void setDeliveryaddress(String deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}
	
}