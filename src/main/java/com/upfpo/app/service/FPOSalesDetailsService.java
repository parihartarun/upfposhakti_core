package com.upfpo.app.service;

import com.upfpo.app.entity.FPOSalesDetails;

import java.util.List;
import java.util.Optional;

public interface FPOSalesDetailsService {

    public FPOSalesDetails insertSalesDetails ( FPOSalesDetails salesDetails);
    public List<FPOSalesDetails> getSalesDetails();
    public Optional<FPOSalesDetails> getSalesDetailsById (Integer id);
    public FPOSalesDetails updateSalesDetails(Integer id, FPOSalesDetails salesDetails);
    public Optional deleteSalesDetails (Integer id);
}
