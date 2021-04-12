package com.upfpo.app.service;

import com.upfpo.app.dto.InputSupplierFertilizerDTO;
import com.upfpo.app.entity.FertilizerName;
import com.upfpo.app.entity.FertilizerType;
import com.upfpo.app.entity.InputSupplierFertilizer;
import com.upfpo.app.requestStrings.ReportRequestString;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface InputSupplierFertilizerService {


    List<InputSupplierFertilizerDTO> getAllInputSupplierFertilizer(ReportRequestString reportRequestString);

    List<FertilizerType> getAllFertilizerType();


    List<FertilizerName> getAllFertilizerName(Integer typeId);

    InputSupplierFertilizer createInputSupplierFertilizer(InputSupplierFertilizer inputSupplierFertilizer, MultipartFile file);

    Boolean deleteInputSupplierFertilizer(Integer id);

    Resource loadFileAsResource(String fileName);

    InputSupplierFertilizer updateInputSupplierFertilizer(Integer id, InputSupplierFertilizer inputSupplierFertilizer1, MultipartFile file);
}
