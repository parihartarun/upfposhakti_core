package com.upfpo.app.service;

import com.upfpo.app.entity.FPOServices;

import java.util.List;
import java.util.Optional;

public interface FPOServicesService {

    public Optional deleteFPOServices(Integer id);
    public FPOServices updateFPOServices(Integer id, FPOServices FPOServices);
    public List<FPOServices> getFPOServices();
    public Optional<FPOServices> getFPOServicesById(Integer id);
    public FPOServices insertFPOServices(FPOServices FPOServices);

}
