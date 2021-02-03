package com.upfpo.app.service;


import com.upfpo.app.entity.FPOLevelProduction;
import com.upfpo.app.entity.FPOSalesDetails;
import com.upfpo.app.repository.FPOLevelProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FPOLevelProductionServiceImpl implements FPOLevelProductionService {

    @Autowired
    private FPOLevelProductionRepository levelProductionRepository;

    public List<FPOLevelProduction> getAllLevelProduction (){
        return levelProductionRepository.findAll();
    }

    public Optional<FPOLevelProduction> getLevelProductionById (Integer id){
        if(!levelProductionRepository.existsById(id)) {
            return null;
        }
        return levelProductionRepository.findById(id);
    }

    public FPOLevelProduction addLevelProduction (FPOLevelProduction levelProduction){

        return levelProductionRepository.save(levelProduction);
    }

    public FPOLevelProduction updateLevelProduction (Integer id, FPOLevelProduction levelProduction){
        Optional<FPOLevelProduction> flp = levelProductionRepository.findById(id);
        if(!flp.isPresent()) {
            return null;
        }
        levelProduction.setId(id);

        return levelProductionRepository.save(levelProduction);
    }

    public Optional deleteLevelProduction (Integer id){

        return levelProductionRepository.findById(id)
                .map(levelProduction -> {
                    levelProductionRepository.delete(levelProduction);
                    return "Delete Successfully!";
                });
    }
}