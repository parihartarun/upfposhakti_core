package com.upfpo.app.controller;

import com.upfpo.app.entity.FPOSalesDetails;
import com.upfpo.app.service.FPOSalesDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping(value = "/fposalesdetails")
public class FPOSalesDetailsController {

    private static final Logger LOG = LoggerFactory.getLogger(FPOSalesDetailsController.class);

    @Autowired
    private FPOSalesDetailsServiceImpl fpoSalesDetailsService;

    @GetMapping("/getall")
    public List<FPOSalesDetails> getSalesDetails (){

        return fpoSalesDetailsService.getSalesDetails();
    }



    @GetMapping("/{id}")
    public Optional<FPOSalesDetails> getSalesDetailsById(@PathVariable Integer id) {

        return fpoSalesDetailsService.getSalesDetailsById(id);
    }


    @PostMapping("/insert")
    public ResponseEntity<String> insertSalesDetails(@RequestBody FPOSalesDetails salesDetails) {
        LOG.info("Inside SalesDetailsController saving sales details ", salesDetails);
        ResponseEntity<String> resp = null;
        try {
            FPOSalesDetails id = fpoSalesDetailsService.insertSalesDetails(salesDetails);
            resp = new ResponseEntity<String>("FPOSalesDetails created Successfully!", HttpStatus.OK );
            LOG.info("FPOSalesDetails  created Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Save the Sales Details", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Save the Sales Details");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOSalesDetails Of Controller with response ", resp);
        return resp;
    }


    @PutMapping("/update1/{id}")
    public ResponseEntity<String> updateSalesDetails1(@PathVariable Integer id, @RequestBody FPOSalesDetails salesDetails) {
        LOG.info("Inside SalesDetailsController updating sales details ", salesDetails);
        ResponseEntity<String> resp = null;
        try {
            FPOSalesDetails fsd = fpoSalesDetailsService.updateSalesDetails(id, salesDetails);
            resp = new ResponseEntity<String>("FPOSalesDetails Updated Successfully!", HttpStatus.OK );
            LOG.info("FPOSalesDetails Updated Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Update the Sales Details", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Update the Sales Details");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOSalesDetails Of Controller with response ", resp);
        return resp;
    }


    @DeleteMapping("/delete1/{id}")
    public ResponseEntity<String> deleteSalesDetails1(@PathVariable Integer id) {
        LOG.info("Inside SalesDetailsController delete sales details ");
        ResponseEntity<String> resp = null;
        try {
            fpoSalesDetailsService.deleteSalesDetails(id);
            resp = new ResponseEntity<String>("FPOSalesDetails Deleted Successfully!", HttpStatus.OK );
            LOG.info("FPOSalesDetails Deleted Successfully!");
            //}
        } catch (Exception e) {
            resp = new ResponseEntity<String>("Failed to Delete the Sales Details", HttpStatus.INTERNAL_SERVER_ERROR);
            LOG.info("Failed to Delete the Sales Details");
            e.printStackTrace();
        }
        LOG.info("Exiting FPOSalesDetails Of Controller with response ", resp);
        return resp;
    }

}
