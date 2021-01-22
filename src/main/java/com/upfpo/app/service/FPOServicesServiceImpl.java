package com.upfpo.app.service;

import com.upfpo.app.entity.FPOSalesDetails;
import com.upfpo.app.entity.FPOServices;

import com.upfpo.app.repository.FPOServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FPOServicesServiceImpl implements FPOServicesService{


    @Autowired
    private FPOServicesRepository fpoServicesRepository;

    @Override
    public List<FPOServices> getFPOServices() {
        return fpoServicesRepository.findAll();
    }

    @Override
    public Optional<FPOServices> getFPOServicesById(Integer id) {
        if(!fpoServicesRepository.existsById(id)) {
            return null;
        }
        return fpoServicesRepository.findById(id);
    }


    @Override
    public FPOServices insertFPOServices(FPOServices FPOServices) {
        fpoServicesRepository.save(FPOServices);
        return FPOServices;
    }

    @Override
    public FPOServices updateFPOServices(Integer id, FPOServices FPOServices) {
        Optional<FPOServices> sd = fpoServicesRepository.findById(id);
        if(!sd.isPresent()) {
            return null;
        }
        FPOServices.setId(id);
        return fpoServicesRepository.save(FPOServices);
    }

    @Override
    public Optional deleteFPOServices(Integer id) {
        return fpoServicesRepository.findById(id)
                .map(FPOServices -> {
                    fpoServicesRepository.delete(FPOServices);
                    return "Delete Successfully!";
                });
    }








}
