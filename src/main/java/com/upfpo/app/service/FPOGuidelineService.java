package com.upfpo.app.service;


import com.upfpo.app.entity.FPOGuidelines;

import java.util.List;

public interface FPOGuidelineService {

    public List<FPOGuidelines> getAllFPOGuidelines ();
    public FPOGuidelines getFPOGuidelinesByID(Long id);
    public FPOGuidelines createFPOGuidelines(FPOGuidelines fpoGuidelines);
    public FPOGuidelines updateFPOGuidelines(Long id, FPOGuidelines fpoGuidelines);
    public Boolean deleteFPOGuidelines(Long id);
}
