package com.upfpo.app.service;

import com.upfpo.app.entity.SchemeDetail;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SchemeDetailService {

    public SchemeDetail updateSchemeDetail(Integer id, SchemeDetail schemeDetail1, MultipartFile file);
    public Resource loadFileAsResource(String fileName);
    public Boolean deleteSchemeDetail(Integer id);

    List<SchemeDetail> getSchemeByType(String schemeType);

    public SchemeDetail createSchemeDetail (SchemeDetail schemeDetail, MultipartFile file);
    public List<SchemeDetail> getAllSchemeDetail();
}
