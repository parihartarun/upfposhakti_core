package com.upfpo.app.service;

import com.upfpo.app.entity.FPOSalesDetails;
import com.upfpo.app.repository.FPOSalesDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FPOSalesDetailsServiceImpl implements FPOSalesDetailsService{

    @Autowired
    private FPOSalesDetailsRepository salesDetailsRepository;


    @Override
    public FPOSalesDetails insertSalesDetails(FPOSalesDetails salesDetails) {

        salesDetailsRepository.save(salesDetails);
        return salesDetails;
    }

    @Override
    public List<FPOSalesDetails> getSalesDetails() {

        return salesDetailsRepository.findAll();
    }

    @Override
    public Optional<FPOSalesDetails> getSalesDetailsById(Integer id) {
        if(!salesDetailsRepository.existsById(id)) {
            return null;
        }
        return salesDetailsRepository.findById(id);
    }

    @Override
    public FPOSalesDetails updateSalesDetails(Integer id, FPOSalesDetails salesDetails) {
        Optional<FPOSalesDetails> sd = salesDetailsRepository.findById(id);
        if(!sd.isPresent()) {
            return null;
        }
        salesDetails.setId(id);
        return salesDetailsRepository.save(salesDetails);
    }

    @Override
    public Optional deleteSalesDetails(Integer id) {
        return salesDetailsRepository.findById(id)
                .map(salesDetails -> {
                    salesDetailsRepository.delete(salesDetails);
                    return "Delete Successfully!";
                });
    }
}
