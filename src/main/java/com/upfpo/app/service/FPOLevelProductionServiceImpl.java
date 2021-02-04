package com.upfpo.app.service;


import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.entity.FPOLevelProduction;
import com.upfpo.app.repository.FPOLevelProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class FPOLevelProductionServiceImpl implements FPOLevelProductionService {

    @Autowired
    private FPOLevelProductionRepository levelProductionRepository;

    public List<FPOLevelProduction> getAllLevelProduction (){
        return levelProductionRepository.findByIsDeleted(false);
    }

    public Optional<FPOLevelProduction> getLevelProductionById (Integer id){
        if(!levelProductionRepository.existsById(id)) {
            return null;
        }
        return levelProductionRepository.findById(id);
    }

    public FPOLevelProduction addLevelProduction (FPOLevelProduction levelProduction){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        levelProduction.setDeleted(false);
        levelProduction.setCreateDate(Calendar.getInstance());
        levelProduction.setCreateBy(currentPrincipalName);

        return levelProductionRepository.save(levelProduction);
    }

    public FPOLevelProduction updateLevelProduction (Integer id, FPOLevelProduction levelProduction){
        Optional<FPOLevelProduction> flp = levelProductionRepository.findById(id);
        if(!flp.isPresent()) {
            return null;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        levelProduction.setId(id);
        levelProduction.setDeleted(false);
        levelProduction.setUpdateDate(Calendar.getInstance());
        levelProduction.setUpdatedBy(currentPrincipalName);

        return levelProductionRepository.save(levelProduction);
    }

    public Boolean deleteLevelProduction(Integer id) {
        if(levelProductionRepository.findById(id) != null)
            try {
                FPOLevelProduction fpoLevelProduction = levelProductionRepository.findById(id).get();
                fpoLevelProduction.setDeleted(true);
                fpoLevelProduction.setDeleteDate(Calendar.getInstance());
                levelProductionRepository.save(fpoLevelProduction);
                return true;
            }catch(Exception e)
            {
                throw new NotFoundException();
            }
        else
            return false;
    }
}