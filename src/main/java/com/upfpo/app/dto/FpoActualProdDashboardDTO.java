package com.upfpo.app.dto;

import java.util.List;

public class FpoActualProdDashboardDTO 
{
	private List<FpoActProdRabiDTO> fpoActProdRabi;
	
	private List<FpoActProdZayadDTO> fpoActProdZayad;
	
	private List<FpoActProdKharifDTO> fpoActProdKharif;
	
	public List<FpoActProdRabiDTO> getFpoActProdRabi() {
		return fpoActProdRabi;
	}

	public void setFpoActProdRabi(List<FpoActProdRabiDTO> fpoActProdRabi) {
		this.fpoActProdRabi = fpoActProdRabi;
	}

	public List<FpoActProdZayadDTO> getFpoActProdZayad() {
		return fpoActProdZayad;
	}

	public void setFpoActProdZayad(List<FpoActProdZayadDTO> fpoActProdZayad) {
		this.fpoActProdZayad = fpoActProdZayad;
	}

	public List<FpoActProdKharifDTO> getFpoActProdKharif() {
		return fpoActProdKharif;
	}

	public void setFpoActProdKharif(List<FpoActProdKharifDTO> fpoActProdKharif) {
		this.fpoActProdKharif = fpoActProdKharif;
	}
	
}
