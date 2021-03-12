package com.upfpo.app.dto;

import java.util.List;

public class InputSupplierDashboardIndentDTO 
{
	private List<InputSupplierDashBoardIndentSeedDTO> seedIndent;
	
	private List<InputSupplierDashBoardIndentFertilizerDTO> fertilizerIndent;
	
	private List<InputSupplierDashBoardIndentInsecticideDTO> insecticideIndent;
	
	private List<InputSupplierDashBoardIndentMachineryDTO> machineryIndent;

	public List<InputSupplierDashBoardIndentSeedDTO> getSeedIndent() {
		return seedIndent;
	}

	public void setSeedIndent(List<InputSupplierDashBoardIndentSeedDTO> seedIndent) {
		this.seedIndent = seedIndent;
	}

	public List<InputSupplierDashBoardIndentFertilizerDTO> getFertilizerIndent() {
		return fertilizerIndent;
	}

	public void setFertilizerIndent(List<InputSupplierDashBoardIndentFertilizerDTO> fertilizerIndent) {
		this.fertilizerIndent = fertilizerIndent;
	}

	public List<InputSupplierDashBoardIndentInsecticideDTO> getInsecticideIndent() {
		return insecticideIndent;
	}

	public void setInsecticideIndent(List<InputSupplierDashBoardIndentInsecticideDTO> insecticideIndent) {
		this.insecticideIndent = insecticideIndent;
	}

	public List<InputSupplierDashBoardIndentMachineryDTO> getMachineryIndent() {
		return machineryIndent;
	}

	public void setMachineryIndent(List<InputSupplierDashBoardIndentMachineryDTO> machineryIndent) {
		this.machineryIndent = machineryIndent;
	}
	
}
