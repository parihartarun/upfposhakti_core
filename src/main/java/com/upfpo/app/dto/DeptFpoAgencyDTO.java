package com.upfpo.app.dto;

public class DeptFpoAgencyDTO 
{
	private Long count;
	
	private String agency;
	
	private Double agencyWiseFpo;
	
	public DeptFpoAgencyDTO(Long count, String agency) {
		super();
		this.count = count;
		this.agency = agency;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}
	
	public Double getAgencyWiseFpo() {
		return agencyWiseFpo;
	}

	public void setAgencyWiseFpo(Double agencyWiseFpo) {
		this.agencyWiseFpo = agencyWiseFpo;
	}
}
