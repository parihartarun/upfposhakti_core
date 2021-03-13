package com.upfpo.app.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.dto.BuyerSellerDashboardDTO;
import com.upfpo.app.dto.BuyerSellerIndentDTO;
import com.upfpo.app.repository.EnquiryRepository;

@Service
public class BuyerSellerDashboardServiceImpl implements BuyerSellerDashboardService
{
	@Autowired
	EnquiryRepository enquiryRepository;
	
	@Autowired
	EntityManager entityManager;
	
	Integer fpos = 0;
	
	Integer crops = 0;
	
	String sql = "";
	
	
	@Override
	public BuyerSellerDashboardDTO getBuyerSellerDashboardData(Integer buyerId) 
	{
		fpos = enquiryRepository.getFpoCount(buyerId);
		
		BuyerSellerDashboardDTO buyerData = new BuyerSellerDashboardDTO();
		buyerData.setFpos(fpos);
		buyerData.setCrops(enquiryRepository.getCropCount(buyerId));
		buyerData.setActiveIndents(enquiryRepository.getIndents("Active", buyerId));
		buyerData.setCancelIndents(enquiryRepository.getIndents("Cancelled", buyerId));
		buyerData.setFulfilledIndents(enquiryRepository.getIndents("Fullfilled", buyerId));
		buyerData.setBuyerSellerCropIndent(getCropIndentStatusFullfilled(buyerId));
		return buyerData;
		
	}
	
	public List<BuyerSellerIndentDTO> getCropIndentStatusFullfilled(Integer buyerId)
	{
		sql = "select distinct e.crop_id as cropId, cm.crop_name as cropName, count(e.crop_id) as indentQty from enquiry e join crop_master cm on e.crop_id = cm.id\r\n"
				+ "where masterid = :buyerId group by cm.crop_name,  e.crop_id order by indentQty desc;";
		
		List<BuyerSellerIndentDTO> obj =  (List<BuyerSellerIndentDTO>) entityManager.createNativeQuery(sql,"BuyerSellerIndentDTO").setParameter("buyerId", buyerId).
				getResultList();
		return obj;
		
	}
	
}
