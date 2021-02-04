package com.upfpo.app.service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.FPOSalesDetails;
import com.upfpo.app.entity.FPOServices;
import com.upfpo.app.repository.FPOSalesDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class FPOSalesDetailsServiceImpl implements FPOSalesDetailsService{

    @Autowired
    private FPOSalesDetailsRepository salesDetailsRepository;


    @Override
    public FPOSalesDetails insertSalesDetails(FPOSalesDetails salesDetails) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        salesDetails.setCreatedDate(Calendar.getInstance());
        salesDetails.setCreatedBy(currentPrincipalName);
        salesDetails.setDeleted(false);
        salesDetailsRepository.save(salesDetails);
        return salesDetails;
    }

    @Override
    public List<FPOSalesDetails> getSalesDetails() {

        return salesDetailsRepository.findByIsDeleted(false);
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        salesDetails.setUpdateDate(Calendar.getInstance());
        salesDetails.setUpdatedBy(currentPrincipalName);
        salesDetails.setDeleted(false);
        salesDetails.setId(id);

        return salesDetailsRepository.save(salesDetails);
    }

    @Override
    public Boolean deleteFPOSalesDetails(Integer id) {
        if(salesDetailsRepository.findById(id) != null)
            try {
                FPOSalesDetails fpoSalesDetails = salesDetailsRepository.findById(id).get();
                fpoSalesDetails.setDeleted(true);
                fpoSalesDetails.setDeleteDate(Calendar.getInstance());
                salesDetailsRepository.save(fpoSalesDetails);
                return true;
            }catch(Exception e)
            {
                throw new NotFoundException();
            }
        else
            return false;
    }
}
