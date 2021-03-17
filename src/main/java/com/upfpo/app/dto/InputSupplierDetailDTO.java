package com.upfpo.app.dto;

import java.util.List;

public class InputSupplierDetailDTO {

    InputSupplierDTO inputSupplier;
    List<InputSupplierFertilizerDTO> fertilizer;
    List<InputSupplierSeedDTO> seed;
    List<InputSupplierMachineryDTO> machinerys;
    List<InputSupplierInsecticideDTO> insecticides;

    public InputSupplierDetailDTO() {
    }

    public InputSupplierDetailDTO(InputSupplierDTO inputSupplier, List<InputSupplierFertilizerDTO> fertilizer, List<InputSupplierSeedDTO> seed, List<InputSupplierMachineryDTO> machinerys, List<InputSupplierInsecticideDTO> insecticides) {
        this.inputSupplier = inputSupplier;
        this.fertilizer = fertilizer;
        this.seed = seed;
        this.machinerys = machinerys;
        this.insecticides = insecticides;
    }

    public InputSupplierDTO getInputSupplier() {
        return inputSupplier;
    }

    public void setInputSupplier(InputSupplierDTO inputSupplier) {
        this.inputSupplier = inputSupplier;
    }

    public List<InputSupplierFertilizerDTO> getFertilizer() {
        return fertilizer;
    }

    public void setFertilizer(List<InputSupplierFertilizerDTO> fertilizer) {
        this.fertilizer = fertilizer;
    }

    public List<InputSupplierSeedDTO> getSeed() {
        return seed;
    }

    public void setSeed(List<InputSupplierSeedDTO> seed) {
        this.seed = seed;
    }

    public List<InputSupplierMachineryDTO> getMachinerys() {
        return machinerys;
    }

    public void setMachinerys(List<InputSupplierMachineryDTO> machinerys) {
        this.machinerys = machinerys;
    }

    public List<InputSupplierInsecticideDTO> getInsecticides() {
        return insecticides;
    }

    public void setInsecticides(List<InputSupplierInsecticideDTO> insecticides) {
        this.insecticides = insecticides;
    }
}
