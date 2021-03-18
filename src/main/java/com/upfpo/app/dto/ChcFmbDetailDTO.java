package com.upfpo.app.dto;

import java.util.List;

public class ChcFmbDetailDTO {

    ChcFmbDTO chcFmb;
    List<ChcFmbMachineryDTO> machinery;

    public ChcFmbDetailDTO() {
    }

    public ChcFmbDetailDTO(ChcFmbDTO chcFmb, List<ChcFmbMachineryDTO> machinery) {
        this.chcFmb = chcFmb;
        this.machinery = machinery;
    }

    public ChcFmbDTO getChcFmb() {
        return chcFmb;
    }

    public void setChcFmb(ChcFmbDTO chcFmb) {
        this.chcFmb = chcFmb;
    }

    public List<ChcFmbMachineryDTO> getMachinery() {
        return machinery;
    }

    public void setMachinery(List<ChcFmbMachineryDTO> machinery) {
        this.machinery = machinery;
    }
}
