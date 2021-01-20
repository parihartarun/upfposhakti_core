package com.upfpo.app.dto;

public class ProductionDTO {

	private Double totalprod;
	private Double rabiprod;
	private Double kharifprod;
	private Double zayadprod;
	
	

	public ProductionDTO(Double totalprod, Double rabiprod, Double kharifprod, Double zayadprod) {
		super();
		this.totalprod = totalprod;
		this.rabiprod = rabiprod;
		this.kharifprod = kharifprod;
		this.zayadprod = zayadprod;
	}

	public Double getTotalprod() {
		return totalprod;
	}

	public void setTotalprod(Double totalprod) {
		this.totalprod = totalprod;
	}

	public Double getRabiprod() {
		return rabiprod;
	}

	public void setRabiprod(Double rabiprod) {
		this.rabiprod = rabiprod;
	}

	public Double getKharifprod() {
		return kharifprod;
	}

	public void setKharifprod(Double kharifprod) {
		this.kharifprod = kharifprod;
	}

	public Double getZayadprod() {
		return zayadprod;
	}

	public void setZayadprod(Double zayadprod) {
		this.zayadprod = zayadprod;
	}

}
