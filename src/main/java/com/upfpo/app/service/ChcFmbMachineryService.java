package com.upfpo.app.service;

import com.upfpo.app.dto.ChcFmbMachineryDTO;
import com.upfpo.app.entity.ChcFmbMachinery;
import com.upfpo.app.entity.EquipmentType;
import com.upfpo.app.entity.EqupmentMaster;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ChcFmbMachineryService  {


    List<ChcFmbMachineryDTO> getAllChcFmbMachinery(Integer masterId);

    List<EquipmentType> getAllEquipmentType();

    List<EqupmentMaster> getAllEquipmentByType(Integer typeId);

    ChcFmbMachinery createChcFmbMachinery(ChcFmbMachinery chcFmbMachinery, MultipartFile file);

    Boolean deleteChcFmbMachinery(Integer id);

    Resource loadFileAsResource(String fileName);

    ChcFmbMachinery updateChcFmbMachinery(Integer id, ChcFmbMachinery chcFmbMachinery1, MultipartFile file);
}
