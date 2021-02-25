package com.upfpo.app.service;

import com.upfpo.app.entity.EquipmentType;
import com.upfpo.app.entity.EqupmentMaster;
import com.upfpo.app.entity.InputSupplierMachinery;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface InputSupplierMachineryService {
    List<EquipmentType> getAllEquipmentType();

    List<InputSupplierMachinery> getAllInputSupplierMachinery();

    List<EqupmentMaster> getAllEquipmentByType(Integer typeId);

    InputSupplierMachinery createInputSupplierMachinery(InputSupplierMachinery inputSupplierMachinery, MultipartFile file);

    Boolean deleteInputSupplierMachinery(Integer id);

    Resource loadFileAsResource(String fileName);

    InputSupplierMachinery updateInputSupplierMachinery(Integer id, InputSupplierMachinery inputSupplierMachinery1, MultipartFile file);
}
