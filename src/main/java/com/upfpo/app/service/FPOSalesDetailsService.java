package com.upfpo.app.service;

import java.util.List;
import java.util.Optional;

import com.upfpo.app.dto.FPOSalesDetailsDTO;
import com.upfpo.app.entity.FPOSalesDetails;

public interface FPOSalesDetailsService {

    public FPOSalesDetails insertSalesDetails ( FPOSalesDetails salesDetails);
    public List<FPOSalesDetailsDTO> getSalesDetails(Integer masterId);
    public Optional<FPOSalesDetails> getSalesDetailsById (Integer id);
    public FPOSalesDetails updateSalesDetails(Integer id, FPOSalesDetails salesDetails);

    Boolean deleteFPOSalesDetails(Integer id);
}
