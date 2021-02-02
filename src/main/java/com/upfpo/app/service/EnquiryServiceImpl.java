package com.upfpo.app.service;

import com.upfpo.app.dto.EnquiryDTO;
import com.upfpo.app.entity.Enquiry;
import com.upfpo.app.repository.EnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnquiryServiceImpl implements EnquiryService{

    @Autowired
    private EnquiryRepository enquiryRepository;

    public List<Enquiry> getAllEnquiryInfo(){
        return enquiryRepository.findAll();
    }

    public Enquiry createEnquiry (Enquiry enquiry){
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

}
