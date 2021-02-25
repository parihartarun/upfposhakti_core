package com.upfpo.app.dto;

import java.util.List;

public class FpoMarkeProdDashboardDTO 
{
	private List<FpoTotMarRabiDTO> fpoTotMarRabi;
	
	private List<FpoTotMarZayadDTO> fpoTotMarZayad;
	
	private List<FpoTotMarKharifDTO> fpoTotMarKharif;

	public List<FpoTotMarRabiDTO> getFpoTotMarRabi() {
		return fpoTotMarRabi;
	}

	public void setFpoTotMarRabi(List<FpoTotMarRabiDTO> fpoTotMarRabi) {
		this.fpoTotMarRabi = fpoTotMarRabi;
	}

	public List<FpoTotMarZayadDTO> getFpoTotMarZayad() {
		return fpoTotMarZayad;
	}

	public void setFpoTotMarZayad(List<FpoTotMarZayadDTO> fpoTotMarZayad) {
		this.fpoTotMarZayad = fpoTotMarZayad;
	}

	public List<FpoTotMarKharifDTO> getFpoTotMarKharif() {
		return fpoTotMarKharif;
	}

	public void setFpoTotMarKharif(List<FpoTotMarKharifDTO> fpoTotMarKharif) {
		this.fpoTotMarKharif = fpoTotMarKharif;
	}
	
	
}
