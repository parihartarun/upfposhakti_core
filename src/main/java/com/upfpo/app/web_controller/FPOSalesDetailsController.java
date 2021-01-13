package com.upfpo.app.web_controller;

import com.upfpo.app.entity.FPOSalesDetails;
import com.upfpo.app.service.FPOSalesDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/fposalesdetails")
public class FPOSalesDetailsController {

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
    public FPOSalesDetails insertSalesDetails(@RequestBody FPOSalesDetails salesDetails){

        return fpoSalesDetailsService.insertSalesDetails(salesDetails);
    }

    @PutMapping("/update/{id}")
    public FPOSalesDetails updateSalesDetails(@PathVariable Integer id,@RequestBody FPOSalesDetails salesDetails){
     return fpoSalesDetailsService.updateSalesDetails(id, salesDetails);
    }

    @DeleteMapping("/delete/{id}")
    public Optional<FPOSalesDetails> deleteSalesDetails(@PathVariable Integer id){
        return fpoSalesDetailsService.deleteSalesDetails(id);
    }


}
