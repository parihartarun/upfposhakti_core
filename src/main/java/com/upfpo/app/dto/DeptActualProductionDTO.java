package com.upfpo.app.dto;

import java.util.List;

public class DeptActualProductionDTO 
{
	private List<DeptActProdKharifDTO> deptActProdKharif;
	
	private List<DeptActProdRabiDTO>   deptActProdRabi;
	
	private List<DeptActProdZayadfDTO>   deptActProdZayad;

	public List<DeptActProdKharifDTO> getDeptActProdKharif() {
		return deptActProdKharif;
	}

	public void setDeptActProdKharif(List<DeptActProdKharifDTO> deptActProdKharif) {
		this.deptActProdKharif = deptActProdKharif;
	}

	public List<DeptActProdRabiDTO> getDeptActProdRabi() {
		return deptActProdRabi;
	}

	public void setDeptActProdRabi(List<DeptActProdRabiDTO> deptActProdRabi) {
		this.deptActProdRabi = deptActProdRabi;
	}

	public List<DeptActProdZayadfDTO> getDeptActProdZayad() {
		return deptActProdZayad;
	}

	public void setDeptActProdZayad(List<DeptActProdZayadfDTO> deptActProdZayad) {
		this.deptActProdZayad = deptActProdZayad;
	}

}
