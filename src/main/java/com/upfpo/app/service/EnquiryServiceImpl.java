package com.upfpo.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.CropNotFoundException;
import com.upfpo.app.configuration.exception.FpoNotFoundException;
import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.dto.EnquieryRequest;
import com.upfpo.app.dto.EnquiryDTO;
import com.upfpo.app.entity.CropMaster;
import com.upfpo.app.entity.CropVerietyMaster;
import com.upfpo.app.entity.Enquiry;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.TotalProduction;
import com.upfpo.app.repository.CropDetailsMasterRepository;
import com.upfpo.app.repository.CropVarietyRepository;
import com.upfpo.app.repository.EnquiryRepository;
import com.upfpo.app.repository.FpoMasterRepository;
import com.upfpo.app.repository.TotalProductionRepository;
import com.upfpo.app.repository.UserRepository;

@Service
public class EnquiryServiceImpl implements EnquiryService{

    @Autowired
    private EnquiryRepository enquiryRepository;
    
    @Autowired
    private CropVarietyRepository cropVarietyRepository;
    @Autowired
    private TotalProductionRepository totalProductionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FpoMasterRepository fpoRepository;
    @Autowired
    private CropDetailsMasterRepository cropMasterRepository;
    
    @Autowired
	EntityManager entityManager;

    public List<Enquiry> getAllEnquiryInfo(){
        return enquiryRepository.findAll();
    }

    public Enquiry createEnquiry (EnquieryRequest enquiryRequest){
   
    	System.out.println("Date Has been received"+enquiryRequest.getFulfillmentDate());
    	
    	Enquiry enquiry =  new Enquiry(); 
    	enquiry.setCreateDateTime(new Date());  // filled
    	enquiry.setDeliveryAddress(enquiryRequest.getFpoDeliveryAddress());
    	enquiry.setFulfillmentDate(enquiryRequest.getFulfillmentDate());       // from ui
    	
    	enquiry.setCropVeriety(cropVarietyRepository.findById(enquiryRequest.getCropVeriety()).get());
    	enquiry.setQuantity(enquiryRequest.getQuantity());              // from ui
    	enquiry.setReason(null);                // no idea hence empty
    	enquiry.setStatus("Active");            // active
    	enquiry.setEnquieryNumber("INDNT"+enquiryRequest.getMasterId()+new Date().getTime());
    	enquiry.setFpo(fpoRepository.findById(enquiryRequest.getFpoId()).orElseThrow(FpoNotFoundException::new));                   // from ui
    	enquiry.setMasterId(enquiryRequest.getMasterId());
    	enquiry.setCreatedBy(enquiryRequest.getCreatedBy());
      	enquiry.setCropMaster(cropMasterRepository.findById(enquiryRequest.getCropId()).orElseThrow(CropNotFoundException::new));  
      	enquiry.setCreatedbyRoleId(enquiryRequest.getCreatedbyRoleId());
      	enquiry.setCreatedbyUserId(enquiryRequest.getCreatedbyUserId());
      	return enquiryRepository.save(enquiry);
    }

    
    
    public Enquiry getEnquieryById(Long id)
    {
    	return enquiryRepository.findByEnid(id);
    }
    public Enquiry updateEnquiryDetail(Long id, Enquiry enquiry) {
    	
        Enquiry sd = enquiryRepository.findByEnid(id);
        if(sd==null) {
            return null;
        }         
         if(enquiry.getStatus().contentEquals("fulfilled") || enquiry.getStatus().contentEquals("partially fulfilled")) {
        	 //System.out.println("");
        	 CropMaster cropMaster= cropMasterRepository.findById(sd.getCropMaster().getCropId()).orElseThrow(NotFoundException::new); 
        	 CropVerietyMaster cropVarietyMaster=this.cropVarietyRepository.findById(sd.getCropVeriety().getVerietyId()).orElseThrow(NotFoundException::new);	   
             List<TotalProduction> totalProductionlist =  totalProductionRepository.findByFpoRegisterAndCropMasterAndCropVerityMaster(sd.getFpo().getFpoId(),sd.getCropMaster().getCropId(),sd.getCropVeriety().getVerietyId());
        	 
        	 if(totalProductionlist==null ||totalProductionlist.isEmpty())
         {
        	 throw new NotFoundException("Could not find production data !!!");
         }else {
        	 
        	 Double remainingQuantity  = enquiry.getSoldQuantity();
        	 int index = 0;
        	 while(remainingQuantity.doubleValue()>0 && index<totalProductionlist.size())
        	 {
        		 TotalProduction data = totalProductionlist.get(index);
        		 if(remainingQuantity.doubleValue()>data.getCurrentMarketable().doubleValue())
        		 {
        		 data.setCurrentMarketable(0.0);
        		 this.totalProductionRepository.save(data);
        		 remainingQuantity = remainingQuantity.doubleValue() - data.getCurrentMarketable().doubleValue();
        		 }
        		 else if(remainingQuantity.doubleValue()==data.getCurrentMarketable().doubleValue())
        		 {
        			 remainingQuantity = 0.0;
        		 data.setCurrentMarketable(0.0);
        		 this.totalProductionRepository.save(data);
        		 }else
        		 {
        		 data.setCurrentMarketable(data.getCurrentMarketable().doubleValue()-remainingQuantity.doubleValue());
        		 this.totalProductionRepository.save(data);
        		 remainingQuantity = 0.0;
        		 }
        		 index++;
        		 
        	 }
        	 
        	 
         }
         }
         
        sd.setStatus(enquiry.getStatus());
        Enquiry upenquiry = sd; 
        
        return enquiryRepository.save(upenquiry);
    }
    
    public Enquiry cancelEnquiry(Long id)
    {
    	Enquiry enquiryDetails = enquiryRepository.findByEnid(id);
    	enquiryDetails.setStatus("cancelled");
    	return enquiryRepository.save(enquiryDetails);
    }

    public Optional deleteEnquiry(Long id) {
        return enquiryRepository.findById(id)
                .map(enquiry -> {
                    enquiryRepository.delete(enquiry);
                    return "Delete Successfully!";
                });
    }

	public void saveEnquiry(Enquiry enquiry) {
	
		enquiryRepository.save(enquiry);
	} 

	public List<Enquiry> getEnquiryInfo(Integer masterId, String roleId) {
		 //return enquiryRepository.findByMasterId(masterId);
		//return enquiryRepository.findByMasterIdOrderByEnidDesc(masterId);
		return enquiryRepository.findByMasterIdAndCreatedbyRoleIdInOrderByEnidDesc(masterId, roleId);
		/*String sql = "select e.enquierynumber as enquieryNumber, cm.id as cropId, cm.crop_name as cropName, cv.veriety_id as verietyId, cv.crop_veriety as verietyName,\r\n"
				+ "e.status, e.deliveryaddress as deliveryAddress, e.quantity, e.create_date_time as createDateTime, e.id as enid from enquiry e\r\n"
				+ "inner join crop_master cm on cm.id = e.crop_id\r\n"
				+ "inner join crop_veriety_master cv on cv.veriety_id = cast(e.cropveriety as Integer)\r\n"
				+ "where e.masterid = :masterId and e.createdby_role_id = :roleId order by e.id desc";
		List<EnquiryDTO> obj =  (List<EnquiryDTO>) entityManager.createNativeQuery(sql,"EnquiryDTO").setParameter("masterId", masterId).setParameter("roleId", roleId).getResultList();
		return obj;*/
	}

	public List<Enquiry> getEnquiryInfoByFpo(FPORegister fpo) {
		//return enquiryRepository.findByFpoOrderByEnidDesc(fpo);
		return enquiryRepository.findByFpoAndStatusNotInOrderByEnidDesc(fpo, "cancelled");
		/*String sql = "select e.enquierynumber as enquieryNumber, cm.id as cropId, cm.crop_name as cropName, cv.veriety_id as verietyId, cv.crop_veriety as verietyName,\r\n"
				+ "e.status, e.deliveryaddress as deliveryAddress, e.quantity, e.create_date_time as createDateTime, e.id as enid from enquiry e\r\n"
				+ "inner join crop_master cm on cm.id = e.crop_id\r\n"
				+ "inner join crop_veriety_master cv on cv.veriety_id = cast(e.cropveriety as Integer)\r\n"
				+ "where e.fpo_id = :masterId and e.status not in ('cancelled') order by e.id desc";
		List<EnquiryDTO> obj =  (List<EnquiryDTO>) entityManager.createNativeQuery(sql,"EnquiryDTO").setParameter("masterId", fpo).getResultList();
		return obj;*/
	}

	
	
}
