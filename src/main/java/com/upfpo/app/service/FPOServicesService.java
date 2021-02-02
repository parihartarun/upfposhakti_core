package com.upfpo.app.service;

import com.upfpo.app.entity.FPOServices;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface FPOServicesService {

    public Optional deleteFPOServices(Integer id);
    //public FPOServices updateFPOServices(Integer id, FPOServices FPOServices, MultipartFile file);
    public List<FPOServices> getFPOServices();
    public Optional<FPOServices> getFPOServicesById(Integer id);
   // public FPOServices insertFPOServices(FPOServices FPOServices);

}
