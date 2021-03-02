package com.upfpo.app.dto;

import java.util.List;

public class FpoTotSoldProductionDTO 
{
	private List<FpoTotSoldRabiDTO> fpoTotSoldRabi; 
	
	private List<FpoTotSoldZayadDTO> fpoTotSoldZayad;
	
	private List<FpoTotSoldKharifDTO> fpoTotSoldKharif;

	public List<FpoTotSoldRabiDTO> getFpoTotSoldRabi() {
		return fpoTotSoldRabi;
	}

	public void setFpoTotSoldRabi(List<FpoTotSoldRabiDTO> fpoTotSoldRabi) {
		this.fpoTotSoldRabi = fpoTotSoldRabi;
	}

	public List<FpoTotSoldZayadDTO> getFpoTotSoldZayad() {
		return fpoTotSoldZayad;
	}

	public void setFpoTotSoldZayad(List<FpoTotSoldZayadDTO> fpoTotSoldZayad) {
		this.fpoTotSoldZayad = fpoTotSoldZayad;
	}

	public List<FpoTotSoldKharifDTO> getFpoTotSoldKharif() {
		return fpoTotSoldKharif;
	}

	public void setFpoTotSoldKharif(List<FpoTotSoldKharifDTO> fpoTotSoldKharif) {
		this.fpoTotSoldKharif = fpoTotSoldKharif;
	}
	
	
}
