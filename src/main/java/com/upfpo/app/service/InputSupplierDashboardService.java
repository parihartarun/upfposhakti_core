package com.upfpo.app.service;

import com.upfpo.app.dto.*;

import java.util.List;

public interface InputSupplierDashboardService {

    InputSupplierDTO getInputSupplierDetails(Integer masterId);

    List<InputSupplierFertilizerDTO> getAllInputSupplierFertilizer(Integer masterId);

    List<InputSupplierSeedDTO> getAllInputSupplierSeed(Integer masterId);

    List<InputSupplierMachineryDTO> getAllInputSupplierMachinery(Integer masterId);

    List<InputSupplierInsecticideDTO> getAllInputSupplierInsecticide(Integer masterId);
}
