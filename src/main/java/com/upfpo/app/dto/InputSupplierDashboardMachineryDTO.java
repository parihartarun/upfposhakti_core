package com.upfpo.app.dto;

import java.math.BigInteger;

public class InputSupplierDashboardMachineryDTO 
{
	private Integer machineryNameId;
	
	private String machinerytName;
	
	private BigInteger machineryQty;
	
	public InputSupplierDashboardMachineryDTO(Integer machineryNameId, String machinerytName, BigInteger machineryQty) {
		super();
		this.machineryNameId = machineryNameId;
		this.machinerytName = machinerytName;
		this.machineryQty = machineryQty;
	}

	public Integer getMachineryNameId() {
		return machineryNameId;
	}

	public void setMachineryNameId(Integer machineryNameId) {
		this.machineryNameId = machineryNameId;
	}

	public String getMachinerytName() {
		return machinerytName;
	}

	public void setMachinerytName(String machinerytName) {
		this.machinerytName = machinerytName;
	}

	public BigInteger getMachineryQty() {
		return machineryQty;
	}

	public void setMachineryQty(BigInteger machineryQty) {
		this.machineryQty = machineryQty;
	}
	
	
}
