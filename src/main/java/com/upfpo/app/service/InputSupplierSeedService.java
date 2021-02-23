package com.upfpo.app.service;

import com.upfpo.app.entity.InputSupplierSeed;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface InputSupplierSeedService {
    InputSupplierSeed createInputSupplierSeed(InputSupplierSeed inputSupplierSeed, MultipartFile file);

    Boolean deleteInputSupplierSeed(Integer id);

    Resource loadFileAsResource(String fileName);

    InputSupplierSeed updateInputSupplierSeed(Integer id, InputSupplierSeed inputSupplierSeed1, MultipartFile file);
}
