package com.upfpo.app.service;

import com.upfpo.app.entity.FPOLevelProduction;

import java.util.List;
import java.util.Optional;

public interface FPOLevelProductionService {

    public List<FPOLevelProduction> getAllLevelProduction ();
    public Optional<FPOLevelProduction> getLevelProductionById (Integer id);
    public FPOLevelProduction addLevelProduction (FPOLevelProduction levelProduction);
    public FPOLevelProduction updateLevelProduction (Integer id, FPOLevelProduction levelProduction);
    public Boolean deleteLevelProduction (Integer id);

}
