package com.upfpo.app.dto;

import java.math.BigInteger;

public class EnquiryChcFmbDTO 
{
	private BigInteger equId;
	
	private Integer createdBy;
	
	private Integer machineTypeId;
	
	private String machineTypeName;
	
	private Integer machineId;
	
	private String machineName;
	
	private String status;
	
	private Double indentQty;
	
	private Integer noOfDays;
	
	private String deliveryAddress;

	public BigInteger getEquId() {
		return equId;
	}

	public void setEquId(BigInteger equId) {
		this.equId = equId;
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

	public String getMachineTypeName() {
		return machineTypeName;
	}

	public void setMachineTypeName(String machineTypeName) {
		this.machineTypeName = machineTypeName;
	}

	public Integer getMachineId() {
		return machineId;
	}

	public void setMachineId(Integer machineId) {
		this.machineId = machineId;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getIndentQty() {
		return indentQty;
	}

	public void setIndentQty(Double indentQty) {
		this.indentQty = indentQty;
	}

	public Integer getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
}
