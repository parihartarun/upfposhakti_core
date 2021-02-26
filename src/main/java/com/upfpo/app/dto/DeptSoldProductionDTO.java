package com.upfpo.app.dto;

import java.util.List;

public class DeptSoldProductionDTO 
{
	private List<DeptTotSoldZayadDTO> deptTotSoldZayad; 
	
	private List<DeptTotSoldKharifDTO> deptTotSoldKharif;
	
	private List<DeptTotSoldRabiDTO> deptTotSoldRabi;

	public List<DeptTotSoldZayadDTO> getDeptTotSoldZayad() {
		return deptTotSoldZayad;
	}

	public void setDeptTotSoldZayad(List<DeptTotSoldZayadDTO> deptTotSoldZayad) {
		this.deptTotSoldZayad = deptTotSoldZayad;
	}

	public List<DeptTotSoldKharifDTO> getDeptTotSoldKharif() {
		return deptTotSoldKharif;
	}

	public void setDeptTotSoldKharif(List<DeptTotSoldKharifDTO> deptTotSoldKharif) {
		this.deptTotSoldKharif = deptTotSoldKharif;
	}

	public List<DeptTotSoldRabiDTO> getDeptTotSoldRabi() {
		return deptTotSoldRabi;
	}

	public void setDeptTotSoldRabi(List<DeptTotSoldRabiDTO> deptTotSoldRabi) {
		this.deptTotSoldRabi = deptTotSoldRabi;
	}
	
	
}
