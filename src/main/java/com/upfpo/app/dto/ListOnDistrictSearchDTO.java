package com.upfpo.app.dto;

import java.util.List;

public class ListOnDistrictSearchDTO 
{
	List<FpoOnDistrictDTO> fpoDetails;
	
	List<InputSupplierOnDistrictDTO> inputSupplierDetails;
	
	List<ChcFmbOnDistrictDTO> chcFmbDetails;

	public List<FpoOnDistrictDTO> getFpoDetails() {
		return fpoDetails;
	}

	public void setFpoDetails(List<FpoOnDistrictDTO> fpoDetails) {
		this.fpoDetails = fpoDetails;
	}

	public List<InputSupplierOnDistrictDTO> getInputSupplierDetails() {
		return inputSupplierDetails;
	}

	public void setInputSupplierDetails(List<InputSupplierOnDistrictDTO> inputSupplierDetails) {
		this.inputSupplierDetails = inputSupplierDetails;
	}

	public List<ChcFmbOnDistrictDTO> getChcFmbDetails() {
		return chcFmbDetails;
	}

	public void setChcFmbDetails(List<ChcFmbOnDistrictDTO> chcFmbDetails) {
		this.chcFmbDetails = chcFmbDetails;
	}
}
