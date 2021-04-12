package com.upfpo.app.service;

import com.upfpo.app.dto.InputSupplierInsecticideDTO;
import com.upfpo.app.entity.InputSupplierInsecticide;
import com.upfpo.app.entity.InsecticideType;
import com.upfpo.app.requestStrings.ReportRequestString;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface InputSupplierInsecticideService {


    List<InputSupplierInsecticideDTO> getAllInputSupplierInsecticide(ReportRequestString reportRequestString);

    List<InsecticideType> getInsecticideType();

    InputSupplierInsecticide createInputSupplierInsecticide(InputSupplierInsecticide inputSupplierInsecticide, MultipartFile file);

    Boolean deleteInputSupplierInsecticide(Integer id);

    Resource loadFileAsResource(String fileName);

    InputSupplierInsecticide updateInputSupplierInsecticide(Integer id, InputSupplierInsecticide inputSupplierInsecticide1, MultipartFile file);
}
