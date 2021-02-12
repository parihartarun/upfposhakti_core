package com.upfpo.app.service;

import java.util.List;
import java.util.Optional;

import com.upfpo.app.dto.FPOSalesDetailsDTO;
import com.upfpo.app.entity.FPOSaleInfo;
import com.upfpo.app.entity.FPOSalesDetails;

public interface FPOSalesDetailsService {

    public void insertSalesDetails ( FPOSaleInfo salesInfo);
    public List<FPOSalesDetailsDTO> getSalesDetails(Integer masterId);
    public Optional<FPOSaleInfo> getSalesDetailsById (Integer id);
    public FPOSaleInfo updateSalesDetails(Integer id, FPOSaleInfo salesDetails);

    Boolean deleteFPOSalesDetails(Integer id);
}
