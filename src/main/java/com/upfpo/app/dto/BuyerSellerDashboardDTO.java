package com.upfpo.app.dto;

import java.util.List;

public class BuyerSellerDashboardDTO 
{
	private Integer fpos;
	
	private Integer activeIndents;
	
	private Integer fulfilledIndents;
	
	private Integer cancelIndents;
	
	private Integer crops;
	
	private Integer cropId;
	
	private String cropName;
	
	private String status;
	
	private List<BuyerSellerDashboardDTO> buyerSellerDashboard;
	

	public BuyerSellerDashboardDTO() {
		
	}

	
	public BuyerSellerDashboardDTO(Integer cropId, String cropName, String status) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
		this.status = status;
	}



	public Integer getFpos() {
		return fpos;
	}

	public void setFpos(Integer fpos) {
		this.fpos = fpos;
	}

	public Integer getActiveIndents() {
		return activeIndents;
	}

	public void setActiveIndents(Integer activeIndents) {
		this.activeIndents = activeIndents;
	}

	public Integer getFulfilledIndents() {
		return fulfilledIndents;
	}

	public void setFulfilledIndents(Integer fulfilledIndents) {
		this.fulfilledIndents = fulfilledIndents;
	}

	public Integer getCancelIndents() {
		return cancelIndents;
	}

	public void setCancelIndents(Integer cancelIndents) {
		this.cancelIndents = cancelIndents;
	}

	public Integer getCrops() {
		return crops;
	}

	public void setCrops(Integer crops) {
		this.crops = crops;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BuyerSellerDashboardDTO> getBuyerSellerDashboard() {
		return buyerSellerDashboard;
	}

	public void setBuyerSellerDashboard(List<BuyerSellerDashboardDTO> buyerSellerDashboard) {
		this.buyerSellerDashboard = buyerSellerDashboard;
	}

	public Integer getCropId() {
		return cropId;
	}

	public void setCropId(Integer cropId) {
		this.cropId = cropId;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	
	
	
}
