package com.upfpo.app.dto;

import java.util.List;

public class DeptMarketableProductionDTO 
{
	private List<DeptTotMarRabiDTO> deptTotMarRabi;
	
	private List<DeptTotMarZayadDTO> deptTotMarZayad;
	
	private List<DeptTotMarKharifDTO> deptTotMarKharif;

	public List<DeptTotMarRabiDTO> getDeptTotMarRabi() {
		return deptTotMarRabi;
	}

	public void setDeptTotMarRabi(List<DeptTotMarRabiDTO> deptTotMarRabi) {
		this.deptTotMarRabi = deptTotMarRabi;
	}

	public List<DeptTotMarZayadDTO> getDeptTotMarZayad() {
		return deptTotMarZayad;
	}

	public void setDeptTotMarZayad(List<DeptTotMarZayadDTO> deptTotMarZayad) {
		this.deptTotMarZayad = deptTotMarZayad;
	}

	public List<DeptTotMarKharifDTO> getDeptTotMarKharif() {
		return deptTotMarKharif;
	}

	public void setDeptTotMarKharif(List<DeptTotMarKharifDTO> deptTotMarKharif) {
		this.deptTotMarKharif = deptTotMarKharif;
	}
	
}
