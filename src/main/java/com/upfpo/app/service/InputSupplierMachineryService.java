package com.upfpo.app.service;

import com.upfpo.app.dto.InputSupplierMachineryDTO;
import com.upfpo.app.entity.EquipmentType;
import com.upfpo.app.entity.EqupmentMaster;
import com.upfpo.app.entity.InputSupplierMachinery;
import com.upfpo.app.requestStrings.ReportRequestString;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface InputSupplierMachineryService {


    List<InputSupplierMachineryDTO> getAllInputSupplierMachinery(ReportRequestString reportRequestString);

    List<EquipmentType> getAllEquipmentType();



    List<EqupmentMaster> getAllEquipmentByType(Integer typeId);

    InputSupplierMachinery createInputSupplierMachinery(InputSupplierMachinery inputSupplierMachinery, MultipartFile file);

    Boolean deleteInputSupplierMachinery(Integer id);

    Resource loadFileAsResource(String fileName);

    InputSupplierMachinery updateInputSupplierMachinery(Integer id, InputSupplierMachinery inputSupplierMachinery1, MultipartFile file);
}
