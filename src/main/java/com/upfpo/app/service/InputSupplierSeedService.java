package com.upfpo.app.service;

import com.upfpo.app.dto.InputSupplierSeedDTO;
import com.upfpo.app.entity.InputSupplierSeed;
import com.upfpo.app.requestStrings.ReportRequestString;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface InputSupplierSeedService {


    List<InputSupplierSeedDTO> getAllInputSupplierSeed(ReportRequestString reportRequestString);

    InputSupplierSeed createInputSupplierSeed(InputSupplierSeed inputSupplierSeed, MultipartFile file);

    Boolean deleteInputSupplierSeed(Integer id);

    Resource loadFileAsResource(String fileName);

    InputSupplierSeed updateInputSupplierSeed(Integer id, InputSupplierSeed inputSupplierSeed1, MultipartFile file);
}
