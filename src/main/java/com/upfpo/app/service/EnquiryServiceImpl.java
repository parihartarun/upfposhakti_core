package com.upfpo.app.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.CropNotFoundException;
import com.upfpo.app.configuration.exception.FpoNotFoundException;
import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.configuration.exception.UserNotFoundException;
import com.upfpo.app.dto.EnquieryRequest;
import com.upfpo.app.entity.CropMaster;
import com.upfpo.app.entity.CropVerietyMaster;
import com.upfpo.app.entity.Enquiry;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.TotalProduction;
import com.upfpo.app.entity.User;
import com.upfpo.app.repository.CropDetailsMasterRepository;
import com.upfpo.app.repository.CropVarietyRepository;
import com.upfpo.app.repository.EnquiryRepository;
import com.upfpo.app.repository.FpoMasterRepository;
import com.upfpo.app.repository.TotalProductionRepository;
import com.upfpo.app.repository.UserRepository;
import com.upfpo.app.util.GetFinYear;

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

    public List<Enquiry> getAllEnquiryInfo(){
        return enquiryRepository.findAll();
    }

    public Enquiry createEnquiry (EnquieryRequest enquiryRequest){
   
    	BigInteger val = BigInteger.valueOf(1);
    	System.out.println("Date Has been received"+enquiryRequest.getFulfillmentDate());
    	
    	Enquiry enquiry =  new Enquiry(); 
    	enquiry.setCreateDateTime(new Date());  // filled
    	enquiry.setDeliveryAddress(enquiryRequest.getFpoDeliveryAddress());
    	enquiry.setFulfillmentDate(enquiryRequest.getFulfillmentDate());       // from ui
    	
    	enquiry.setCropVeriety(cropVarietyRepository.findById(enquiryRequest.getCropVeriety()).get());
    	enquiry.setQuantity(enquiryRequest.getQuantity());              // from ui
    	enquiry.setReason(null);                // no idea hence empty
    	enquiry.setStatus("Active");            // active
    	enquiry.setEnquieryNumber("INDNT"+enquiryRequest.getUserId()+new Date().getTime());
    	enquiry.setFpo(fpoRepository.findById(enquiryRequest.getFpoId()).orElseThrow(FpoNotFoundException::new));                   // from ui
    	//enquiry.setMasterId(enquiryRequest.getMasterId());
    	enquiry.setMasterId(1);
    	//enquiry.setCreatedBy(enquiryRequest.getCreatedBy());
    	enquiry.setCreatedBy(val);
      	enquiry.setCropMaster(cropMasterRepository.findById(enquiryRequest.getCropId()).orElseThrow(CropNotFoundException::new));  	 	 	
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

	public List<Enquiry> getEnquiryInfo(Integer masterId) {
		 return enquiryRepository.findByMasterId(masterId);
	}

	public List<Enquiry> getEnquiryInfoByFpo(FPORegister fpo) {
		return enquiryRepository.findByFpo(fpo);
	}

	
	
}
