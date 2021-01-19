package com.upfpo.app.controller;


import com.upfpo.app.entity.Enquiry;
import com.upfpo.app.service.EnquiryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/enquiry")
public class EnquiryController {
    
    
    @Autowired
    private EnquiryServiceImpl enquiryService;

    private static final Logger LOG = LoggerFactory.getLogger(FPOSalesDetailsController.class);



    @GetMapping("/getall")
    public List<Enquiry> getAllEnquiryDetails (){

        return enquiryService.getAllEnquiryInfo();
    }



    @PostMapping("/insert")
    public ResponseEntity<String> createEnquiry(@RequestBody Enquiry enquiry) {
        LOG.info("Inside EnquiryController saving Enquiry ", enquiry);
        ResponseEntity<String> resp = null;
        try {
            Enquiry id = enquiryService.createEnquiry(enquiry);
            resp = new ResponseEntity<String>("Enquiry created Successfully!", HttpStatus.OK );
            LOG.info("Enquiry  created Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Save the Enquiry", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the Enquiry");
            e.printStackTrace();
        }
        LOG.info("Exiting Enquiry Of Controller with response ", resp);
        return resp;
    }


    @PutMapping("/update1/{id}")
    public ResponseEntity<String> updateSalesDetails1(@PathVariable Long id, @RequestBody Enquiry enquiry) {
        LOG.info("Inside EnquiryController updating sales details ", enquiryService);
        ResponseEntity<String> resp = null;
        try {
            Enquiry fsd = enquiryService.updateEnquiryDetail(id, enquiry);
            resp = new ResponseEntity<String>("Enquiry Updated Successfully!", HttpStatus.OK );
            LOG.info("Enquiry Updated Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Update the Enquiry", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Update the Enquiry");
            e.printStackTrace();
        }
        LOG.info("Exiting Enquiry Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping("/delete1/{id}")
    public ResponseEntity<String> deleteEnquiry(@PathVariable Long id) {
        LOG.info("Inside EnquiryController delete sales details ");
        ResponseEntity<String> resp = null;
        try {
            enquiryService.deleteEnquiry(id);
            resp = new ResponseEntity<String>("Enquiry Deleted Successfully!", HttpStatus.OK );
            LOG.info("Enquiry Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Delete the Enquiry", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the Enquiry");
            e.printStackTrace();
        }
        LOG.info("Exiting Enquiry Of Controller with response ", resp);
        return resp;
    }

}
