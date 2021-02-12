package com.upfpo.app.service;

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
import com.upfpo.app.entity.Enquiry;
import com.upfpo.app.entity.FPORegister;
import com.upfpo.app.entity.User;
import com.upfpo.app.repository.CropDetailsMasterRepository;
import com.upfpo.app.repository.EnquiryRepository;
import com.upfpo.app.repository.FpoMasterRepository;
import com.upfpo.app.repository.UserRepository;

@Service
public class EnquiryServiceImpl implements EnquiryService{

    @Autowired
    private EnquiryRepository enquiryRepository;
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
   
    	
    	System.out.println("Date Has been received"+enquiryRequest.getFulfillmentDate());
    	
    	Enquiry enquiry =  new Enquiry(); 
    	enquiry.setCreateDateTime(new Date());  // filled
    	enquiry.setFulfillmentDate(enquiryRequest.getFulfillmentDate());       // from ui
    	enquiry.setQuantity(enquiryRequest.getQuantity());              // from ui
    	enquiry.setReason(null);                // no idea hence empty
    	enquiry.setStatus("Active");            // active
    	enquiry.setEnquieryNumber("INDNT"+enquiryRequest.getUserId()+new Date().getTime());
    	enquiry.setFpo(fpoRepository.findById(enquiryRequest.getFpoId()).orElseThrow(FpoNotFoundException::new));                   // from ui
    	enquiry.setUser(userRepository.findById(Long.parseLong(""+enquiryRequest.getUserId())).orElseThrow(UserNotFoundException::new));                  // from user	
      	enquiry.setCropMaster(cropMasterRepository.findById(enquiryRequest.getCropId()).orElseThrow(CropNotFoundException::new));  	 	 	
      	return enquiryRepository.save(enquiry);
    }

    public Enquiry updateEnquiryDetail(Long id, Enquiry enquiry) {
        Optional<Enquiry> sd = enquiryRepository.findById(id);
        if(!sd.isPresent()) {
            return null;
        }
        enquiry.setId(id);
        return enquiryRepository.save(enquiry);
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

	public List<Enquiry> getEnquiryInfo(User user) {
		 return enquiryRepository.findByUser(user);
	}

	public List<Enquiry> getEnquiryInfoByFpo(FPORegister fpo) {
		return enquiryRepository.findByFpo(fpo);
	}

	
	
}
