package com.upfpo.app.service;


import com.upfpo.app.entity.FPOGuidelineType;
import com.upfpo.app.entity.FPOGuidelines;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import reactor.util.annotation.Nullable;

import java.io.IOException;
import java.util.List;

public interface FPOGuidelineService {


    List<FPOGuidelines> getFPOGuidelineByType(FPOGuidelineType fpoGuidelineType);

    List<FPOGuidelines> getAllFPOGuidelines();


    FPOGuidelines uploadFPOGuidline(FPOGuidelines fpoGuideline, MultipartFile file);



    //FPOGuidelines updateFPOGuidelines(Integer id, FPOGuidelines fpoGuidelines1, MultipartFile file);

    FPOGuidelines updateFPOGuidelines(Integer id, FPOGuidelines fpoGuidelines1, MultipartFile file);

    public Boolean deleteFPOGuidelines(Long id);

    Resource loadFileAsResource(String fileName);
}
